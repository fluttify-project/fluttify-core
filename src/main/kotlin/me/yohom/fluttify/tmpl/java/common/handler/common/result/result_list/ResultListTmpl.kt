package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.genericType
import me.yohom.fluttify.extensions.getResource

//List<Integer> jsonableResult = null;
//if (result != null) {
//    jsonableResult = new ArrayList<>();
//    for (#__type_name__# item : result) {
//        getHEAP().put(item.hashCode(), item);
//        jsonableResult.add(item.hashCode());
//    }
//}
private val tmpl = getResource("/tmpl/java/result_list.stmt.java.tmpl").readText()

fun ResultListTmpl(returnType: TYPE_NAME): String {
    return tmpl
        .replace("#__type_name__#", returnType.genericType().replace("$", "."))
}