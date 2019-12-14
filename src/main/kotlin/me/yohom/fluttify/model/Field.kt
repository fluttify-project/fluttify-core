package me.yohom.fluttify.model

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.toUnderscore

data class Field(
    /**
     * 是否公开
     */
    override val isPublic: Boolean,
    /**
     * 是否只读
     */
    val isFinal: Boolean?,
    /**
     * 是否静态
     */
    val isStatic: Boolean?,
    /**
     * 属性的值
     */
    val value: Any? = null,
    /**
     * 变量
     */
    val variable: Variable,
    /**
     * 所在类名
     */
    val className: String,
    /**
     * getter
     */
    val getterName: String = variable.name,
    /**
     * setter
     */
    val setterName: String = variable.name,
    /**
     * 所属平台
     */
    override var platform: Platform,
    /**
     * 是否过时
     */
    var isDeprecated: Boolean = false
) : IPlatform, IScope {
    @Deprecated("不再使用方法引用的方式, 而是使用匿名函数的方式放到handlerMap中去", ReplaceWith("getterMethodName"))
    fun nativeHandleGetterMethodName(): String {
        return "handle${className.toUnderscore()}_get_${getterName.depointer()}"
    }

    @Deprecated("不再使用方法引用的方式, 而是使用匿名函数的方式放到handlerMap中去", ReplaceWith("setterMethodName"))
    fun nativeHandleSetterMethodName(): String {
        return "handle${className.toUnderscore()}_set_${setterName.depointer()}"
    }

    fun getterMethodName(): String {
        return "${className.replace("$", ".")}::get_${getterName.depointer()}"
    }

    fun setterMethodName(): String {
        return "${className.replace("$", ".")}::set_${setterName.depointer()}"
    }

    fun asGetterMethod(): Method {
        return Method(
            variable.typeName,
            getterName,
            listOf(),
            isStatic = false,
            isAbstract = false,
            isPublic = true,
            className = className,
            platform = platform,
            isDeprecated = isDeprecated
        )
    }

    fun asSetterMethod(): Method {
        return Method(
            "void",
            setterName,
            listOf(Parameter(variable = variable, platform = platform)),
            isStatic = false,
            isAbstract = false,
            isPublic = true,
            className = className,
            platform = platform,
            isDeprecated = isDeprecated
        )
    }
}