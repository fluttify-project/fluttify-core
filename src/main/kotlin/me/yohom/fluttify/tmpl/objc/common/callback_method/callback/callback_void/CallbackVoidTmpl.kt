package me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_void

import me.yohom.fluttify.model.Method

//[channel invokeMethod:@"#__callback_method__#" arguments:@{#__callback_args__#}];
internal class CallbackVoidTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/callback_void.stmt.m.tmpl").readText()

    fun objcCallbackVoid(): String {
        val callbackMethod =
            "Callback::${method.className}::${method.name}${method.formalParams.joinToString("") { it.named }.capitalize()}"
        val callbackArgs = method
            .formalParams
            .joinToString {
                "@\"${it.variable.name}\": arg${it.variable.name}"
//            when {
//                it.variable.isStruct() -> "@\"${it.variable.name}\": @(${StructToNSValueTmpl(it.variable).objcStructToNSValue()}.hash)"
//                it.variable.isRefType() -> "@\"${it.variable.name}\": @(${it.variable.name}.hash)"
//                // 如果碰到id类型的参数, 那么一律转为NSObject处理
//                it.variable.typeName == "id" -> "@\"${it.variable.name}\": @(((NSObject*) ${it.variable.name}).hash)"
//                else -> "@\"${it.variable.name}\": @(${it.variable.name})"
//            }
            }

        return tmpl
            .replace("#__callback_method__#", callbackMethod)
            .replace("#__callback_args__#", callbackArgs)
    }
}