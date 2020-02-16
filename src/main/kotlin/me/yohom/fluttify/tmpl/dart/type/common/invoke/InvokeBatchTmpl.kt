package me.yohom.fluttify.tmpl.dart.type.common.invoke

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.*

// todo 使用模板重构
fun InvokeBatchTmpl(method: Method): String {
    fun invokeString(methodName: String, params: List<Parameter>): String {
        val resultBuilder = StringBuilder("")

        val actualParams = params
            .filterFormalParams()
            .toMutableList()
            .apply {
                add(
                    Parameter(
                        variable = Variable(method.className, "this", Platform.General, ListType.NonList, 0),
                        platform = Platform.General
                    )
                )
            }
            .map { it.variable }
            .toDartMapBatch {
                when {
                    it.typeName.findType().isEnum() -> {
                        // 枚举列表
                        if (it.isList) {
                            "${it.name.depointer()}[i].map((it) => it.index).toList()"
                        } else {
                            "${it.name.depointer()}[i].index"
                        }
                    }
                    it.typeName.jsonable() -> "${it.name.depointer()}[i]"
                    (it.isList && it.genericLevel <= 1) || it.isStructPointer() -> "${it.name.depointer()}[i].map((it) => it.refId).toList()"
                    it.genericLevel > 1 -> "[]" // 多维数组暂不处理
                    else -> "${it.name.depointer()}[i].refId"
                }
            }

        val viewMethodChannel = "${ext.methodChannelName}/${method.className.toUnderscore()}"
        val methodChannel = ext.methodChannelName

        // 只有当前类是View的时候, 才需要区分普通channel和View channel
        if (method.className.findType().isView()) {
            resultBuilder.append(
                "final resultBatch = await MethodChannel(viewChannel ? '$viewMethodChannel' : '$methodChannel').invokeMethod('$methodName', $actualParams);\n"
            )
        } else {
            resultBuilder.append(
                "final resultBatch = await MethodChannel('$methodChannel').invokeMethod('$methodName', $actualParams);\n"
            )
        }
        return resultBuilder.toString()
    }

    return invokeString(method.nameWithClass(), method.formalParams)
}