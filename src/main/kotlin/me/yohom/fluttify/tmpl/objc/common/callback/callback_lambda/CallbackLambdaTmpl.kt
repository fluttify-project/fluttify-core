package me.yohom.fluttify.tmpl.objc.common.callback.callback_lambda

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ctype.CallbackArgCTypeTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_jsonable.CallbackArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_list.CallbackArgListTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_struct.CallbackArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.CallbackReturnTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_void.CallbackVoidTmpl

//^(#__formal_params__#) {
//    FlutterMethodChannel *channel = [FlutterMethodChannel
//        methodChannelWithName:@"#__method_channel__#"
//              binaryMessenger:[self->_registrar messenger]];
//
//    NSLog(@"#__log__#");
//
//    // 构造可以直接传输的参数
//    #__local_args__#
//
//    #__callback__#
//}
internal class CallbackLambdaTmpl(private val callerMethod: Method, private val callbackLambda: Type) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/lambda_callback.stmt.m.tmpl").readText()

    fun objcCallback(): String {
        val methodChannel = "${callerMethod.nameWithClass()}::Callback"
        val formalParams = callbackLambda.formalParams.joinToString { "${it.variable.paramType()} ${it.variable.name.depointer()}" }
        val localArgs = if (callbackLambda.returnType == "void") {
            // 只有没有返回值的方法需要设置, 不然的话会把不需要的对象放到HEAP中去, dart端又无法释放, 造成泄露
            callbackLambda
                .formalParams
                .map { it.variable }
                .joinToString("\n") {
                    when {
                        it.isCType() -> CallbackArgCTypeTmpl(it).objcCallbackArgCType()
                        it.jsonable() -> CallbackArgJsonableTmpl(it).objcCallbackArgJsonable()
                        it.isEnum() -> CallbackArgEnumTmpl(it).objcCallbackArgEnum()
                        it.isList -> CallbackArgListTmpl(it).objcCallbackArgList()
                        it.isStruct() -> CallbackArgStructTmpl(it).objcCallbackArgStruct()
                        else -> CallbackArgRefTmpl(it).objcCallbackArgRef()
                    }
                }
        } else {
            ""
        }
        val callback = when {
            callbackLambda.returnType == "void" -> CallbackVoidTmpl(callbackLambda.asMethod()).objcCallbackVoid()
            else -> CallbackReturnTmpl(callbackLambda.asMethod()).objcCallbackReturn()
        }

        return tmpl
            .replace("#__log__#", "")
            .replace("#__method_channel__#", methodChannel)
            .replace("#__formal_params__#", formalParams)
            .replaceParagraph("#__local_args__#", localArgs)
            .replaceParagraph("#__callback__#", callback)
    }
}