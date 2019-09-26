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
//    HEAP[obj.hashCode()] = obj
//
//    methodResult.success(obj.hashCode())
//}
internal class HandlerObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_object_factory.stmt.kt.tmpl").readText()

    fun kotlinObjectFactory(): List<String> {
        return type.constructors
            .filterConstructor()
            .map {
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
                        when {
                            // 因为dart到kotlin这边都是double类型, 如果参数实际类型是float的话, 需要转一手
                            it.variable.typeName.toLowerCase() == "float" -> "${this}.toFloat()"
                            // 如果是列表参数, 统一成ArrayList
                            it.variable.isList -> "ArrayList($this)"
                            else -> this
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