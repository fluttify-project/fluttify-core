package me.yohom.fluttify.common.tmpl.dart.objectfactory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.filterConstructable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Lib

//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#.dart';
//
//class ObjectFactory {
//  static final _channel = MethodChannel('#__method_chanel__#');
//
//  #__create_objects__#
//}
/**
 * 对象工厂
 */
class ObjectFactoryTmpl(
    val libs: List<Lib>,
    val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/object_factory.dart.tmpl").readText()

    fun dartObjectFactory(): String {
        return tmpl
            .replace("#__current_package__#", "${ext.outputProjectName}/${ext.outputProjectName}")
            .replace("#__method_chanel__#", "${ext.outputOrg}/${ext.outputProjectName}")
            .replaceParagraph("#__create_objects__#", libs
                .flatMap { it.types }
                .filterConstructable()
                .joinToString("\n") { CreateObjectTmpl(it).dartCreateObject() })
    }
}