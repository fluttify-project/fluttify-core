package me.yohom.fluttify.tmpl.kotlin.common.handler.handler_object_factory

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgRefTmpl

//"ObjectFactory::create#__creator_name__#" to { registrar, args, methodResult ->
//    // 参数
//    #__args__#
//
//    // 创建对象
//    val obj = #__class_name__#(#__args_value__#)
//    REF_MAP[obj.hashCode()] = obj
//
//    methodResult.success(obj.hashCode())
//}
internal class HandlerObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_object_factory.stmt.kt.tmpl").readText()

    fun kotlinObjectFactory(): List<String> {
        return type.constructors
            .filterConstructor()
            .map {
                // 参数分为三种, 分情况分别构造以下三种模板
                // 1. 枚举
                // 2. jsonable
                // 3. 引用
                // 4. 列表
                val args = it.formalParams
                    .filter { !it.variable.typeName.findType().isCallback() }
                    .joinToString("\n") {
                        when {
                            it.variable.typeName.jsonable() -> ArgJsonableTmpl(it.variable).kotlinArgJsonable()
                            it.variable.typeName.findType().isEnum() -> ArgEnumTmpl(it.variable).kotlinArgEnum()
                            it.variable.isList -> ArgListTmpl(it.variable).kotlinArgList()
                            else -> ArgRefTmpl(it.variable).kotlinArgRef()
                        }
                    }
                val creatorName = "${type.name.toUnderscore()}${it.formalParams.joinToString("__", prefix = "__") {
                    it.variable.typeName.toUnderscore().replace("[]", "Array")
                }}"
                val argsValue = it.formalParams.joinToString {
                    it.variable.name.run {
                        // 因为dart到kotlin这边都是double类型, 如果参数实际类型是float的话, 需要转一手
                        if (it.variable.typeName.toLowerCase() == "float") {
                            "${this}.toFloat()"
                        } else {
                            this
                        }
                    }
                }

                tmpl
                    .replace("#__creator_name__#", creatorName)
                    .replaceParagraph("#__args__#", args)
                    .replace("#__args_value__#", argsValue)
                    .replace("#__class_name__#", type.name)
            }
    }
}