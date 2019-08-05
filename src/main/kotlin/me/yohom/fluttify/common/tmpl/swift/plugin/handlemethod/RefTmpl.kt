package me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod

import me.yohom.fluttify.common.model.Method

//let refId = args["refId"] as Int
//let ref = REF_MAP[refId] as #__class_name__#
class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/ref.stmt.swift.tmpl").readText()

    fun swiftRef(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}