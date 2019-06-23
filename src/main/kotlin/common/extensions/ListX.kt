package common.extensions

import common.KOTLIN_SOURCE
import common.model.Variable


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Variable>.toDartMap(): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.name}\": ${it.name}" }
}

/**
 * 保留的model类转换成kotlin代码
 */
fun Variable.convertPreservedModel(): KOTLIN_SOURCE {
    return when (type) {
        "Bundle" -> "\n\t\t\t\tval $name = Bundle()"
        "Bitmap" -> "\n\t\t\t\tval $name = (args[\"$name\"] as? ByteArray)?.run { BitmapFactory.decodeByteArray(this, 0, size) }"
        else -> ""
    }
}