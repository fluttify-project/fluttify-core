package common.extensions

import common.model.Variable


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Variable>.toDartMap(): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.type}\": ${it.name}" }
}