package common.extensions

import common.JAVA_SOURCE
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java.JavaLexer
import parser.java.JavaParser
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener

/**
 * java源码判断是否是模型类
 */
fun JAVA_SOURCE.isModel(): Boolean {
    var isAbstract = false
    var isSubclass = false
    var hasDependency = false
    val fieldJsonable: MutableList<Boolean> = mutableListOf()

    walkTree(object : JavaParserBaseListener() {
        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext?) {
            // 如果是接口, 那么就不是model
            ctx?.run { isAbstract = true }
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext?) {
            ctx?.run {
                // 如果类有继承, 暂时认为不是model
                isSubclass = ctx.isSubclass()

                // 抽象类不是model
                isAbstract = ctx.isAbstract()
            }
        }

        override fun enterConstructorDeclaration(constructor: ConstructorDeclarationContext?) {
            constructor?.run {
                hasDependency = constructor.hasParameter()
            }
        }

        override fun enterFieldDeclaration(field: FieldDeclarationContext?) {
            field?.run {
                fieldJsonable.add(
                    if (!field.jsonable()) {
                        field.type()?.isModelType() ?: false
                    } else {
                        true
                    }
                )
            }
        }
    })

    return if (isAbstract
        || isSubclass
        || hasDependency
        || fieldJsonable.isEmpty()
    ) false else fieldJsonable.all { it }
}

/**
 * Java源码遍历
 */
fun JAVA_SOURCE.walkTree(listener: JavaParserBaseListener) {
    val lexer = JavaLexer(CharStreams.fromString(this))
    val parser = JavaParser(CommonTokenStream(lexer))
    val tree = parser.compilationUnit()
    val walker = ParseTreeWalker()

    walker.walk(listener, tree)
}