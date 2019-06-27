package common.extensions

import common.gWalker
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.Test
import parser.java.JavaLexer
import parser.java.JavaParser
import parser.java.JavaParserBaseListener

class ClassContextXKtTest {

    @Test
    fun isSubclass() {
    }

    @Test
    fun superClass() {
    }

    @Test
    fun isAbstract() {
    }

    @Test
    fun isPublic() {
    }

    @Test
    fun interface2lambdas() {
        val source = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/baidu/mapapi/map/BaiduMap\$OnMapClickListener.java".file().readText()

        val lexer = JavaLexer(CharStreams.fromString(source))
        val parser = JavaParser(CommonTokenStream(lexer))
        gWalker.walk(object : JavaParserBaseListener() {
            override fun enterInterfaceDeclaration(ctx: JavaParser.InterfaceDeclarationContext?) {
                ctx?.run {
                    println(interface2lambdas())
                }
            }
        }, parser.compilationUnit())
    }

    @Test
    fun isSubclass1() {
    }
}