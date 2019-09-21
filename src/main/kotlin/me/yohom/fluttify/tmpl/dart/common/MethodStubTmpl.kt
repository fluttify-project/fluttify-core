package me.yohom.fluttify.tmpl.dart.common

import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Method

//#__annotation__#
//#__return_type__# #__method_name__#(#__formal_params__#) {
//  return #__return_value__#;
//}
@Deprecated("暂时不用")
class MethodStubTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/method_stub.mtd.dart.tmpl").readText()

    fun dartMethodStub(): String {
        return tmpl
            .replace("#__annotation__#", "@override")
            .replace("#__return_type__#", method.returnType.toDartType())
            .replace("#__method_name__#", method.name)
            .replace("#__formal_params__#", method.formalParams.joinToString { it.variable.toDartString() })
            .replace("#__return_value__#", "null")
    }
}