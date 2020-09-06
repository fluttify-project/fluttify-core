package me.yohom.fluttify.tmpl.java.common.handler.common.ref

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//int refId = (int) args.get("__this__");
//#__class_name__# ref = (#__class_name__#) getHEAP().get(refId);
private val tmpl by lazy { getResource("/tmpl/java/ref.stmt.java.tmpl").readText() }

fun RefTmpl(method: Method): String {
    return if (method.isStatic)
        ""
    else
        tmpl.replace("#__class_name__#", method.className.replace("$", "."))
}