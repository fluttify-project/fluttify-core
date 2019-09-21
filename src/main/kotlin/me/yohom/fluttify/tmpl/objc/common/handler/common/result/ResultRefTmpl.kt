package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.isObjcValueType
import me.yohom.fluttify.extensions.jsonable

//NSInteger returnRefId = [result hashValue];
//REF_MAP[@(returnRefId)] = result;
//
//methodResult(returnRefId);
internal class ResultRefTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/objc/result_ref.stmt.m.tmpl").readText()

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