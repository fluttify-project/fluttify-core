package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.SYSTEM_TYPE
import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.jsonable

class SDK : PlatformAware {

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
    override var platform: Platform = Platform.Unknown

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
            val allTypes = (androidSDK?.libs ?: mutableListOf()).union(iOSSDK?.libs ?: listOf()).flatMap { it.types }
            return when {
                // 查找的类型在sdk内, 那么直接过滤出目标类型
                allTypes.map { it.name.depointer() }.contains(fullName) -> allTypes.first { it.name.depointer() == fullName }
                // 如果不在sdk内, 但是是jsonable类型, 那么构造一个Type
                fullName.jsonable() -> Type().apply { name = fullName; isJsonable = true }
                // 已支持的系统类
                fullName in SYSTEM_TYPE.map { it.name } -> SYSTEM_TYPE.first { it.name == fullName }
                // lambda
                fullName.contains("|") -> Type().apply {
                    typeType = TypeType.Lambda
                    name = fullName
                    returnType = fullName.substringBefore("|")
                    formalParams = fullName
                        .substringAfter("|")
                        .split(",")
                        .map { it.split(" ") }
                        .map {
                            Parameter(
                                variable = Variable(it[0], it[1], platform = Platform.General),
                                platform = Platform.General
                            )
                        }
                }
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

    /**
     * 回调类们
     */
    val callbacks: List<Type>
        get() = types.filter { it.isCallback() }

    override fun toString(): String {
        return "Lib(name='$name', types=$types)"
    }
}

enum class Platform {
    General, iOS, Android, Unknown
}