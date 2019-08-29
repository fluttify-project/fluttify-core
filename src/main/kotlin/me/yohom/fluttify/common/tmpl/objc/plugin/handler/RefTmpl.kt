package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.model.Method

//NSInteger refId = [args[@"refId"] integerValue];
//#__class_name__#* ref = (#__class_name__# *) REF_MAP[@(refId)];
internal class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/ref.stmt.m.tmpl").readText()

    fun objcRef(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}