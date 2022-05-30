package me.yohom.fluttify.tmpl.dart.type.type_constants

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceGlobal
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.dart.type.type_constants.constant.TypeConstantTmpl

//import 'package:flutter/services.dart';
//import '../facade/shared.g.dart';
//
//#__constants__#
private val tmpl by lazy { getResource("/tmpl/dart/type_constants.dart.tmpl").readText() }

fun TypeConstantsTmpl(topLevelConstants: List<Variable>): String {
    return tmpl
        .replaceParagraph("#__constants__#", topLevelConstants.joinToString("\n") { TypeConstantTmpl(it) })
        .replaceGlobal()
}