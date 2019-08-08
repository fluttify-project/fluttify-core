package me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.toSwiftType
import me.yohom.fluttify.common.model.Field

//private func #__setter_method_name__#(registrar: Registrar, args: Dictionary<String, Any>, methodResult: FlutterResult) {
//    let #__field_name__# = args["#__field_name__#"] as #__field_type__#
//
//    let refId = args["refId"] as Int
//    let ref = REF_MAP[refId] as #__class_name__#
//
//    ref.#__setter__# = #__field_name__#
//    methodResult("success")
//}
class SetterMethodTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/setter.mtd.swift.tmpl").readText()

    fun swiftSetter(): String {
        val setterMethodName = field.nativeHandleSetterMethodName()
        val setter = field.setterName.depointer()
        val fieldName = field.variable.name
        val fieldType = field.variable.typeName.toSwiftType()
        val className = field.className

        return tmpl
            .replace("#__setter_method_name__#", setterMethodName)
            .replace("#__setter__#", setter)
            .replace("#__field_name__#", fieldName.depointer())
            .replace("#__field_type__#", fieldType)
            .replace("#__class_name__#", className)
    }
}