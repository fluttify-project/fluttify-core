package me.yohom.fluttify.model

data class Constructor(
    /**
     * 构造器名称
     */
    var name: String,
    /**
     * 形参
     */
    var formalParams: List<Parameter>,
    /**
     * 是否公开
     */
    var isPublic: Boolean?,
    override var platform: Platform
) : PlatformAware