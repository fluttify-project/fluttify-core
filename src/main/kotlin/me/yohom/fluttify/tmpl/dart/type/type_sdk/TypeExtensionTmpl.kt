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

//extension #__extension_name__# on #__class_name__# {
//  //region constants
//  static const String name__ = '#__origin_class_name__#';
//
//  #__constants__#
//  //endregion
//
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
//
//  @override
//  String toString() {
//    return '#__class_name__#{refId: $refId, runtimeType: $runtimeType, tag__: $tag__}';
//  }
//}
private val tmpl by lazy { getResource("/tmpl/dart/type_extension.dart.tmpl").readText() }

fun TypeExtensionTmpl(type: Type): String {
    val currentPackage = ext.projectName
    val className = if (type.declaredGenericTypes.isNotEmpty()) {
        "${type.name.toDartType()}<${type.declaredGenericTypes.joinToString()}>"
    } else {
        type.name.toDartType()
    }
    val originClassName = type.name.replace("$", ".")
    // 如果父类是混淆类或非公开类, 那么直接继承Object类
    val superClass = if (type.superClass.run {
            isEmpty()
                    ||
                    isObfuscated()
                    ||
                    EXCLUDE_TYPES.any { it.matches(this) }
                    ||
                    findType().isUnknownType
                    ||
                    !findType().isPublic }) {
        type.platform.objectType()
    } else {
        type.superClass.toDartType()
    }

    // 如果含有非混淆类的接口, 再以mixin的方式集成
    val mixins = if (type.ancestorInterfaces(false).isNotEmpty()) {
        "with ${type.ancestorInterfaces(false).reversed().joinToString { it.toDartType() }}"
    } else {
        ""
    }

    // 常量
    val constants = type.fields
        .filterConstants()
        .joinToString("\n") {
            "static final ${it.variable.trueType.toDartType()} ${it.variable.name} = ${it.value.removeNumberSuffix().escape()};"
        }

    // 构造器
    val creators = if (type.constructable) {
        CreatorTmpl(type).union(CreatorBatchTmpl(type)).toList()
    } else {
        listOf()
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
        .replace("#__extension_name__#", type.name)
        .replace("#__class_name__#", type.superClass)
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
        .replace("#__abstract__#", if (type.isAbstract) "/* abstract */ " else "")
        .replace("#__class_name__#", className)
        .replace("#__origin_class_name__#", originClassName)
        .replace("#__super_class__#", superClass)
        .replace("#__mixins__#", mixins)
        .replace("#__tag__#", ext.projectName)
        .replaceParagraph("#__constants__#", constants)
        .replaceParagraph("#__creators__#", creators.joinToString("\n"))
        .replaceParagraph("#__getters__#", getters.joinToString("\n"))
        .replaceParagraph("#__setters__#", setters.joinToString("\n"))
        .replaceParagraph("#__methods__#", methods.joinToString("\n"))
}