package me.yohom.fluttify.extensions

import com.google.gson.GsonBuilder
import me.yohom.fluttify.FluttifyCorePlugin
import me.yohom.fluttify.model.*
import java.net.URL

fun Any.toJson(): String {
    return GsonBuilder().setPrettyPrinting().create().toJson(this)
}

fun <T> T.must(message: String = "", mapper: T.() -> Boolean?): Boolean {
    return if (mapper() != true) {
        when (this) {
            is Variable -> println("Variable::${typeName}::${name}由于不是`$message`, 被过滤")
            is Field -> println("${className}::Field::${variable.typeName}::${variable.name}由于不是`$message`, 被过滤")
            is Type -> println("Type::${name}由于不是`$message`, 被过滤")
            is Method -> println("${className}::Method::${nameWithClass()}(${formalParams.joinToString { it.variable.typeName }})由于不是`$message`, 被过滤")
            is Constructor -> println("Constructor::$name(${formalParams.joinToString { it.variable.typeName }})由于不是`$message`, 被过滤")
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
            is Variable -> println("Variable::${typeName}::${name}由于是`$message`, 被过滤")
            is Field -> println("${className}::Field::${variable.typeName}::${variable.name}由于是`$message`, 被过滤")
            is Type -> println("Type::${name}由于是`$message`, 被过滤")
            is Method -> println("${className}::Method::${nameWithClass()}(${formalParams.joinToString { it.variable.typeName }})由于是`$message`, 被过滤")
            is Constructor -> println("Constructor::$name(${formalParams.joinToString { it.variable.typeName }})由于是`$message`, 被过滤")
            else -> println("不支持的过滤类型")
        }
        false
    } else {
        true
    }
}

fun getResource(name: String): URL {
    return FluttifyCorePlugin::class.java.getResource(name)
}