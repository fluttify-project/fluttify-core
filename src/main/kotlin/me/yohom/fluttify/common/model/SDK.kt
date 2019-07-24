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
    var libs: MutableList<Lib> = mutableListOf()

    override fun toString(): String {
        return "SDK(version='$version', platform=$platform, libs=$libs)"
    }
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

    override fun toString(): String {
        return "Lib(name='$name', types=$types)"
    }
}

enum class Platform {
    iOS, Android, Unknown
}