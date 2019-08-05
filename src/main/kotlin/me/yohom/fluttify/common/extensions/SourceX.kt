package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.IGNORE_CLASS
import me.yohom.fluttify.common.IGNORE_METHOD
import me.yohom.fluttify.common.JAVA_SOURCE
import me.yohom.fluttify.common.OBJC_SOURCE
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java.JavaLexer
import parser.java.JavaParser
import parser.java.JavaParser.ClassDeclarationContext
import parser.java.JavaParser.FieldDeclarationContext
import parser.java.JavaParserBaseListener
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

//region Java源码扩展

fun JAVA_SOURCE.classContext(): JavaParser.ClassDeclarationContext {
    return parser().classDeclaration()
}

fun JAVA_SOURCE.methodContext(): JavaParser.MethodDeclarationContext {
    return parser().methodDeclaration()
}

/**
 * 所有成员都是静态
 */
fun JAVA_SOURCE.javaAllMemberStatic(): Boolean {
    val memberAllStatic = mutableListOf<Boolean>()

    walkTree(object : JavaParserBaseListener() {
        override fun enterFieldDeclaration(field: FieldDeclarationContext?) {
            field?.run {
                memberAllStatic.add(field.isStatic())
            }
        }

        override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
            ctx?.run {
                // 如果方法名称是在忽略列表里的, 那么就直接跳过
                if (ctx.name() in IGNORE_METHOD) return

                memberAllStatic.add(!ctx.isInstanceMethod())
            }
        }
    })
    return memberAllStatic.all { it }
}

/**
 * 是否是View
 */
fun JAVA_SOURCE.isView(): Boolean {
    var isView = false

    walkTree(object : JavaParserBaseListener() {
        override fun enterClassDeclaration(ctx: ClassDeclarationContext?) {
            ctx?.run {
                if (superClass() in listOf("View", "ViewGroup")) {
                    isView = true
                }
            }
        }
    })
    return isView
}

/**
 * 是否是忽略的类
 */
fun JAVA_SOURCE.isIgnore(): Boolean {
    var isIgnore = false

    walkTree(object : JavaParserBaseListener() {
        override fun enterClassDeclaration(ctx: ClassDeclarationContext?) {
            ctx?.run {
                if (superClass() in IGNORE_CLASS) {
                    isIgnore = true
                }
            }
        }
    })
    return isIgnore
}

/**
 * 是否有公有无参的构造器
 */
fun JAVA_SOURCE.javaPublicNonDependencyConstructor(): Boolean {
    val publicNonDependency = mutableListOf<Boolean>()

    walkTree(object : JavaParserBaseListener() {
        override fun enterConstructorDeclaration(ctx: JavaParser.ConstructorDeclarationContext?) {
            ctx?.run {
                publicNonDependency.add(isPublic() && !hasDependency())
            }
        }
    })
    return publicNonDependency.any { it } || publicNonDependency.isEmpty()
}

/**
 * 是否抽象
 */
fun JAVA_SOURCE.isAbstract(): Boolean {
    var isAbstract = false

    walkTree(object : JavaParserBaseListener() {
        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            isAbstract = ctx.isAbstract()
        }

        override fun enterInterfaceDeclaration(ctx: JavaParser.InterfaceDeclarationContext?) {
            isAbstract = true
        }
    })
    return isAbstract
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

/**
 * 获取解析器
 */
fun JAVA_SOURCE.parser(): JavaParser {
    val lexer = JavaLexer(CharStreams.fromString(this))
    return JavaParser(CommonTokenStream(lexer))
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
 * 是否有公有无参的构造器 即检查有无`无参数`的init方法
 */
fun OBJC_SOURCE.objcPublicNonDependencyConstructor(): Boolean {
    val publicNonDependency = mutableListOf<Boolean>()

    walkTree(object : ObjectiveCParserBaseListener() {
        override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext) {
            ctx.run {
                if (name() == "init") {
                    publicNonDependency.add(formalParams().isEmpty())
                }
            }
        }
    })
    return publicNonDependency.any { it } || publicNonDependency.isEmpty()
}

/**
 * 所有成员都是静态
 */
fun OBJC_SOURCE.objcAllMemberStatic(): Boolean {
    val memberAllStatic = mutableListOf<Boolean>()

    walkTree(object : ObjectiveCParserBaseListener() {
        override fun enterFieldDeclaration(ctx: ObjectiveCParser.FieldDeclarationContext) {
            memberAllStatic.add(ctx.isStatic())
        }

        override fun enterClassMethodDeclaration(ctx: ObjectiveCParser.ClassMethodDeclarationContext) {
            memberAllStatic.add(true)
        }

        override fun enterInstanceMethodDeclaration(ctx: ObjectiveCParser.InstanceMethodDeclarationContext) {
            memberAllStatic.add(false)
        }
    })
    return memberAllStatic.all { it }
}
//endregion