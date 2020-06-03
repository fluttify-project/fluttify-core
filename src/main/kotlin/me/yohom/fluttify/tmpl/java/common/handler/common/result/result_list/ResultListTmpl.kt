package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list

import me.yohom.fluttify.extensions.iterableLevel
import me.yohom.fluttify.extensions.genericTypes
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//List<Integer> jsonableResult = null;
//if (__result__ != null) {
//    jsonableResult = new ArrayList<>();
//    for (#__type_name__# item : __result__) {
//        getHEAP().put(System.identityHashCode(item), item);
//        jsonableResult.add(System.identityHashCode(item));
//    }
//}
private val tmpl = getResource("/tmpl/java/result_list.stmt.java.tmpl").readText()

fun ResultListTmpl(method: Method): String {
    val typeName = if (method.returnType.iterableLevel() > 1) {
        "List jsonableResult = new ArrayList());"
    } else {
        method.returnType.genericTypes().run {
            if (isNotEmpty()) {
                this[0].replace("$", ".")
            } else {
                "java.lang.Object"
            }
        }

    }

    return tmpl
        .replace("#__type_name__#", typeName)
}