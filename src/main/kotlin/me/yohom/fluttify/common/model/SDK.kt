package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.extensions.jsonable

class SDK {

    /**
     * 每构造一个sdk, 都记录到静态变量中去, 以供程序的其他地方调用
     */
    init {
        sdks.add(this)
    }

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

    companion object {
        val sdks: MutableList<SDK> = mutableListOf()

        private val androidSDK
            get() = sdks.firstOrNull { it.platform == Platform.Android }

        private val iOSSDK
            get() = sdks.firstOrNull { it.platform == Platform.iOS }

        fun findType(fullName: String): Type {
            val allTypes = androidSDK?.libs?.union(iOSSDK?.libs ?: listOf())?.flatMap { it.types } ?: listOf()
            return when {
                // 查找的类型在sdk内, 那么直接过滤出目标类型
                allTypes.map { it.name }.contains(fullName) -> allTypes.first { it.name == fullName }
                // 如果不在sdk内, 但是是jsonable类型, 那么构造一个Type
                fullName.jsonable() -> Type().apply { name = fullName }
                // 已支持的系统类
                fullName in listOf("android.content.Context", "android.app.Application", "android.app.Activity") -> Type().apply { name = fullName }
                // 其他情况一律认为不认识的类
                else -> Type.UNKNOWN_TYPE
            }
        }
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