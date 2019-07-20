package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.TYPE_NAME
import common.extensions.*
import me.yohom.fluttify.common.extensions.*
import parser.java.JavaParser
import parser.java.JavaParserBaseListener

/**
 * 回调类表达式模型
 */
data class Callback(val callerClass: String, val callerMethod: String, val className: String) {
    override fun toString(): String {
        val isInterface = className.javaType()?.typeType == TypeType.Interface

        val callbackMethodList = mutableListOf<CallbackMethod>()

        className
            .javaType()
            ?.path
            ?.file()
            ?.readText()
            ?.run {
                walkTree(object : JavaParserBaseListener() {
                    override fun enterInterfaceMethodDeclaration(ctx: JavaParser.InterfaceMethodDeclarationContext?) {
                        ctx?.run {
                            val method = CallbackMethod(
                                "$callerClass::$callerMethod",
                                returnType(),
                                name(),
                                formalParams()
                            )
                            callbackMethodList.add(method)
                        }
                    }
                })
            }

        return """object : $className${if (isInterface) "" else "()"} {
                val callbackChannel = MethodChannel(registrar.messenger(), "$callerClass::${callerMethod}_Callback" + refId)
${callbackMethodList.joinToString("\n")}
            }
        """
    }
}

data class CallbackMethod(
    val callerInfo: String,
    val returnType: TYPE_NAME,
    val methodName: String,
    val formalParams: List<Variable>
) {
    override fun toString(): String {
        val returnData = formalParams
            .toMutableList()
            .apply { add(Variable("int", "refId")) }
            .joinToString(",\n") { "\t\t\t\t\t\t\t\t\"${it.name}\" to ${if (it.type.jsonable()) it.name else "${it.name}.hashCode().apply { REF_MAP[this] = ${it.name} }"}" }
        return """              
                override fun $methodName(${formalParams.joinToString { "${it.name}: ${it.type.toKotlinType()}" }}): ${returnType.toKotlinType()} {
                    callbackChannel.invokeMethod(
                            "${callerInfo}_Callback::$methodName",
                            mapOf<String, Any?>(
$returnData
                            )
                    )
                    ${if (returnType.toKotlinType() == "Boolean") "\nreturn true" else ""}
                }
        """
    }
}