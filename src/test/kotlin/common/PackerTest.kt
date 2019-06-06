package common

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Test
import parser.java.JavaLexer
import parser.java.JavaParser

class PackerTest {

    @Test
    fun packJava() {
        val testFilePath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/tbit/tbitblesdk/Bike/model/BikeState.java"
        val lexer = JavaLexer(CharStreams.fromFileName(testFilePath))
        val parser = JavaParser(CommonTokenStream(lexer))
        val tree = parser.compilationUnit()

        println(Packer.pack(tree))
    }

    @Test
    fun packObjc() {
    }

    @Test
    fun packDart() {
    }
}