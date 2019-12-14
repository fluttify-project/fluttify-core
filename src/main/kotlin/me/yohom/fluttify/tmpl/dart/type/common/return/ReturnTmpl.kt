package me.yohom.fluttify.tmpl.dart.type.common.`return`

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultListTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.ResultRefTmpl

class ReturnTmpl(private val method: Method) {
    fun dartReturn(): String {
        return method.run {
            // 如果是多维列表, 那么不处理, 直接返回空列表
            if (returnType.isCollection() && returnType.genericLevel() > 1) {
                return "[] /* 暂时不支持多维列表 */";
            }

            // 如果返回类型是抽象类, 那么先转换成它的子类
            var concretTypeWithContainer: String
            // 如果是(列表+抽象)类, 那么先把泛型类处理成实体类, 再加上`List`
            if (returnType.isCollection() && returnType.genericLevel() != 0) {
                val genericType = returnType.genericType()
                concretTypeWithContainer = genericType
                if (genericType.findType().isAbstract) {
                    concretTypeWithContainer = genericType.findType().run { firstConcretSubtype()?.name ?: this.name }
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
                        ResultJsonableTmpl(concretTypeWithContainer, method.platform).dartResultJsonable()
                    }
                    // 返回枚举类型
                    findType().isEnum() -> ResultEnumTmpl(concretTypeWithContainer).dartResultEnum()
                    // 返回列表类型
                    isCollection() -> {
                        val type = if (concretTypeWithContainer.genericLevel() != 0) {
                            concretTypeWithContainer.genericType()
                        } else {
                            method.platform.objectType()
                        }

                        ResultListTmpl(type, method.platform).dartResultList()
                    }
                    else -> ResultRefTmpl(concretTypeWithContainer).dartResultRef()
                }
            }
        }
    }
}