package common

import parser.java8.Java8Parser
import parser.objc.ObjectiveCParser

class MethodExtractor private constructor(
    private val javaCtx: Java8Parser.MethodDeclarationContext?,
    private val objcCtx: ObjectiveCParser.MethodDeclarationContext?
) {

    constructor(javaCtx: Java8Parser.MethodDeclarationContext) : this(javaCtx, null)
    constructor(objcCtx: ObjectiveCParser.MethodDeclarationContext) : this(null, objcCtx)

    /**
     * 限定词
     */
    val modifiers: List<String>
        get() = javaCtx?.methodModifier()?.map { it.text } ?: listOf()

    /**
     * 返回类型
     */
    val returnType: String
        get() = when {
            javaCtx != null -> javaCtx.methodHeader().result().text.toDartType()
            objcCtx != null -> objcCtx.methodType().typeName().text
            else -> throw IllegalStateException("javaCtx和objcCtx不能同时为null")
        }

    /**
     * 方法名
     */
    val name: String
        get() = when {
            javaCtx != null -> javaCtx.methodHeader().methodDeclarator().Identifier().toString()
            objcCtx != null -> objcCtx
                .methodSelector()
                .selector()
                ?.text ?: objcCtx
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
                javaCtx != null -> {
                    val result = mutableListOf<Pair<String, String>>()

                    val parameters = javaCtx.methodHeader()
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
                objcCtx != null -> {
                    val result = mutableListOf<Pair<String, String>>()

                    objcCtx.methodSelector().keywordDeclarator()
                        ?.forEach {
                            result.add(Pair(it.methodType()[0].typeName().text.toDartType(), it.identifier().text))
                        }
                    return result
                }
                else -> throw IllegalStateException("javaCtx和objcCtx不能同时为null")
            }

        }
}