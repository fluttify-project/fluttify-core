package me.yohom.fluttify.tmpl.dart.type.type_sdk.creator

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//static Future<#__class_name__#> create__#__signature__#(#__formal_params__#) async {
//  final int refId = await MethodChannel('#__channel_name__#').invokeMethod('ObjectFactory::create#__creator_name__#'#__separator__##__args__#);
//  final object = #__class_name__#()..refId = refId..tag = '#__tag__#';
//
//  kNativeObjectPool.add(object);
//  return object;
//}
private val tmpl = getResource("/tmpl/dart/creator.mtd.dart.tmpl").readText()

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
                                .typeName
                                .replace("[]", "Array")
                                .enList(it.variable.getIterableLevel())
                                .toUnderscore()
                        }
                    )
                    .replace("#__creator_name__#", it.creatorName(type.name))
                    .replace("#__formal_params__#", it.formalParams.joinToString { it.variable.toDartString() })
                    .replace("#__channel_name__#", ext.methodChannelName)
                    .replace("#__separator__#", if (it.formalParams.isEmpty()) "" else ", ")
                    .replace("#__args__#", it.formalParams.map { it.variable }.toDartMap {
                        when {
                            it.typeName.jsonable() -> it.name
                            it.isEnum() -> "${it.name}.index"
                            it.isIterable -> if (it.getIterableLevel() <= 1) "${it.name}.map((it) => it.refId).toList()" else "[] /* 暂不支持嵌套列表 */"
                            else -> "${it.name}.refId"
                        }
                    })
                    .replace("#__tag__#", ext.projectName)
            }
        Platform.iOS -> listOf(
            tmpl
                .replace("#__class_name__#", type.name.toUnderscore())
                .replace("#__signature__#", "")
                .replace("#__creator_name__#", type.name.toUnderscore())
                .replace("#__formal_params__#", "")
                .replace("#__channel_name__#", ext.methodChannelName)
                .replace("#__separator__#", "")
                .replace("#__args__#", "")
                .replace("#__tag__#", ext.projectName)
        )
        else -> listOf()
    }
}