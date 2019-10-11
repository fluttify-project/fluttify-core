package me.yohom.fluttify.extensions

import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java类扩展
/**
 * 是某个类的子类(实现了某个接口的认为还是model, 比如说实现了Parcel)
 */
fun JavaParser.ClassDeclarationContext?.isSubclass(): Boolean {
    if (this == null) return false
    return EXTENDS() != null
}

/**
 * 获取父类名称
 */
fun JavaParser.ClassDeclarationContext.superClass(): String? {
    return typeType()?.text
}

/**
 * 获取泛型类型
 */
fun JavaParser.ClassDeclarationContext.genericTypes(): List<String> {
    return typeParameters()
        ?.typeParameter()
        ?.map { typeFullName(it.IDENTIFIER().text) } ?: listOf()
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
 * 全名
 */
fun JavaParser.ClassDeclarationContext.fullName(): String {
    val packageName = ancestorOf(JavaParser.CompilationUnitContext::class)
        ?.packageDeclaration()
        ?.qualifiedName()
        ?.text ?: ""
    return "$packageName.${IDENTIFIER().text.replace("$", ".")}"
}

/**
 * 全名
 */
fun JavaParser.EnumDeclarationContext.fullName(): String {
    val packageName = ancestorOf(JavaParser.CompilationUnitContext::class)
        ?.packageDeclaration()
        ?.qualifiedName()
        ?.text ?: ""
    return "$packageName.${IDENTIFIER().text.replace("$", ".")}"
}

/**
 * 获取泛型类型
 */
fun JavaParser.InterfaceDeclarationContext.genericTypes(): List<String> {
    return typeParameters()
        ?.typeParameter()
        ?.map { typeFullName(it.IDENTIFIER().text) } ?: listOf()
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

//region Objc类扩展
/**
 * 是某个类的子类(实现了某个接口的认为还是model, 比如说实现了Parcel)
 */
fun ObjectiveCParser.ClassInterfaceContext.isSubclass(): Boolean {
    return COLON() != null && superclassName?.IDENTIFIER()?.text != "NSObject"
}

/**
 * objc类的全名
 */
fun ObjectiveCParser.ClassInterfaceContext.fullName(): String {
    return className.text
}
//endregion