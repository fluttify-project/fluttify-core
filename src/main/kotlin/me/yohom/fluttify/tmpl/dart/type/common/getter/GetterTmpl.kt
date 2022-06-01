package me.yohom.fluttify.tmpl.dart.type.common.getter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.*

//#__static__#Future<#__type__#> get_#__name__#(#__view_channel__#) async {
//  final __result__ = await #__channel__#.invokeMethod("#__getter_method__#", #__ref_id__#);
//  return #__result__#;
//}
private val tmpl by lazy { getResource("/tmpl/dart/getter.mtd.dart.tmpl").readText() }

fun GetterTmpl(field: Field): String {
    val dartType = field.variable.trueType.toDartType().enOptional()
    val name = if (field.isStatic == true) {
        "static_${field.variable.name.depointer()}"
    } else {
        field.variable.name.depointer()
    }

    val channel = "k${ext.projectName.underscore2Camel()}Channel"
    val getter = field.getterMethodName
    val result = field.variable.run {
        when {
            jsonable()
                    || trueType.isVoid()
                    /* dynamic类型直接返回, 让应用层自行决定怎么处理 */
                    || trueType.isDynamic() -> ResultJsonableTmpl(trueType, platform)
            isIterable -> ResultListTmpl(if (getIterableLevel() > 0) trueType.genericTypes()[0] else platform.objectType(), field.platform)
            isStructPointer() -> ResultListTmpl(trueType.depointer(), field.platform)
            isEnum() -> ResultEnumTmpl(trueType)
            else -> ResultRefTmpl(field.asGetterMethod())
        }
    }

    return field.variable.run {
        tmpl
            .replace("#__type__#", dartType)
            .replace("#__static__#", if (field.isStatic == true) "static " else "")
            .replace("#__name__#", name)
            .replace("#__channel__#", channel)
            .replace("#__getter_method__#", getter)
            .replace("#__ref_id__#", if (field.isStatic == true) "" else "{'__this__': this}")
            .replace("#__result__#", result)
    }
}