package me.yohom.fluttify.extensions

import com.google.gson.GsonBuilder
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.model.Variable

fun Any.id(): Int {
    return hashCode()
}

fun Any.toJson(): String {
    return GsonBuilder().setPrettyPrinting().create().toJson(this)
}

fun <T> T.must(message: String = "", mapper: T.() -> Boolean?): Boolean {
    return if (mapper() != true) {
        when (this) {
            is Variable -> println("Variable::${name}由于不是`$message`, 被过滤")
            is Field -> println("Field::${variable.name}由于不是`$message`, 被过滤")
            is Type -> println("Type::${name}由于不是`$message`, 被过滤")
            is Method -> println("Method::${nameWithClass()}(${formalParams.joinToString { it.variable.typeName }})由于不是`$message`, 被过滤")
            else -> println("不支持的过滤类型")
        }
        false
    } else {
        true
    }
}

fun <T> T.mustNot(message: String = "", mapper: T.() -> Boolean?): Boolean {
    return if (mapper() != false) {
        when (this) {
            is Variable -> println("Variable::${name}由于是`$message`, 被过滤")
            is Field -> println("Field::${variable.name}由于是`$message`, 被过滤")
            is Type -> println("Type::${name}由于是`$message`, 被过滤")
            is Method -> println("Method::${name}(${formalParams.joinToString { it.variable.typeName }})由于是`$message`, 被过滤")
            else -> println("不支持的过滤类型")
        }
        false
    } else {
        true
    }
}