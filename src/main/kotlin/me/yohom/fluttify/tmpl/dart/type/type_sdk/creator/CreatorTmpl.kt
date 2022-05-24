package me.yohom.fluttify.tmpl.dart.type.type_sdk.creator

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//static Future<#__class_name__#> create__#__signature__#(#__formal_params__#) async {
//  final __result__ = await k#__project_prefix__#Channel.invokeMethod(
//    'ObjectFactory::create#__creator_name__#',
//    #__args__#
//  );
//  return #__project_prefix__##__platform__#As<#__class_name__#>(__result__);
//}
private val tmpl by lazy { getResource("/tmpl/dart/creator.mtd.dart.tmpl").readText() }

fun CreatorTmpl(type: Type): List<String> {
    return when (type.platform) {
        Platform.Android -> type.constructors
            .filterConstructor()
            .map {
                tmpl
                    .replace("#__class_name__#", type.name.toUnderscore().enOptional())
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
                    .replace("#__args__#", it.formalParams.map { it.variable }.toDartMap())
                    .replaceGlobal(type.platform)
            }
        Platform.iOS -> listOf(
            tmpl
                .replace("#__class_name__#", type.name.toUnderscore().enOptional())
                .replace("#__signature__#", "")
                .replace("#__creator_name__#", type.name.toUnderscore())
                .replace("#__formal_params__#", "{ bool init = true /* ios only */ }")
                .replace("#__args__#", "{'init': init}")
                .replaceGlobal(type.platform)
        )
        else -> listOf()
    }
}