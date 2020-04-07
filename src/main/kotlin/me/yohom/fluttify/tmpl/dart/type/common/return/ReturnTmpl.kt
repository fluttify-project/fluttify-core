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
        if (returnType.isCollection() && returnType.collectionLevel() > 1) {
            return "[] /* 暂时不支持多维列表 */";
        }

        // 如果返回类型是抽象类, 那么先转换成它的子类
        var concretTypeWithContainer: String
        // 如果是(列表+抽象)类, 那么先把泛型类处理成实体类, 再加上`List`
        if (returnType.isCollection() && returnType.collectionLevel() != 0) {
            val genericType = returnType.genericTypes()
            concretTypeWithContainer = genericType[0]
            if (genericType[0].findType().isAbstract) {
                concretTypeWithContainer = genericType[0].findType().run { firstConcretSubtype()?.name ?: this.name }
            }
            concretTypeWithContainer = "List<$concretTypeWithContainer>"
        } else {
            concretTypeWithContainer = returnType
            if (returnType.findType().isAbstract) {
                concretTypeWithContainer = returnType.findType().run { firstConcretSubtype()?.name ?: this.name }
            }
        }

        concretTypeWithContainer.run {
            when {
                jsonable() || concretTypeWithContainer == "void" -> {
                    ResultJsonableTmpl(concretTypeWithContainer, method.platform)
                }
                // 返回枚举类型
                findType().isEnum() -> ResultEnumTmpl(concretTypeWithContainer)
                // 返回列表类型
                isCollection() -> {
                    val type = if (concretTypeWithContainer.collectionLevel() != 0) {
                        concretTypeWithContainer.genericTypes()[0]
                    } else {
                        method.platform.objectType()
                    }

                    ResultListTmpl(type, method.platform)
                }
                else -> ResultRefTmpl(concretTypeWithContainer)
            }
        }
    }
}