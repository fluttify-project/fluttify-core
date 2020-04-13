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
        println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓方法↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        println("方法:\"${toString()}\"执行过滤开始")
        val result = (must("返回类型是jsonable类型") { returnType.jsonable() }
                || must("返回类型是void") { returnType.isVoid() }
                || must("返回类型是原始类型指针类型") { returnType.isPrimitivePointerType() }
                || must("返回类型关联类型都通过过滤") { returnType.allTypes().all { it.filter() } }
                || must("返回类型是所在类声明泛型") { returnType in className.findType().genericTypes })
                &&
                mustNot("返回类型是混淆类") { returnType.isObfuscated() }
                &&
                mustNot("返回类型是嵌套数组/列表") { returnType.run { iterableLevel() > 1 || (isList() && genericTypes()[0].isArray()) } }
                &&
                mustNot("返回类型是排除类") { EXCLUDE_TYPES.any { it.matches(returnType) } }
                &&
                must("返回类型的祖宗类是已知类") {
                    returnType.allTypes().flatMap { it.ancestorTypes }.all { it.findType().isKnownType() }
                }
                &&
                must("返回类型不是回调类") { returnType.allTypes().none { it.isCallback() } }
                &&
                must("返回类型有实体子类") { returnType.allTypes().all { it.isConcret() || it.hasConcretSubtype() } }
                &&
                must("参数类型全部通过类型过滤") {
                    formalParams.all {
                        it.variable.typeName.jsonable() ||
                                it.variable.allTypes().all { it.filter() } ||
                                it.variable.typeName in className.findType().genericTypes
                    }
                }
                &&
                must("公开方法") { isPublic }
                &&
                mustNot("忽略方法") { EXCLUDE_METHODS.any { methods -> methods.matches(name) } }
                &&
                mustNot("废弃方法") { isDeprecated }
                &&
                // 重写的方法其实没必要再生成一次, 就算调用的是父类的方法, native端仍然是预期行为
                mustNot("祖宗类已有的方法") {
                    name in className
                        .findType()
                        .ancestorTypes
                        .filter { !it.isObfuscated() }
                        .flatMap { it.findType().methods }
                        .map { it.name }
                }
                &&
                must("所在类是公开类") { className.containerType().findType().isPublic }
                &&
                must("所在类是静态类型") { className.containerType().findType().isStaticType }
                &&
                must("形参类型全部都是公开类型") { formalParams.all { it.variable.isPublicType() } }
                &&
                // 形参是已知类型或者是类泛型类型之一
                must("形参类型全部都是已知类型") {
                    formalParams.all {
                        it.variable.isKnownType()
                                || it.variable.typeName in className.findType().genericTypes
                    }
                }
                &&
                must("形参全部是静态类型") { formalParams.all { it.variable.typeName.findType().isStaticType } }
                &&
                must("形参中的lambda类型的所有参数是已知类型") {
                    formalParams.filter { it.variable.isLambda() }
                        .run { isEmpty() || all { it.variable.isKnownLambda() } }
                }
                &&
                mustNot("形参类型含有泛型") { formalParams.any { it.variable.isGenericType() } }
                &&
                mustNot("形参类型含有混淆类") { formalParams.any { it.variable.typeName.isObfuscated() } }
                &&
                // 参数不能中含有排除的类
                mustNot("形参含有排除的类") { formalParams.any { param -> EXCLUDE_TYPES.any { it.matches(param.variable.typeName.depointer()) } } }
                &&
                mustNot("形参祖宗类含有未知类型") {
                    formalParams
                        .flatMap { it.variable.typeName.findType().ancestorTypes }
                        .any { it.findType().isUnknownType() }
                }
                &&
                mustNot("形参父类是混淆类") {
                    formalParams.any { it.variable.typeName.findType().superClass.isObfuscated() }
                }
        println("方法:\"${toString()}\"执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑方法↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
        return result
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
        val hasOverload = className
            .findType()
            .methods
            .map { it.signatureNamed() }
            .filter { it == this.signatureNamed() }.size > 1
        return if (hasOverload) {
            // 类内部含有相同方法名超过1个, 说明有重载, 这里需要给方法名加上类型
            name + formalParams.joinToStringX(
                "__",
                "__"
            ) { "${if (it.named.isNotBlank()) "${it.named}_" else ""}${it.variable.typeName.toDartType()}" }
                .toUnderscore()
        } else {
            signatureNamed()
        }
    }

    /**
     * 只包含方法名和命名参数部分的签名
     */
    private fun signatureNamed(): String {
        return name + formalParams.joinToStringX("") { if (it.named.isNotBlank()) "_${it.named}" else "" }
            .capitalize()
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract, isPublic=$isPublic, className='$className', platform=$platform, isDeprecated=$isDeprecated)"
    }
}