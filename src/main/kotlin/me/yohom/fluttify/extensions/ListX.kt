package me.yohom.fluttify.extensions

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
 * 过滤出可以自动生成的类
 */
fun List<Type>.filterType(): List<Type> {
    return asSequence()
        .filter { it.filter() }
        .filter { println("Type::${it.name}通过过滤"); true }
        .toList()
}

/**
 * 从field中过滤出常量
 */
fun List<Field>.filterConstants(): List<Field> {
    return asSequence()
        .filter { it.filterConstants() }
        .filter { println("Field::${it.variable.name}通过Constants过滤"); true }
        .toList()
}

/**
 * 过滤出可以自动生成的方法
 */
fun List<Method>.filterMethod(): List<Method> {
    return asSequence()
        .filter { it.filter() }
        .distinctBy { it.nameWithClass() }
        .filter { println("Method::${it.name}通过Method过滤"); true }
        .toList()
}

/**
 * 从field中过滤出getter
 */
fun List<Field>.filterGetters(): List<Field> {
    return asSequence()
        .filter { it.filterGetters() }
        .filter { println("Field::${it.variable.name}通过Getter过滤"); true }
        .toList()
}

/**
 * 从field中过滤出setter
 */
fun List<Field>.filterSetters(): List<Field> {
    return asSequence()
        .filter { it.filterSetter() }
        .filter { println("Field::${it.variable.name}通过Setter过滤"); true }
        .toList()
}

/**
 * 过滤出可以直接构造的类
 */
fun List<Type>.filterConstructable(): List<Type> {
    return filterType()
        .asSequence()
        .filter { it.constructable() }
        .toList()
}

/**
 * 过滤出可以构造的构造器
 */
fun List<Constructor>.filterConstructor(): List<Constructor> {
    return asSequence()
        .filter { it.filter() }
        .toList()
}

/**
 * 过滤出可以自动生成的参数
 */
fun List<Parameter>.filterFormalParams(): List<Parameter> {
    return asSequence()
        .filter { it.filter() }
        .filter { println("Parameter::${it.variable.typeName}通过过滤"); true }
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
