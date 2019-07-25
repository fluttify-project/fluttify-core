package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Variable
import me.yohom.fluttify.common.tmpl.Tmpl

/**
 * 生成普通类的dart接口
 */
class MethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/method.mtd.dart.tmpl").readText()

    fun dartMethod(): String {
        val static = if (method.isStatic) "static" else ""
        val returnType = method.returnType.toDartType()
        val name = method.name
        val formalParams = method.formalParams.joinToString { it.toDartString() }
        val invoke = invokeString(method.isStatic, method.className, method.name, method.formalParams)
        val callback = callbackString(method.className, method.name, listOf())
        val returnStatement = returnString(method.returnType)

        return tmpl
            .replace("#__static__#", static)
            .replace("#__return_type__#", returnType)
            .replace("#__method_name__#", name)
            .replace("#__formal_params__#", formalParams)
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
        params: List<Variable>
    ): String {
        val resultBuilder = StringBuilder("")

        val actualParams = params
            .filter { !it.type.isJavaCallback() }
            .toMutableList()
            .apply { if (!isStatic) add(Variable("int", "refId")) }
            .toDartMap {
                when {
                    it.type.isEnum() -> "${it.name}.index"
                    it.type.isList() -> "${it.name}.map((it) => it.refId).toList()"
                    it.type.jsonable() -> it.name
                    else -> "${it.name}.refId"
                }
            }

        resultBuilder.append(
            "final result = await _channel.invokeMethod('$className::$methodName', $actualParams);\n"
        )
        return resultBuilder.toString()
    }

    private fun callbackString(
        className: String,
        methodName: String,
        callbacks: List<Method>
    ): String {
        val resultBuilder = StringBuilder("")
        callbacks
            .distinctBy { it.name }
            .forEach { callback ->
                resultBuilder.appendln(
                    Tmpl.Dart.callbackCaseBuilder
                        .replace("#__callback_case__#", "$className::${methodName}_Callback::${callback.name}")
                        .replace("#__callback_handler__#", callback.name)
                        .replace("#__callback_args__#", callback.formalParams.joinToString {
                            if (it.type.jsonable()) {
                                "args['${it.name}']"
                            } else {
                                "${it.type.toDartType()}.withRefId(args['${it.name}'])"
                            }
                        })
                )
            }
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
        } else if (returnType.isEnum()) {
            resultBuilder.append("${returnType.toDartType()}.values[result]")
        } else {
            if (returnType.isList()) {
                resultBuilder.append(
                    "(result as List).map((it) => ${returnType.genericType().toDartType()}.withRefId(it))"
                )
            } else {
                resultBuilder.append("${returnType.toDartType()}.withRefId(result)")
            }
        }

        return resultBuilder.toString()
    }
}