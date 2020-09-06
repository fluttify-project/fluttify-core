package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_void

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.deprotocol
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//dispatch_async(dispatch_get_main_queue(), ^{
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//        methodChannelWithName:#__method_channel__#
//              binaryMessenger:[registrar messenger]
//                        codec:[FlutterStandardMethodCodec codecWithReaderWriter:[[FluttifyReaderWriter alloc] init]]];
//
//  [channel invokeMethod:@"#__callback_method__#" arguments:@{#__callback_args__#}];
//});
private val tmpl by lazy { getResource("/tmpl/objc/callback_void.stmt.m.tmpl").readText() }

fun CallbackVoidTmpl(method: Method): String {
    val callbackMethod = "Callback::${method.nameWithClass()}"
    val methodChannel = "@\"${method.className.deprotocol().replace("$", ".")}::Callback\""

    val callbackArgs = method
        .formalParams
        .joinToString { "@\"${it.variable.name.depointer()}\": arg${it.variable.name.depointer()} == nil ? [NSNull null] : arg${it.variable.name.depointer()}" }

    return tmpl
        .replace("#__callback_method__#", callbackMethod)
        .replace("#__method_channel__#", methodChannel)
        .replace("#__callback_args__#", callbackArgs)
}