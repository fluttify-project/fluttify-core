package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.genericType

//if (result != null) {
//    List<Integer> refIdList = new ArrayList<>();
//    for (#__type_name__# item : result) {
//        getHEAP().put(item.hashCode(), item);
//        refIdList.add(item.hashCode());
//    }
//    methodResult.success(refIdList);
//} else {
//    methodResult.success(null);
//}
internal class ResultListTmpl(private val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/java/result_list.stmt.java.tmpl").readText()

    fun javaListResult(): String {
        return tmpl
            .replace("#__type_name__#", returnType.genericType())
    }

}