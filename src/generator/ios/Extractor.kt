package generator.ios

import parser.objc.ObjectiveCParser

internal class MethodExtractor(private val context: ObjectiveCParser.MethodDeclarationContext) {

    /**
     * 返回类型
     */
    val returnType: String
        get() = context.methodType().typeName().text

    /**
     * 方法名
     */
    val name: String
        get() = context
            .methodSelector()
            .selector()
            ?.text ?: context
            .methodSelector()
            .keywordDeclarator()[0]
            .selector()
            .text

    /**
     * 参数列表
     *
     * Map的键是类型名, 值是变量名
     */
    val params: List<Pair<String, String>>
        get() {
            val result = mutableListOf<Pair<String, String>>()

            context.methodSelector().keywordDeclarator()
                ?.forEach {
                    result.add(Pair(it.methodType()[0].typeName().text.toDartType(), it.identifier().text))
                }
            return result
        }


}