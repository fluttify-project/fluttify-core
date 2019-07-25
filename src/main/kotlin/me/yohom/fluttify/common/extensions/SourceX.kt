package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.Framework
import me.yohom.fluttify.Jar
import me.yohom.fluttify.common.*
import me.yohom.fluttify.common.model.TypeType
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
/**
 * java源码判断是否是模型类
 *
 * 识别规则:
 * 判定为true:
 *   1. 当前类是model, 父类也是model √
 *   2. 所有字段都是model/jsonable √
 *   3. 保留的model类 √
 * 判定为false:
 *   1. 所有成员(包括字段和方法)都是static √
 *   2. 任何一个方法参数中含有非model类
 */
fun JAVA_SOURCE.isJavaModel(): Boolean {
//    var parentIsModel = false
//
//    val fieldAllModel = mutableListOf<Boolean>()
//    val fieldAllStatic = mutableListOf<Boolean>()
//    val memberAllStatic = mutableListOf<Boolean>()
//    val methodArgsAllModel = mutableListOf<Boolean>()
//
//    var isModel = false
//
//    walkTree(object : JavaParserBaseListener() {
//        override fun enterClassDeclaration(ctx: ClassDeclarationContext?) {
//            ctx?.run {
//                println(
//                    "正在评估类: ${ctx.IDENTIFIER().text}; 路径: ${me.yohom.fluttify.Jar.Decompiled.CLASSES[ctx.IDENTIFIER()?.text]?.path ?: ""}"
//                )
//                // 父类是否是model, 如果是的话, 那么忽略父类的影响, 如果不是的话, 那么当前类也不是model
//                // 如果没有父类, 那么就认为父类是model
//                parentIsModel = ctx.superClass()?.isJavaModelType() == true || ctx.EXTENDS() == null
//            }
//        }
//
//        override fun enterFieldDeclaration(field: FieldDeclarationContext?) {
//            field?.run {
//                fieldAllStatic.add(field.isStatic())
//                memberAllStatic.add(field.isStatic())
//                if (field.isStatic()) return
//
//                fieldAllModel.add(
//                    field.jsonable()
//                            || me.yohom.fluttify.Jar.Decompiled.CLASSES[type().genericType()]?.isModel == true
//                            || PRESERVED_MODEL.contains(type())
//                )
//            }
//        }
//
//        override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
//            ctx?.run {
//                // 如果方法名称是在忽略列表里的, 那么就直接跳过
//                if (ctx.name() in IGNORE_METHOD) return
//
//                memberAllStatic.add(!ctx.isInstanceMethod())
//                formalParams().forEach { methodArgsAllModel.add(it.type.isModel()) }
//            }
//        }
//
//        override fun exitClassDeclaration(ctx: ClassDeclarationContext?) {
//            ctx?.run {
//                println("parentIsModel: $parentIsModel, fieldAllModel: $fieldAllModel, fieldAllStatic: $memberAllStatic, methodArgsAllModel: $methodArgsAllModel")
//
//                isModel = (fieldAllModel.all { it } || fieldAllModel.isEmpty())
//                        && (!memberAllStatic.all { it } || memberAllStatic.isEmpty())
//                        && (!fieldAllStatic.all { it } || fieldAllStatic.isEmpty())
//                        && parentIsModel
//                        && (methodArgsAllModel.all { it } || methodArgsAllModel.isEmpty())
//
//                me.yohom.fluttify.Jar.Decompiled.CLASSES[ctx.IDENTIFIER().text]?.isModel = isModel
//
//                println("${ctx.IDENTIFIER().text} 评估结果: $isModel\n")
//            }
//        }
//
//        override fun enterEnumDeclaration(ctx: JavaParser.EnumDeclarationContext?) {
//            ctx?.run { isModel = true }
//        }
//    })

    return false
}

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
 * 是否是回调类, 目前只识别interface文件
 */
fun TYPE_NAME.isJavaCallback(): Boolean {
    return Jar.Decompiled.CLASSES[this]?.typeType == TypeType.Interface
}

/**
 * 是否是回调类, 目前只识别protocol文件
 */
fun TYPE_NAME.isObjcCallback(): Boolean {
    return Framework.CLASSES[this]?.typeType == TypeType.Interface
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