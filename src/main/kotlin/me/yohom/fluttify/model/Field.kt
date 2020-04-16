package me.yohom.fluttify.model

import me.yohom.fluttify.NEXT_ID
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
    var isDeprecated: Boolean = false,
    override var id: Int = NEXT_ID
) : IPlatform, IScope, IElement {

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
        println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓属性↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        println("属性:\"${toString()}\"执行getter过滤开始")
        val result = (must("jsonable类型") { variable.typeName.jsonable() }
                || must("关联类型都通过过滤") { variable.typeName.allTypes().all { it.filter() } })
                && // 必须先通过类型的过滤
                must("公开field") { isPublic }
                &&
                mustNot("静态field") { isStatic }
                &&
                variable.mustNot("多维列表") { getIterableLevel() > 1 }
                &&
                variable.mustNot("lambda类型") { isLambda() }
                &&
                variable.mustNot("匿名lambda类型") { Regex("\\(\\^\\w+\\)\\(\\)").matches(name) }
                &&
                variable.must("具体类型或者含有子类的抽象类") { isConcret() || hasConcretSubtype() }
                &&
                variable.mustNot("回调类") { isCallback() }
        println("属性:\"${toString()}\"执行getter过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑属性↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
        return result
    }

    fun filterSetter(): Boolean {
        println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓属性↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        println("属性:${toString()}执行setter过滤开始")
        val result = (must("jsonable类型") { variable.typeName.jsonable() }
                || must("关联类型都通过过滤") { variable.typeName.allTypes().all { it.filter() } })
                && // 必须先通过类型的过滤
                must("公开field") { isPublic }
                &&
                mustNot("不可改field") { isFinal }
                &&
                mustNot("静态field") { isStatic }
                &&
                variable.mustNot("多维列表") { getIterableLevel() > 1 }
                &&
                variable.mustNot("lambda类型") { isLambda() }
                &&
                variable.mustNot("匿名lambda类型") { Regex("\\(\\^\\w+\\)\\(\\)").matches(name) }
        println("属性:${toString()}执行setter过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑属性↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
        return result
    }

    fun filterSetterBatch(): Boolean {
        return filterSetter() && !variable.isCallback()
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
            isDeprecated = isDeprecated,
            id = NEXT_ID
        )
    }

    fun asSetterMethod(): Method {
        return Method(
            "void",
            setterName,
            listOf(Parameter(variable = variable, platform = platform, id = NEXT_ID)),
            isStatic = false,
            isAbstract = false,
            isPublic = true,
            className = className,
            platform = platform,
            isDeprecated = isDeprecated,
            id = NEXT_ID
        )
    }
}