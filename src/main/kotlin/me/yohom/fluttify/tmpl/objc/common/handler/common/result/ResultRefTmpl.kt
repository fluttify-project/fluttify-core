package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.TYPE_NAME

//// return a ref
//HEAP[@((#__cast_nsobject__#result).hash)] = result;
//methodResult(@((#__cast_nsobject__#result).hash));
internal class ResultRefTmpl(private val returnType: TYPE_NAME) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/result_ref.stmt.m.tmpl").readText()

    fun objcResultRef(): String {
        // 如果返回的是id类型, 那么一律转为NSObject*
        return tmpl.replace("#__cast_nsobject__#", if (returnType == "id") "(NSObject*) " else "")
    }
}