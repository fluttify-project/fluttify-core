package common.extensions

import common.JAVA_SOURCE
import common.UNKNOWN
import common.model.JavaTypeInfo
import common.model.Method
import common.model.Variable
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser

/**
 * java源码判断是否是模型类
 */
fun JAVA_SOURCE.isModel(): Boolean {
    var isAbstract = false
    var isSubclass = false
    var hasDependency = false
    val fieldJsonable: MutableList<Boolean> = mutableListOf()

    walkTree(object : Java8BaseListener() {
        override fun enterInterfaceDeclaration(`interface`: Java8Parser.InterfaceDeclarationContext?) {
            // 如果是接口, 那么就不是model
            `interface`?.run {
                isAbstract = true
            }
        }

        override fun enterNormalClassDeclaration(`class`: Java8Parser.NormalClassDeclarationContext?) {
            `class`?.run {
                // 如果类有继承, 暂时认为不是model
                isSubclass = `class`.isSubclass()

                // 抽象类不是model
                isAbstract = `class`.isAbstract()
            }
        }

        override fun enterConstructorDeclarator(constructor: Java8Parser.ConstructorDeclaratorContext?) {
            constructor?.run {
                hasDependency = constructor.hasParameter()
            }
        }

        override fun enterFieldDeclaration(field: Java8Parser.FieldDeclarationContext?) {
            field?.run {
                fieldJsonable.add(
                    if (!field.jsonable()) {
                        field.type()?.isModel() ?: false
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
 * Java源码解析
 */
fun JAVA_SOURCE.typeInfo(): JavaTypeInfo {
    var packageName = ""
    val fields = mutableListOf<Variable>()
    val methods = mutableListOf<Method>()
    var className = ""

    walkTree(object : Java8BaseListener() {
        override fun enterPackageName(ctx: Java8Parser.PackageNameContext?) {
            packageName = ctx?.packageName()?.text ?: ""
        }

        override fun enterNormalClassDeclaration(ctx: Java8Parser.NormalClassDeclarationContext?) {
            if (ctx != null) {
                className = ctx.Identifier().text
            }
        }

        override fun enterInterfaceDeclaration(ctx: Java8Parser.InterfaceDeclarationContext?) {
            if (ctx != null && ctx.normalInterfaceDeclaration().interfaceModifier().map { it.text }.contains("public")) {
                className = ctx.normalInterfaceDeclaration().Identifier().text
            }
        }

        override fun enterEnumDeclaration(ctx: Java8Parser.EnumDeclarationContext?) {
            if (ctx != null && ctx.classModifier().map { it.text }.contains("public")) {
                className = ctx.Identifier().text
            }
        }

        override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
            ctx?.run {
                methods.add(Method(ctx.returnType()!!, ctx.name()!!, ctx.formalParams()))
            }
        }

        override fun enterFieldDeclaration(ctx: Java8Parser.FieldDeclarationContext?) {
            ctx?.run {
                fields.add(Variable(ctx.type()!!, ctx.name()!!))
            }
        }
    })

    return JavaTypeInfo("$packageName.$className", className, UNKNOWN, fields, methods)
}

/**
 * Java源码遍历
 */
fun JAVA_SOURCE.walkTree(listener: Java8BaseListener) {
    val lexer = Java8Lexer(CharStreams.fromString(this))
    val parser = Java8Parser(CommonTokenStream(lexer))
    val tree = parser.compilationUnit()
    val walker = ParseTreeWalker()

    walker.walk(listener, tree)
}