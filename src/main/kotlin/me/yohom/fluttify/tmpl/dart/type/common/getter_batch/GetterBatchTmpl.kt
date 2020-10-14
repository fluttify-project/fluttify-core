package me.yohom.fluttify.tmpl.dart.type.common.getter_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.*

//Future<List<#__type__#>> get_#__name__#_batch(#__view_channel__#) async {
//  final resultBatch = await #__channel__#.invokeMethod("#__getter_method__#_batch", [for (final __item__ in this) {'__this__': __item__}]);
//
//  final typedResult = (resultBatch as List).cast<#__result_type__#>().map((__result__) => #__result__#).toList();
//  return typedResult;
//}
private val tmpl by lazy { getResource("/tmpl/dart/getter_batch.mtd.dart.tmpl").readText() }

fun GetterBatchTmpl(field: Field): String {
    val dartType = field.variable.trueType.toDartType()
    val name = if (field.isStatic == true) "static_${field.variable.name.depointer()}" else field.variable.name.depointer()
    val viewChannel = if (field.className.findType().isView) "{bool viewChannel = true}" else ""

    val channel = if (field.className.findType().isView) {
        val channelName = "viewChannel ? '${ext.methodChannelName}/${field.className.toUnderscore()}' : '${ext.methodChannelName}'"
        "MethodChannel($channelName, StandardMethodCodec(FluttifyMessageCodec('${ext.projectName}')))"
    } else {
        "k${ext.projectName.underscore2Camel()}Channel"
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
            jsonable()
                    || trueType.isVoid()
                    /* dynamic类型直接返回, 让应用层自行决定怎么处理 */
                    || trueType.isDynamic() -> ResultJsonableTmpl(trueType, platform)
            isIterable -> ResultListTmpl(
                if (getIterableLevel() > 0) trueType.genericTypes()[0] else platform.objectType()
            )
            isStructPointer() -> ResultListTmpl(trueType.depointer())
            isEnum() -> ResultEnumTmpl(trueType)
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
            .replace("#__channel__#", channel)
            .replace("#__getter_method__#", getter)
            .replace("#__result_type__#", resultType)
            .replace("#__native_object_pool__#", nativeObjectPool)
            .replace("#__tag__#", ext.projectName)
            .replace("#__result__#", result)
    }
}