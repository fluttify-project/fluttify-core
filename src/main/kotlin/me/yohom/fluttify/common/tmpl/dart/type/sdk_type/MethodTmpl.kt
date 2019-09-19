package me.yohom.fluttify.common.tmpl.dart.type.sdk_type

import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Parameter
import me.yohom.fluttify.common.model.Platform
import me.yohom.fluttify.common.model.Variable
import me.yohom.fluttify.common.tmpl.dart.type.sdk_type.callback.CallbackMethodTmpl

//#__static__# Future<#__return_type__#> #__method_name__#(#__formal_params__#) async {
//  // 日志打印
//  #__log__#
//
//  // 调用原生方法
//  #__invoke__#
//
//  // 接受原生回调
//  #__callback__#
//
//  // 返回值
//  return #__return_statement__#;
//}
/**
 * 生成普通类的dart接口
 */
class MethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type/sdk_type/method.mtd.dart.tmpl").readText()

    fun dartMethod(): String {
        val static = if (method.isStatic) "static" else ""
        val returnType = method.returnType.toDartType()
        val name = method.name
        // 方法声明内的参数一律保留, 只有在传参的时候过滤掉lambda和callback参数
        val formalParams = method
            .formalParams
            .joinToString { it.variable.toDartString() }
        val log = if (method.isStatic) {
            "print('fluttify-dart: ${method.className}::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\'${it.variable.name}\\':$${it.variable.name}" }})');"
        } else {
            "print('fluttify-dart: ${method.className}@\$refId::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\'${it.variable.name}\\':$${it.variable.name}" }})');"
        }
        val invoke = invokeString(method.isStatic, method.className, method.name, method.formalParams)
        val callback = CallbackMethodTmpl(method).callback()
        val returnStatement = returnString(method.returnType)

        return tmpl
            .replace("#__static__#", static)
            .replace("#__return_type__#", returnType)
            .replace("#__method_name__#", name)
            .replace("#__formal_params__#", formalParams)
            .replaceParagraph("#__log__#", log)
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__callback__#", callback)
            .replace("#__return_statement__#", returnStatement)
    }

    /**
     * 方法体拼接字符串
     */
    private fun invokeString(
        isStatic: Boolean,
        className: String,
        methodName: String,
        params: List<Parameter>
    ): String {
        val resultBuilder = StringBuilder("")

        val actualParams = params
            .filterFormalParams()
            .toMutableList()
            .apply {
                if (!isStatic) add(
                    Parameter(
                        variable = Variable("int", "refId", platform = Platform.General),
                        platform = Platform.General
                    )
                )
            }
            .map { it.variable }
            .toDartMap {
                when {
                    it.typeName.findType().isEnum() -> "${it.name}.index"
                    it.typeName.findType().isList() -> "${it.name}.map((it) => it.refId).toList()"
                    it.typeName.jsonable() -> it.name
                    else -> "${it.name}.refId"
                }
            }

        resultBuilder.append(
            "final result = await _channel.invokeMethod('$className::$methodName', $actualParams);\n"
        )
        return resultBuilder.toString()
    }

    /**
     * 返回值拼接字符串
     */
    private fun returnString(returnType: String): String {
        val resultBuilder = StringBuilder("")

        if (returnType.jsonable()) {
            if (returnType.isList()) {
                resultBuilder.append(
                    "(result as List).cast<${returnType.genericType().toDartType()}>()"
                )
            } else {
                resultBuilder.append("result")
            }
        } else if (returnType.findType().isEnum()) {
            resultBuilder.append("${returnType.toDartType()}.values[result]")
        } else {
            if (returnType.findType().isList()) {
                resultBuilder.append(
                    "(result as List).map((it) => ${returnType.genericType().toDartType()}()..refId = it)"
                )
            } else {
                resultBuilder.append("${returnType.toDartType()}()..refId = result")
            }
        }

        return resultBuilder.toString()
    }
}