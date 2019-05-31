package common.model

import builtparser.JavaParser
import common.extensions.*
import parser.java8.Java8BaseListener
import parser.java8.Java8Parser
import preprocess.Jar

/**
 * 类信息 Java类和Objc类公用
 */
abstract class ClassInfo(
    /**
     * 全名 包含包名
     */
    open val name: String,

    /**
     * 类文件所在绝对路径
     */
    open val path: String
) {
    /**
     * 是否是model类
     */
    abstract val isModel: Boolean
}

/**
 * Java类信息
 */
data class JavaClassInfo(
    override val name: String,

    /**
     * 去除包名的类名
     */
    val simpleName: String,

    override val path: String
) : ClassInfo(name, path) {
    override val isModel: Boolean
        get() {
            if (path.substringAfterLast(".") != "java") return false

            var isAbstract = false
            var isSubclass = false
            var hasDependency = false
            val fieldJsonable: MutableList<Boolean> = mutableListOf()

            val parser = JavaParser(path)

            parser.walkTree(object : Java8BaseListener() {
                override fun enterInterfaceDeclaration(`interface`: Java8Parser.InterfaceDeclarationContext?) {
                    // 如果是接口, 那么就不是model
                    `interface`?.run {
                        isAbstract = true
                    }
                }

                override fun enterNormalClassDeclaration(`class`: Java8Parser.NormalClassDeclarationContext?) {
                    `class`?.run {
                        // 如果类有继承或者实现的话, 暂时认为不是model
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
                        if (field.isStatic()) return

                        fieldJsonable.add(
                            if (!field.jsonable()) {
                                Jar.Decompiled.classes[field.typeName()]?.isModel ?: false
                            } else {
                                true
                            }
                        )
                    }
                }
            })

            return if (isAbstract || isSubclass || hasDependency || fieldJsonable.isEmpty()) false
            else fieldJsonable.all { it }
        }

    override fun toString(): String {
        return "\nJavaClassInfo(name='$name', simpleName='$simpleName', path='$path', isModel='$isModel')\n"
    }
}

/**
 * Objc类信息
 */
data class ObjcClassInfo(
    override val name: String,
    override val path: String
) : ClassInfo(name, path) {
    override val isModel: Boolean
        get() {
            return false
        }
}