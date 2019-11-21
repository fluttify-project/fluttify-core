package me.yohom.fluttify.tmpl.dart.type.common.`return`

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method

class ReturnTmpl(private val method: Method) {
    fun dartMethodReturn(): String {
        return returnString(method.returnType)
    }

    private fun returnString(returnType: String): String {
        // 如果是多维列表, 那么不处理, 直接返回空列表
        if (returnType.isList() && returnType.genericLevel() > 1) {
            return "[] /* 暂时不支持多维列表 */";
        }

        val resultBuilder = StringBuilder("")

        // 如果返回类型是抽象类, 那么先转换成它的子类
        var concretType: String
        // 如果是(列表+抽象)类, 那么先把泛型类处理成实体类, 再加上`List`
        if (returnType.isList() && returnType.genericLevel() != 0) {
            val genericType = returnType.genericType()
            concretType = genericType
            if (genericType.findType().isAbstract) {
                concretType = genericType.findType().run { firstConcretSubtype()?.name ?: this.name }
            }
            concretType = "List<$concretType>"
        } else {
            concretType = returnType
            if (returnType.findType().isAbstract) {
                concretType = returnType.findType().run { firstConcretSubtype()?.name ?: this.name }
            }
        }

        // 返回jsonable类型
        if (concretType.jsonable() || concretType == "void") {
            if (concretType.isList()) {
                val type = if (concretType.genericLevel() != 0) {
                    concretType.genericType().toDartType()
                } else {
                    method.platform.objectType()
                }
                resultBuilder.append("(result as List).cast<${type}>()")
            } else {
                resultBuilder.append("result")
            }
        }
        // 返回枚举类型
        else if (concretType.findType().isEnum()) {
            resultBuilder.append("${concretType.toDartType()}.values[result]")
        }
        // 返回列表类型
        else {
            if (concretType.isList()) {
                val type = if (concretType.genericLevel() != 0) {
                    concretType.genericType().toDartType()
                } else {
                    method.platform.objectType()
                }

                resultBuilder.append("(result as List).cast<int>().map((it) => $type()..refId = it..tag = '${ext.outputProjectName}').toList()")
            } else {
                resultBuilder.append("${concretType.toDartType()}()..refId = result..tag = '${ext.outputProjectName}'")
            }
        }

        return resultBuilder.toString()
    }
}