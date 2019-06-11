package common.extensions

import common.DART_SOURCE
import common.JAVA_SOURCE
import common.OBJC_SOURCE
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.dart.Dart2BaseListener
import parser.dart.Dart2Lexer
import parser.dart.Dart2Parser
import parser.java.JavaLexer
import parser.java.JavaParser
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

//region Java源码扩展
/**
 * java源码判断是否是模型类
 */
fun JAVA_SOURCE.isJavaModel(): Boolean {
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
                // 构造器如果有参数, 则不是model
                hasDependency = constructor.hasParameter()
            }
        }

        override fun enterFieldDeclaration(field: FieldDeclarationContext?) {
            field?.run {
                fieldJsonable.add(
                    if (!field.jsonable()) {
                        field.type()?.isJavaModelType() ?: false
                    } else {
                        // 静态属性不作为model的字段
                        !field.isStatic()
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
//endregion

//region Objc源码扩展
/**
 * Objc源码遍历
 */
fun OBJC_SOURCE.walkTree(listener: ObjectiveCParserBaseListener) {
    val lexer = ObjectiveCLexer(CharStreams.fromString(this))
    val parser = ObjectiveCParser(CommonTokenStream(lexer))
    val tree = parser.translationUnit()
    val walker = ParseTreeWalker()

    walker.walk(listener, tree)
}

/**
 * objc源码判断是否是模型类
 *
 * 源码内只有一个类
 */
fun OBJC_SOURCE.isObjcModel(): Boolean {
    var isAbstract = false
    var isSubclass = false
    var hasDependency = false
    val fieldJsonable: MutableList<Boolean> = mutableListOf()

    walkTree(object : ObjectiveCParserBaseListener() {
        override fun enterProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext?) {
            // 如果是接口, 那么就不是model
            ctx?.run { isAbstract = true }
        }

        override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
            ctx?.run {
                // 如果类有继承, 暂时认为不是model
                isSubclass = ctx.isSubclass()
            }
        }

        override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext?) {
            ctx?.run {
                // 如果类中含有init方法, 那么就认为含有依赖
                if (ctx.name()?.contains("init") == true) {
                    hasDependency = true
                }
            }
        }

        override fun enterFieldDeclaration(ctx: ObjectiveCParser.FieldDeclarationContext?) {
            ctx?.run {
                fieldJsonable.add(
                    if (!ctx.jsonable()) {
                        ctx.type()?.isObjcModelType() ?: false
                    } else {
                        // 静态属性不作为model的字段
                        !ctx.isStatic()
                    }
                )
            }
        }
    })

    return if (isAbstract
        || isSubclass
        || hasDependency
        || fieldJsonable.isEmpty()
    )
        false
    else
        fieldJsonable.all { it }
}
//endregion

//region Dart源码扩展
/**
 * Dart源码遍历
 */
fun DART_SOURCE.walkTree(listener: Dart2BaseListener) {
    val lexer = Dart2Lexer(CharStreams.fromString(this))
    val parser = Dart2Parser(CommonTokenStream(lexer))
    val tree = parser.compilationUnit()
    val walker = ParseTreeWalker()

    walker.walk(listener, tree)
}
//endregion