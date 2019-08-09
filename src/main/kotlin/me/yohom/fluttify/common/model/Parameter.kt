package me.yohom.fluttify.common.model

/**
 * 参数类型
 *
 * [Parameter]的[named]与[Variable]的区别是[Parameter]的[named]是指参数的命名部分, 而[Variable]的[name]就是变量的名称, 调用时不需要命名
 */
class Parameter(
    val named: String = "",
    val variable: Variable,
    override var platform: Platform = Platform.Unknown
) : PlatformAware