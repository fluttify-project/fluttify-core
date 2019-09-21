package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.TYPE_NAME

//NSValue* resultValue = [NSValue value:&result withObjCType:@encode(#__result_type__#)];
//REF_MAP[@(resultValue.hash)] = resultValue;
//
//methodResult(@(resultValue.hash));
internal class ResultStructTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/objc/result_struct.stmt.m.tmpl").readText()

    fun objcResultStruct(): String {
        return tmpl.replace("#__result_type__#", returnType)
    }

}