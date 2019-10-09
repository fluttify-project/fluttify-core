package me.yohom.fluttify.model

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*

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
     * 是否是静态(内部)类
     */
    var isStaticType: Boolean = false

    /**
     * 是否jsonable
     */
    var isJsonable: Boolean = false

    /**
     * 父类全名
     */
    var superClass: String = ""

    /**
     * 实现的接口全名
     */
    var interfaces: List<String> = mutableListOf()

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
     *
     * 查找sdk中所有的类, 如果没有一个类是当前类的子类, 且当前类是接口类型, 那么就认为这个类是回调类
     */
    fun isCallback(): Boolean {
        return isInterface() // 必须是接口
                // 必须公开
                && isPublic
                // 不能有泛型
                && genericTypes.isEmpty()
                // 回调类不能有超类
                && superClass == ""
                && (interfaces.isEmpty() || interfaces.contains("NSObject"))
                // 必须没有子类
                && SDK.sdks.flatMap { it.libs }.flatMap { it.types }.none { it.interfaces.contains(this.name) || it.superClass == this.name }
    }

    fun isLambda(): Boolean = typeType == TypeType.Lambda

    fun subtypes(): List<Type> {
        return SDK.sdks.flatMap { it.libs }.flatMap { it.types }.filter { it.superClass == this.name }
    }

    fun constructable(): Boolean {
        return !isAbstract
                && (this != UNKNOWN_TYPE || isList())
                && !isEnum()
                && !isObfuscated()
                // 不是静态类的内部类, 需要先构造外部类, 这里过滤掉
                && ((isInnerClass && isStaticType) || !isInnerClass)
                && (constructors.any { it.isPublic == true } || constructors.isEmpty())
                && (superClass.findType() != UNKNOWN_TYPE || superClass == "")
                && (constructors.filterConstructor().isNotEmpty() || constructors.isEmpty() || isJsonable)
                // 这条是针对ios平台, 如果init方法不是公开的(即被标记为unavailable), 那么就跳过这个类
                && ((platform == Platform.iOS && methods.find { name == "init" }?.isPublic == true) || platform != Platform.iOS)
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
        return typeType == TypeType.Class || typeType == TypeType.Interface
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