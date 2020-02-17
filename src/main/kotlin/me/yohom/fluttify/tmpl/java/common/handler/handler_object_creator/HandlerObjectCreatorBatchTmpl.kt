package me.yohom.fluttify.tmpl.java.common.handler.handler_object_creator

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl

//// factory
//put("ObjectFactory::create_batch#__creator_name__#", (argsBatch, methodResult) -> {
//    List<Integer> resultList = new ArrayList<>();
//
//    for (int i = 0; i < (List<(Map<String, Object>>) argsBatch.size(); i++) {
//        Map<String, Object> args = ((List<Map<String, Object>>) argsBatch).get(i);
//
//        // args
//        #__args__#;
//
//        // create target object
//        #__class_name__# obj = new #__class_name__#(#__args_value__#);
//        getHEAP().put(obj.hashCode(), obj);
//
//        // print current HEAP
//        if (getEnableLog()) {
//            Log.d("ObjectFactory", "HEAP: " + getHEAP());
//        }
//
//        resultList.add(obj.hashCode());
//    }
//
//    methodResult.success(resultList);
//});
private val tmpl = getResource("/tmpl/java/handler_object_creator_batch.stmt.java.tmpl").readText()

fun HandlerObjectFactoryBatchTmpl(type: Type): List<String> {
    return type.constructors
        .filterConstructor()
        .map {
            val args = it.formalParams
                .filter { !it.variable.typeName.findType().isCallback() }
                .joinToString("\n") {
                    when {
                        it.variable.jsonable() -> ArgJsonableTmpl(it.variable)
                        it.variable.isEnum() -> ArgEnumTmpl(it.variable)
                        it.variable.isList -> ArgListTmpl(it.variable)
                        else -> ArgRefTmpl(it.variable)
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