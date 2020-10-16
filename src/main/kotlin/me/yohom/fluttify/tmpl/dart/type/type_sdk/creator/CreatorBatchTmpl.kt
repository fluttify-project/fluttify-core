package me.yohom.fluttify.tmpl.dart.type.type_sdk.creator

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type

//static Future<List<#__class_name__#>> create_batch__#__signature__#(#__formal_params__#) async {
//  assert(#__check_param_size__#);
//  final __result_batch__ = await  k#__project_prefix__#Channel.invokeListMethod(
//    'ObjectFactory::create_batch#__creator_name__#',
//     #__args__#
//   );
//  return __result_batch__
//      .map((it) => #__project_prefix__##__platform__#As<#__class_name__#>(it))
//      .toList();
//}
private val tmpl by lazy { getResource("/tmpl/dart/creator_batch.mtd.dart.tmpl").readText() }

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
                            it.variable
                                .trueType
                                .replace("[]", "Array")
                                .enList(it.variable.getIterableLevel())
                                .toUnderscore()
                        }
                    )
                    .replace("#__creator_name__#", it.creatorName(type.name))
                    .replace("#__formal_params__#", it
                        .formalParams
                        .run {
                            if (isEmpty()) {
                                "int length"
                            } else {
                                joinToString { it.variable.toDartStringBatch() }
                            }
                        })
                    .replace("#__args__#", it.formalParams
                        .map { it.variable }
                        .run {
                            if (isEmpty()) {
                                "{'length': length}"
                            } else {
                                toDartMapBatch("[for (int __i__ = 0; __i__ < ${it.formalParams.firstOrNull()?.variable?.name}.length; __i__++) {")
                            }
                        })
                    .replace("#__tag__#", ext.projectName)
                    .replaceGlobal(type.platform)
            }
        Platform.iOS -> listOf(
            tmpl
                .replace("#__class_name__#", type.name.toUnderscore())
                .replace("#__check_param_size__#", "true")
                .replace("#__signature__#", "")
                .replace("#__creator_name__#", type.name.toUnderscore())
                .replace("#__formal_params__#", "int length, { bool init = true /* ios only */ }")
                .replace("#__args__#", "{'length': length, 'init': init}")
                .replaceGlobal(type.platform)
        )
        else -> listOf()
    }
}