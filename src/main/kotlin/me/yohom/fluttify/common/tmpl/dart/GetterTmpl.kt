package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.common.model.Field

//Future<#__type__#> get#__name__#() async {
//    final result = await _channel.invokeMethod("#__getter_method__#", {'refId': refId});
//    return result;
//}
/**
 * 生成普通类的dart接口
 */
class GetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/getter.mtd.dart.tmpl").readText()

    fun dartGetter(): String {
        return field.variable?.run {
            val type = typeName
            val name = name
            val getterMethod = "$type::get${name.capitalize()}"

            tmpl
                .replace("#__type__#", type)
                .replace("#__name__#", name)
                .replace("#__getter_method__#", getterMethod)
        } ?: ""
    }
}