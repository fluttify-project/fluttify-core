package common.extensions

import parser.java8.Java8Parser

fun Java8Parser.ConstructorDeclaratorContext?.hasParameter(): Boolean {
    if (this == null) return false

    return formalParameterList()
        ?.formalParameters()
        ?.formalParameter()
        ?.isNotEmpty() ?: false
}