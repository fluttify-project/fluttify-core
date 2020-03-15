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

@Throws(IllegalArgumentException::class)
fun <T : RuleContext> RuleContext.ancestorOf(target: KClass<T>): T? {
    return when {
        parent == null -> null
        parent.javaClass == target.java -> parent as? T // 匹配到目标类型, 说明是[parentClass]的子节点
        else -> parent.ancestorOf(target) // 其他情况继续向上搜索
    }
}

fun RuleContext.typeFullName(typeSimpleName: String): String {
    return if (typeSimpleName.jsonable() || typeSimpleName == "void") {
        typeSimpleName
    } else if (typeSimpleName == "Object") {
        "java.lang.Object"
    } else if (typeSimpleName == "Throwable") {
        "java.lang.Throwable"
    } else if (typeSimpleName == "Exception") {
        "java.lang.Exception"
    } else {
        ancestorOf(JavaParser.CompilationUnitContext::class)
            ?.importDeclaration()
            ?.find {
                !typeSimpleName.jsonable() // 非jsonable类型
                        && it.qualifiedName().text.length >= typeSimpleName.dearray().length // import的长度必须大于简称类名长度
                        && it.qualifiedName().text.run { substringAfterLast(".") } == typeSimpleName.dearray() // 搜索全类名的时候需要去掉数组后缀
            }
            ?.qualifiedName()
            ?.run {
                // 如果是数组类型的话, 要加上[]
                if (typeSimpleName.isArray()) {
                    "$text[]"
                } else {
                    text
                }
            }
        // 如果不是import进来的说明这个类是当前文件的主类或者相同包下的类, 直接拼接package和类名
            ?: ancestorOf(JavaParser.CompilationUnitContext::class)
                ?.packageDeclaration()
                ?.qualifiedName()?.text + "." + typeSimpleName
    }
}