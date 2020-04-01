package me.yohom.fluttify.model

import me.yohom.fluttify.EXCLUDE_TYPES
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*

data class Field(
    /**
     * 是否公开
     */
    override val isPublic: Boolean,
    /**
     * 是否只读
     */
    val isFinal: Boolean?,
    /**
     * 是否静态
     */
    val isStatic: Boolean?,
    /**
     * 属性的值
     */
    val value: String = "null",
    /**
     * 变量
     */
    val variable: Variable,
    /**
     * 所在类名
     */
    val className: String,
    /**
     * getter
     */
    val getterName: String = variable.name,
    /**
     * setter
     */
    val setterName: String = variable.name,
    /**
     * 所属平台
     */
    override var platform: Platform,
    /**
     * 是否过时
     */
    var isDeprecated: Boolean = false
) : IPlatform, IScope {

    fun filterConstants(): Boolean {
        return must("公开field") { isPublic } &&
                must("静态field") { isStatic == true } &&
                must("不可变变量") { isFinal == true } &&
                variable.must("数字或字符串类型") {
                    typeName in listOf("int", "double", "String") && (value.isNumber() || value.isString())
                } &&
                must("有值") { value.isNotEmpty() } &&
                mustNot("包含new关键字") { value.startsWith("new") }
    }

    fun filterGetters(): Boolean {
        return variable.type().filter() && // 必须先通过类型的过滤
                must("公开field") { isPublic } &&
                mustNot("静态field") { isStatic } &&
                variable.must("已知类型") { isKnownType() } &&
                variable.mustNot("多维列表") { genericLevel > 1 } &&
                variable.mustNot("lambda类型") { isLambda() } &&
                variable.mustNot("匿名lambda类型") { Regex("\\(\\^\\w+\\)\\(\\)").matches(name) } &&
                variable.must("公开类型") { isPublicType() } &&
                variable.must("具体类型或者含有子类的抽象类") { isConcret() || hasConcretSubtype() } &&
                variable.must("返回类型的祖宗类是已知类") {
                    typeName.findType().ancestorTypes.all {
                        it.findType().isKnownType()
                    }
                } &&
                variable.mustNot("混淆类") { typeName.isObfuscated() } &&
                variable.mustNot("类型是排除类") { EXCLUDE_TYPES.any { it.matches(typeName) } }
    }

    fun filterSetter(): Boolean {
        return variable.type().filter() && // 必须先通过类型的过滤
                must("公开field") { isPublic } &&
                mustNot("不可改field") { isFinal } &&
                mustNot("静态field") { isStatic } &&
                variable.must("已知类型") { isKnownType() } &&
                variable.mustNot("多维列表") { genericLevel > 1 } &&
                variable.mustNot("lambda类型") { isLambda() } &&
                variable.mustNot("匿名lambda类型") { Regex("\\(\\^\\w+\\)\\(\\)").matches(name) } &&
                variable.must("公开类型") { typeName.findType().isPublic } &&
                variable.must("返回类型的祖宗类是已知类") {
                    typeName.findType().ancestorTypes.all {
                        it.findType().isKnownType()
                    }
                } &&
                variable.mustNot("混淆类") { typeName.isObfuscated() }
    }

    fun filterSetterBatch(): Boolean {
        return filterSetter() && !variable.type().isCallback()
    }

    fun getterMethodName(): String {
        return "${className.replace("$", ".")}::get_${getterName.depointer()}"
    }

    fun setterMethodName(): String {
        return "${className.replace("$", ".")}::set_${setterName.depointer()}"
    }

    fun asGetterMethod(): Method {
        return Method(
            variable.typeName,
            getterName,
            listOf(),
            isStatic = false,
            isAbstract = false,
            isPublic = true,
            className = className,
            platform = platform,
            isDeprecated = isDeprecated
        )
    }

    fun asSetterMethod(): Method {
        return Method(
            "void",
            setterName,
            listOf(Parameter(variable = variable, platform = platform)),
            isStatic = false,
            isAbstract = false,
            isPublic = true,
            className = className,
            platform = platform,
            isDeprecated = isDeprecated
        )
    }
}