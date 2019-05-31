package common.extensions

import parser.java8.Java8Parser

/**
 * 是某个类的子类/实现了某个接口
 */
fun Java8Parser.NormalClassDeclarationContext?.isSubclass(): Boolean {
    if (this == null) return false
    return superclass() != null || superinterfaces() != null
}

/**
 * 是某个类的子类/实现了某个接口
 */
fun Java8Parser.NormalClassDeclarationContext?.isAbstract(): Boolean {
    if (this == null) return false
    return classModifier()?.map { it.text }?.contains("abstract") == true
}