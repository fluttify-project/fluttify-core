package generator.common

fun List<Pair<String, String>>.toDartMap(): String {
    if (isEmpty()) return ""

    val result = StringBuilder()
    result.append("{")
    forEach { result.append("${it.first}: ${it.second}, ") }
    result.append("}")
    return result.toString()
}