package common.translator

import common.DART_SOURCE
import common.gWalker
import org.jetbrains.annotations.TestOnly
import parser.java.JavaParser
import parser.java.JavaParserBaseListener

object Java2Dart {
    /**
     * 翻译一个Java语句块(block)到Dart源码
     */
    fun translateBlock(block: JavaParser.BlockContext): DART_SOURCE {
        val result = StringBuilder("")

        block.blockStatement().forEach {
            result.appendln(
                when {
                    it.localVariableDeclaration() != null -> it.localVariableDeclaration().toDart()
                    it.localTypeDeclaration() != null -> it.localTypeDeclaration().toDart()
                    it.statement() != null -> it.statement().toDart()
                    else -> ""
                }
            )
        }

        return result.toString()
    }
}

/**
 * 局部变量声明
 */
@TestOnly
fun JavaParser.LocalVariableDeclarationContext.toDart(): DART_SOURCE {
    return "${typeType().text} ${variableDeclarators().text}"
}

/**
 * 局部内部类声明 这个很少用到吧
 */
@TestOnly
fun JavaParser.LocalTypeDeclarationContext.toDart(): DART_SOURCE {
    return ""
}

/**
 * 语句
 */
@TestOnly
fun JavaParser.StatementContext.toDart(): DART_SOURCE {
    val result = StringBuilder("")
    gWalker.walk(object : JavaParserBaseListener() {
        // return 语句
        override fun enterStmtCase10(ctx: JavaParser.StmtCase10Context?) {
            ctx?.run {
                println("enterStmtCase10: $text")

                result.append("return ")
                expression()?.run { result.append(text) }
                result.appendln(";")
            }
        }

        // 表达式 语句
        override fun enterStmtCase15(ctx: JavaParser.StmtCase15Context?) {
            ctx?.run {
                println("enterStmtCase15: $text")

                result.appendln("${expression().text};")
            }
        }
    }, this)
    return result.toString()
}

/**
 * 表达式
 *
 * 已覆盖所有分支
 */
@TestOnly
fun JavaParser.ExpressionContext.toDart(): DART_SOURCE {
    val result = StringBuilder("")
    gWalker.walk(object : JavaParserBaseListener() {
        // 点操作符 表达式
        override fun enterExprCase0(ctx: JavaParser.ExprCase0Context?) {
            ctx?.run {
                println("enterExprCase0: $text")

                result.append(text)
            }
        }

        // 点操作符 表达式
        override fun enterExprCase1(ctx: JavaParser.ExprCase1Context?) {
            ctx?.run {
                println("enterExprCase1: $text")

                result.append(expression().toDart())
                result.append(DOT().text)

                IDENTIFIER()?.run { result.append(text) }
                methodCall()?.run { result.append(toDart()) }
                THIS()?.run { result.append(text) }
            }
        }

        // 方法调用 表达式
        override fun enterExprCase3(ctx: JavaParser.ExprCase3Context?) {
            ctx?.run {
                println("enterExprCase3: $text")

                result.appendln("${toDart()};")
            }
        }
    }, this)
    return result.toString()
}

@TestOnly
fun JavaParser.MethodCallContext.toDart(): DART_SOURCE {
    val result = StringBuilder("")
    IDENTIFIER()
        ?.run {
            result.append(text)
            result.append("(")
            expressionList()?.run { result.append(expression().joinToString { it.toDart() }) }
            result.append(")")
        }
    THIS()
        ?.run {
            result.append("this")
            result.append("(")
            expressionList()?.run { result.append(expression().joinToString { it.toDart() }) }
            result.append(")")
        }
    SUPER()
        ?.run {
            result.append("super")
            result.append("(")
            expressionList()?.run { result.append(expression().joinToString { it.toDart() }) }
            result.append(")")
        }
    return result.toString()
}