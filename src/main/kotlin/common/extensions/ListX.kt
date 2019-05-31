package common.extensions


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Pair<String, String>>.toDartMap(): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.second}\": ${it.second}" }
}