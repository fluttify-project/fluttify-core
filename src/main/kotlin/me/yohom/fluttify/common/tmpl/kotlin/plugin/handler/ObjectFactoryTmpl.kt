package me.yohom.fluttify.common.tmpl.kotlin.plugin.handler

import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Type

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
internal class ObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/object_factory.stmt.kt.tmpl").readText()

    fun kotlinObjectFactory(): List<String> {
        return type.constructors
            .filterConstructor()
            .map {
                // 参数分为三种, 分情况分别构造以下三种模板
                // 1. 枚举
                // 2. jsonable
                // 3. 引用
                val args = it.formalParams
                    .filter { !it.variable.typeName.findType().isCallback() }
                    .joinToString("\n") {
                        when {
                            it.variable.typeName.jsonable() -> ArgJsonableTmpl(it.variable).kotlinArgJsonable()
                            it.variable.typeName.findType().isEnum() -> ArgEnumTmpl(it.variable).kotlinArgEnum()
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