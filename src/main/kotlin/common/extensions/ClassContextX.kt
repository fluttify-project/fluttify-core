package common.extensions

import parser.java.JavaParser

/**
 * 是某个类的子类(实现了某个接口的认为还是model, 比如说实现了Parcel)
 */
fun JavaParser.ClassDeclarationContext?.isSubclass(): Boolean {
    if (this == null) return false
    return parentOf(JavaParser.TypeDeclarationContext::class).classDeclaration().EXTENDS() != null
}

/**
 * 是某个类的子类/实现了某个接口
 */
fun JavaParser.ClassDeclarationContext?.isAbstract(): Boolean {
    if (this == null) return false
    return parentOf(JavaParser.TypeDeclarationContext::class).classOrInterfaceModifier().map { it.text }.contains("abstract")
}

/**
 * 是否public
 */
fun JavaParser.ClassDeclarationContext?.isPublic(): Boolean {
    if (this == null) return false
    return parentOf(JavaParser.TypeDeclarationContext::class).classOrInterfaceModifier().map { it.text }.contains("public")
}