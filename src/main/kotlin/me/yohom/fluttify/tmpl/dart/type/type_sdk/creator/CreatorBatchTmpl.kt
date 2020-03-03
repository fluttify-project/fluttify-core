package me.yohom.fluttify.tmpl.dart.type.type_sdk.creator

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//static Future<List<#__class_name__#>> create_batch__#__signature__#(#__formal_params__#) async {
//  if (#__check_param_size__#) {
//    return Future.error('all args must has same length!');
//  }
//  final List resultBatch = await MethodChannel('#__channel_name__#').invokeMethod('ObjectFactory::create_batch#__creator_name__#', #__args__#);
//
//  final List<#__class_name__#> typedResult = resultBatch.map((result) => #__class_name__#()..refId = result..tag = '#__tag__#').toList();
//  kNativeObjectPool.addAll(typedResult);
//  return typedResult;
//}
private val tmpl = getResource("/tmpl/dart/creator_batch.mtd.dart.tmpl").readText()

fun CreatorBatchTmpl(type: Type): List<String> {
    return when (type.platform) {
        Platform.Android -> type.constructors
            .filterConstructor()
            .map {
                tmpl
                    .replace("#__class_name__#", type.name.toUnderscore())
                    .replace("#__check_param_size__#", it.formalParams.checkParamSize())
                    .replace(
                        "#__signature__#",
                        it.formalParams.joinToString("__") {
                            it.variable.typeName.toUnderscore().replace("[]", "Array")
                        }
                    )
                    .replace(
                        "#__creator_name__#",
                        "${type.name.toUnderscore()}${it.formalParams.joinToString("__", "__") {
                            it.variable.typeName.toUnderscore().replace("[]", "Array")
                        }}"
                    )
                    .replace("#__formal_params__#", it
                        .formalParams
                        .run {
                            if (isEmpty()) {
                                "int length"
                            } else {
                                joinToString { it.variable.toDartStringBatch() }
                            }
                        })
                    .replace("#__channel_name__#", ext.methodChannelName)
                    .replace("#__args__#", it.formalParams
                        .map { it.variable }
                        .run {
                            if (isEmpty()) {
                                "{'length': length}"
                            } else {
                                toDartMapBatch("[for (int i = 0; i < ${it.formalParams.firstOrNull()?.variable?.name}.length; i++) {") {
                                    when {
                                        it.typeName.findType().isEnum() -> {
                                            // 枚举列表
                                            if (it.isList) {
                                                "${it.name.depointer()}[i].map((it) => it.index).toList()"
                                            } else {
                                                "${it.name.depointer()}[i].index"
                                            }
                                        }
                                        it.typeName.jsonable() -> "${it.name.depointer()}[i]"
                                        (it.isList && it.genericLevel <= 1) || it.isStructPointer() -> "${it.name.depointer()}[i].map((it) => it.refId).toList()"
                                        it.genericLevel > 1 -> "[]" // 多维数组暂不处理
                                        else -> "${it.name.depointer()}[i].refId"
                                    }
                                }
                            }
                        })
                    .replace("#__tag__#", ext.projectName)
            }
        Platform.iOS -> listOf(
            tmpl
                .replace("#__class_name__#", type.name.toUnderscore())
                .replace("#__check_param_size__#", "false")
                .replace("#__signature__#", "")
                .replace("#__creator_name__#", type.name.toUnderscore())
                .replace("#__formal_params__#", "int length")
                .replace("#__channel_name__#", ext.methodChannelName)
                .replace("#__separator__#", "")
                .replace("#__args__#", "{'length': length}")
                .replace("#__tag__#", ext.projectName)
        )
        else -> listOf()
    }
}