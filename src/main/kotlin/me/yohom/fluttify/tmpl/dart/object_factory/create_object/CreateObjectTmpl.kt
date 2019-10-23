package me.yohom.fluttify.tmpl.dart.object_factory.create_object

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.filterConstructor
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.toDartMap
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//static Future<#__class_name__#> create#__creator_name__#(#__formal_params__#) async {
//  final int refId = await _channel.invokeMethod('ObjectFactory::create#__creator_name__#'#__separator__##__args__#);
//  final object = #__class_name__#()..refId = refId..tag = '#__tag__#';
//
//  kNativeObjectPool.add(object);
//  return object;
//}
class CreateObjectTmpl(val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/create_object.mtd.dart.tmpl").readText()

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
                                it.isEnum() -> "${it.name}.index"
                                it.isList -> if (it.genericLevel <= 1) "${it.name}.map((it) => it.refId).toList()" else "[] /* 暂不支持嵌套列表 */"
                                it.typeName.jsonable() -> it.name
                                else -> "${it.name}.refId"
                            }
                        })
                        .replace("#__tag__#", ext.outputProjectName)
                }
            Platform.iOS -> listOf(
                tmpl
                    .replace("#__class_name__#", type.name.toUnderscore())
                    .replace("#__creator_name__#", type.name.toUnderscore())
                    .replace("#__formal_params__#", "")
                    .replace("#__separator__#", "")
                    .replace("#__args__#", "")
                    .replace("#__tag__#", ext.outputProjectName)
            )
            else -> listOf()
        }
    }
}