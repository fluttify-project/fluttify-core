package me.yohom.fluttify.tmpl.java.common.handler.handler_object_factory

import me.yohom.fluttify.extensions.filterConstructor
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl

//"ObjectFactory::create#__creator_name__#" to { registrar, args, methodResult ->
//    Log.d("ObjectFactory", "创建对象: #__creator_name__#")
//
//    // 参数
//    #__args__#
//
//    // 创建对象
//    val obj = #__class_name__#(#__args_value__#)
//    HEAP[obj.hashCode()] = obj
//
//    // 打印当前HEAP
//    Log.d("ObjectFactory", "HEAP: $HEAP")
//
//    methodResult.success(obj.hashCode())
//}
internal class HandlerObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/java/handler_object_factory.stmt.java.tmpl").readText()

    fun javaObjectFactory(): List<String> {
        return type.constructors
            .filterConstructor()
            .map {
                val args = it.formalParams
                    .filter { !it.variable.typeName.findType().isCallback() }
                    .joinToString("\n") {
                        when {
                            it.variable.jsonable() -> ArgJsonableTmpl(it.variable).javaArgJsonable()
                            it.variable.isEnum() -> ArgEnumTmpl(it.variable).javaArgEnum()
                            it.variable.isList -> ArgListTmpl(it.variable).javaArgList()
                            else -> ArgRefTmpl(it.variable).javaArgRef()
                        }
                    }
                val creatorName = "${type.name.toUnderscore()}${it.formalParams.joinToString("__", prefix = "__") {
                    it.variable.typeName.toUnderscore().replace("[]", "Array")
                }}"
                val argsValue = it.formalParams.joinToString { it.variable.var2Args() }

                tmpl
                    .replace("#__creator_name__#", creatorName)
                    .replaceParagraph("#__args__#", args)
                    .replace("#__args_value__#", argsValue)
                    .replace("#__class_name__#", type.name.replace("$", "."))

            }
    }
}