package me.yohom.fluttify.model

import me.yohom.fluttify.NEXT_ID
import me.yohom.fluttify.extensions.allTypes
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.must
import me.yohom.fluttify.extensions.mustNot

/**
 * 参数类型
 *
 * [Parameter]的[named]与[Variable]的区别是[Parameter]的[named]是指参数的命名部分, 而[Variable]的[name]就是变量的名称, 调用时不需要命名
 */
data class Parameter(
    val named: String = "",
    val variable: Variable,
    override var platform: Platform,
    override var id: Int = NEXT_ID
) : IPlatform, IElement {
    val filter: Boolean
        get() {
            println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓参数↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
            println("参数:${variable}执行过滤开始")
            val result = variable.mustNot("Lambda") { isLambda() } // lambda不参与传递
                    &&
                    variable.mustNot("Callback") { isCallback() } // 回调类不参与传递(但是接口类型参与传递)
                    &&
                    variable.must("已知类型") { isKnownType() }
                    ||
                    variable.must("jsonable类型") { jsonable() }
            println("参数:${variable}执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
            println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑参数↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
            return result
        }

    companion object {
        fun simpleParameter(typeName: String, name: String): Parameter {
            return Parameter(
                variable = Variable(typeName, name, Platform.General, id = NEXT_ID),
                platform = Platform.General,
                id = NEXT_ID
            )
        }
    }
}