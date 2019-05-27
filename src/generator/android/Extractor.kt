package generator.android

import parser.java8.Java8Parser

class MethodExtractor(private val context: Java8Parser.MethodDeclarationContext) {

    /**
     * 限定词
     */
    val modifiers: List<String>
        get() = context.methodModifier().map { it.text }

    /**
     * 返回类型
     */
    val returnType: String
        get() = context.methodHeader().result().text

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

            parameters
                ?.formalParameters()
                ?.formalParameter()
                ?.forEach { result.add(Pair(it.unannType().text, it.variableDeclaratorId().text)) }

            val lastParamType = parameters?.lastFormalParameter()?.formalParameter()?.unannType()?.text
            val lastParamVar = parameters?.lastFormalParameter()?.formalParameter()?.variableDeclaratorId()?.text
            if (lastParamType != null && lastParamVar != null) {
                result.add(Pair(lastParamType, lastParamVar))
            }
            return result
        }

}