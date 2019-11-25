package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable

//methodResult.success(#__result__#);
internal class ResultJsonableTmpl(val returnType: String) {
    private val tmpl = this::class.java.getResource("/tmpl/java/result_jsonable.stmt.java.tmpl").readText()

    fun javaJsonableResult(): String {
        val result = if (returnType.endsWith("[]"))
            "new ArrayList<${returnType.removeSuffix("[]")}>(java.util.Arrays.asList(result))"
        else
            "result"
        return tmpl
            .replace("#__result__#", result)
    }
}