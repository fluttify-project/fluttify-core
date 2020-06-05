package me.yohom.fluttify.tmpl.dart.type.common.`return`

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultListTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultRefTmpl

fun ReturnTmpl(method: Method): String {
    return method.run {
        // 如果是多维列表, 那么不处理, 直接返回空列表
        if (returnType.isIterable() && returnType.iterableLevel() > 1) {
            return "[] /* 暂时不支持多维列表 */";
        }

        when {
            returnType.jsonable() || returnType.isVoid() -> {
                ResultJsonableTmpl(returnType, method.platform)
            }
            // 返回枚举类型
            returnType.findType().isEnum -> ResultEnumTmpl(returnType)
            // 返回列表类型
            returnType.isIterable() -> {
                val type = if (returnType.iterableLevel() != 0) {
                    returnType.genericTypes()[0]
                } else {
                    "" // 这里传空字符串即可 ResultListTmpl内部会转换为对应平台的Object类型
                }

                ResultListTmpl(type, method.platform)
            }
            returnType.isStructPointer() -> ResultListTmpl(returnType.depointer(), method.platform)
            else -> ResultRefTmpl(returnType)
        }
    }
}