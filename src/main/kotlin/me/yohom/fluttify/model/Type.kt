package me.yohom.fluttify.model

import me.yohom.fluttify.EXCLUDE_TYPES
import me.yohom.fluttify.Regexes
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
    var isInnerType: Boolean = false

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
     * 祖宗类型
     *
     * 包括类和接口, 因为需要递归, 而且结果是不变的, 所以这里用lazy计算, 提高性能
     */
    @delegate:Transient
    val ancestorTypes by lazy {
        val result = mutableListOf<String>()

        fun findAncestorClasses(clazz: String) {
            val superClass = clazz.findType().superClass
            if (superClass.isNotEmpty()) {
                result.add(superClass)
                findAncestorClasses(superClass)
            }
            // 从父类搜索祖先类时, 不能缺了父类实现的接口
            val interfaces = clazz.findType().interfaces
            if (interfaces.isNotEmpty()) {
                interfaces.forEach {
                    result.add(it)
                    findAncestorClasses(it)
                }
            }
        }

        fun findAncestorInterfaces(interfaze: String) {
            val interfaces = interfaze.findType().interfaces
            if (interfaces.isNotEmpty()) {
                interfaces.forEach {
                    result.add(it)
                    findAncestorInterfaces(it)
                }
            }
        }

        findAncestorClasses(name)
        findAncestorInterfaces(name)

        result.distinct()
    }

    fun filter(): Boolean {
        println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓类↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        println("类:${name}执行过滤开始")
        val result = must("已知类型") { platform != Platform.Unknown }
                &&
                must("公开类型") { isPublic }
                &&
                must("祖宗类全部是已知类型") { ancestorTypes.all { it.findType().platform != Platform.Unknown } }
                &&
                // 换言之只支持接口的泛型
                mustNot("不是接口且含有泛型") { !isInterface() && genericTypes.isNotEmpty() }
                &&
                mustNot("混淆类型") { isObfuscated() }
                &&
                mustNot("忽略类型") { EXCLUDE_TYPES.any { type -> type.matches(name) } }
                &&
                mustNot("祖宗类含有忽略类型") { EXCLUDE_TYPES.any { type -> ancestorTypes.any { type.matches(it) } } }
                &&
                (isEnum() || !isInnerType || (constructors.any { it.isPublic } || constructors.isEmpty())).apply {
                    if (!this) println("filterType: $name 由于构造器不是全公开且是内部类 被过滤")
                }
                ||
                must("是List") { /* Regexes.MAP.matches(name) ||*/ Regexes.ITERABLE.matches(name) }
        println("类:${name}执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑类↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
        return result
    }

    /**
     * 是否是回调
     *
     * 查找sdk中所有的类, 如果没有一个类是当前类的子类, 且当前类是接口类型, 那么就认为这个类是回调类
     */
    fun isCallback(): Boolean {
        return isInterface() // 必须是接口
                // 必须公开
                && isPublic
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
                && returnType.findType().platform != Platform.Unknown
                && formalParams.all { it.variable.isKnownType() }
    }

    fun subtypes(): List<Type> {
        return SDK
            .sdks
            .flatMap { it.libs }
            .flatMap { it.types }
            .asSequence()
            // 计算子类的时候, 去除掉忽略的类
            .filter { type -> EXCLUDE_TYPES.none { it.matches(type.name) } }
            .filter { it.isPublic }
            .filterNot { it.name.isObfuscated() }
            .filter { (it.superClass == name || name in it.interfaces) }
            .toList()
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

    fun superTypes(): List<Type> {
        return listOf(superClass.findType())
            .union(interfaces.map { it.findType() })
            .toList()
    }

    fun isAlias(): Boolean {
        return typeType == TypeType.Alias
    }

    fun constructable(): Boolean {
        println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓构造器↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        println("构造器:${name}执行过滤开始")
        val result = mustNot("抽象类型") { isAbstract }
                &&
                // 但凡有循环构造, 即当前构造器的参数类型的构造器参数包含了当前类 形如: class A { A(B b) {} }; class B { B(A a) {} }
                // 这样的结构会造成死循环
                mustNot("构造器循环构造") {
                    constructors.any {
                        it.formalParams.any {
                            it.variable.containerType().constructors.any { it.formalParams.any { it.variable.typeName == name } }
                        }
                    }
                }
                &&
                must("是已知类型或jsonable类型") { platform != Platform.Unknown || jsonable() }
                &&
                mustNot("枚举类型") { isEnum() }
                &&
                mustNot("lambda类型") { isLambda() }
                &&
                mustNot("函数类型") { isFunction() }
                &&
                mustNot("别名类型") { isAlias() }
                &&
                mustNot("混淆类型") { isObfuscated() }
                &&
                // 不是静态类的内部类, 需要先构造外部类, 这里过滤掉
                must("静态类的内部类") { (isInnerType && isStaticType) || !isInnerType }
                &&
                must("有公开构造器或没有声明构造器") { (constructors.any { it.isPublic } || constructors.isEmpty()) }
                &&
                must("父类不是未知类或没有父类") { superClass.findType().platform != Platform.Unknown || superClass == "" }
                &&
                must("所有构造器都通过过滤或没有构造器或jsonable类型") { constructors.any { it.filter() } || constructors.isEmpty() || isJsonable }
                &&
                must("这条是针对ios平台, 如果init方法不是公开的(即被标记为unavailable), 那么就跳过这个类") {
                    platform == Platform.iOS && methods.find { it.name == "init" }?.isPublic != false
                            || platform != Platform.iOS
                }
        println("构造器:${name}执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑构造器↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
        return result
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

    fun jsonable(): Boolean {
        return name.jsonable()
    }

    fun toDartType(): String {
        return name.toDartType()
    }

    fun isObfuscated(): Boolean {
        return name.isObfuscated()
    }

    fun isView(): Boolean {
        return ancestorTypes.any {
            it in listOf(
                "android.view.View",
                "android.view.ViewGroup",
                "android.widget.FrameLayout",
                "UIView"
            )
        } && !isAbstract
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

    /**
     * [ancestorTypes]的一个别名方法, 过滤出祖宗类型里的接口, [includeObfuscated]区分是否包含混淆的接口类
     */
    fun ancestorInterfaces(includeObfuscated: Boolean = true): List<String> {
        return ancestorTypes
            .filter { it.findType().typeType == TypeType.Interface }
            .filter { if (!includeObfuscated) !it.isObfuscated() else true }
    }

    fun isKnownType(): Boolean {
        return platform != Platform.Unknown
    }

    fun isUnknownType(): Boolean {
        return platform == Platform.Unknown
    }

    override fun toString(): String {
        return "Type(name='$name', genericTypes=$genericTypes, typeType=$typeType, isPublic=$isPublic, isInnerClass=$isInnerType, isJsonable=$isJsonable, superClass='$superClass', constructors=$constructors, fields=$fields, methods=$methods, constants=$constants, returnType='$returnType', formalParams=$formalParams)"
    }

    companion object {
        /**
         * 没有类
         */
        val NO_TYPE: Type = Type().apply { name = ""; platform = Platform.General }
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda, Struct, Function, Alias
}