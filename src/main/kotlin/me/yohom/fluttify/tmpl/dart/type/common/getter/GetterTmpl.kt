package me.yohom.fluttify.tmpl.dart.type.common.getter

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result.*

//Future<#__type__#> get_#__name__#(#__view_channel__#) async {
//  final result = await MethodChannel(#__method_channel__#).invokeMethod("#__getter_method__#", {'refId': refId});
//  #__native_object_pool__#
//  return #__result__#;
//}
class GetterTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/getter.mtd.dart.tmpl").readText()

    fun dartGetter(): String {
        val typeNameWithContainer = field.variable.run {
            var result = typeName.findType().run { if (isAlias()) aliasOf!! else typeName }.toDartType()
            if (isStructPointer()) {
                result = "List<$result>"
            } else if (isList) {
                for (i in 0 until genericLevel) {
                    result = "List<$result>"
                }
            }
            result
        }
        val name = field.variable.name.depointer()
        val viewChannel = if (field.className.findType().isView()) "{bool viewChannel = true}" else ""

        val viewMethodChannel = "${ext.methodChannelName}/${field.className.toUnderscore()}"
        val normalMethodChannel = ext.methodChannelName
        // 只有当前类是View的时候, 才需要区分普通channel和View channel
        val methodChannel = if (field.className.findType().isView()) {
            "viewChannel ? '$viewMethodChannel' : '$normalMethodChannel'"
        } else {
            "'$normalMethodChannel'"
        }

        val getter = field.getterMethodName()
        val result = field.variable.run {
            when {
                jsonable() or isAliasType() -> ResultJsonableTmpl(typeNameWithContainer, platform).dartResultJsonable()
                isList || isStructPointer() -> ResultListTmpl(typeName, platform).dartResultList()
                isEnum() -> ResultEnumTmpl(typeName).dartResultEnum()
                typeName.isVoid() -> ResultVoidTmpl().dartResultVoid()
                else -> ResultRefTmpl(typeName).dartResultRef()
            }
        }
        val nativeObjectPool = field.variable.run {
            when {
                jsonable() or isEnum() or isAliasType() -> ""
                isList || isStructPointer() -> "kNativeObjectPool.addAll($result);"
                else -> "kNativeObjectPool.add($result);"
            }
        }

        return field.variable.run {
            tmpl
                .replace("#__type__#", typeNameWithContainer)
                .replace("#__name__#", name)
                .replace("#__view_channel__#", viewChannel)
                .replace("#__method_channel__#", methodChannel)
                .replace("#__getter_method__#", getter)
                .replace("#__native_object_pool__#", nativeObjectPool)
                .replace("#__result__#", result)
        }
    }
}