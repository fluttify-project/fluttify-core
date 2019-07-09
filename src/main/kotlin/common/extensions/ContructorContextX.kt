package common.extensions

import parser.java.JavaParser

/**
 * 是否是公有构造器
 */
fun JavaParser.ConstructorDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") ?: false
}

/**
 * 是否是无参构造器
 */
fun JavaParser.ConstructorDeclarationContext.hasDependency(): Boolean {
    return formalParameters().formalParameterList() != null
}