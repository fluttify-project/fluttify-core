package me.yohom.fluttify.common.model

class SDK {
    /**
     * 版本
     */
    var version: String = ""

    /**
     * 名称
     */
    var name: String = ""

    /**
     * 平台
     */
    var platform: Platform = Platform.Unknown

    /**
     * 类
     */
    var types: MutableList<Type> = mutableListOf()
}

enum class Platform {
    iOS, Android, Unknown
}