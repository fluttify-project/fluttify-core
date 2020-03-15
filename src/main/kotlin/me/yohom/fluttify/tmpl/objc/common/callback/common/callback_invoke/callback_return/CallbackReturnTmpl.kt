package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method

//[channel invokeMethod:@"#__callback_method__#"
//            arguments:@{#__callback_args__#}
//               result:^(id result) {}]; // 由于结果是异步返回, 这里用不上, 所以就不生成代码了
//
//// 由于flutter无法同步调用method channel, 所以暂不支持有返回值的回调方法
//// 相关issue https://github.com/flutter/flutter/issues/28310
//NSLog(@"暂不支持有返回值的回调方法");
//
//#__stub_return__#;
private val tmpl = getResource("/tmpl/objc/callback_return.stmt.m.tmpl").readText()

fun CallbackReturnTmpl(method: Method): String {
    val callbackMethod = method.run {
        "Callback::${className}::${name}${formalParams.joinToString("") { it.named }.capitalize()}"
    }

// 由于目前有返回值的回调方法是开放出来的, 也就是会通知dart端回调被调用了, 但是不会要求dart端返回值, 原生端也不会传有效的参数过去, 所以这里先传一个空的字典过去
//    val callbackArgs = method
//        .formalParams
//        .joinToString { "@\"${it.variable.name.depointer()}\": arg${it.variable.name.depointer()}" }

    val stubReturn = method
        .returnType
        .run {
            when {
                isVoid() -> ""
                isBoolean() -> "return NO;"
                isValueType() -> "return 0;"
                findType().isStruct() -> "$this value; return value;"
                else -> "return nil;"
            }
        }

    return tmpl
        .replace("#__callback_method__#", callbackMethod)
        .replace("#__callback_args__#", "")
        .replaceParagraph("__stub_return__", stubReturn)
}