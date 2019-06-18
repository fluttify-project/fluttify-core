package common.extensions

import org.antlr.v4.runtime.RuleContext
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