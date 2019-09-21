package me.yohom.fluttify.tmpl.swift.plugin.handler

import me.yohom.fluttify.model.Method

//let refId = args["refId"] as Int
//let ref = REF_MAP[refId] as #__class_name__#
internal class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/ref.stmt.swift.tmpl").readText()

    fun swiftRef(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}