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
            is Variable -> println("Variable::${typeName}::${name}由于不是`$message`, 未通过条件")
            is Field -> println("${className}::Field::${variable.typeName}::${variable.name}由于不是`$message`, 未通过条件")
            is Type -> println("Type::${name}由于不是`$message`, 未通过条件")
            is Method -> println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.typeName }})由于不是`$message`, 未通过条件")
            is Constructor -> println("Constructor::$name(${formalParams.joinToString { it.variable.typeName }})由于不是`$message`, 未通过条件")
            else -> println("不支持的过滤类型")
        }
        false
    } else {
        when (this) {
            is Variable -> println("Variable::${typeName}::${name}通过条件`$message`")
            is Field -> println("${className}::Field::${variable.typeName}::${variable.name}通过条件`$message`")
            is Type -> println("Type::${name}通过条件`$message`")
            is Method -> println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.typeName }})通过条件`$message`")
            is Constructor -> println("Constructor::$name(${formalParams.joinToString { it.variable.typeName }})通过条件`$message`")
            else -> println("不支持的过滤类型")
        }
        true
    }
}

fun <T> T.mustNot(message: String = "", mapper: T.() -> Boolean?): Boolean {
    return if (mapper() != false) {
        when (this) {
            is Variable -> println("Variable::${typeName}::${name}由于是`$message`, 未通过条件")
            is Field -> println("${className}::Field::${variable.typeName}::${variable.name}由于是`$message`, 未通过条件")
            is Type -> println("Type::${name}由于是`$message`, 未通过条件")
            is Method -> println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.typeName }})由于是`$message`, 未通过条件")
            is Constructor -> println("Constructor::$name(${formalParams.joinToString { it.variable.typeName }})由于是`$message`, 未通过条件")
            else -> println("不支持的过滤类型")
        }
        false
    } else {
        when (this) {
            is Variable -> println("Variable::${typeName}::${name}通过条件`$message`")
            is Field -> println("${className}::Field::${variable.typeName}::${variable.name}通过条件`$message`")
            is Type -> println("Type::${name}通过条件`$message`")
            is Method -> println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.typeName }})通过条件`$message`")
            is Constructor -> println("Constructor::$name(${formalParams.joinToString { it.variable.typeName }})通过条件`$message`")
            else -> println("不支持的过滤类型")
        }
        true
    }
}

fun getResource(name: String): URL {
    return FluttifyCorePlugin::class.java.getResource(name)
}