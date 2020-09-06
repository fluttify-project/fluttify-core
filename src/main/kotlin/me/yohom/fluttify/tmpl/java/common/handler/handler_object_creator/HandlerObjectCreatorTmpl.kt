package me.yohom.fluttify.tmpl.java.common.handler.handler_object_creator

import me.yohom.fluttify.extensions.filterConstructor
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl

//// factory
//put("ObjectFactory::create#__creator_name__#", (args, methodResult) -> {
//    Log.d("ObjectFactory", "创建对象: #__creator_name__#");
//
//    // args
//    #__args__#;
//
//    // create target object
//    #__class_name__# obj = new #__class_name__#(#__args_value__#);
//    getHEAP().put(obj.hashCode(), obj);
//
//    // print current HEAP
//    if (getEnableLog()) {
//        Log.d("ObjectFactory", "HEAP: " + getHEAP());
//    }
//
//    methodResult.success(obj.hashCode());
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_object_creator.stmt.java.tmpl").readText() }

fun HandlerObjectFactoryTmpl(type: Type): List<String> {
    return type.constructors
        .filterConstructor()
        .map {
            val args = it.formalParams
                .filter { !it.variable.trueType.findType().isCallback }
                .joinToString("\n") {
                    when {
                        it.variable.isEnum() -> ArgEnumTmpl(it.variable)
                        else -> ArgRefTmpl(it.variable)
                    }
                }
            val creatorName = it.creatorName(type.name)
            val argsValue = it.formalParams.joinToString { it.variable.var2Args() }

            tmpl
                .replace("#__creator_name__#", creatorName)
                .replaceParagraph("#__args__#", args)
                .replace("#__args_value__#", argsValue)
                .replace("#__class_name__#", type.name.replace("$", "."))
        }
}