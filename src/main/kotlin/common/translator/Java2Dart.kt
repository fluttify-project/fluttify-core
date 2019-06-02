package common.translator

import common.DART_SOURCE
import common.JAVA_SOURCE
import common.Temps
import common.extensions.*
import parser.java8.Java8BaseListener
import parser.java8.Java8Parser

// TODO 处理内部类问题 Dart没有内部类, 所以内部类要单独输出到一个文件 在分析过程中就把所有的Model类生成
object Java2Dart {
    private val result = StringBuilder()
    private var enteredEnum = false

    fun translate(source: JAVA_SOURCE): DART_SOURCE {

        source.walkTree(object : Java8BaseListener() {
            override fun enterNormalClassDeclaration(clazz: Java8Parser.NormalClassDeclarationContext?) {
                clazz?.run { result.append(Temps.Dart.classDeclaration.placeholder(clazz.Identifier().text)) }
            }

            override fun enterFieldDeclaration(field: Java8Parser.FieldDeclarationContext?) {
                if (enteredEnum) return

                field?.run {
                    if (!type()!!.isModelType()) return

                    result.append("  ${if (isStatic()) "static " else ""}${type()} ${name()} = ${value()};\n")
                }
            }

            override fun enterMethodDeclaration(method: Java8Parser.MethodDeclarationContext?) {
                if (enteredEnum) return

                method?.run {
                    // 参数中有非model参数, 则跳过
                    if (method.formalParams().any { !it.type.isModelType() }
                        || method.returnType()?.isModelType() != true) return

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

            override fun enterEnumDeclaration(`enum`: Java8Parser.EnumDeclarationContext?) {
                enum?.run {
                    enteredEnum = true

                    result.append("\n  enum ${enum.Identifier()} {\n")
                }
            }

            override fun enterEnumConstant(ctx: Java8Parser.EnumConstantContext?) {
                ctx?.run {
                    result.append("    ${ctx.Identifier()};\n")
                }
            }

            override fun exitEnumDeclaration(ctx: Java8Parser.EnumDeclarationContext?) {
                enteredEnum = false

                result.append("  }\n")
            }
        })

        return result.toString()
    }

    /**
     * Java语法的语句转为Dart语法的语句
     *
     * 暂时支持赋值语句和return语句
     */
    private fun Java8Parser.BlockStatementsContext.toDart(): DART_SOURCE {
        val result = StringBuilder("")

        blockStatement().forEach {
            it.statement()
                ?.statementWithoutTrailingSubstatement()
                ?.expressionStatement()
                ?.statementExpression()
                ?.assignment()
                ?.run {
                    leftHandSide()
                        .fieldAccess()
                        ?.run { result.append("    $text ${assignmentOperator().text} ${expression().text};\n") }
                    leftHandSide()
                        .expressionName()
                        ?.run { result.append("    $text ${assignmentOperator().text} ${expression().text};\n") }
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


}