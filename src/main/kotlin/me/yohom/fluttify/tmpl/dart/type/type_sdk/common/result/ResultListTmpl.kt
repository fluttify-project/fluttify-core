package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.genericType

//(result as List).cast<int>().map((it) => #__type_name__#()..refId = it).toList()
class ResultListTmpl(private val returnType: TYPE_NAME) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/result_list.stmt.dart.tmpl").readText()

    fun dartResultList(): String {
        return tmpl
            .replace("#__type_name__#", returnType.depointer().genericType())
    }
}