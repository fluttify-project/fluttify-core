package me.yohom.fluttify.tmpl.dart.type.type_sdk.creator

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//static Future<#__class_name__#> create__#__signature__#(#__formal_params__#) async {
//  final refId = await k#__identifier__#Channel.invokeMethod('ObjectFactory::create#__creator_name__#', #__args__#);
//  final object = #__class_name__#()..refId = refId;
//  return object;
//}
private val tmpl by lazy { getResource("/tmpl/dart/creator.mtd.dart.tmpl").readText() }

fun CreatorTmpl(type: Type): List<String> {
    return when (type.platform) {
        Platform.Android -> type.constructors
            .filterConstructor()
            .map {
                tmpl
                    .replace("#__class_name__#", type.name.toUnderscore())
                    .replace(
                        "#__signature__#",
                        it.formalParams.joinToString("__") {
                            it.variable
                                .trueType
                                .replace("[]", "Array")
                                .enList(it.variable.getIterableLevel())
                                .toUnderscore()
                        }
                    )
                    .replace("#__creator_name__#", it.creatorName(type.name))
                    .replace("#__formal_params__#", it.formalParams.joinToString { it.variable.toDartString() })
                    .replace("#__identifier__#", ext.projectName.underscore2Camel())
                    .replace("#__args__#", it.formalParams.map { it.variable }.toDartMap())
                    .replace("#__tag__#", ext.projectName)
            }
        Platform.iOS -> listOf(
            tmpl
                .replace("#__class_name__#", type.name.toUnderscore())
                .replace("#__signature__#", "")
                .replace("#__creator_name__#", type.name.toUnderscore())
                .replace("#__formal_params__#", "{ bool init = true /* ios only */ }")
                .replace("#__identifier__#", ext.projectName.underscore2Camel())
                .replace("#__args__#", "{'init': init}")
                .replace("#__tag__#", ext.projectName)
        )
        else -> listOf()
    }
}