package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.JAVA_FILE
import me.yohom.fluttify.common.OBJC_FILE
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
    val enumConstants = mutableListOf<String>()
    val methods = mutableListOf<Method>()
    var simpleName = ""
    var typeType: TypeType? = null
    var superClass = ""
    var isPublic = false

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext) {
            packageName = ctx.qualifiedName().text
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            isPublic = ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true
            simpleName = ctx.IDENTIFIER()?.text ?: ""
            typeType = TypeType.Class

            val imports = ctx
                .ancestorOf(CompilationUnitContext::class)
                ?.importDeclaration()
                ?.map { it.qualifiedName().text } ?: listOf()
            superClass = imports.firstOrNull { it.substringAfterLast(".") == ctx.typeType()?.text } ?: ""
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext) {
            isPublic = ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true
            simpleName = ctx.IDENTIFIER().text
            typeType = TypeType.Interface
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext) {
            isPublic = ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true
            simpleName = ctx.IDENTIFIER().text
            typeType = TypeType.Enum
        }

        override fun enterMethodDeclaration(ctx: MethodDeclarationContext) {
            if (ctx.name().isObfuscated()) return

            methods.add(
                Method(
                    ctx.returnType(),
                    ctx.name(),
                    ctx.formalParams(),
                    ctx.isStatic(),
                    ctx.isAbstract(),
                    ctx.isPublic(),
                    "$packageName.${simpleName.replace("$", ".")}"
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
                    true,
                    isPublic = true,
                    className = "$packageName.${simpleName.replace("$", ".")}"
                )
            )
        }

        override fun enterFieldDeclaration(ctx: FieldDeclarationContext) {
            if (ctx.name().isObfuscated()) return
            fields.add(
                Field(
                    ctx.isPublic(),
                    ctx.isFinal(),
                    ctx.isStatic(),
                    Variable(ctx.type(), ctx.name(), ctx.type().isList()),
                    "$packageName.${simpleName.replace("$", ".")}"
                )
            )
        }

        override fun enterEnumConstant(ctx: EnumConstantContext) {
            enumConstants.add(ctx.IDENTIFIER().text)
        }
    })

    return Type().also {
        it.typeType = typeType
        it.isPublic = isPublic
        it.name = "$packageName.${simpleName.replace("$", ".")}"
        it.superClass = superClass
        it.fields.addAll(fields)
        it.methods.addAll(methods)
        it.constants.addAll(enumConstants)
    }
}

/**
 * Objc源码解析
 */
fun OBJC_FILE.objcType(): List<Type> {
    val source = readText()

    val result = mutableListOf<Type>()

    var fields = mutableListOf<Field>()
    val enumConstants = mutableListOf<String>()
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
            fields.add(
                Field(
                    true,
                    ctx.isFinal(),
                    false,
                    variable,
                    name
                )
            )
        }

        override fun enterClassMethodDeclaration(ctx: ObjectiveCParser.ClassMethodDeclarationContext) {
            methods.add(
                Method(
                    ctx.methodDeclaration().returnType(),
                    ctx.methodDeclaration().name(),
                    ctx.methodDeclaration().formalParams(),
                    true,
                    null,
                    true,
                    name
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
                    null,
                    true,
                    name
                )
            )
        }

        override fun enterEnumeratorIdentifier(ctx: ObjectiveCParser.EnumeratorIdentifierContext) {
            enumConstants.add(ctx.text)
        }

        override fun exitProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
            if (name.isNotEmpty()) {
                result.add(
                    Type().also {
                        it.typeType = typeType
                        it.isPublic = true
                        it.name = name
                        it.superClass = superClass
                        it.fields.addAll(fields)
                        it.methods.addAll(methods)
                        it.constants.addAll(enumConstants)
                    }
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
            }
        }

        override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            if (name.isNotEmpty()) {
                result.add(
                    Type().also {
                        it.typeType = typeType
                        it.isPublic = true
                        it.name = name
                        it.superClass = superClass
                        it.fields.addAll(fields)
                        it.methods.addAll(methods)
                        it.constants.addAll(enumConstants)
                    }
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
            }
        }

        override fun exitEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext) {
            if (name.isNotEmpty()) {
                result.add(Type().also {
                    it.typeType = typeType
                    it.isPublic = true
                    it.name = name
                    it.superClass = superClass
                    it.fields.addAll(fields)
                    it.methods.addAll(methods)
                    it.constants.addAll(enumConstants)
                })
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
            }
        }
    })

    return result
}

fun File.iterate(fileSuffix: String?, recursive: Boolean = true, forEach: (File) -> Unit) {
    FileUtils
        .iterateFiles(this, arrayOf(fileSuffix), recursive)
        .forEach { forEach(it) }
}