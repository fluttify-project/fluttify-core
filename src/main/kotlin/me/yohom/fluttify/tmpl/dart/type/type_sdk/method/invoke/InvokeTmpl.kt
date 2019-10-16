package me.yohom.fluttify.tmpl.dart.type.type_sdk.method.invoke

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Variable

class InvokeTmpl(
    private val method: Method,
    private val ext: FluttifyExtension
) {
    fun dartMethodInvoke(): String {
        return invokeString(method.isStatic, method.nameWithClass(), method.formalParams)
    }

    private fun invokeString(
        isStatic: Boolean,
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
                    it.typeName.jsonable() -> it.name
                    (it.isList && it.genericLevel <= 1) || it.isStructPointer() -> "${it.name}.map((it) => it.refId).toList()"
                    it.genericLevel > 1 -> "[]" // 多维数组暂不处理
                    else -> "${it.name}.refId"
                }
            }

        val viewMethodChannel = "${ext.methodChannelName}/${method.className.toUnderscore()}"
        val methodChannel = ext.methodChannelName

        // 只有当前类是View的时候, 才需要区分普通channel和View channel
        if (method.className.findType().isView()) {
            resultBuilder.append(
                "final result = await MethodChannel(viewChannel ? '$viewMethodChannel' : '$methodChannel').invokeMethod('$methodName', $actualParams);\n"
            )
        } else {
            resultBuilder.append(
                "final result = await MethodChannel('$methodChannel').invokeMethod('$methodName', $actualParams);\n"
            )
        }
        return resultBuilder.toString()
    }
}