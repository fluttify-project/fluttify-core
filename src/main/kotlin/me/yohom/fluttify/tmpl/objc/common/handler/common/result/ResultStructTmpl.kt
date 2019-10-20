package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel

//NSValue* resultValue = [NSValue value:&result withObjCType:@encode(#__result_type__#)];
//HEAP_#__plugin_name__#[@(resultValue.hash)] = resultValue;
//
//methodResult(@(resultValue.hash));
internal class ResultStructTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/objc/result_struct.stmt.m.tmpl").readText()

    fun objcResultStruct(): String {
        return tmpl
            .replace("#__result_type__#", returnType)
            .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))

    }

}