package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list

import me.yohom.fluttify.extensions.collectionLevel
import me.yohom.fluttify.extensions.genericTypes
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//List<Integer> jsonableResult = null;
//if (result != null) {
//    jsonableResult = new ArrayList<>();
//    for (#__type_name__# item : result) {
//        getHEAP().put(item.hashCode(), item);
//        jsonableResult.add(item.hashCode());
//    }
//}
private val tmpl = getResource("/tmpl/java/result_list.stmt.java.tmpl").readText()

fun ResultListTmpl(method: Method): String {
    val typeName = if (method.returnType.collectionLevel() > 1) {
        "List jsonableResult = new ArrayList());"
    } else {
        method.returnType.genericTypes()[0].replace("$", ".")
    }

    return tmpl
        .replace("#__type_name__#", typeName)
}