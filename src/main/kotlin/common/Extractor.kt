package common

import parser.java8.Java8Parser
import parser.objc.ObjectiveCParser

class MethodExtractor private constructor(
    private val javaMethodDeclarationCtx: Java8Parser.MethodDeclarationContext?,
    private val objcMethodDeclarationCtx: ObjectiveCParser.MethodDeclarationContext?,
    private val objcClassMethodDeclarationCtx: ObjectiveCParser.ClassMethodDeclarationContext?
) {

    constructor(ctx: Java8Parser.MethodDeclarationContext) : this(ctx, null, null)
    constructor(ctx: ObjectiveCParser.MethodDeclarationContext) : this(null, ctx, null)
    constructor(ctx: ObjectiveCParser.ClassMethodDeclarationContext) : this(null, null, ctx)

    /**
     * 限定词
     */
    val modifiers: List<String>
        get() = javaMethodDeclarationCtx?.methodModifier()?.map { it.text } ?: listOf()

    /**
     * 返回类型
     */
    val returnType: String
        get() = when {
            javaMethodDeclarationCtx != null -> javaMethodDeclarationCtx.methodHeader().result().text.toDartType()
            objcMethodDeclarationCtx != null -> objcMethodDeclarationCtx.methodType().typeName().text
            objcClassMethodDeclarationCtx != null -> objcClassMethodDeclarationCtx.methodDeclaration().methodType().typeName().text
            else -> throw IllegalStateException("javaCtx和objcCtx不能同时为null")
        }

    /**
     * 方法名
     */
    val name: String
        get() = when {
            javaMethodDeclarationCtx != null -> javaMethodDeclarationCtx.methodHeader().methodDeclarator().Identifier().toString()
            objcMethodDeclarationCtx != null -> objcMethodDeclarationCtx
                .methodSelector()
                .selector()
                ?.text ?: objcMethodDeclarationCtx
                .methodSelector()
                .keywordDeclarator()[0]
                .selector()
                .text
            objcClassMethodDeclarationCtx != null -> objcClassMethodDeclarationCtx
                .methodDeclaration()
                .methodSelector()
                .selector()
                ?.text ?: objcClassMethodDeclarationCtx.methodDeclaration()
                .methodSelector()
                .keywordDeclarator()[0]
                .selector()
                .text
            else -> throw IllegalStateException("javaCtx和objcCtx不能同时为null")
        }

    /**
     * 形式参数列表
     *
     * Map的键是类型名, 值是变量名
     */
    val formalParams: List<Pair<String, String>>
        get() {
            when {
                javaMethodDeclarationCtx != null -> {
                    val result = mutableListOf<Pair<String, String>>()

                    val parameters = javaMethodDeclarationCtx.methodHeader()
                        .methodDeclarator()
                        ?.formalParameterList()

                    // 除最后一个参数之外的参数
                    parameters
                        ?.formalParameters()
                        ?.formalParameter()
                        ?.forEach {
                            result.add(Pair(it.unannType().text.toDartType(), it.variableDeclaratorId().text))
                        }

                    // 最后一个参数
                    parameters
                        ?.lastFormalParameter()
                        ?.formalParameter()
                        ?.run {
                            result.add(Pair(unannType().text.toDartType(), variableDeclaratorId().text))
                        }

                    return result
                }
                objcMethodDeclarationCtx != null -> {
                    val result = mutableListOf<Pair<String, String>>()

                    objcMethodDeclarationCtx.methodSelector().keywordDeclarator()
                        ?.forEach {
                            result.add(Pair(it.methodType()[0].typeName().text.toDartType(), it.identifier().text))
                        }
                    return result
                }
                objcClassMethodDeclarationCtx != null -> {
                    val result = mutableListOf<Pair<String, String>>()

                    objcClassMethodDeclarationCtx
                        .methodDeclaration()
                        .methodSelector()
                        .keywordDeclarator()
                        ?.forEach {
                            result.add(Pair(it.methodType()[0].typeName().text.toDartType(), it.identifier().text))
                        }
                    return result
                }
                else -> throw IllegalStateException("javaCtx和objcCtx不能同时为null")
            }

        }
}