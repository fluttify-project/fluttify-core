package me.yohom.fluttify.model

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.mustNot

/**
 * 参数类型
 *
 * [Parameter]的[named]与[Variable]的区别是[Parameter]的[named]是指参数的命名部分, 而[Variable]的[name]就是变量的名称, 调用时不需要命名
 */
data class Parameter(
    val named: String = "",
    val variable: Variable,
    override var platform: Platform
) : IPlatform {
    fun filter(): Boolean {
        return variable.mustNot("Lambda") { isLambda() } && // lambda不参与传递
                variable.mustNot("Callback") { isCallback() } && // 回调类不参与传递(但是接口类型参与传递)
                variable.mustNot("未知类型") { typeName.findType() == Type.UNKNOWN_TYPE }
    }
}