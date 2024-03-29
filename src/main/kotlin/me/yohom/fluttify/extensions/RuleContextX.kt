package me.yohom.fluttify.extensions

import org.antlr.v4.runtime.RuleContext
import parser.java.JavaParser
import kotlin.reflect.KClass

fun <T : Any> RuleContext.isChildOf(parentClass: KClass<T>): Boolean {
    return when {
        parent == null -> false // 表示搜索到树顶部也没搜索到, 那么说明不是[parentClass]的子节点
        parent.javaClass == parentClass.java -> return true // 匹配到目标类型, 说明是[parentClass]的子节点
        else -> return parent.isChildOf(parentClass) // 其他情况继续向上搜索
    }
}

fun <T : Any> RuleContext.isDirectChildOf(parentClass: KClass<T>): Boolean {
    return parent.javaClass == parentClass.java
}

@Throws(IllegalArgumentException::class)
fun <T : RuleContext> RuleContext.ancestorOf(target: KClass<T>): T? {
    return when {
        this.javaClass == target.java -> this as T
        parent == null -> null
        parent.javaClass == target.java -> parent as? T // 匹配到目标类型, 说明是[parentClass]的子节点
        else -> parent.ancestorOf(target) // 其他情况继续向上搜索
    }
}

fun RuleContext.typeFullName(typeSimpleName: String): String {
    fun nonGenericTypeFullName(typeName: String): String {
        // 如果类型含有点(.), 则说明已经是全名, 直接返回
        if (typeName.contains(".")) return typeName

        return if (typeName == "List") {
            "java.util.List"
        } else if (typeName == "Map") {
            "java.util.Map"
        } else if (typeName == "SortedSet") {
            "java.util.SortedSet"
        } else if (typeName == "Object") {
            "java.lang.Object"
        } else if (typeName == "Throwable") {
            "java.lang.Throwable"
        } else if (typeName == "Exception") {
            "java.lang.Exception"
        } else if (typeName == "Iterable") {
            "java.lang.Iterable"
        } else if (typeName == "Void") {
            "java.lang.Void"
        } else if (typeName == "?") {
            "?"
        } else if (typeName.jsonable() || typeName == "void") {
            typeName
        } else {
            ancestorOf(JavaParser.CompilationUnitContext::class)
                ?.importDeclaration()
                ?.find {
                    !typeName.jsonable() // 非jsonable类型
                            && it.qualifiedName().text.length >= typeName.deSquareBracket().length // import的长度必须大于简称类名长度
                            && it.qualifiedName().text.run { substringAfterLast(".") } == typeName.deSquareBracket() // 搜索全类名的时候需要去掉数组后缀
                }
                ?.qualifiedName()
                ?.run {
                    // 如果是数组类型的话, 要加上[]
                    if (typeName.isArray()) {
                        "$text[]"
                    } else {
                        text
                    }
                }
            // 去类型定义里找一下泛型声明, 看下当前类型是否在泛型列表中 这两句没有效果 先注释了
                ?: ancestorOf(JavaParser.ClassDeclarationContext::class)
                    ?.typeParameters()
                    ?.typeParameter()
                    ?.map { it.IDENTIFIER().text }
                    ?.find { it == typeName }
                ?: ancestorOf(JavaParser.InterfaceDeclarationContext::class)
                    ?.typeParameters()
                    ?.typeParameter()
                    ?.map { it.IDENTIFIER().text }
                    ?.find { it == typeName }
                // 如果不是import进来的说明这个类是当前文件的主类或者相同包下的类, 直接拼接package和类名
                ?: (ancestorOf(JavaParser.CompilationUnitContext::class)
                    ?.packageDeclaration()
                    ?.qualifiedName()?.text + "." + typeName)
        }
    }

    fun fullNameWithGeneric(typeName: String): String {
        val containerType = typeName.containerType()
        val genericTypes = typeName.genericTypes()

        return if (genericTypes.all { it.genericTypes().isEmpty() }) {
            // 泛型类型没有泛型, 也就是说只有一层泛型, 那么直接处理
            val fullContainerType = nonGenericTypeFullName(containerType)
            val fullGenericType = genericTypes.map { nonGenericTypeFullName(it) }

            // 泛型列表为空, 则直接使用容器类型, 否则拼接成完整类型
            if (genericTypes.isEmpty()) {
                fullContainerType
            } else {
                "${fullContainerType}<${fullGenericType.joinToString(",")}>"
            }
        } else {
            val fullContainerType = nonGenericTypeFullName(containerType)
            "$fullContainerType<${genericTypes.joinToString("") { fullNameWithGeneric(it) }}>"
        }
    }

    return fullNameWithGeneric(typeSimpleName)
}