package me.yohom.fluttify.tmpl.dart.type.common.getter_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.*

//Future<List<#__type__#>> get_#__name__#_batch(#__view_channel__#) async {
//  final resultBatch = await MethodChannel(#__method_channel__#, StandardMethodCodec(FluttifyMessageCodec())).invokeMethod("#__getter_method__#_batch", [for (final __item__ in this) {'refId': __item__.refId}]);
//  final typedResult = (resultBatch as List).cast<#__result_type__#>.map((__result__) => #__result__#).toList();
//  #__native_object_pool__#
//  return typedResult;
//}
private val tmpl by lazy { getResource("/tmpl/dart/getter_batch.mtd.dart.tmpl").readText() }

fun GetterBatchTmpl(field: Field): String {
    val dartType = field.variable.trueType.toDartType()
    val name = if (field.isStatic == true) "static_${field.variable.name.depointer()}" else field.variable.name.depointer()
    val viewChannel = if (field.className.findType().isView) "{bool viewChannel = true}" else ""

    val viewMethodChannel = "${ext.methodChannelName}/${field.className.toUnderscore()}"
    val normalMethodChannel = ext.methodChannelName
    // 只有当前类是View的时候, 才需要区分普通channel和View channel
    val methodChannel = if (field.className.findType().isView) {
        "viewChannel ? '$viewMethodChannel' : '$normalMethodChannel'"
    } else {
        "'$normalMethodChannel'"
    }

    val getter = field.getterMethodName
    val resultType = field.variable.trueType.run {
        when {
            jsonable() -> toDartType()
            isVoid() -> "String"
            else -> "String"
        }
    }
    val result = field.variable.run {
        when {
            jsonable() -> ResultJsonableTmpl(trueType, platform)
            isIterable -> ResultListTmpl(
                if (getIterableLevel() > 0) trueType.genericTypes()[0] else platform.objectType(),
                platform
            )
            isStructPointer() -> ResultListTmpl(trueType.depointer(), platform)
            isEnum() -> ResultEnumTmpl(trueType)
            trueType.isVoid() -> ResultVoidTmpl()
            else -> ResultRefTmpl(trueType)
        }
    }
    val nativeObjectPool = field.variable.run {
        when {
            jsonable() or isEnum() or isAliasType() -> ""
            isIterable || isStructPointer() -> "kNativeObjectPool.addAll(typedResult.expand((e) => e));"
            else -> "kNativeObjectPool.addAll(typedResult);"
        }
    }

    return field.variable.run {
        tmpl
            .replace("#__type__#", dartType)
            .replace("#__name__#", name)
            .replace("#__view_channel__#", viewChannel)
            .replace("#__method_channel__#", methodChannel)
            .replace("#__getter_method__#", getter)
            .replace("#__result_type__#", resultType)
            .replace("#__native_object_pool__#", nativeObjectPool)
            .replace("#__tag__#", ext.projectName)
            .replace("#__result__#", result)
    }
}