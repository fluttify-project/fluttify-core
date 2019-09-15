package me.yohom.fluttify.common.tmpl.objc.common.handler.result

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.isObjcValueType
import me.yohom.fluttify.common.extensions.jsonable

//NSInteger returnRefId = [result hashValue];
//REF_MAP[@(returnRefId)] = result;
//
//methodResult(returnRefId);
internal class ResultRefTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/result/result_ref.stmt.m.tmpl").readText()

    fun objcResultRef(): String {
        return when {
            returnType == "void" -> "methodResult(@\"success\");"
            returnType.isObjcValueType() -> "methodResult(@(result));"
            returnType.jsonable() -> "methodResult(result);"
            else -> tmpl
        }
    }

}