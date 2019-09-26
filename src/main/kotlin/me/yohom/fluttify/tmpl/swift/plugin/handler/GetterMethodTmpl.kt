package me.yohom.fluttify.tmpl.swift.plugin.handler

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.objc2SwiftSpec
import me.yohom.fluttify.extensions.toSwiftType
import me.yohom.fluttify.model.Field

//private func #__getter_method_name__#(registrar: FlutterPluginRegistrar, args: Dictionary<String, Any>, methodResult: FlutterResult) {
//    // 引用对象
//    let refId = args["refId"] as! Int
//    let ref = HEAP[refId] as! #__class_name__#
//
//    methodResult(ref.#__getter__#)
//}
internal class GetterMethodTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/getter.mtd.swift.tmpl").readText()

    fun swiftGetter(): String {
        return tmpl
            .replace("#__getter_method_name__#", field.nativeHandleGetterMethodName())
            .replace("#__class_name__#", field.className.toSwiftType())
            .replace("#__field_name__#", field.getterName.depointer())
            .replace("#__getter__#", field.getterName.depointer().objc2SwiftSpec())
    }
}