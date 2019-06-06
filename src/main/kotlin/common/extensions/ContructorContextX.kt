package common.extensions

import parser.java.JavaParser

fun JavaParser.ConstructorDeclarationContext?.hasParameter(): Boolean {
    if (this == null) return false
    return formalParameters().formalParameterList().childCount != 0
}