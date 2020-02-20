package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.enList
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// list arg
//List<Integer> #__arg_name__#RefIdList = (List<Integer>) args.get("#__arg_name__#");
//List<#__type_name__#> #__arg_name__# = new ArrayList<>();
//for (int refId : refIdList) {
//    #__arg_name__#.add((#__type_name__#) getHEAP().get(refIdList.get(refId)));
//}
private val tmpl = getResource("/tmpl/java/arg_list.stmt.java.tmpl").readText()

fun ArgListTmpl(variable: Variable): String {
    return if (variable.genericLevel == 0) {
        tmpl
            .replace("#__type_name__#", variable.typeName.replace("$", "."))
            .replace("#__arg_name__#", variable.name)
    } else {
        var typeName = variable.typeName.replace("$", ".")
        for (i in 0 until (variable.genericLevel - 1)) {
            typeName = typeName.enList()
        }
        "$typeName ${variable.name} = new ArrayList<>();"
    }
}