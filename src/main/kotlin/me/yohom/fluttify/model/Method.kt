package me.yohom.fluttify.model

import me.yohom.fluttify.IGNORE_METHOD
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.toDartType

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
    var isPublic: Boolean?,
    /**
     * 所在类名称
     */
    var className: String,

    override var platform: Platform,

    /**
     * 是否过时
     */
    var isDeprecated: Boolean = false
) : PlatformAware {
    fun isOk(): Boolean {
        return when {
            // 不能是忽略的方法
            name in IGNORE_METHOD -> {
                false.apply { println("方法${this@Method} 由于`不能是忽略的方法`, 被过滤") }
            }
            // 不能是非公开方法
            isPublic != true -> {
                false.apply { println("方法${this@Method} 由于`不能是非公开方法`, 被过滤") }
            }
            // 所在类不能是非公开类
            !className.depointer().findType().isPublic -> {
                false.apply { println("方法${this@Method} 由于`所在类不能是非公开类`, 被过滤") }
            }
            // 返回类型不能是混淆类
            returnType.depointer().findType().isObfuscated() -> {
                false.apply { println("方法${this@Method} 由于`返回类型不能是混淆类`, 被过滤") }
            }
            // 返回类型不能是未知类
            returnType.depointer().findType() == Type.UNKNOWN_TYPE -> {
                false.apply { println("方法${this@Method} 由于`返回类型不能是未知类`, 被过滤") }
            }
            // 返回类型不能是接口
//            returnType.depointer().findType().isInterface() -> {
//                false.apply { println("方法${this@Method} 由于`返回类型不能是接口`, 被过滤") }
//            }
            // 返回类型不能含有泛型
            returnType.depointer().findType().genericTypes.isNotEmpty() -> {
                false.apply { println("方法${this@Method} 由于`返回类型不能含有泛型`, 被过滤") }
            }
            // 形参类型必须全部都是公开类型
            !formalParams.all { it.variable.typeName.findType().isPublic } -> {
                false.apply { println("方法${this@Method} 由于`形参类型必须全部都是公开类型`, 被过滤") }
            }
            // 形参类型必须全部都不含有泛型
            !formalParams.all { it.variable.typeName.findType().genericTypes.isEmpty() } -> {
                false.apply { println("方法${this@Method} 由于`形参类型必须全部都不含有泛型`, 被过滤") }
            }
            // 形参类型必须全部都不是未知类型
            !formalParams.all { it.variable.typeName.findType() != Type.UNKNOWN_TYPE } -> {
                false.apply { println("方法${this@Method} 由于`形参类型必须全部都不是未知类型`, 被过滤") }
            }
            // 形参父类必须全部都不是未知类型
            !formalParams.all {
                it.variable.typeName.findType().superClass.run { isEmpty() || findType() != Type.UNKNOWN_TYPE }
            } -> {
                false.apply { println("方法${this@Method} 由于`形参父类必须全部都不是未知类型`, 被过滤") }
            }
            else -> {
                true.apply { println("方法${this@Method} 通过过滤") }
            }
        }
    }

    @Deprecated("不再使用方法引用的方式, 而是使用匿名函数的方式放到handlerMap中去", ReplaceWith("methodName"))
    fun handleMethodName(): String {
        return "handle${className.toDartType()}_$name"
    }

    fun nameWithClass(): String {
        return "${className}::$name${formalParams.joinToString("") { it.named }.capitalize()}"
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract, isPublic=$isPublic, className='$className')"
    }
}