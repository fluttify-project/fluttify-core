package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// ref arg
//Integer __refId__ = (Integer) ((Map<String, Object>) __args__).get("#__arg_name__#");
//#__type_name__# #__arg_name__# = __refId__ != null ? (#__type_name__#) getHEAP().get(__refId__) : null;
private val tmpl by lazy { getResource("/tmpl/java/arg_ref.stmt.java.tmpl").readText() }

fun ArgRefTmpl(variable: Variable): String {
    // TODO 对应参数类型是泛型的workaround, 判断类型名长度是否为1, 如果是的话, 则替换为Object, 这个需要后期完善一下
    val typeName = if (variable.trueType.replace("$", ".").length == 1) {
        "java.lang.Object"
    } else {
        variable.trueType.replace("$", ".")
    }
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", variable.name)
}