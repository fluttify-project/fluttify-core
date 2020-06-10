package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.genericTypes
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// list arg
//List<Integer> #__arg_name__#RefIdList = (List<Integer>) ((Map<String, Object>) __args__).get("#__arg_name__#");
//#__type_name__# #__arg_name__# = new ArrayList<>();
//for (int refId : #__arg_name__#RefIdList) {
//    ((ArrayList<#__generic_type_name__#>) #__arg_name__#).add((#__generic_type_name__#) getHEAP().get(refId));
//}
private val tmpl by lazy { getResource("/tmpl/java/arg_list.stmt.java.tmpl").readText() }

fun ArgListTmpl(variable: Variable): String {
    val typeName = variable.trueType.replace("$", ".")
    val genericType = if (typeName.genericTypes().isNotEmpty()) typeName.genericTypes()[0] else "Object"
    val name = variable.name
    // 只处理非列表和一维列表, 多维列表一律返回一个空的列表
    return if (variable.getIterableLevel() <= 1) {
        tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__generic_type_name__#", genericType)
            .replace("#__arg_name__#", variable.name)
    } else {
        "$typeName $name = new ArrayList<>();"
    }
}