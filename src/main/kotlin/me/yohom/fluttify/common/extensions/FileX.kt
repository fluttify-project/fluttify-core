package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.JAVA_FILE
import me.yohom.fluttify.common.OBJC_FILE
import me.yohom.fluttify.common.TYPE_NAME
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
    var genericTypes = listOf<TYPE_NAME>()
    val fields = mutableListOf<Field>()
    val constructors = mutableListOf<Constructor>()
    val enumConstants = mutableListOf<String>()
    val methods = mutableListOf<Method>()
    var simpleName = ""
    var typeType: TypeType? = null
    var superClass = ""
    var isPublic = false
    var isInnerClass = false

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext) {
            packageName = ctx.qualifiedName().text
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            isPublic = ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true
            simpleName = ctx.IDENTIFIER()?.text ?: ""
            isInnerClass = simpleName.contains("$")
            typeType = TypeType.Class
            genericTypes = ctx.genericTypes()

            val imports = ctx
                .ancestorOf(CompilationUnitContext::class)
                ?.importDeclaration()
                ?.map { it.qualifiedName().text } ?: listOf()
            superClass = imports.firstOrNull { it.substringAfterLast(".") == ctx.typeType()?.text } ?: ""
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext) {
            isPublic = ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true
            simpleName = ctx.IDENTIFIER().text
            isInnerClass = simpleName.contains("$")
            typeType = TypeType.Interface
            genericTypes = ctx.genericTypes()
            superClass = ctx.superClass() ?: ""
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext) {
            isPublic = ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true
            simpleName = ctx.IDENTIFIER().text
            isInnerClass = simpleName.contains("$")
            typeType = TypeType.Enum
        }

        override fun enterConstructorDeclaration(ctx: ConstructorDeclarationContext) {
            if (ctx.IDENTIFIER().text.isObfuscated()) return

            constructors.add(
                Constructor(
                    ctx.IDENTIFIER().text,
                    ctx.formalParams(),
                    ctx.isPublic(),
                    platform = Platform.Android
                )
            )
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
                    "$packageName.${simpleName.replace("$", ".")}",
                    platform = Platform.Android
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
                    className = "$packageName.${simpleName.replace("$", ".")}",
                    platform = Platform.Android
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
                    Variable(ctx.type(), ctx.name(), ctx.type().isList(), Platform.Android),
                    "$packageName.${simpleName.replace("$", ".")}",
                    platform = Platform.Android
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
        it.isInnerClass = isInnerClass
        it.genericTypes.addAll(genericTypes)
        it.constructors = constructors
        it.name = "$packageName.${simpleName.replace("$", ".")}"
        it.superClass = superClass
        it.fields.addAll(fields)
        it.methods.addAll(methods)
        it.constants.addAll(enumConstants)
        it.platform = Platform.Android
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
    var genericTypes = listOf<TYPE_NAME>()
    val constructors = mutableListOf<Constructor>()

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
            // 只接收property
            ctx.ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class) ?: return

            // todo 判断是否是list
            val variable = Variable(ctx.type(), ctx.name(), platform = Platform.iOS)
            // property肯定是public的, 且肯定是非static的, 因为如果需要static的话, 用方法就行了
            fields.add(
                Field(
                    true,
                    ctx.isFinal(),
                    false,
                    variable,
                    name,
                    ctx.getterName(),
                    ctx.setterName(),
                    Platform.iOS
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
                    name,
                    Platform.iOS
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
                    name,
                    Platform.iOS
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
                        it.platform = Platform.iOS
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
                        it.platform = Platform.iOS
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
                    it.platform = Platform.iOS
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