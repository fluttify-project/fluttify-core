package me.yohom.fluttify.tmpl.java.common.handler.common.ref

import me.yohom.fluttify.model.Method

//int refId = (int) args.get("refId");
//#__class_name__# ref = (#__class_name__#) getHEAP().get(refId);
internal class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/java/ref.stmt.java.tmpl").readText()

    fun javaRef(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className.replace("$", "."))

    }
}