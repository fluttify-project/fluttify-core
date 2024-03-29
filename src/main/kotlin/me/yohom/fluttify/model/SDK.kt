package me.yohom.fluttify.model

import com.google.gson.Gson
import me.yohom.fluttify.EXCLUDE_CONSTANTS
import me.yohom.fluttify.EXCLUDE_LIBS
import me.yohom.fluttify.SYSTEM_TYPE
import me.yohom.fluttify.SYSTEM_TYPEDEF
import me.yohom.fluttify.extensions.depointer

class SDK : IPlatform {

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

    /**
     * 非间接依赖的库
     */
    val directLibs: List<Lib>
        get() = libs.filterNot { it.isDependency }
            .filter { lib -> EXCLUDE_LIBS.none { it.matches(lib.name) } }

    /**
     * 所有通过过滤的方法
     */
    @delegate:Transient
    val allFilteredMethods: List<Method> by lazy {
        directLibs.flatMap { it.types }.flatMap { it.methods }.filter { it.filter }
    }

    /**
     * 所有常量
     */
    @delegate:Transient
    val allConstants: List<Field> by lazy {
        directLibs.flatMap { it.types }.flatMap { it.fields }.filter { it.filterConstants }
    }

    /**
     * 所有属性
     */
    @delegate:Transient
    val allProperties: List<Field> by lazy {
        directLibs.flatMap { it.types }.flatMap { it.fields }
            .filter { it.filterGetters || it.filterSetter }
    }

    /**
     * 所有类型
     */
    @delegate:Transient
    val allTypes: MutableList<Type> by lazy {
        directLibs.flatMap { it.types }.toMutableList()
    }

    /**
     * 所有枚举类型
     */
    @delegate:Transient
    val allEnumTypes: MutableList<Type> by lazy {
        directLibs.flatMap { it.types }.filter { it.typeType == TypeType.Enum }.toMutableList()
    }

    override fun toString(): String {
        return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
    }

    companion object {
        val sdks: MutableList<SDK> = mutableListOf()

        private val androidSDK
            get() = sdks.firstOrNull { it.platform == Platform.Android }

        private val iOSSDK
            get() = sdks.firstOrNull { it.platform == Platform.iOS }

        fun findType(fullName: String): Type {
            val allTypes = (androidSDK?.libs ?: mutableListOf())
                .union(iOSSDK?.libs ?: listOf())
                .flatMap { it.types }
            val finalTypeName = (SYSTEM_TYPEDEF[fullName] ?: fullName)
            return when {
                // 如果是空字符串那么返回NO_TYPE
                finalTypeName.isEmpty() -> Type.NO_TYPE
                // 查找的类型在sdk内, 那么直接过滤出目标类型
                allTypes.map { it.name.depointer() }
                    .contains(finalTypeName) -> allTypes.first { it.name.depointer() == finalTypeName }
                // 已支持的系统类 由于会有泛型类的情况, 比如`android.util.Pair<*, *>`, 所以需要通过正则表达式来处理
                SYSTEM_TYPE.map { Regex(it.name) }
                    .any { it.matches(finalTypeName) } -> SYSTEM_TYPE.first {
                    Regex(it.name).matches(finalTypeName)
                }
                // 是objc的id指针
                finalTypeName == "id" -> Type().apply {
                    name = "id"; typeType = TypeType.Class; platform = Platform.iOS
                }
                // void*类型
                finalTypeName == "void*" -> Type().apply {
                    name = "NSValue"; typeType = TypeType.Class; platform = Platform.iOS
                }
                // lambda
                finalTypeName.contains("|") -> Type().apply {
                    typeType = TypeType.Lambda
                    name = finalTypeName
                    returnType = finalTypeName.substringBefore("|")
                    formalParams = finalTypeName
                        .substringAfter("|")
                        .split(",")
                        .filter { it.contains("#") }
                        .map { it.trim().split("#") }
                        .map {
                            Parameter(
                                variable = Variable(it[0], it[1], platform = Platform.iOS),
                                platform = Platform.iOS
                            )
                        }
                    platform = Platform.iOS
                }
                else -> Type().apply { name = finalTypeName }
            }
        }

        fun findExtensions(fullName: String): List<Type> {
            val allTypes = (androidSDK?.libs ?: mutableListOf()).union(iOSSDK?.libs ?: listOf())
                .flatMap { it.types }
            return allTypes.filter { it.typeType == TypeType.Extension && it.name == fullName }
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
    var sourceFiles: MutableList<SourceFile> = mutableListOf()

    /**
     * 类
     */
    val types: List<Type>
        get() = sourceFiles.filter { it.filter }.flatMap { it.types }

    /**
     * 顶层常量
     */
    val topLevelConstants: List<Variable>
        get() = sourceFiles.filter { it.filter }
            .flatMap { it.topLevelConstants }
            .distinctBy { it.name }
            .filter { it.isKnownType() }
            .filter { lib -> EXCLUDE_CONSTANTS.none { it.matches(lib.name) } }

    /**
     * 是否是依赖
     */
    var isDependency: Boolean = false

    override fun toString(): String {
        return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
    }
}

enum class Platform {
    General, iOS, Android, Unknown;

    fun objectType(): String {
        return when (this) {
            General -> "Object"
            iOS -> "NSObject"
            Android -> "java_lang_Object"
            Unknown -> "Object"
        }
    }

    fun nativeObjectType(): String {
        return when (this) {
            General -> "Object"
            iOS -> "NSObject*"
            Android -> "java.lang.Object"
            Unknown -> "Object"
        }
    }
}