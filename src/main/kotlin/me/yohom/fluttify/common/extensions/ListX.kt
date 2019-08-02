package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.IGNORE_CLASS
import me.yohom.fluttify.common.IGNORE_METHOD
import me.yohom.fluttify.common.model.Field
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Type
import me.yohom.fluttify.common.model.Variable


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Variable>.toDartMap(valueBuilder: ((Variable) -> String) = { it.name }): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.name}\": ${valueBuilder(it)}" }
}

fun List<Method>.filterMethod(distinctSource: List<String> = listOf()): List<Method> {
    return asSequence()
        .filter { method -> distinctSource.isEmpty() or distinctSource.none { it.contains(method.name) } }
        .distinctBy { "${it.className}::${it.name}" }
        .filter { it.name !in IGNORE_METHOD }
        .filter { it.isPublic == true }
        .filter { it.className.findType().isPublic }
        // 返回值
        .filter { !it.returnType.findType().isObfuscated() }
        .filter { it.returnType.findType() != Type.UNKNOWN_TYPE }
        .filter { !it.returnType.findType().isInterface() } // 暂不支持返回值为接口类型的方法
        .filter { it.returnType.findType().genericTypes.isEmpty() } // 暂不支持返回泛型类型的方法
        // 参数
        .filter { it.formalParams.none { it.typeName.findType() == Type.UNKNOWN_TYPE } }
        .filter { it.formalParams.all { it.typeName.findType().isPublic } }
        .filter { it.formalParams.all { it.typeName.findType().genericTypes.isEmpty() } }
        .toList()
}

fun List<Field>.filterGetters(): List<Field> {
    return asSequence()
        .filter { it.isPublic == true }
        .filter { it.isStatic == false }
        .filter { it.variable?.typeName?.findType() != Type.UNKNOWN_TYPE }
        .filter { it.variable?.typeName?.findType()?.isInterface() == false }
        .filter { it.variable?.typeName?.findType()?.isPublic == true }
        .toList()
}

fun List<Type>.filterType(): List<Type> {
    return asSequence()
        .filter { it.isPublic }
        .filter { it.genericTypes.isEmpty() } // 有泛型的类暂不支持处理
        .filter { it.constructors.all { it.isPublic == true } }
        .filter { !it.isObfuscated() }
        .filter { it.superClass !in IGNORE_CLASS }
        .toList()
}

fun List<Field>.filterSetters(): List<Field> {
    return asSequence()
        .filter { it.isFinal == false }
        .filter { it.isPublic == true }
        .filter { it.isStatic == false }
        .filter { it.variable?.typeName?.findType() != Type.UNKNOWN_TYPE }
        .filter { it.variable?.typeName?.findType()?.isInterface() == false }
        .filter { it.variable?.typeName?.findType()?.isPublic == true }
        .toList()
}

