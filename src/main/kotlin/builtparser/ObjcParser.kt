package builtparser

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

class ObjcParser(objcFilePath: String) {
    private val lexer = ObjectiveCLexer(CharStreams.fromFileName(objcFilePath))
    private val parser = ObjectiveCParser(CommonTokenStream(lexer))
    private val tree = parser.translationUnit()
    private val walker = ParseTreeWalker()

    fun walkTree(listener: ObjectiveCParserBaseListener) {
        walker.walk(listener, tree)
    }
}