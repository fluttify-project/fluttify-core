package me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod

import me.yohom.fluttify.common.extensions.toKotlinType
import me.yohom.fluttify.common.model.Field

//private fun #__setter_name__#(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {
//    val #__field_name__# = args["#__field_name__#"] as #__field_type__#
//
//    val refId = args["refId"] as Int
//    val ref = REF_MAP[refId] as #__class_name__#
//
//    ref.#__field_name__# = #__field_name__#
//    methodResult.success("success")
//}
class SetterMethodTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/setter.mtd.swift.tmpl").readText()

    fun kotlinSetter(): String {
        val setterName = field.kotlinHandleSetterMethod()
        val fieldName = field.variable!!.name
        val fieldType = field.variable.typeName.toKotlinType()
        val className = field.className

        return tmpl
            .replace("#__setter_name__#", setterName)
            .replace("#__field_name__#", fieldName)
            .replace("#__field_type__#", fieldType)
            .replace("#__class_name__#", className)
    }
}