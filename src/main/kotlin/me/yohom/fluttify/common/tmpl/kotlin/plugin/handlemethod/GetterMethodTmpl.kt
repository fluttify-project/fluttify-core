package me.yohom.fluttify.common.tmpl.kotlin.plugin.handlemethod

import me.yohom.fluttify.common.extensions.toKotlinType
import me.yohom.fluttify.common.model.Field

//private fun #__getter_name__#(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {
//    // 引用对象
//    val refId = args["refId"] as Int
//    val ref = REF_MAP[refId] as #__class_name__#
//
//    methodResult.success(ref.#__field_name__#)
//}
class GetterMethodTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/getter.mtd.kt.tmpl").readText()

    fun kotlinGetter(): String {
        return tmpl
            .replace("#__getter_name__#", field.kotlinHandleGetterMethod())
            .replace("#__class_name__#", field.className.toKotlinType())
            .replace("#__field_name__#", field.variable!!.name)
    }
}