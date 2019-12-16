package me.yohom.fluttify.model

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*

open class Type : IPlatform, IScope {
    override var platform: Platform = Platform.Unknown

    /**
     * 全名
     */
    var name: String = ""

    /**
     * 是谁的别名
     */
    var aliasOf: String? = null

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
    override var isPublic: Boolean = true

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
    var isStaticType: Boolean = true

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
     * 返回值类型 Lambda/Function专用
     */
    var returnType: String = ""

    /**
     * 形参 Lambda/Function专用
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
                && !hasSubtype()
    }

    fun isLambda(): Boolean = typeType == TypeType.Lambda

    fun isFunction(): Boolean = typeType == TypeType.Function

    fun isKnownFunction(): Boolean {
        return isFunction()
                && returnType.findType() != UNKNOWN_TYPE
                && formalParams.all { it.variable.isKnownType() }
    }

    fun subtypes(): List<Type> {
        return SDK
            .sdks
            .flatMap { it.libs }
            .flatMap { it.types }
            .filter { (it.superClass == name || name in it.interfaces) && !it.name.isObfuscated() }
    }

    fun hasConcretSubtype(): Boolean {
        return firstConcretSubtype() != null
    }

    fun firstConcretSubtype(): Type? {
        return if (isConcret()) {
            this
        } else {
            SDK
                .sdks
                .flatMap { it.libs }
                .flatMap { it.types }
                .firstOrNull { (it.superClass == name || name in it.interfaces) && !it.name.isObfuscated() }
                ?.firstConcretSubtype()
        }
    }

    fun superType() : List<Type> {
        return listOf(superClass.findType()).union(interfaces.map { it.findType() }).toList()
    }

    fun isAlias(): Boolean {
        return typeType == TypeType.Alias
    }

    fun constructable(): Boolean {
        return !isAbstract
                // 但凡有循环构造, 即当前构造器的参数类型的构造器参数包含了当前类 形如: class A { A(B b) {} }; class B { B(A a) {} }
                // 这样的结构会造成死循环
                && !(constructors.any { it.formalParams.any { it.variable.type().constructors.any { it.formalParams.any { it.variable.typeName == name } } } })
                && (this != UNKNOWN_TYPE || jsonable())
                && !isEnum()
                && !isLambda()
                && !isFunction()
                && !isAlias()
                && !isObfuscated()
                // 不是静态类的内部类, 需要先构造外部类, 这里过滤掉
                && ((isInnerClass && isStaticType) || !isInnerClass)
                && (constructors.any { it.isPublic } || constructors.isEmpty())
                && (superClass.findType() != UNKNOWN_TYPE || superClass == "")
                && (constructors.any { it.formalParams.isEmpty() || it.formalParams.all { it.variable.constructable() } && it.isPublic } || constructors.isEmpty() || isJsonable)
                // 这条是针对ios平台, 如果init方法不是公开的(即被标记为unavailable), 那么就跳过这个类
                && ((platform == Platform.iOS && methods.find { it.name == "init" }?.isPublic != false) || platform != Platform.iOS)
    }

    fun isEnum(): Boolean {
        return typeType == TypeType.Enum
    }

    fun isStruct(): Boolean {
        return typeType == TypeType.Struct
    }

    fun isStructPointer(): Boolean {
        return typeType == TypeType.Struct && name.pack().endsWith("*")
    }

    fun isInterface(): Boolean {
        return typeType == TypeType.Interface
    }

    fun isConcret(): Boolean {
        return !isAbstract
    }

    fun hasSubtype(): Boolean {
        return subtypes().isNotEmpty()
    }

    fun isList(): Boolean {
        return name.isCollection()
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

    /**
     * 如果是lambda或者function类型, 提供一个转为method的方法
     */
    fun asMethod(): Method {
        return Method(
            returnType,
            name,
            formalParams,
            isFunction = true,
            isStatic = true,
            isAbstract = false,
            isPublic = true,
            className = name,
            platform = platform,
            isDeprecated = false
        )
    }

    override fun toString(): String {
        return "Type(name='$name', genericTypes=$genericTypes, typeType=$typeType, isPublic=$isPublic, isInnerClass=$isInnerClass, isJsonable=$isJsonable, superClass='$superClass', constructors=$constructors, fields=$fields, methods=$methods, constants=$constants, returnType='$returnType', formalParams=$formalParams)"
    }

    companion object {
        /**
         * 未知的类
         */
        val UNKNOWN_TYPE: Type = Type().apply { name = "unknown" }

        /**
         * 没有类
         */
        val NO_TYPE: Type = Type().apply { name = "" }
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda, Struct, Function, Alias
}