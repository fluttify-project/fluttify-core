package me.yohom.fluttify.tmpl.dart.type.common.getter_batch

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.*

//Future<List<#__type__#>> get_#__name__#_batch(#__view_channel__#) async {
//  final resultBatch = await #__channel__#.invokeMethod("#__getter_method__#_batch", [for (final __item__ in this) {'__this__': __item__}]);
//  return (resultBatch as List).map((__result__) => #__result__#).cast<#__type__#>().toList();
//}
private val tmpl by lazy { getResource("/tmpl/dart/getter_batch.mtd.dart.tmpl").readText() }

fun GetterBatchTmpl(field: Field): String {
    val dartType = field.variable.trueType.toDartType().enOptional()
    val name =
        if (field.isStatic == true) "static_${field.variable.name.depointer()}" else field.variable.name.depointer()

    val channel = "k${ext.projectName.underscore2Camel()}Channel"
    val getter = field.getterMethodName
    val resultType = field.variable.trueType.toDartType()
    val result = field.variable.run {
        when {
            jsonable()
                    || trueType.isVoid()
                    /* dynamic类型直接返回, 让应用层自行决定怎么处理 */
                    || trueType.isDynamic() -> ResultJsonableTmpl(trueType, platform)
            isIterable -> ResultListTmpl(
                if (getIterableLevel() > 0) trueType.genericTypes()[0] else platform.objectType(),
                field.platform
            )
            isStructPointer() -> ResultListTmpl(trueType.depointer(), field.platform)
            isEnum() -> ResultEnumTmpl(trueType)
            else -> ResultRefTmpl(field.asGetterMethod())
        }
    }

    return field.variable.run {
        tmpl
            .replace("#__type__#", dartType)
            .replace("#__name__#", name)
            .replace("#__channel__#", channel)
            .replace("#__cast__#", field.variable.trueType.containerType().toDartType())
            .replace("#__getter_method__#", getter)
            .replace("#__result_type__#", resultType)
            .replace("#__result__#", result)
    }
}