package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.*

open class Type : PlatformAware {
    override var platform: Platform = Platform.Unknown

    /**
     * 全名
     */
    var name: String = ""

    /**
     * 泛型类型
     */
    var genericTypes: MutableList<TYPE_NAME> = mutableListOf()

    /**
     * 类/接口/枚举/lambda
     */
    var typeType: TypeType? = null

    /**
     * 是否公开
     */
    var isPublic: Boolean = true

    /**
     * 是否抽象
     */
    var isAbstract: Boolean = false

    /**
     * 是否是内部类
     */
    var isInnerClass: Boolean = false

    /**
     * 是否jsonable
     */
    var isJsonable: Boolean = false

    /**
     * 父类全名
     */
    var superClass: String = ""

    /**
     * 所有的构造器
     */
    var constructors: MutableList<Constructor> = mutableListOf()

    /**
     * 所有的字段
     */
    var fields: MutableList<Field> = mutableListOf()

    /**
     * 所有的方法
     */
    var methods: MutableList<Method> = mutableListOf()

    /**
     * 枚举值 枚举专用
     */
    var constants: MutableList<String> = mutableListOf()

    /**
     * 返回值类型 Lambda专用
     */
    var returnType: String = ""

    /**
     * 形参 Lambda专用
     */
    var formalParams: List<Parameter> = listOf()

    /**
     * 是否过时
     */
    var deprecated: Boolean = false

    /**
     * 是否是回调
     */
    fun isCallback(): Boolean {
        return typeType == TypeType.Interface // 必须是接口
                // 返回类型必须是void或者Boolean
                && methods.all { it.returnType in listOf("void", "boolean", "BOOL") }
                // 参数类型必须是jsonable或者引用类型
                && methods.all {
            it.formalParams.all {
                it.variable
                    .typeName
                    .findType()
                    .run { this != UNKNOWN_TYPE && !isInterface() }
            }
        }
                // 必须没有父类
                && superClass.isEmpty()
                // 或者是lambda
                || typeType == TypeType.Lambda
    }

    /**
     * 是否是delegate, 与callback类似, 但是callback侧重于异步, 而delegate侧重于委托
     */
    fun isDelegate(): Boolean {
        return isCallback() && name.endsWith("Delegate")
    }

    fun subtypes(): List<Type> {
        return SDK.sdks.flatMap { it.libs }.flatMap { it.types }.filter { it.superClass == this.name }
    }

    fun constructable(): Boolean {
        return !isAbstract
                && this != UNKNOWN_TYPE
                && !isList()
                && (constructors.filterConstructor().isNotEmpty() || constructors.isEmpty() || isJsonable)
    }

    fun isEnum(): Boolean {
        return typeType == TypeType.Enum
    }

    fun isStruct(): Boolean {
        return typeType == TypeType.Struct
    }

    fun isInterface(): Boolean {
        return typeType == TypeType.Interface
    }

    fun isList(): Boolean {
        return name.isList()
    }

    fun jsonable(): Boolean {
        return name.jsonable()
    }

    fun toDartType(): String {
        return name.toDartType()
    }

    fun isRefType(): Boolean {
        return typeType == TypeType.Class
    }

    fun isObfuscated(): Boolean {
        return name.isObfuscated()
    }

    fun isView(): Boolean {
        return superClass in listOf(
            "android.view.View",
            "android.view.ViewGroup",
            "android.widget.FrameLayout",
            "UIView"
        )
    }

    fun nameWithGeneric(): String {
        return if (genericTypes.isEmpty()) name else "$name<${genericTypes.joinToString()}>"
    }

    override fun toString(): String {
        return "Type(name='$name', genericTypes=$genericTypes, typeType=$typeType, isPublic=$isPublic, isInnerClass=$isInnerClass, isJsonable=$isJsonable, superClass='$superClass', constructors=$constructors, fields=$fields, methods=$methods, constants=$constants, returnType='$returnType', formalParams=$formalParams)"
    }

    companion object {
        val UNKNOWN_TYPE: Type = Type().apply { name = "unknown" }
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda, Struct
}