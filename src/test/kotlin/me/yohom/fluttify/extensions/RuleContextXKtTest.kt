package me.yohom.fluttify.extensions

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.model.*
import org.junit.jupiter.api.Test
import parser.java.JavaParser
import parser.java.JavaParserBaseListener


class RuleContextXKtTest {

    @Test
    fun ancestorOf() {
        val source ="""
            package com.tencent.imsdk.v2;

            public interface V2TIMSendCallback<T> extends V2TIMValueCallback<T> {
               void onProgress(int var1);
            }
        """.trimIndent()

        var packageName = ""
        var genericTypes = listOf<TYPE_NAME>()
        val fields = mutableListOf<Field>()
        val constructors = mutableListOf<Constructor>()
        val enumConstants = mutableListOf<String>()
        val methods = mutableListOf<Method>()
        var simpleName = ""
        var typeType: TypeType? = null
        var superClass = ""
        val interfaces = mutableListOf<String>()
        var isPublic = false
        var isAbstract = false
        var isInnerType = false
        var isStaticType = true

        source.walkTree(object : JavaParserBaseListener() {
            override fun enterPackageDeclaration(ctx: JavaParser.PackageDeclarationContext) {
                packageName = ctx.qualifiedName().text
            }

            override fun enterInterfaceDeclaration(ctx: JavaParser.InterfaceDeclarationContext) {
                isPublic = ctx.isPublic()
                simpleName = ctx.IDENTIFIER().text
                isInnerType = simpleName.contains("$")
                typeType = TypeType.Interface
                genericTypes = ctx.genericTypes()
                interfaces.addAll(ctx.superInterfaces())
                isAbstract = true
            }

            override fun enterEnumDeclaration(ctx: JavaParser.EnumDeclarationContext) {
                isPublic = ctx.isPublic() == true
                simpleName = ctx.IDENTIFIER().text
                isInnerType = simpleName.contains("$")
                isStaticType = true
                typeType = TypeType.Enum
                isAbstract = false
            }

            override fun enterConstructorDeclaration(ctx: JavaParser.ConstructorDeclarationContext) {
                if (ctx.IDENTIFIER().text.isObfuscated()) return

                isStaticType = ctx.isStaticType()

                constructors.add(
                    Constructor(
                        ctx.IDENTIFIER().text,
                        ctx.formalParams(),
                        ctx.isPublic(),
                        platform = Platform.Android
                    )
                )
            }

            override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext) {
                if (ctx.name().isObfuscated()) return

                methods.add(
                    Method(
                        ctx.returnType(),
                        ctx.name(),
                        ctx.formalParams(),
                        ctx.isStatic(),
                        ctx.isAbstract(),
                        ctx.isPublic(),
                        "$packageName.$simpleName",
                        Platform.Android,
                        ctx.isDeprecated(),
                        isGenericMethod = ctx.isGenericMethod()
                    )
                )
            }

            override fun enterInterfaceMethodDeclaration(ctx: JavaParser.InterfaceMethodDeclarationContext) {
                methods.add(
                    Method(
                        ctx.returnType(),
                        ctx.name(),
                        ctx.formalParams(),
                        ctx.isStatic(),
                        true,
                        true,
                        "$packageName.$simpleName",
                        Platform.Android,
                        ctx.isDeprecated(),
                        isGenericMethod = ctx.isGenericMethod()
                    )
                )
            }

            override fun enterFieldDeclaration(ctx: JavaParser.FieldDeclarationContext) {
                if (ctx.name().isObfuscated()) return
                fields.add(
                    Field(
                        ctx.isPublic(),
                        ctx.isFinal(),
                        ctx.isStatic(),
                        ctx.getValue(),
                        Variable(
                            ctx.type(),
                            ctx.name(),
                            Platform.Android
                        ),
                        "$packageName.$simpleName",
                        platform = Platform.Android,
                        isDeprecated = ctx.isDeprecated()
                    )
                )
            }

            override fun enterEnumConstant(ctx: JavaParser.EnumConstantContext) {
                enumConstants.add(ctx.IDENTIFIER().text)
            }
        })

        println("interfaces: $interfaces")
    }

    @Test
    fun typeFullName() {
        "com.aliyun.common.utils.Size"
    }

}