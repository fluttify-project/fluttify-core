package me.yohom.fluttify.tmpl.dart.type.common.getter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.*

//Future<List<#__type__#>> get_#__name__#_batch(#__view_channel__#) async {
//  final resultBatch = await MethodChannel(#__method_channel__#).invokeMethod("#__getter_method__#", [for (final item in this) {'refId': item.refId}]);
//  final typedResult = (resultBatch as List).map((result) => #__result__#).toList();
//  #__native_object_pool__#
//  return typedResult;
//}
private val tmpl = getResource("/tmpl/dart/getter_batch.mtd.dart.tmpl").readText()

fun GetterBatchTmpl(field: Field, batch: Boolean = false): String {
    val typeNameWithContainer = field.variable.run {
        var result = typeName.findType().run { if (isAlias()) aliasOf!! else typeName }.toDartType()
        if (isStructPointer()) {
            result = "List<$result>"
        } else if (isList) {
            for (i in 0 until genericLevel) {
                result = "List<$result>"
            }
        }
        result
    }
    val name = field.variable.name.depointer()
    val viewChannel = if (field.className.findType().isView()) "{bool viewChannel = true}" else ""

    val viewMethodChannel = "${ext.methodChannelName}/${field.className.toUnderscore()}"
    val normalMethodChannel = ext.methodChannelName
    // 只有当前类是View的时候, 才需要区分普通channel和View channel
    val methodChannel = if (field.className.findType().isView()) {
        "viewChannel ? '$viewMethodChannel' : '$normalMethodChannel'"
    } else {
        "'$normalMethodChannel'"
    }

    val getter = field.getterMethodName()
    val result = field.variable.run {
        when {
            jsonable() or isAliasType() -> ResultJsonableTmpl(typeNameWithContainer, platform)
            isList || isStructPointer() -> ResultListTmpl(typeName, platform)
            isEnum() -> ResultEnumTmpl(typeName)
            typeName.isVoid() -> ResultVoidTmpl()
            else -> ResultRefTmpl(typeName)
        }
    }
    val nativeObjectPool = field.variable.run {
        when {
            jsonable() or isEnum() or isAliasType() -> ""
            isList || isStructPointer() -> "kNativeObjectPool.addAll(typedResult.expand((e) => e));"
            else -> "kNativeObjectPool.addAll(typedResult);"
        }
    }

    return field.variable.run {
        tmpl
            .replace("#__type__#", typeNameWithContainer)
            .replace("#__name__#", name)
            .replace("#__view_channel__#", viewChannel)
            .replace("#__method_channel__#", methodChannel)
            .replace("#__getter_method__#", getter)
            .replace("#__native_object_pool__#", nativeObjectPool)
            .replace("#__result__#", result)
    }
}