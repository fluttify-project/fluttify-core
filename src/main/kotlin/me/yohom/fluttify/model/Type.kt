package me.yohom.fluttify.model

import me.yohom.fluttify.*
import me.yohom.fluttify.extensions.*

open class Type(override var id: Int = NEXT_ID) : IPlatform, IScope, IElement {
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
    var declaredGenericTypes: MutableList<TYPE_NAME> = mutableListOf()

    /**
     * 泛型类型
     */
    var definedGenericTypes: MutableList<TYPE_NAME> = mutableListOf()

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
     * 父类全名
     */
    var superClass: String = ""

    /**
     * 实现的接口全名
     */
    var interfaces: MutableList<String> = mutableListOf()

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
    var enumerators: MutableList<Enumerator> = mutableListOf()

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

    @delegate:Transient
    val filter: Boolean by lazy {
        if (TYPE_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓类↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        if (TYPE_LOG) println("类:\"${name}\"执行过滤开始")
        val result = mustNot("忽略类型") { EXCLUDE_TYPES.any { type -> type.matches(name) } }
                &&
                mustNot("以_开头") { name.startsWith("_") }
                &&
                must("已知类型") { isKnownType }
                &&
                must("公开类型") {
                    // 这里需要把内部类的所有外部类都判断过去, 只要碰到一个外部类不是public的, 那当前内部类就认为不是public的
                    // 碰到了三层内部类的情况, 然后最内一层是public的, 上面两层不是public的
                    var tmp = this
                    var result = tmp.isPublic
                    while (tmp.isInnerType) {
                        if (tmp.isPublic) {
                            tmp = tmp.name.substringBeforeLast("$").containerType().findType()
                            result = tmp.isPublic
                        } else {
                            result = false
                            break
                        }
                    }
                    result
                }
                &&
                must("类名不能为空") { name.isNotBlank() }
                &&
                mustNot("混淆类型") { isObfuscated }
                &&
                mustNot("函数类型且含有lambda") { isFunction && formalParams.any { it.variable.isLambda() } }
                &&
                mustNot("祖宗类含有忽略类型") {
                    ancestorTypes.isNotEmpty() && EXCLUDE_TYPES.any { type -> ancestorTypes.any { type.matches(it) } }
                }
                &&
                (isEnum || !isInnerType || (constructors.any { it.isPublic } || constructors.isEmpty())).apply {
                    if (!this) println("filterType: $name 由于构造器不是全公开且是内部类 被过滤")
                }
                ||
                must("是List") { /* Regexes.MAP.matches(name) ||*/ Regexes.ITERABLE.matches(name) }
        if (TYPE_LOG) println("类:\"${name}\"执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        if (TYPE_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑类↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
        result
    }

    /**
     * 是否是回调
     *
     * 查找sdk中所有的类, 如果没有一个类是当前类的子类, 且当前类是接口类型, 那么就认为这个类是回调类
     */
    @delegate:Transient
    val isCallback: Boolean by lazy {
        // 是否在手动配置的回调类列表内
        when (platform) {
            Platform.General -> false
            Platform.iOS -> ext.ios.callbackClasses.any { Regex(it).matches(name) }
            Platform.Android -> ext.android.callbackClasses.any { Regex(it).matches(name) }
            Platform.Unknown -> false
        }
                ||
                ((isInterface || isAbstract) // 必须是接口 或 抽象类
                        &&
                        // 必须公开
                        isPublic
                        &&
                        (interfaces.isEmpty() || interfaces.contains("NSObject") || interfaces.contains("java.io.Serializable"))
                        &&
                        constructors.isEmpty()
                        &&
                        // 必须没有子类
                        !hasSubtype
                        &&
                        // 不在手动配置的非回调类列表内
                        when (platform) {
                            Platform.General -> true
                            Platform.iOS -> ext.ios.noncallbackClasses.none { Regex(it).matches(name.depointer()) }
                            Platform.Android -> ext.android.noncallbackClasses.none { Regex(it).matches(name.depointer()) }
                            Platform.Unknown -> true
                        })
    }

    @delegate:Transient
    val isLambda: Boolean by lazy { typeType == TypeType.Lambda }

    @delegate:Transient
    val isFunction: Boolean by lazy { typeType == TypeType.Function }

    @delegate:Transient
    val isKnownFunction: Boolean by lazy {
        isFunction
                && returnType.findType().isKnownType
                && formalParams.all { it.variable.isKnownType() }
    }

    @delegate:Transient
    val subtypes: List<Type> by lazy {
        SDK
            .sdks
            .flatMap { it.libs }
            .flatMap { it.types }
            .asSequence()
            // 计算子类的时候, 去除掉忽略的类
            .filter { type -> EXCLUDE_TYPES.none { it.matches(type.name) } }
            .filter { it.isPublic }
            .filter { it.ancestorTypes.contains(name) }
            .toList()
    }

    @delegate:Transient
    val hasConcretSubtype: Boolean by lazy {
        firstConcretSubtype != null && isKnownType
    }

    @delegate:Transient
    val firstConcretSubtype: Type? by lazy {
        subtypes.firstOrNull { it.isConcret && !it.isObfuscated }
    }

    fun isAlias(): Boolean {
        return typeType == TypeType.Alias
    }

    @delegate:Transient
    val constructable: Boolean by lazy {
        if (CONSTRUCTOR_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓构造器↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        if (CONSTRUCTOR_LOG) println("构造器:${name}执行过滤开始")
        val result = mustNot("抽象类型") { isAbstract }
                &&
                // 但凡有循环构造, 即当前构造器的参数类型的构造器参数包含了当前类 形如: class A { A(B b) {} }; class B { B(A a) {} }
                // 这样的结构会造成死循环
                mustNot("构造器循环构造") {
                    constructors.isNotEmpty() &&
                            constructors.all {
                                it.formalParams.any {
                                    it.variable.containerType().constructors.any { it.formalParams.any { it.variable.trueType == name } }
                                }
                            }
                }
                &&
                // class A { A(A a) {} }
                mustNot("构造器含有自身类型的参数") {
                    constructors.isNotEmpty() &&
                            constructors.all { it.formalParams.map { it.variable.trueType }.contains(this.name) }
                }
                &&
                must("是已知类型或jsonable类型") { isKnownType }
                &&
                mustNot("lambda类型") { isLambda }
                &&
                mustNot("函数类型") { isFunction }
                &&
                mustNot("别名类型") { isAlias() }
                &&
                mustNot("混淆类型") { isObfuscated }
                &&
                must("存在参数都不为`混淆类型 或 未知类`的构造器") {
                    constructors
                        .any {
                            it.formalParams.map { it.variable.trueType }
                                .all { !it.isObfuscated() && it.findType().isKnownType }
                        }
                            || constructors.isEmpty()
                }
                &&
                // 不是静态类的内部类, 需要先构造外部类, 这里过滤掉
                must("静态类的内部类") { (isInnerType && isStaticType) || !isInnerType }
                &&
                must("有公开构造器 或 没有声明构造器") { (constructors.any { it.isPublic } || constructors.isEmpty()) }
                &&
                must("存在构造器可以通过过滤 或 没有构造器") { constructors.any { it.filter } || constructors.isEmpty() }
                &&
                must("这条是针对ios平台, 如果init方法不是公开的(即被标记为unavailable), 那么就跳过这个类") {
                    platform == Platform.iOS && methods.find { it.name == "init" }?.isPublic != false
                            || platform != Platform.iOS
                }
                &&
                must("这条是针对ios平台, 祖宗类是可构造的") {
                    platform != Platform.iOS
                            ||
                            ancestorTypes.isEmpty()
                            ||
                            ancestorTypes.all { it.findType().run { constructable || isAbstract } } }
                ||
                must("公开枚举") { isPublic && isEnum }
        if (CONSTRUCTOR_LOG) println("构造器:${name}执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        if (CONSTRUCTOR_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑构造器↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
        result
    }

    @delegate:Transient
    val isEnum: Boolean by lazy {
        typeType == TypeType.Enum
    }

    @delegate:Transient
    val isStruct: Boolean by lazy {
        typeType == TypeType.Struct
    }

    @delegate:Transient
    val isStructPointer: Boolean by lazy {
        typeType == TypeType.Struct && name.pack().endsWith("*")
    }

    @delegate:Transient
    val isInterface: Boolean by lazy {
        typeType == TypeType.Interface
    }

    @delegate:Transient
    val isConcret: Boolean by lazy {
        !isAbstract && isKnownType
    }

    @delegate:Transient
    val hasSubtype: Boolean by lazy {
        subtypes.isNotEmpty()
    }

    @delegate:Transient
    val jsonable: Boolean by lazy {
        name.jsonable()
    }

    @delegate:Transient
    val toDartType: String by lazy {
        name.toDartType()
    }

    @delegate:Transient
    val isObfuscated: Boolean by lazy {
        name.isObfuscated()
    }

    @delegate:Transient
    val isView: Boolean by lazy {
        must("通过类型过滤") { filter }
                &&
                must("祖宗类中有平台View类") {
                    ancestorTypes.any {
                        it in listOf(
                            "android.view.View",
                            "android.view.SurfaceView",
                            "android.view.ViewGroup",
                            "android.widget.FrameLayout",
                            "UIView"
                        )
                    }
                }
                && mustNot("抽象类型") { isAbstract }
                && mustNot("混淆类型") { isObfuscated }
                && must("可构造") { constructable }
                && must("是class") { typeType == TypeType.Class }
                && must("非排除类") { EXCLUDE_TYPES.none { exType -> exType.matches(name) } }
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
            isDeprecated = false,
            id = NEXT_ID
        )
    }

    /**
     * [ancestorTypes]的一个别名方法, 过滤出祖宗类型里的接口, [includeObfuscated]区分是否包含混淆的接口类
     */
    fun ancestorInterfaces(includeObfuscated: Boolean = true): List<String> {
        return ancestorTypes
            .filter { it.findType().run { typeType == TypeType.Interface && filter } }
            .filter { if (!includeObfuscated) !it.isObfuscated() else true }
    }

    @delegate:Transient
    val isKnownType: Boolean by lazy {
        platform != Platform.Unknown || jsonable || Regexes.ITERABLE.matches(name) || Regexes.MAP.matches(name)
    }

    @delegate:Transient
    val isUnknownType: Boolean by lazy {
        !isKnownType
    }

    /**
     * 从Category合并到Class里去
     */
    fun mergeWithCategory(): Type {
        val categories = SDK.findExtensions(name)
        categories.forEach {
            fields.addAll(it.fields)
            methods.addAll(it.methods)
            interfaces.addAll(it.interfaces)
        }
        return this
    }

    override fun toString(): String {
        return "Type(name='$name', genericTypes=$declaredGenericTypes, typeType=$typeType, isPublic=$isPublic, isInnerClass=$isInnerType, superClass='$superClass', constructors=$constructors, fields=$fields, methods=$methods, constants=$enumerators, returnType='$returnType', formalParams=$formalParams)"
    }

    companion object {
        /**
         * 没有类
         */
        val NO_TYPE: Type = Type(id = NEXT_ID).apply { name = ""; platform = Platform.General }
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda, Struct, Function, Alias, Extension
}