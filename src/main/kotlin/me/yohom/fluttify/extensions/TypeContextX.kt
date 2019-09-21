package me.yohom.fluttify.extensions

import parser.java.JavaParser

fun JavaParser.TypeDeclarationContext.isPublic(): Boolean {
    return classOrInterfaceModifier().map { it.text }.contains("public")
}