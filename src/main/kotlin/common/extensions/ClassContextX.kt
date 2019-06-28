package common.extensions

import common.gWalker
import common.model.Lambda
import common.model.Variable
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
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
fun JavaParser.ClassDeclarationContext?.superClass(): String? {
    if (this == null) return null
    return typeType()?.text
}

/**
 * 是某个类的子类/实现了某个接口
 */
fun JavaParser.ClassDeclarationContext?.isAbstract(): Boolean {
    if (this == null) return false
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
 * 全名
 */
fun JavaParser.ClassDeclarationContext.fullClassName(): String {
    val packageName = ancestorOf(JavaParser.CompilationUnitContext::class)
        ?.packageDeclaration()
        ?.qualifiedName()
        ?.text ?: ""
    return "$packageName.${IDENTIFIER().text}"
}

/**
 * 是否public
 */
fun JavaParser.InterfaceDeclarationContext.interface2lambdas(): List<Lambda> {
    val result = mutableListOf<Lambda>()

    gWalker.walk(object : JavaParserBaseListener() {
        val existMethod = mutableListOf<String>()

        override fun enterInterfaceMethodDeclaration(ctx: JavaParser.InterfaceMethodDeclarationContext?) {
            ctx?.run {
                val allParams = mutableListOf<Variable>()

                val parametersContext = formalParameters().formalParameterList()

                // 除最后一个参数之外的参数
                parametersContext
                    ?.formalParameter()
                    ?.forEach {
                        allParams.add(Variable(it.typeType().text, it.variableDeclaratorId().text))
                    }

                // 最后一个参数
                parametersContext
                    ?.lastFormalParameter()
                    ?.run {
                        allParams.add(Variable(typeType().text, variableDeclaratorId().text))
                    }

                val returnType = typeTypeOrVoid().text.toDartType()
                // 处理java中重载的情况
                val methodName = if (IDENTIFIER().text in existMethod)
                    "${IDENTIFIER().text}_${allParams.joinToString("_") { it.type }}"
                else
                    IDENTIFIER().text

                if (allParams.all { !it.isUnknownType() }) {
                    result.add(Lambda(returnType, methodName, allParams))
                    existMethod.add(IDENTIFIER().text)
                }
            }
        }
    }, this)

    return result
}
//endregion

//region Java类扩展
/**
 * 是某个类的子类(实现了某个接口的认为还是model, 比如说实现了Parcel)
 */
fun ObjectiveCParser.ClassInterfaceContext?.isSubclass(): Boolean {
    if (this == null) return false
    return COLON() != null && superclassName?.IDENTIFIER()?.text != "NSObject"
}
//endregion