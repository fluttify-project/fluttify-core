package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.IGNORE_CLASS
import me.yohom.fluttify.common.model.*


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Variable>.toDartMap(valueBuilder: ((Variable) -> String) = { it.name }): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.name}\": ${valueBuilder(it)}" }
}

fun List<Method>.filterMethod(distinctSource: List<String> = listOf()): List<Method> {
    return asSequence()
        .filter { !it.isDeprecated }
        .filter { (!it.className.findType().isInterface()).apply { if (!this) println("filterMethod: $it 由于所在类是接口 被过滤") } }
        .filter { !(it.platform == Platform.iOS && it.name.startsWith("init")) } // ios端的init系列函数作为构造器而不是普通方法
        .filter { method ->
            (distinctSource.isEmpty() or distinctSource.none { it.contains(method.name) }).apply {
                if (!this) println(
                    "filterMethod: $method 由于与distinctSource中的方法重复 被过滤"
                )
            }
        }
        .distinctBy { "${it.className}::${it.name}" }
        .filter { it.isOk() }
        .toList()
}

fun List<Field>.filterGetters(): List<Field> {
    return asSequence()
        .filter { (it.isPublic == true).apply { if (!this) println("filterGetters: $it 由于不是公开field 被过滤") } }
        .filter { (it.isStatic == false).apply { if (!this) println("filterGetters: $it 由于是静态field 被过滤") } }
        .filter { (it.variable.typeName.findType().jsonable()).apply { if (!this) println("filterGetters: $it 由于是非jsonable类型 被过滤") } }
        .filter { (it.variable.typeName.findType() != Type.UNKNOWN_TYPE).apply { if (!this) println("filterGetters: $it 由于是未知类型 被过滤") } }
        .filter { (!it.variable.typeName.findType().isInterface()).apply { if (!this) println("filterGetters: $it 由于是接口类型 被过滤") } }
        .filter { (!it.className.findType().isInterface()).apply { if (!this) println("filterGetters: $it 由于所在类是接口 被过滤") } }
        .filter { (it.variable.typeName.findType().isPublic).apply { if (!this) println("filterGetters: $it 由于是非公开类型 被过滤") } }
        .filter { println("字段${it}通过Getter过滤"); true }
        .toList()
}

fun List<Type>.filterType(): List<Type> {
    return asSequence()
        .filter { it.isPublic.apply { if (!this) println("filterType: $it 由于不是公开类 被过滤") } }
        .filter {
            it.genericTypes.isEmpty().apply { if (!this) println("filterType: $it 由于含有泛型 被过滤") }
        } // 有泛型的类暂不支持处理
        .filter { (!(it.constructors.all { it.isPublic != true } && it.isInnerClass)).apply { if (!this) println("filterType: $it 由于构造器不是全公开且是内部类 被过滤") } }
        .filter { (!it.isObfuscated()).apply { if (!this) println("filterType: $it 由于是混淆类 被过滤") } }
        .filter { (it.superClass !in IGNORE_CLASS).apply { if (!this) println("filterType: $it 由于父类是忽略类 被过滤") } }
        .filter { println("类${it}通过过滤"); true }
        .toList()
}

fun List<Parameter>.filterFormalParams(): List<Parameter> {
    return asSequence()
        // 要过滤掉是接口, 却不是回调类的参数
        .filter { (!it.variable.typeName.findType().run { isInterface() && !isCallback() }).apply { if (!this) println("filterFormalParams: $it 由于是接口, 却不是回调类 被过滤") } }
        .filter { (it.variable.typeName.findType() != Type.UNKNOWN_TYPE).apply { if (!this) println("filterFormalParams: $it 由于是未知类型 被过滤") } }
        .filter { println("参数${it}通过过滤"); true }
        .toList()
}

fun List<Field>.filterSetters(): List<Field> {
    return asSequence()
        .filter { (it.isFinal == false).apply { if (!this) println("filterSetters: $it 由于是final字段 被过滤") } }
        .filter { (it.isPublic == true).apply { if (!this) println("filterSetters: $it 由于不是公开field 被过滤") } }
        .filter { (it.isStatic == false).apply { if (!this) println("filterSetters: $it 由于是静态字段 被过滤") } }
        .filter { (it.variable.typeName.findType().jsonable()).apply { if (!this) println("filterSetters: $it 由于是非jsonable类型 被过滤") } }
        .filter { (it.variable.typeName.findType() != Type.UNKNOWN_TYPE).apply { if (!this) println("filterSetters: $it 由于是未知类型 被过滤") } }
        .filter { (!it.variable.typeName.findType().isInterface()).apply { if (!this) println("filterSetters: $it 由于是接口类型 被过滤") } }
        .filter { (!it.className.findType().isInterface()).apply { if (!this) println("filterSetters: $it 由于所在类是接口 被过滤") } }
        .filter { (it.variable.typeName.findType().isPublic).apply { if (!this) println("filterSetters: $it 由于字段类型不是公开类型 被过滤") } }
        .filter { println("字段${it}通过Setter过滤"); true }
        .toList()
}

