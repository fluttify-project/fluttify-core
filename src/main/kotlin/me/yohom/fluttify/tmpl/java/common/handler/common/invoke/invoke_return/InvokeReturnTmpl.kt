package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_return

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//#__return_type__# __result__;
//try {
//    __result__ = #__invoke_target__#.#__method_name__#(#__actual_params__#);
//} catch (Throwable throwable) {
//    throwable.printStackTrace();
//    if (getEnableLog()) {
//        Log.d("Current HEAP: ", getHEAP().toString());
//    }
//    __methodResult__.error(throwable.getMessage(), null, null);
//    return;
//}
private val tmpl by lazy { getResource("/tmpl/java/invoke_return.stmt.java.tmpl").readText() }

fun InvokeReturnTmpl(method: Method): String {
    // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
    return tmpl
        .replace("#__return_type__#", method.returnType.replace("$", "."))
        .replace("#__invoke_target__#", if (method.isStatic) method.className.replace("$", ".") else "__this__")
        .replace("#__method_name__#", method.name)
        .replace("#__actual_params__#", method.formalParams.joinToString { it.variable.var2Args() })
}