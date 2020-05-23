package me.yohom.fluttify.extensions

import io.reactivex.rxjava3.core.Observable
import me.yohom.fluttify.model.*


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Variable>.toDartMap(
    prefix: String = "{",
    postfix: String = "}",
    valueBuilder: ((Variable) -> String) = { it.name }
): String {
    if (isEmpty()) return ""
    return joinToString(prefix = prefix, postfix = postfix) { "\"${it.name.depointer()}\": ${valueBuilder(it)}" }
}

/**
 * 键值对转成dart的map字面量字符串 批处理版本
 */
fun List<Variable>.toDartMapBatch(
    prefix: String = "[for (int __i__ = 0; __i__ < this.length; __i__++) {",
    suffix: String = "}]",
    valueBuilder: ((Variable) -> String) = { it.name }
): String {
    if (isEmpty()) return ""
    return joinToStringX(
        prefix = prefix,
        suffix = suffix
    ) { "\"${if (it.name == "this") "refId" else it.name.depointer()}\": ${valueBuilder(it)}" }
}

/**
 * 过滤出可以自动生成的类
 */
fun List<Type>.filterType(): List<Type> {
    return asSequence()
        .filter { it.filter }
        .filter { println("Type::${it.name}通过过滤"); true }
        .toList()
}

/**
 * 从field中过滤出常量
 */
fun List<Field>.filterConstants(): List<Field> {
    return asSequence()
        .filter { it.filterConstants }
        .distinctBy { it.variable.name }
        .filter { println("Field::${it.variable.name}通过Constants过滤"); true }
        .toList()
}

/**
 * 过滤出可以自动生成的方法
 */
fun List<Method>.filterMethod(batch: Boolean = false): List<Method> {
    return asSequence()
        .filter {
            if (batch) {
                it.filterBatch
            } else {
                it.filter
            }
        }
        .distinctBy { it.nameWithClass() }
        .filter { println("Method::${it.name}通过Method过滤"); true }
        .toList()
}

/**
 * 从field中过滤出getter
 */
fun List<Field>.filterGetters(): List<Field> {
    return asSequence()
        .filter { it.filterGetters }
        .filter { println("Field::${it.variable.name}通过Getter过滤"); true }
        .toList()
}

/**
 * 从field中过滤出setter
 */
fun List<Field>.filterSetters(batch: Boolean = false): List<Field> {
    return asSequence()
        .filter { if (batch) it.filterSetterBatch else it.filterSetter }
        .filter { println("Field::${it.variable.name}通过Setter过滤"); true }
        .toList()
}

/**
 * 过滤出可以直接构造的类
 */
fun List<Type>.filterConstructable(): List<Type> {
    return filterType()
        .asSequence()
        .filter { it.constructable }
        .toList()
}

/**
 * 过滤出可以构造的构造器
 */
fun List<Constructor>.filterConstructor(): List<Constructor> {
    return asSequence()
        .filter { it.filter }
        .toList()
}

/**
 * 过滤出可以自动生成的参数
 */
fun List<Parameter>.filterFormalParams(): List<Parameter> {
    return asSequence()
        .filter { it.filter }
        .filter { println("Parameter::${it.variable.trueType}通过过滤"); true }
        .toList()
}

fun <T> List<T>.joinToStringX(
    separator: String = ", ",
    prefix: String = "",
    suffix: String = "",
    transform: ((T) -> CharSequence)? = null
): String {
    return if (isEmpty()) {
        ""
    } else {
        joinToString(separator, prefix, suffix, transform = transform)
    }
}

fun <T> Iterable<T>.toObservable(): Observable<T> {
    return Observable.fromIterable(this)
}

fun List<Parameter>.addParameter(param: Parameter): List<Parameter> {
    return toMutableList().apply { add(param) }
}

fun List<Parameter>.checkParamSize(): String {
    return if (size <= 1) {
        "false"
    } else {
        // if (v1.length != v2.length || v2.length != v3.length || v3.length != v4.length) { }
        mapIndexed { index: Int, param: Parameter ->
            when (index) {
                // 第一个元素
                0 -> "${param.variable.name}.length"
                // 最后一个元素
                size - 1 -> "!= ${param.variable.name}.length"
                // 中间元素
                else -> "!= ${param.variable.name}.length || ${param.variable.name}.length"
            }
        }.joinToString(" ")
    }

}