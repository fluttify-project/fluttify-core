package common.extensions

import common.JAVA_FILE
import common.OBJC_FILE
import common.model.JavaTypeInfo
import common.model.Method
import common.model.ObjcTypeInfo
import common.model.Variable
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

/**
 * Java源码解析
 */
fun JAVA_FILE.javaTypeInfo(): JavaTypeInfo {
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
            if (ctx != null && ctx.ancestorOf(TypeDeclarationContext::class).isPublic()) {
                className = ctx.IDENTIFIER().text
            }
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext?) {
            if (ctx != null && ctx.ancestorOf(TypeDeclarationContext::class).isPublic()) {
                className = ctx.IDENTIFIER().text
            }
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext?) {
            if (ctx != null && ctx.ancestorOf(TypeDeclarationContext::class).isPublic()) {
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

/**
 * Objc源码解析
 */
fun OBJC_FILE.objcTypeInfo(): ObjcTypeInfo {
    val source = readText()

    val fields = mutableListOf<Variable>()
    val methods = mutableListOf<Method>()
    var className = ""

    source.walkTree(object : ObjectiveCParserBaseListener() {
        override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
            ctx?.run {
                className = ctx.className.text
            }
        }

        override fun enterProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext?) {
            ctx?.run {
                className = ctx.protocolName().text
            }
        }

        override fun enterEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext?) {
            ctx?.run {
                className = ctx.identifier().text
            }
        }

        override fun enterClassMethodDeclaration(ctx: ObjectiveCParser.ClassMethodDeclarationContext?) {
            ctx?.run {
                val methodDeclaration = ctx.methodDeclaration()
                methods.add(
                    Method(
                        methodDeclaration.returnType()!!,
                        methodDeclaration.name()!!,
                        methodDeclaration.formalParams()
                    )
                )
            }
        }

        override fun enterInstanceMethodDeclaration(ctx: ObjectiveCParser.InstanceMethodDeclarationContext?) {
            ctx?.run {
                val methodDeclaration = ctx.methodDeclaration()
                methods.add(
                    Method(
                        methodDeclaration.returnType()!!,
                        methodDeclaration.name()!!,
                        methodDeclaration.formalParams()
                    )
                )
            }
        }

        override fun enterFieldDeclaration(ctx: ObjectiveCParser.FieldDeclarationContext?) {
            ctx?.run {
                fields.add(Variable(ctx.type()!!, ctx.name()!!))
            }
        }
    })

    return ObjcTypeInfo(className, absolutePath, fields, methods)
}
