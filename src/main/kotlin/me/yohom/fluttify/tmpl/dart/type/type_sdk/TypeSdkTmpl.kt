package me.yohom.fluttify.tmpl.dart.type.type_sdk

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.common.getter.GetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter.SetterTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.creator.CreatorTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//import 'package:#__current_package__#/src/android/android.export.g.dart';
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//class #__class_name__# extends #__super_class__# #__mixins__# {
//  #__constants__#
//
//  #__creators__#
//
//  // generate getters
//  #__getters__#
//
//  // generate setters
//  #__setters__#
//
//  // generate methods
//  #__methods__#
//}
class TypeSdkTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/sdk_type.dart.tmpl").readText()

    fun dartClass(): String {
        val currentPackage = ext.projectName
        val className = type.name.toDartType()
        val superClass = if (type.superType.isEmpty())
            type.platform.objectType()
        else
            type.superType.toDartType()

        val mixins = if (type.interfaces.isNotEmpty() && type.interfaces.none { it.findType() == Type.UNKNOWN_TYPE }) {
            // todo 使用递归处理完全, 现在只是写死了只处理了两层
            val interfaces = type.interfaces
                .union(type.interfaces.flatMap { it.findType().interfaces })
                .filter { it.findType().isInterface() }
                .filterNot { it.isObfuscated() }
                .reversed()
                .joinToString { it.toDartType() }
            if (interfaces.isEmpty()) "" else "with $interfaces"
        } else {
            ""
        }

        val constants = type.fields.filterConstants()

        val creators = if (type.constructable()) {
            CreatorTmpl(type).dartCreator()
        } else {
            listOf()
        }
        val getters = type.fields
            .filterGetters()
            .map { GetterTmpl(it).dartGetter() }

        val setters = type.fields
            .filterSetters()
            .map { SetterTmpl(it).dartSetter() }

        val methods = type.methods
            .filterMethod()
            .map { MethodTmpl(it).dartMethod() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__class_name__#", className)
            .replace("#__super_class__#", superClass)
            .replace("#__mixins__#", mixins)
            .replaceParagraph("#__constants__#", constants.joinToString("\n") { "static final ${it.variable.typeName.toDartType()} ${it.variable.name} = ${it.value.removeNumberSuffix()};" })
            .replaceParagraph("#__creators__#", creators.joinToString("\n"))
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
            .replaceParagraph("#__methods__#", methods.joinToString("\n"))
    }
}