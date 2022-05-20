package me.yohom.fluttify.model

import com.google.gson.Gson
import me.yohom.fluttify.*
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
    var isGenericMethod: Boolean = false,
    /**
     * 文档注释
     */
    var doc: String = "",
    override var id: Int = NEXT_ID
) : IPlatform, IScope, IElement {

    val exactName: String = "$name${formalParams.joinToString(":") { it.named }}"

    val filter: Boolean
        get() {
            if (METHOD_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓方法↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
            if (METHOD_LOG) println("方法:\"${toString()}\"执行过滤开始")
            val result = (must("返回类型是jsonable类型") { returnType.jsonable() }
                    || must("返回类型是void") { returnType.isVoid() }
                    || must("返回类型是原始类型指针类型") { returnType.isPrimitivePointerType() }
                    || must("返回类型关联类型都通过过滤") {
                !returnType.isMap()
                        &&
                        returnType.allTypes()
                            .all { it.filter || it.name in this.className.findType().declaredGenericTypes } // 能够通过过滤, 或者是声明泛型
            }
                    || must("返回类型是所在类声明泛型") { returnType in className.findType().declaredGenericTypes })
                    &&
                    mustNot("方法名为空") { name.isEmpty() }
                    &&
                    mustNot("返回类型是混淆类") { returnType.isObfuscated() }
                    &&
                    mustNot("方法名为main") { name == "main" }
                    &&
                    mustNot("方法名被混淆") { name.isObfuscatedMethod() }
                    &&
                    mustNot("返回类型是嵌套数组/列表") { returnType.run { iterableLevel() > 1 || (isList() && genericTypes()[0].isRefArray()) } }
                    &&
                    mustNot("返回类型是排除类") { EXCLUDE_TYPES.any { it.matches(returnType) } }
                    &&
                    must("返回类型不是回调类") { returnType.allTypes().none { it.isCallback } }
                    &&
                    must("参数类型全部通过类型过滤") {
                        formalParams.all {
                            it.variable
                                .allTypes()
                                // 类型通过过滤或者是声明的泛型类`
                                .all { it.filter || it.name in className.findType().declaredGenericTypes }
                                    ||
                                    it.variable.trueType in className.findType().declaredGenericTypes
                        }
                    }
                    &&
                    must("公开方法") { isPublic }
                    &&
                    mustNot("忽略方法") { EXCLUDE_METHODS.any { methods -> methods.matches(nameWithClass()) } }
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
                    must("所在类是公开类") {
                        // 这里需要把内部类的所有外部类都判断过去, 只要碰到一个外部类不是public的, 那当前内部类就认为不是public的
                        // 碰到了三层内部类的情况, 然后最内一层是public的, 上面两层不是public的
                        var type = className.containerType().findType()
                        var result = type.isPublic
                        while (type.isInnerType) {
                            if (type.isPublic) {
                                type = type.name.substringBeforeLast("$").containerType().findType()
                                result = type.isPublic
                            } else {
                                result = false
                                break
                            }
                        }
                        result
                    }
                    &&
                    must("所在类是静态类型") { className.containerType().findType().isStaticType }
                    &&
                    must("形参类型全部都是公开类型") { formalParams.all { it.variable.isPublicType() } }
                    &&
                    mustNot("形参类型里多层block") {
                        formalParams.any { it.variable.isLambda() && it.variable.trueType.findType().formalParams.any { it.variable.isLambda() } }
                    }
                    &&
                    must("形参全部是静态类型") { formalParams.all { it.variable.trueType.findType().isStaticType } }
                    &&
                    must("形参中的lambda类型的所有参数是已知类型") {
                        formalParams.filter { it.variable.isLambda() }
                            .run { isEmpty() || all { it.variable.isKnownLambda() } }
                    }
                    &&
                    mustNot("形参类型含有混淆类") {
                        formalParams.any {
                            it.variable.trueType.containerType().isObfuscated()
                        }
                    } // TODO 这里只判断了容器类是否是混淆类, 需要处理如果泛型类型是混淆类的情况
                    &&
                    // 参数不能中含有排除的类
                    mustNot("形参含有排除的类") {
                        formalParams.any { param ->
                            EXCLUDE_TYPES.any {
                                it.matches(
                                    param.variable.trueType.depointer()
                                )
                            }
                        }
                    }
            if (METHOD_LOG) println("方法:\"${toString()}\"执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
            if (METHOD_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑方法↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")
            return result
        }

    val filterBatch: Boolean
        get() {
            return filter && mustNot("含有回调参数") { formalParams.any { it.variable.run { isCallback() || isLambda() } } }
        }

    fun nameWithClass(): String {
        return "${className.replace("$", ".")}::${signature}"
    }

    /**
     * 包含方法名, 命名参数和参数类型的完整签名
     */
    val signature: String
        get() {
            val hasOverload = className
                .findType()
                .methods
                .map { it.signatureNamed() }
                .filter { it == this.signatureNamed() }.size > 1
            return if (hasOverload) {
                // 类内部含有相同方法名超过1个, 说明有重载, 这里需要给方法名加上类型
                name + formalParams
                    .joinToStringX(
                        "__",
                        "__"
                    ) { "${if (it.named.isNotBlank()) "${it.named}_" else ""}${it.variable.trueType.toDartType()}" }
                    .toUnderscore()
            } else {
                signatureNamed()
            }.replace("[]", "Array") // 去掉数据的方括号
        }

    /**
     * 只包含方法名和命名参数部分的签名
     */
    private fun signatureNamed(): String {
        return name + formalParams.joinToStringX("") { if (it.named.isNotBlank()) "_${it.named}" else "" }
            .capitalize()
    }

    override fun toString(): String {
        return Gson().newBuilder().setPrettyPrinting().create().toJson(this)
    }
}