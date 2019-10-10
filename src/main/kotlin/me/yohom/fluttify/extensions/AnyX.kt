package me.yohom.fluttify.extensions

import com.google.gson.GsonBuilder
import me.yohom.fluttify.model.Field
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
            is Variable -> print("${name}由于不是$message, 被过滤")
            is Field -> print("${variable.name}由于不是$message, 被过滤")
        }
        false
    } else {
        true
    }
}

fun <T> T.mustNot(message: String = "", mapper: T.() -> Boolean?): Boolean {
    return if (mapper() != false) {
        when (this) {
            is Variable -> print("${name}由于是$message, 被过滤")
        }
        false
    } else {
        true
    }
}