package generator.android

import parser.java8.Java8Parser

internal class MethodExtractor(private val context: Java8Parser.MethodDeclarationContext) {

    /**
     * 限定词
     */
    val modifiers: List<String>
        get() = context.methodModifier().map { it.text }

    /**
     * 返回类型
     */
    val returnType: String
        get() = context.methodHeader().result().text.toDartType()

    /**
     * 方法名
     */
    val name: String
        get() = context.methodHeader().methodDeclarator().Identifier().toString()

    /**
     * 参数列表
     *
     * Map的键是类型名, 值是变量名
     */
    val params: List<Pair<String, String>>
        get() {
            val result = mutableListOf<Pair<String, String>>()

            val parameters = context.methodHeader()
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


}