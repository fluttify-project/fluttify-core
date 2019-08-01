package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Method

//"#__class_name__#::#__method_name__#" -> {
//    #__handler__#
//}
class BranchTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/branch.stmt.kt.tmpl").readText()

    fun kotlinBranch(): String {
        val className = method.className
        val methodName = method.name
        val handler = "handle${method.className.toDartType()}_${method.name}(registrar, args, methodResult)"

        return tmpl.replace("#__class_name__#", className)
            .replace("#__method_name__#", methodName)
            .replace("#__handler__#", handler)
    }
}