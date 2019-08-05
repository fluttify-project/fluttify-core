package me.yohom.fluttify.common.extensions

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
    return if (typeSimpleName.jsonable()) {
        typeSimpleName
    } else {
        ancestorOf(JavaParser.CompilationUnitContext::class)
            ?.importDeclaration()
            ?.find {
                !typeSimpleName.jsonable()
                        && it.qualifiedName().text.length >= typeSimpleName.length
                        && it.qualifiedName().text.replace("$", ".").run { substringAfterLast(".") } == typeSimpleName
            }
            ?.qualifiedName()
            ?.text
            ?.replace("$", ".")
        // 如果不是import进来的说明这个类是当前文件的主类, 直接拼接package和类名
            ?: ancestorOf(JavaParser.CompilationUnitContext::class)
                ?.packageDeclaration()
                ?.qualifiedName()?.text + "." + typeSimpleName.replace("$", ".")
    }
}