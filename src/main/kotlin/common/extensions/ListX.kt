package common.extensions

import Jar
import common.KOTLIN_SOURCE
import common.PRESERVED_MODEL
import common.model.Variable


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Variable>.toDartMap(valueBuilder: ((Variable) -> String) = { it.name }): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.name}\": ${valueBuilder(it)}" }
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

/**
 * 变量类型是否是回调类型
 */
fun Variable.isCallback(): Boolean {
    return Jar.Decompiled.classes[type]?.isCallback == true
}

/**
 * 变量类型是未知类型
 */
fun Variable.isUnknownType(): Boolean = !Jar.Decompiled.classes.containsKey(type)

/**
 * 是否是模型类
 */
fun Variable.isModel(): Boolean = jsonable()
        || Jar.Decompiled.classes[type]?.isModel == true
        || type in PRESERVED_MODEL

/**
 * 是否可序列化
 */
fun Variable.jsonable(): Boolean = type.jsonable()

/**
 * 是否是枚举类
 */
fun Variable.isEnum(): Boolean = Jar.Decompiled.classes[type]?.isEnum == true
