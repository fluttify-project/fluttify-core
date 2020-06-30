package me.yohom.fluttify.extensions

import com.google.gson.GsonBuilder
import me.yohom.fluttify.*
import me.yohom.fluttify.model.*
import java.net.URL

fun Any.toJson(): String {
    return GsonBuilder().setPrettyPrinting().create().toJson(this)
}

fun <T> T.must(message: String = "", mapper: T.() -> Boolean?): Boolean {
    return if (mapper() != true) {
        when (this) {
            is Variable -> if (VARIABLE_LOG) println("Variable::${trueType}::${name}由于不是`$message`, 未通过条件")
            is Field -> if (FIELD_LOG) println("${className}::Field::${variable.trueType}::${variable.name}由于不是`$message`, 未通过条件")
            is Type -> if (TYPE_LOG) println("Type::${name}由于不是`$message`, 未通过条件")
            is Method -> if (METHOD_LOG) println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.trueType }})由于不是`$message`, 未通过条件")
            is Constructor -> if (CONSTRUCTOR_LOG) println("Constructor::$name(${formalParams.joinToString { it.variable.trueType }})由于不是`$message`, 未通过条件")
            else -> println("不支持的过滤类型")
        }
        false
    } else {
        if (SUCCESS_LOG) {
            when (this) {
                is Variable -> if (VARIABLE_LOG) println("Variable::${trueType}::${name}通过条件`$message`")
                is Field -> if (FIELD_LOG) println("${className}::Field::${variable.trueType}::${variable.name}通过条件`$message`")
                is Type -> if (TYPE_LOG) println("Type::${name}通过条件`$message`")
                is Method -> if (METHOD_LOG) println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.trueType }})通过条件`$message`")
                is Constructor -> if (CONSTRUCTOR_LOG) println("Constructor::$name(${formalParams.joinToString { it.variable.trueType }})通过条件`$message`")
                else -> println("不支持的过滤类型")
            }
        }
        true
    }
}

fun <T> T.mustNot(message: String = "", mapper: T.() -> Boolean?): Boolean {
    return if (mapper() != false) {
        when (this) {
            is Variable -> if (VARIABLE_LOG) println("Variable::${trueType}::${name}由于是`$message`, 未通过条件")
            is Field -> if (FIELD_LOG) println("${className}::Field::${variable.trueType}::${variable.name}由于是`$message`, 未通过条件")
            is Type -> if (TYPE_LOG) println("Type::${name}由于是`$message`, 未通过条件")
            is Method -> if (METHOD_LOG) println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.trueType }})由于是`$message`, 未通过条件")
            is Constructor -> if (CONSTRUCTOR_LOG) println("Constructor::$name(${formalParams.joinToString { it.variable.trueType }})由于是`$message`, 未通过条件")
            else -> println("不支持的过滤类型")
        }
        false
    } else {
        if (SUCCESS_LOG) {
            when (this) {
                is Variable -> if (VARIABLE_LOG) println("Variable::${trueType}::${name}通过条件`$message`")
                is Field -> if (FIELD_LOG) println("${className}::Field::${variable.trueType}::${variable.name}通过条件`$message`")
                is Type -> if (TYPE_LOG) println("Type::${name}通过条件`$message`")
                is Method -> if (METHOD_LOG) println("${className}::$returnType::$name(${formalParams.joinToString { it.variable.trueType }})通过条件`$message`")
                is Constructor -> if (CONSTRUCTOR_LOG) println("Constructor::$name(${formalParams.joinToString { it.variable.trueType }})通过条件`$message`")
                else -> println("不支持的过滤类型")
            }
        }
        true
    }
}

fun getResource(name: String): URL {
    return FluttifyCorePlugin::class.java.getResource(name)
}