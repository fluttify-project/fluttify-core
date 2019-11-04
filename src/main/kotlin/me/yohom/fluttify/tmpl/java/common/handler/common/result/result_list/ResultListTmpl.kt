package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list

//for (val item in result) {
//    HEAP[item.hashCode()] = item
//}
//
//methodResult.success(result.map { it.hashCode() })
internal class ResultListTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/result_list.stmt.kt.tmpl").readText()

    fun kotlinListResult(): String {
        return tmpl
    }

}