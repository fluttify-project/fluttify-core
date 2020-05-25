package me.yohom.fluttify.extensions

import me.yohom.fluttify.TYPE_NAME
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java类扩展

/**
 * 获取泛型类型
 */
fun JavaParser.ClassDeclarationContext.genericTypes(): List<TYPE_NAME> {
    return typeParameters()
        ?.typeParameter()
        ?.map { it.IDENTIFIER().text } ?: listOf()
}

/**
 * 是某个类的子类/实现了某个接口
 */
fun JavaParser.ClassDeclarationContext.isAbstract(): Boolean {
    return ancestorOf(JavaParser.TypeDeclarationContext::class)
        ?.classOrInterfaceModifier()
        ?.map { it.text }
        ?.contains("abstract") == true
}

/**
 * 是否public
 */
fun JavaParser.ClassDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.TypeDeclarationContext::class)
        ?.classOrInterfaceModifier()
        ?.map { it.text }
        ?.contains("public") == true
}

/**
 * 是否public
 */
fun JavaParser.EnumDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.TypeDeclarationContext::class)
        ?.classOrInterfaceModifier()
        ?.map { it.text }
        ?.contains("public") == true
}

/**
 * 获取泛型类型
 */
fun JavaParser.InterfaceDeclarationContext.genericTypes(): List<String> {
    return typeParameters()
        ?.typeParameter()
        ?.map { it.IDENTIFIER().text } ?: listOf()
}

/**
 * 获取父类名称
 */
fun JavaParser.InterfaceDeclarationContext.superInterfaces(): List<String> {
    return typeList()?.typeType()?.map { it.text?.run { typeFullName(this) } ?: "" } ?: listOf()
}

/**
 * 是否public
 */
fun JavaParser.InterfaceDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.TypeDeclarationContext::class)
        ?.classOrInterfaceModifier()
        ?.map { it.text }
        ?.contains("public") == true
}
//endregion