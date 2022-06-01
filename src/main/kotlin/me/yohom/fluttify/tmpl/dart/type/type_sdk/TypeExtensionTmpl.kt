package me.yohom.fluttify.tmpl.dart.type.type_sdk

import me.yohom.fluttify.EXCLUDE_TYPES
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.common.getter.GetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.getter_batch.GetterBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter.SetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter_batch.SetterBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.creator.CreatorBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.creator.CreatorTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl

//import 'dart:typed_data';
//
//#__platform_import__#
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//#__foundation__#
//
//extension #__extension_name__# on #__class_name__# {
//  //region getters
//  #__getters__#
//  //endregion
//
//  //region setters
//  #__setters__#
//  //endregion
//
//  //region methods
//  #__methods__#
//  //endregion
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_extension.dart.tmpl").readText() }

fun TypeExtensionTmpl(type: Type): String {
    val currentPackage = ext.projectName
    val className = if (type.declaredGenericTypes.isNotEmpty()) {
        "${type.name.toDartType()}<${type.declaredGenericTypes.joinToString()}>"
    } else {
        type.name.toDartType()
    }

    val getters = type.fields
        .filterGetters()
        .map { GetterTmpl(it) }

    val setters = type.fields
        .filterSetters()
        .map { SetterTmpl(it) }

    val methods = type.methods
        .filterMethod()
        .map { MethodTmpl(it) }

    return tmpl
        .replace("#__extension_name__#", type.extensionName)
        .replace("#__class_name__#", type.name)
        .replace(
            "#__platform_import__#", when (type.platform) {
                Platform.iOS -> "import 'package:$currentPackage/src/ios/ios.export.g.dart';"
                Platform.Android -> "import 'package:$currentPackage/src/android/android.export.g.dart';"
                else -> ""
            }
        )
        .replaceParagraph(
            "#__foundation__#",
            ext.foundationVersion.keys.joinToString("\n") { "import 'package:$it/$it.dart';" }
        )
        .replace("#__class_name__#", className)
        .replace("#__tag__#", ext.projectName)
        .replaceParagraph("#__getters__#", getters.joinToString("\n"))
        .replaceParagraph("#__setters__#", setters.joinToString("\n"))
        .replaceParagraph("#__methods__#", methods.joinToString("\n"))
}