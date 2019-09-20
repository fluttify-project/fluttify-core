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
        val returnVoid = "methodResult(@\"success\");"
        val returnValue = "methodResult(@\"success\");"
        val returnJsonable = "methodResult(result);"

        return when {
            returnType == "void" -> returnVoid
            returnType.isObjcValueType() -> returnValue
            returnType.jsonable() -> returnJsonable
            else -> tmpl
        }
    }

}