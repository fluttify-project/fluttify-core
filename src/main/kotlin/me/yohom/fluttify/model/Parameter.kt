package me.yohom.fluttify.model

import me.yohom.fluttify.METHOD_LOG
import me.yohom.fluttify.NEXT_ID
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
            if (METHOD_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓参数↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
            if (METHOD_LOG) println("参数:${variable}执行过滤开始")
            val result = (variable.mustNot("Lambda") { isLambda() } // lambda不参与传递
                    // 碰到一种情况, 一个回调类既需要作为对象传递又需要作为回调处理
                    // 解决方案为对象照常传递, 在原生端判断对象是否为null, 如果是null则作为回调处理
//                    &&
//                    variable.mustNot("Callback") { isCallback() } // 回调类不参与传递(但是接口类型参与传递)
                    &&
                    variable.must("已知类型") { isKnownType() })
                    ||
                    variable.must("jsonable类型") { jsonable() }
            if (METHOD_LOG) println("参数:${variable}执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
            if (METHOD_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑参数↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
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