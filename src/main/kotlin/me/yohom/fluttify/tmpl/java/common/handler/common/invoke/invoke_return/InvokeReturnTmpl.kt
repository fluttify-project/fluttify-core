package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_return

import me.yohom.fluttify.model.Method

//#__return_type__# result = #__invoke_target__#.#__method_name__#(#__actual_params__#);
class InvokeReturnTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/java/invoke_return.stmt.java.tmpl").readText()

    fun javaInvokeReturn(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
        return tmpl
            .replace("#__return_type__#", method.returnType)
            .replace("#__invoke_target__#", if (method.isStatic) method.className else "ref")
            .replace("#__method_name__#", method.name)
            .replace("#__actual_params__#", method.formalParams.joinToString { it.variable.var2Args(method) })
    }
}