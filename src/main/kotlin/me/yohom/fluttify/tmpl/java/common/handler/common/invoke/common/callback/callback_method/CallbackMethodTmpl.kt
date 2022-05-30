package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.ifIsGenericTypeConvertToObject
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_return.CallbackReturnTmpl

//@Override
//public #__return_type__# #__callback_method__#(#__formal_params__#) {
//    // print log
//    if (getEnableLog()) {
//        #__log__#
//    }
//
//    // call dart method
//    handler.post(new Runnable() {
//        @Override
//        public void run() {
//            callbackChannel.invokeMethod(
//                "Callback::#__callback_method_name__#",
//                new HashMap<String, Object>() {{
//                    #__callback_args__#
//                }}
//            );
//        }
//    });
//
//    // method result
//    #__return_stmt__#
//}
private val tmpl by lazy { getResource("/tmpl/java/callback_method.mtd.java.tmpl").readText() }

fun CallbackMethodTmpl(method: Method): String {
    val callbackMethod = method.exactName
    val formalParams = method
        .formalParams
        .map { it.variable }
        .joinToString {
            "${it.trueType.replace("$", ".").ifIsGenericTypeConvertToObject()} ${it.name}"
        }
    val returnType = method.returnType.replace("$", ".")
    val callbackArgs = method
        .formalParams
        .joinToString("\n") {
            "put(\"${it.variable.name}\", ${it.variable.name});"
        }
    // 打印日志
    val logArgs = method
        .formalParams
        .filterNot { it.variable.isCallback() }
        .filterNot { it.variable.isLambda() }
        .joinToString(" + ") { it.variable.name }
    val log =
        """Log.d("java-callback", "fluttify-java-callback: ${method.name}(" + ${if (logArgs.isEmpty()) "\"\"" else logArgs} + ")");"""
    // 返回语句
    val returnStmt = CallbackReturnTmpl(method)

    return tmpl
        .replace("#__callback_method__#", callbackMethod)
        .replace("#__formal_params__#", formalParams)
        .replace("#__return_type__#", returnType)
        .replaceParagraph("#__callback_args__#", callbackArgs)
        .replaceParagraph("#__log__#", log)
        .replaceParagraph("#__return_stmt__#", returnStmt)
}