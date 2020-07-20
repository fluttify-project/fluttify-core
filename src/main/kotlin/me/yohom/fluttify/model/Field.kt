package me.yohom.fluttify.model

import me.yohom.fluttify.*
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

    val filterConstants: Boolean
        get() {
            return must("公开field") { isPublic }
                    &&
                    must("静态field") { isStatic == true }
                    &&
                    must("不可变变量") { isFinal == true }
                    &&
                    variable.mustNot("名为CREATOR") { name == "CREATOR" }
                    &&
                    variable.must("数字或字符串类型") {
                        trueType in listOf("int", "double", "String") && (value.isNumber() || value.isString())
                    }
                    &&
                    must("有值") { value.isNotEmpty() }
                    &&
                    mustNot("包含new关键字") { value.startsWith("new") }
                    &&
                    variable.mustNot("变量名为关键字") { name in JAVA_RESERVED }
        }

    val filterGetters: Boolean
        get() {
            if (FIELD_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓属性↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
            if (FIELD_LOG) println("属性:\"${toString()}\"执行getter过滤开始")
            val result = (must("jsonable类型") { variable.trueType.jsonable() }
                    // 关联类型不能超过2个, 即只能有一个泛型, 像Map<X, Y>这种就要过滤掉, 因为无法直接传递
                    || must("关联类型都通过过滤") { variable.trueType.allTypes().run { size <= 2 && all { it.filter } } })
                    && // 必须先通过类型的过滤
                    must("公开field") { isPublic }
                    &&
                    variable.mustNot("多维列表") { getIterableLevel() > 1 }
                    &&
                    variable.mustNot("名为CREATOR") { name == "CREATOR" }
                    &&
                    variable.mustNot("lambda类型") { isLambda() }
                    &&
                    variable.mustNot("匿名lambda类型") { Regex("\\(\\^\\w+\\)\\(.*\\)").matches(name) }
                    &&
                    variable.mustNot("回调类") { isCallback() }
                    &&
                    variable.mustNot("常量") { filterConstants }
                    &&
                    variable.mustNot("变量名为关键字") { name in JAVA_RESERVED }
            if (FIELD_LOG) println("属性:\"${toString()}\"执行getter过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
            if (FIELD_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑属性↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
            return result
        }

    val filterSetter: Boolean
        get() {
            if (FIELD_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓属性↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
            if (FIELD_LOG) println("属性:${toString()}执行setter过滤开始")
            val result = (must("jsonable类型") { variable.trueType.jsonable() }
                    // 关联类型不能超过2个, 即只能有一个泛型, 像Map<X, Y>这种就要过滤掉, 因为无法直接传递
                    || must("关联类型都通过过滤") { variable.trueType.allTypes().run { size <= 2 && all { it.filter } } })
                    && // 必须先通过类型的过滤
                    must("公开field") { isPublic }
                    &&
                    mustNot("不可改field") { isFinal }
                    &&
                    variable.mustNot("多维列表") { getIterableLevel() > 1 }
                    &&
                    variable.mustNot("名为CREATOR") { name == "CREATOR" }
                    &&
                    variable.mustNot("lambda类型") { isLambda() }
                    &&
                    variable.mustNot("匿名lambda类型") { Regex("\\(\\^\\w+\\)\\(.*\\)").matches(name) }
                    &&
                    variable.mustNot("常量") { filterConstants }
                    &&
                    variable.mustNot("变量名为关键字") { name in JAVA_RESERVED }
            if (FIELD_LOG) println("属性:${toString()}执行setter过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
            if (FIELD_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑属性↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
            return result
        }

    val filterSetterBatch: Boolean
        get() {
            return filterSetter && !variable.isCallback()
        }

    val getterMethodName: String
        get() {
            return "${className.replace("$", ".")}::get_${getterName.depointer()}"
        }

    val setterMethodName: String
        get() {
            return "${className.replace("$", ".")}::set_${setterName.depointer()}"
        }

    fun asGetterMethod(): Method {
        return Method(
            variable.trueType,
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