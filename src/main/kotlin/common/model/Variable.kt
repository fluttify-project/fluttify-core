package common.model

import common.TYPE_NAME
import common.extensions.jsonable

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(val type: TYPE_NAME, val name: String) {
    fun jsonable(): Boolean = type.jsonable()
}