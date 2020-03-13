package me.yohom.fluttify.model

import me.yohom.fluttify.EXCLUDE_METHODS
import me.yohom.fluttify.EXCLUDE_TYPES
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*

data class Method(
    /**
     * 方法返回类型
     */
    var returnType: String,
    /**
     * 方法名称
     */
    var name: String,
    /**
     * 形参
     */
    var formalParams: List<Parameter>,
    /**
     * 是否静态
     */
    var isStatic: Boolean,
    /**
     * 是否抽象
     */
    var isAbstract: Boolean?,
    /**
     * 是否公开
     */
    override var isPublic: Boolean,
    /**
     * 所在类名称
     */
    var className: TYPE_NAME,
    override var platform: Platform,

    /**
     * 是否过时
     */
    var isDeprecated: Boolean = false,

    /**
     * 是否是函数
     */
    var isFunction: Boolean = false,
    /**
     * 是否是泛型方法
     */
    var isGenericMethod: Boolean = false
) : IPlatform, IScope {

    val exactName: String = "$name${formalParams.joinToString(":") { it.named }}"

    fun filter(): Boolean {
        return returnType.findType().filter() && // 返回类型必须先通过类型的过滤
                formalParams.all { it.variable.type().filter() } && // 参数类型必须先通过类型的过滤
                must("公开方法") { isPublic } &&
                mustNot("忽略方法") { EXCLUDE_METHODS.any { methods -> methods.matches(name) } } &&
                mustNot("废弃方法") { isDeprecated } &&
                // 重写的方法其实没必要再生成一次, 就算调用的是父类的方法, native端仍然是预期行为
                mustNot("祖宗类已有的方法") {
                    name in
                            className
                                .findType()
                                .ancestorTypes
                                .filter { !it.isObfuscated() }
                                .flatMap { it.findType().methods }
                                .map { it.name }
                } &&
                must("所在类是公开类") { className.findType().isPublic } &&
                must("所在类是静态类型") { className.findType().isStaticType } &&
                must("形参类型全部都是公开类型") { formalParams.all { it.variable.isPublicType() } } &&
                must("形参类型全部都是已知类型") { formalParams.all { it.variable.isKnownType() } } &&
                must("形参全部是静态类型") { formalParams.all { it.variable.typeName.findType().isStaticType } } &&
                must("形参中的lambda类型的所有参数是已知类型") { formalParams.filter { it.variable.isLambda() }.run { isEmpty() || all { it.variable.isKnownLambda() } } } &&
                mustNot("形参类型含有泛型") { formalParams.any { it.variable.isGenericType() } } &&
                mustNot("形参类型含有混淆类") { formalParams.any { it.variable.typeName.isObfuscated() } } &&
                // 不处理c指针类型参数的方法
                mustNot("形参含有是C指针类型") { formalParams.any { param -> param.variable.typeName.isCPointerType() } } &&
                // 参数不能中含有排除的类
                mustNot("形参含有排除的类") { formalParams.any { param -> EXCLUDE_TYPES.any { it.matches(param.variable.typeName.depointer()) } } } &&
                mustNot("形参祖宗类含有未知类型") {
                    formalParams
                        .flatMap { it.variable.typeName.findType().ancestorTypes }
                        .any { it.findType().isUnknownType() }
                } &&
                mustNot("形参父类是混淆类") {
                    formalParams.any { it.variable.typeName.findType().superClass.isObfuscated() }
                } &&
                // 类似float*返回这样的类型的方法都暂时不处理
                mustNot("返回类型是C类型指针") { returnType.isCPointerType() } &&
                must("返回类型是具体类型或者含有实体子类的抽象类") {
                    returnType.findType().run { isConcret() || hasConcretSubtype() }
                } &&
                mustNot("返回类型是混淆类") { returnType.isObfuscated() } &&
                mustNot("返回类型是未知类") { returnType.findType() == Type.UNKNOWN_TYPE } &&
                mustNot("返回类型是嵌套数组/列表") { returnType.run { collectionLevel() > 1 || (isList() && genericType().isArray()) } } &&
                mustNot("返回类型含有泛型") { returnType.findType().genericTypes.isNotEmpty() } &&
                mustNot("返回类型是排除类") { EXCLUDE_TYPES.any { it.matches(returnType) } } &&
                must("返回类型的祖宗类是已知类") { returnType.findType().ancestorTypes.all { it.findType().isKnownType() } }
    }

    fun filterBatch(): Boolean {
        return filter() && mustNot("含有回调参数") { formalParams.any { it.variable.run { isCallback() || isLambda() } } }
    }

    fun nameWithClass(): String {
        return "${className.replace("$", ".")}::${signature()}"
    }

    /**
     * 包含方法名, 命名参数和参数类型的完整签名
     */
    fun signature(): String {
        return if (className.findType().methods.map { it.signatureNamed() }.filter { it == this.signatureNamed() }.size > 1) {
            // 类内部含有相同方法名超过1个, 说明有重载, 这里需要给方法名加上类型
            name + formalParams.joinToStringX("__", "__") { "${it.named}${it.variable.typeName.toUnderscore().toDartType()}" }
        } else {
            signatureNamed()
        }
    }

    /**
     * 只包含方法名和命名参数部分的签名
     */
    fun signatureNamed(): String {
        return name + formalParams.joinToString("") { it.named }.capitalize()
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract, isPublic=$isPublic, className='$className', platform=$platform, isDeprecated=$isDeprecated)"
    }
}