package common.extensions

import common.JAVA_FILE
import common.model.JavaTypeInfo
import common.model.Method
import common.model.Variable
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener

/**
 * Java源码解析
 */
fun JAVA_FILE.typeInfo(): JavaTypeInfo {
    val source = readText()

    var packageName = ""
    val fields = mutableListOf<Variable>()
    val methods = mutableListOf<Method>()
    var className = ""

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext?) {
            ctx?.run {
                packageName = ctx.qualifiedName().text
            }
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext?) {
            if (ctx != null && ctx.parentOf(TypeDeclarationContext::class).isPublic()) {
                className = ctx.IDENTIFIER().text
            }
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext?) {
            if (ctx != null && ctx.parentOf(TypeDeclarationContext::class).isPublic()) {
                className = ctx.IDENTIFIER().text
            }
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext?) {
            if (ctx != null && ctx.parentOf(TypeDeclarationContext::class).isPublic()) {
                className = ctx.IDENTIFIER().text
            }
        }

        override fun enterMethodDeclaration(ctx: MethodDeclarationContext?) {
            ctx?.run {
                methods.add(Method(ctx.returnType()!!, ctx.name()!!, ctx.formalParams()))
            }
        }

        override fun enterFieldDeclaration(ctx: FieldDeclarationContext?) {
            ctx?.run {
                fields.add(Variable(ctx.type()!!, ctx.name()!!))
            }
        }
    })

    return JavaTypeInfo("$packageName.$className", className, absolutePath, fields, methods)
}
