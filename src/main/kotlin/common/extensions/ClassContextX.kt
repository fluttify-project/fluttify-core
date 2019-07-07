package common.extensions

import common.gWalker
import common.model.Lambda
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
fun JavaParser.ClassDeclarationContext.superClass(): String? {
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
 * interface转lambda
 */
fun JavaParser.InterfaceDeclarationContext.interface2lambdas(): List<Lambda> {
    val result = mutableListOf<Lambda>()

    gWalker.walk(object : JavaParserBaseListener() {
        val existMethod = mutableListOf<String>()

        override fun enterInterfaceMethodDeclaration(ctx: JavaParser.InterfaceMethodDeclarationContext?) {
            ctx?.run {
                val returnType = typeTypeOrVoid().text.toDartType()
                // 处理java中重载的情况
                val methodName = if (IDENTIFIER().text in existMethod)
                    "${IDENTIFIER().text}_${formalParams().joinToString("_") { it.type.toDartType() }}"
                else
                    IDENTIFIER().text

                if (formalParams().all { !it.type.isUnknownType() }) {
                    result.add(Lambda(returnType, methodName, formalParams()))
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