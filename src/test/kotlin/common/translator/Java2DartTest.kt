package common.translator

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Test
import parser.java.JavaLexer
import parser.java.JavaParser

class Java2DartTest {
    @Test
    fun translateBlock() {
    }

    @Test
    fun localVariableDeclarationToDart() {
    }

    @Test
    fun localTypeDeclarationToDart() {
    }

    @Test
    fun statementToDart() {
        val source = """
            ab.bc(a, b);
        """.trimIndent()

        val lexer = JavaLexer(CharStreams.fromString(source))
        val parser = JavaParser(CommonTokenStream(lexer))
        println("结果: " + parser.statement().toDart())
    }

    @Test
    fun expressionToDart() {
        val source = """
            ab.bc()
        """.trimIndent()

        val lexer = JavaLexer(CharStreams.fromString(source))
        val parser = JavaParser(CommonTokenStream(lexer))
        println("结果: " + parser.expression().toDart())
    }

    @Test
    fun methodCallToDart() {
        val source = """
            bc()
        """.trimIndent()

        val lexer = JavaLexer(CharStreams.fromString(source))
        val parser = JavaParser(CommonTokenStream(lexer))
        println("结果: " + parser.methodCall().toDart())
    }
}