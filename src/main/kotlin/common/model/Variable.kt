package common.model

import Jar
import common.PRESERVED_MODEL
import common.TYPE_NAME
import common.extensions.jsonable

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(val type: TYPE_NAME, val name: String) {
    fun jsonable(): Boolean = type.jsonable()

    fun isModel(): Boolean = jsonable()
            || Jar.Decompiled.classes[type]?.isModel == true
            || type in PRESERVED_MODEL
}