package me.yohom.fluttify.common.model

data class Constructor(
    /**
     * 构造器名称
     */
    var name: String,
    /**
     * 形参
     */
    var formalParams: List<Variable>,
    /**
     * 是否公开
     */
    var isPublic: Boolean?,
    override var platform: Platform = Platform.Unknown
) : PlatformAware