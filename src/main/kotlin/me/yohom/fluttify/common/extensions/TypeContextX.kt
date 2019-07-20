package me.yohom.fluttify.common.extensions

import parser.java.JavaParser

fun JavaParser.TypeDeclarationContext.isPublic(): Boolean {
    return classOrInterfaceModifier().map { it.text }.contains("public")
}