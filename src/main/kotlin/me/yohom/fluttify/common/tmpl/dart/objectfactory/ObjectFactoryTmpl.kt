package me.yohom.fluttify.common.tmpl.dart.objectfactory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.filterConstructable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Platform

//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#.dart';
//
//class ObjectFactory_#__platform__# {
//  static final _channel = MethodChannel('#__method_chanel__#');
//
//  #__create_objects__#
//}
/**
 * 对象工厂
 */
class ObjectFactoryTmpl(
    val libs: List<Lib>,
    val ext: FluttifyExtension,
    val platform: Platform
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/object_factory.dart.tmpl").readText()

    fun dartObjectFactory(): String {
        return tmpl
            .replace("#__current_package__#", "${ext.outputProjectName}/${ext.outputProjectName}")
            .replace("#__platform__#", platform.toString())
            .replace("#__method_chanel__#", "${ext.outputOrg}/${ext.outputProjectName}")
            .replaceParagraph("#__create_objects__#", libs
                .flatMap { it.types }
                .filterConstructable()
                .joinToString("\n") { CreateObjectTmpl(it).dartCreateObject().joinToString("\n") })
    }
}