package me.yohom.fluttify.common.tmpl.dart.object_factory

import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Platform
import me.yohom.fluttify.common.model.Type

//static Future<#__class_name__#> create#__creator_name__#(#__formal_params__#) async {
//  final int refId = await _channel.invokeMethod('ObjectFactory::create#__creator_name__#'#__separator__##__args__#);
//  return #__class_name__#()..refId = refId;
//}
class CreateObjectTmpl(val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/object_factory/create_object.mtd.dart.tmpl").readText()

    fun dartCreateObject(): List<String> {
        return when (type.platform) {
            Platform.Android -> type.constructors
                .filterConstructor()
                .map {
                    tmpl
                        .replace("#__class_name__#", type.name.toUnderscore())
                        .replace(
                            "#__creator_name__#",
                            "${type.name.toUnderscore()}${it.formalParams.joinToString("__", prefix = "__") {
                                it.variable.typeName.toUnderscore().replace("[]", "Array")
                            }}"
                        )
                        .replace("#__formal_params__#", it.formalParams.joinToString { it.variable.toDartString() })
                        .replace("#__separator__#", if (it.formalParams.isEmpty()) "" else ", ")
                        .replace("#__args__#", it.formalParams.map { it.variable }.toDartMap {
                            when {
                                it.typeName.findType().isEnum() -> "${it.name}.index"
                                it.typeName.findType().isList() -> "${it.name}.map((it) => it.refId).toList()"
                                it.typeName.jsonable() -> it.name
                                else -> "${it.name}.refId"
                            }
                        })
                }
            Platform.iOS -> listOf(
                tmpl
                    .replace("#__class_name__#", type.name.toUnderscore())
                    .replace("#__creator_name__#", type.name.toUnderscore())
                    .replace("#__formal_params__#", "")
                    .replace("#__separator__#", "")
                    .replace("#__args__#", "")
            )
            else -> listOf()
        }
    }
}