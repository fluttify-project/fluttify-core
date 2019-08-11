package me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.objc2SwiftSpec
import me.yohom.fluttify.common.extensions.toSwiftType
import me.yohom.fluttify.common.model.Field

//private func #__getter_method_name__#(registrar: FlutterPluginRegistrar, args: Dictionary<String, Any>, methodResult: FlutterResult) {
//    // 引用对象
//    let refId = args["refId"] as! Int
//    let ref = REF_MAP[refId] as! #__class_name__#
//
//    methodResult(ref.#__getter__#)
//}
internal class GetterMethodTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/getter.mtd.swift.tmpl").readText()

    fun objcGetter(): String {
        return tmpl
            .replace("#__getter_method_name__#", field.nativeHandleGetterMethodName())
            .replace("#__class_name__#", field.className.toSwiftType())
            .replace("#__field_name__#", field.getterName.depointer())
            .replace("#__getter__#", field.getterName.depointer().objc2SwiftSpec())
    }
}