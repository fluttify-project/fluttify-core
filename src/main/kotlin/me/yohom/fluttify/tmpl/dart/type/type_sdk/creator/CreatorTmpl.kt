package me.yohom.fluttify.tmpl.dart.type.type_sdk.creator

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//static Future<#__class_name__#> create#__signature__#(#__formal_params__#) async {
//  final int refId = await MethodChannel('#__channel_name__#').invokeMethod('ObjectFactory::create#__creator_name__#'#__separator__##__args__#);
//  final object = #__class_name__#()..refId = refId..tag = '#__tag__#';
//
//  kNativeObjectPool.add(object);
//  return object;
//}
class CreatorTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/creator.mtd.dart.tmpl").readText()

    fun dartCreator(): List<String> {
        return when (type.platform) {
            Platform.Android -> type.constructors
                .filterConstructor()
                .map {
                    tmpl
                        .replace("#__class_name__#", type.name.toUnderscore())
                        .replace(
                            "#__signature__#",
                            it.formalParams.joinToStringX("__", prefix = "__") {
                                it.variable.typeName.toUnderscore().replace("[]", "Array")
                            }
                        )
                        .replace(
                            "#__creator_name__#",
                            "${type.name.toUnderscore()}${it.formalParams.joinToString("__", prefix = "__") {
                                it.variable.typeName.toUnderscore().replace("[]", "Array")
                            }}"
                        )
                        .replace("#__formal_params__#", it.formalParams.joinToString { it.variable.toDartString() })
                        .replace("#__channel_name__#", ext.methodChannelName)
                        .replace("#__separator__#", if (it.formalParams.isEmpty()) "" else ", ")
                        .replace("#__args__#", it.formalParams.map { it.variable }.toDartMap {
                            when {
                                it.typeName.jsonable() -> it.name
                                it.isEnum() -> "${it.name}.index"
                                it.isList -> if (it.genericLevel <= 1) "${it.name}.map((it) => it.refId).toList()" else "[] /* 暂不支持嵌套列表 */"
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
}