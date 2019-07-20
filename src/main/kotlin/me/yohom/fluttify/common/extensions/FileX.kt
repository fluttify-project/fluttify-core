package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.JAVA_FILE
import me.yohom.fluttify.common.OBJC_FILE
import common.model.*
import me.yohom.fluttify.common.model.*
import org.apache.commons.io.FileUtils
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener
import java.io.File

/**
 * Java源码解析
 */
fun JAVA_FILE.javaType(): Type {
    val source = readText()

    var packageName = ""
    val fields = mutableListOf<Field>()
    val methods = mutableListOf<Method>()
    var simpleName = ""
    var typeType: TypeType? = null
    var superClass = ""

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext) {
            packageName = ctx.qualifiedName().text
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            if (ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true) {
                simpleName = ctx.IDENTIFIER().text
                typeType = TypeType.Class

                val imports = ctx
                    .ancestorOf(CompilationUnitContext::class)
                    ?.importDeclaration()
                    ?.map { it.qualifiedName().text } ?: listOf()
                superClass = imports.firstOrNull { it.substringAfterLast(".") == ctx.typeType()?.text } ?: ""
            }
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext) {
            if (ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true) {
                simpleName = ctx.IDENTIFIER().text
                typeType = TypeType.Interface
            }
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext) {
            if (ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true) {
                simpleName = ctx.IDENTIFIER().text
                typeType = TypeType.Enum
            }
        }

        override fun enterMethodDeclaration(ctx: MethodDeclarationContext) {
            methods.add(
                Method(
                    ctx.returnType(),
                    ctx.name(),
                    ctx.formalParams(),
                    ctx.isStatic(),
                    ctx.isAbstract()
                )
            )
        }

        override fun enterInterfaceMethodDeclaration(ctx: InterfaceMethodDeclarationContext) {
            methods.add(
                Method(
                    ctx.returnType(),
                    ctx.name(),
                    ctx.formalParams(),
                    ctx.isStatic(),
                    true
                )
            )
        }

        override fun enterFieldDeclaration(ctx: FieldDeclarationContext) {
            fields.add(
                Field(
                    ctx.isPublic(),
                    ctx.isFinal(),
                    ctx.isStatic(),
                    Variable(ctx.type(), ctx.name())
                )
            )
        }

        override fun enterEnumConstant(ctx: EnumConstantContext) {
            fields.add(
                Field(
                    true,
                    true,
                    false,
                    Variable(ctx.IDENTIFIER().text, ctx.IDENTIFIER().text)
                )
            )
        }
    })

    return Type(
        "$packageName.${simpleName.replace("$", ".")}",
        absolutePath,
        superClass,
        fields,
        methods,
        typeType
    )
}

/**
 * Objc源码解析
 */
fun OBJC_FILE.objcType(): List<Type> {
    val source = readText()

    val result = mutableListOf<Type>()

    var fields = mutableListOf<Field>()
    var methods = mutableListOf<Method>()
    var name = ""
    var typeType: TypeType? = null
    var superClass = ""

    source.walkTree(object : ObjectiveCParserBaseListener() {
        override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            typeType = TypeType.Class
            name = ctx.className.text
            superClass = ctx.superclassName.text
        }

        override fun enterProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
            typeType = TypeType.Interface
            name = ctx.protocolName().text
            superClass = ""
        }

        override fun enterEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext) {
            typeType = TypeType.Enum
            name = ctx.identifier()?.text
                ?: ctx.enumSpecifier().identifier().firstOrNull { it != null }?.text
                        ?: ""
        }

        override fun enterFieldDeclaration(ctx: ObjectiveCParser.FieldDeclarationContext) {
            val variable = Variable(ctx.type(), ctx.name())

            // property肯定是public的, 且肯定是非static的, 因为如果需要static的话, 用方法就行了
            fields.add(Field(true, ctx.isFinal(), false, variable))
        }

        override fun enterClassMethodDeclaration(ctx: ObjectiveCParser.ClassMethodDeclarationContext) {
            methods.add(
                Method(
                    ctx.methodDeclaration().returnType(),
                    ctx.methodDeclaration().name(),
                    ctx.methodDeclaration().formalParams(),
                    true,
                    null
                )
            )
        }

        override fun enterInstanceMethodDeclaration(ctx: ObjectiveCParser.InstanceMethodDeclarationContext) {
            methods.add(
                Method(
                    ctx.methodDeclaration().returnType(),
                    ctx.methodDeclaration().name(),
                    ctx.methodDeclaration().formalParams(),
                    false,
                    null
                )
            )
        }

        override fun enterEnumeratorIdentifier(ctx: ObjectiveCParser.EnumeratorIdentifierContext) {
            fields.add(
                Field(
                    true,
                    true,
                    false,
                    Variable(ctx.text, ctx.text)
                )
            )
        }

        override fun exitProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
            if (name.isNotEmpty()) {
                result.add(
                    Type(
                        name,
                        absolutePath,
                        superClass,
                        fields,
                        methods,
                        typeType
                    )
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
            }
        }

        override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            if (name.isNotEmpty()) {
                result.add(
                    Type(
                        name,
                        absolutePath,
                        superClass,
                        fields,
                        methods,
                        typeType
                    )
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
            }
        }

        override fun exitEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext?) {
            if (name.isNotEmpty()) {
                result.add(
                    Type(
                        name,
                        absolutePath,
                        superClass,
                        fields,
                        methods,
                        typeType
                    )
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
            }
        }
    })

    return result
}

fun File.iterate(fileSuffix: String, recursive: Boolean = true, forEach: (File) -> Unit) {
    FileUtils
        .iterateFiles(this, arrayOf(fileSuffix), recursive)
        .forEach { forEach(it) }
}