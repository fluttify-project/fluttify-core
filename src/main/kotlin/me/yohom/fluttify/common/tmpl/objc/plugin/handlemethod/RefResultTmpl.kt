package me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.isObjcValueType
import me.yohom.fluttify.common.extensions.jsonable

//NSInteger returnRefId = [result hashValue];
//REF_MAP[@(returnRefId)] = result;
//
//methodResult(returnRefId);
internal class RefResultTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/objc/ref_result.stmt.m.tmpl").readText()

    fun objcRefResult(): String {
        return when {
            returnType == "void" -> "methodResult(@\"success\");"
            returnType.isObjcValueType() -> "methodResult(@(result));"
            returnType.jsonable() -> "methodResult(result);"
            else -> tmpl
        }
    }

}