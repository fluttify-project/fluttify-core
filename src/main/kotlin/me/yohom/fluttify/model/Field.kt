package me.yohom.fluttify.model

import me.yohom.fluttify.EXCLUDE_TYPES
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
                variable.must("数字或字符串类型") { typeName in listOf("int", "double", "String") } &&
                must("有值") { value.isNotEmpty() } &&
                mustNot("包含new关键字") { value.startsWith("new") }
    }

    fun filterGetters(): Boolean {
        return variable.type().filter() && // 必须先通过类型的过滤
                must("公开field") { isPublic } &&
                mustNot("静态field") { isStatic } &&
                variable.must("已知类型") { isKnownType() } &&
                variable.mustNot("lambda类型") { Regex("""\(\^\w+\)\(\)""").matches(name) } &&
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
                filterGetters() &&
                mustNot("不可改field") { isFinal }
    }

    @Deprecated("不再使用方法引用的方式, 而是使用匿名函数的方式放到handlerMap中去", ReplaceWith("getterMethodName"))
    fun nativeHandleGetterMethodName(): String {
        return "handle${className.toUnderscore()}_get_${getterName.depointer()}"
    }

    @Deprecated("不再使用方法引用的方式, 而是使用匿名函数的方式放到handlerMap中去", ReplaceWith("setterMethodName"))
    fun nativeHandleSetterMethodName(): String {
        return "handle${className.toUnderscore()}_set_${setterName.depointer()}"
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