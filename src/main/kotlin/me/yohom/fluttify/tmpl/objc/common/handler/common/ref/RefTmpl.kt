package me.yohom.fluttify.tmpl.objc.common.handler.common.ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Method

//NSInteger refId = [args[@"refId"] integerValue];
//#__class_name__# ref = (#__class_name__#) HEAP_#__plugin_name__#[@(refId)];
internal class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/ref.stmt.m.tmpl").readText()

    fun objcRef(): String {
        val empty = ""
        val protocol = "id<${method.className}>"
        val `class` = method.className.enpointer()

        return when {
            method.isStatic -> empty
            method.className.findType().isInterface() -> tmpl.replace("#__class_name__#", protocol)
            else -> tmpl.replace("#__class_name__#", `class`)
        }.replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}