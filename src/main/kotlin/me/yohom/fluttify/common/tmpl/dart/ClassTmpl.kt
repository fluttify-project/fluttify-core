package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.IGNORE_METHOD
import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.isObfuscated
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Type

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/#__current_package__#.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//class #__class_name__# {
//    #__class_name__#.withRefId(this.refId);
//
//    final int refId;
//
//    static final _channel = MethodChannel('#__method_channel__#');
//
//    #__getters__#
//
//    #__setters__#
//
//    #__methods__#
//}
/**
 * 生成普通类的dart接口
 */
class ClassTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/class.dart.tmpl").readText()

    fun dartClass(): String {
        val currentPackage = ext.outputProjectName
        val className = type.name.toDartType()
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        val getters = type.fields
            .filter { it.isPublic == true }
            .filter { it.isStatic == false }
            .filter { it.variable?.typeName?.findType() != Type.UNKNOWN_TYPE }
            .map { GetterTmpl(it).dartGetter() }

        val setters = type.fields
            .asSequence()
            .filter { it.isFinal == false }
            .filter { it.isPublic == true }
            .filter { it.isStatic == false }
            .filter { it.variable?.typeName?.findType() != Type.UNKNOWN_TYPE }
            .map { SetterTmpl(it).dartSetter() }
            .toList()

        val methods = type.methods
            .asSequence()
            .distinctBy { it.name }
            .filter { it.name !in IGNORE_METHOD }
            .filter { it.isPublic == true }
            .filter { !it.returnType.isObfuscated() }
            .filter { it.returnType.findType() != Type.UNKNOWN_TYPE }
            .filter { it.formalParams.none { it.typeName.findType() == Type.UNKNOWN_TYPE } }
            .map { MethodTmpl(it).dartMethod() }
            // todo 去除和getters和setters重复的方法
            .toList()

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__class_name__#", className)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
            .replaceParagraph("#__methods__#", methods.joinToString("\n"))
    }
}