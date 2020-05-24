package me.yohom.fluttify.tmpl.dart.type.type_constants

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.dart.type.type_constants.constant.TypeConstantTmpl

//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import, unused_local_variable, dead_code, unnecessary_cast
////////////////////////////////////////////////////////////
//// GENERATED BY FLUTTIFY. DO NOT EDIT IT.
////////////////////////////////////////////////////////////
//
//#__constants__#
private val tmpl = getResource("/tmpl/dart/type_constants.dart.tmpl").readText()

fun TypeConstantsTmpl(topLevelConstants: List<Variable>): String {
    return tmpl
        .replaceParagraph("#__constants__#", topLevelConstants.joinToString("\n") { TypeConstantTmpl(it) })
}