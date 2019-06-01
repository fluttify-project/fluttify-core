package common.extensions

import common.DART_SOURCE
import common.JAVA_SOURCE
import common.Temps
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
 * 从java源码获取parser
 */
fun JAVA_SOURCE.parser(): Java8Parser {
    val lexer = Java8Lexer(CharStreams.fromString(this))
    return Java8Parser(CommonTokenStream(lexer))
}

/**
 * 从一个Java模型类生成dart的模型类
 */
fun JAVA_SOURCE.toDartModel(): DART_SOURCE {
    /**
     * Java语法的语句转为Dart语法的语句
     *
     * 暂时支持赋值语句和return语句
     */
    fun Java8Parser.BlockStatementsContext.toDart(): DART_SOURCE {
        val result = StringBuilder("")

        blockStatement().forEach {
            it.statement()
                ?.statementWithoutTrailingSubstatement()
                ?.expressionStatement()
                ?.statementExpression()
                ?.assignment()
                ?.run {
                    result.append("    ${leftHandSide().fieldAccess()?.text} ${assignmentOperator().text} ${expression().text};\n")
                }
            it.statement()
                ?.statementWithoutTrailingSubstatement()
                ?.returnStatement()
                ?.run {
                    result.append("    return ${expression().text};\n")
                }
        }

        return result.toString()
    }

    val result = StringBuilder()

    walkTree(object : Java8BaseListener() {
        override fun enterNormalClassDeclaration(clazz: Java8Parser.NormalClassDeclarationContext?) {
            clazz?.run { result.append(Temps.Dart.classDeclaration.placeholder(clazz.Identifier().text)) }
        }

        override fun enterFieldDeclaration(field: Java8Parser.FieldDeclarationContext?) {
            field?.run {
                if (!type()!!.isModelType()) {
                    return
                }
                result.append("  ${if (isStatic()) "static " else ""}${type()} ${name()} = ${value()};\n")
            }
        }

        override fun enterMethodDeclaration(method: Java8Parser.MethodDeclarationContext?) {
            method?.run {
                // 参数中有非model参数, 则跳过
                if (method.formalParams().any { !it.type.isModelType() }) return

                result.append(
                    Temps.Dart.method.placeholder(
                        method.returnType(),
                        method.name(),
                        method.formalParams().joinToString { "${it.type} ${it.name}" },
                        method.methodBody()?.block()?.blockStatements()?.toDart()
                    )
                )
            }
        }

        override fun exitNormalClassDeclaration(ctx: Java8Parser.NormalClassDeclarationContext?) {
            ctx?.run {
                result.append(Temps.Dart.classEnd)
            }
        }
    })

    return result.toString()
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
    val tree = parser().compilationUnit()
    val walker = ParseTreeWalker()

    walker.walk(listener, tree)
}