package me.yohom.fluttify.tmpl.dart.type.type_interface

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.common.getter.GetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter.SetterTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.anonymous.AnonymousTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method.InterfaceMethodBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method.InterfaceMethodTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl

//import 'dart:typed_data';
//
//#__platform_import__#
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//#__foundation__#
//
//#__sub_class__#
//
//mixin #__interface_type__# on #__super_mixins__# {
//  #__constants__#
//
//  #__sub_instance__#
//
//  @override
//  final String tag__ = '#__tag__#';
//
//  #__getters__#
//
//  #__setters__#
//
//  #__interface_methods__#
//}
//
//#__type_interface_batch__#
private val tmpl by lazy { getResource("/tmpl/dart/type_interface.dart.tmpl").readText() }
private val batchTmpl by lazy { getResource("/tmpl/dart/type_interface_batch.dart.tmpl").readText() }

fun TypeInterfaceTmpl(type: Type): String {
    val currentPackage = ext.projectName
    val typeName =
        "${type.name.toDartType()}${type.declaredGenericTypes.joinToStringX(",", "<", ">")}"

    val constants = type.fields.filterConstants()

    val anonymous = if (type.isCallback) AnonymousTmpl(type) else ""

    val allSuperType = type.ancestorTypes
        .reversed()
        .asSequence()
        .filter { it.isNotBlank() }
        .filter { it.findType().platform != Platform.Unknown }
        .filter { !it.isObfuscated() }
        // 去掉NSObject的继承, 下面会添加回去的, 由于objc的class和protocol不在一个命名空间内, 所以存在class NSObject和protocol NSObject
        // 在dart端不太好处理
        .filter { it != "NSObject" }
        .map {
            // 如果当前类有声明泛型, 那么祖宗类里的泛型就用当前类型的声明泛型
            if (type.declaredGenericTypes.isNotEmpty()) {
                "${it.containerType()}${it.findType().declaredGenericTypes.joinToStringX(",", "<", ">")}"
            }
            // 否则使用祖宗类自己的定义泛型
            else {
                "${it.containerType()}${it.findType().definedGenericTypes.joinToStringX(",", "<", ">")}"
            }
        }
        .toList()
    val subSuperMixins =
        if (allSuperType.isEmpty()) "" else "${allSuperType.joinToString().toDartType()}, "
    val superMixins = if (allSuperType.isEmpty()) {
        type.platform.objectType()
    } else {
        allSuperType.joinToString().toDartType()
    }

    val containerType = typeName.containerType()
    val genericType = type.declaredGenericTypes.joinToStringX(",", "<", ">")
    val subclass =
        "class _${containerType}_SUB$genericType extends ${type.platform.objectType()} with $subSuperMixins$typeName {}"

    // 给接口类型提供一个可供实例化的子类, mixin需要继承各平台Object类型, 并实现接口类
    val subInstance =
        "static $containerType$genericType subInstance$genericType() => _${containerType}_SUB$genericType();"

    val methods = type.methods
        .filterMethod()
        .map {
            // 只有回调类不需要调用原生方法
            if (type.isCallback) {
                InterfaceMethodTmpl(it)
            } else {
                MethodTmpl(it)
            }
        }

    val getters = type.fields
        .filterGetters()
        .map { GetterTmpl(it) }

    val setters = type.fields
        .filterSetters()
        .map { SetterTmpl(it) }

    val methodsBatch = type.methods
        .filterMethod(true)
        .map { InterfaceMethodBatchTmpl(it) }

    val typeInterfaceBatch = if (!type.isCallback && type.declaredGenericTypes.isEmpty()) {
        batchTmpl.replace("#__interface_type__#", typeName)
            .replaceParagraph("#__methods_batch__#", methodsBatch.joinToString("\n"))
    } else {
        ""
    }

    return tmpl
        .replace(
            "#__platform_import__#", when (type.platform) {
                Platform.iOS -> "import 'package:$currentPackage/src/ios/ios.export.g.dart';"
                Platform.Android -> "import 'package:$currentPackage/src/android/android.export.g.dart';"
                else -> ""
            }
        )
        .replaceParagraph(
            "#__foundation__#",
            ext.foundationVersion.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
        .replace("#__sub_class__#", subclass)
        .replace("#__sub_instance__#", subInstance)
        .replaceParagraph("#__anonymous__#", anonymous)
        .replace("#__interface_type__#", typeName)
        .replace("#__sub_super_mixins__#", subSuperMixins)
        .replace("#__super_mixins__#", superMixins)
        .replace("#__tag__#", ext.projectName)
        .replaceParagraph(
            "#__constants__#",
            constants.joinToString("\n") { "static final ${it.variable.trueType.toDartType()} ${it.variable.name} = ${it.value};" }
        )
        .replaceParagraph("#__interface_methods__#", methods.joinToString("\n"))
        .replaceParagraph("#__getters__#", getters.joinToString("\n"))
        .replaceParagraph("#__setters__#", setters.joinToString("\n"))
        .replaceParagraph("#__type_interface_batch__#", typeInterfaceBatch)
}