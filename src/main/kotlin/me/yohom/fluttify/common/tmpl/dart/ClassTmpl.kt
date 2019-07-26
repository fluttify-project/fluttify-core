package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.findType
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
            .map { GetterTmpl(it).dartGetter() }

        val setters = type.fields
            .filter { it.isFinal == false }
            .filter { it.isPublic == true }
            .filter { it.isStatic == false }
            .map { SetterTmpl(it).dartSetter() }

        val methods = type.methods
            .filter { it.isPublic == true }
            .filter { it.formalParams.none { it.typeName.findType() == Type.UNKNOWN_TYPE } }
            .map { MethodTmpl(it).dartMethod() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__class_name__#", className)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
            .replaceParagraph("#__methods__#", methods.joinToString("\n"))
    }
}