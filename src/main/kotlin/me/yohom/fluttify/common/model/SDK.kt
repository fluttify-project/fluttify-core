package me.yohom.fluttify.common.model

class SDK {
    /**
     * 版本
     */
    var version: String = "0.0.1"

    /**
     * 平台
     */
    var platform: Platform = Platform.Unknown

    /**
     * 库 Android上是jar, iOS上是framework
     */
    val libs: MutableList<Lib> = mutableListOf()
}

class Lib {
    /**
     * 名称
     */
    var name: String = ""

    /**
     * 类
     */
    var types: MutableList<Type> = mutableListOf()
}

enum class Platform {
    iOS, Android, Unknown
}