package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.IGNORE_TYPE
import me.yohom.fluttify.common.model.*


/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Variable>.toDartMap(valueBuilder: ((Variable) -> String) = { it.name }): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.name}\": ${valueBuilder(it)}" }
}

/**
 * 过滤出可以自动生成的方法
 */
fun List<Method>.filterMethod(): List<Method> {
    return asSequence()
        .filter { !it.isDeprecated }
        // todo 暂时不处理带有列表参数的方法
        .filter { (!it.formalParams.any { it.variable.typeName.isList() }).apply { if (!this) println("filterMethod: $it 由于参数中有数组 被过滤") } }
        // 类似float*返回这样的类型的方法都暂时不处理
        .filter { !it.returnType.run { contains("*") && depointer().isCType() } }
        .filter { !(it.platform == Platform.iOS && it.name.startsWith("init")) } // ios端的init系列函数作为构造器而不是普通方法
        .distinctBy { "${it.className}::${it.name}" }
        .filter { it.isOk() }
        .toList()
}

/**
 * 从field中过滤出getter
 */
fun List<Field>.filterGetters(): List<Field> {
    return asSequence()
        // todo 暂时不处理带有列表参数的方法
        .filter { (!it.variable.typeName.isList()).apply { if (!this) println("filterMethod: $it 由于参数中有数组 被过滤") } }
        .filter { (it.isPublic == true).apply { if (!this) println("filterGetters: $it 由于不是公开field 被过滤") } }
//        .filter { (it.isStatic == false).apply { if (!this) println("filterGetters: $it 由于是静态field 被过滤") } }
//        .filter { (it.variable.typeName.findType().run { jsonable() || isEnum() }).apply { if (!this) println("filterGetters: $it 由于是非jsonable且非enum类型 被过滤") } }
        .filter { (it.variable.typeName.findType() != Type.UNKNOWN_TYPE).apply { if (!this) println("filterGetters: $it 由于是未知类型 被过滤") } }
//        .filter { (!it.variable.typeName.findType().isInterface()).apply { if (!this) println("filterGetters: $it 由于是接口类型 被过滤") } }
//        .filter { (!it.className.findType().isInterface()).apply { if (!this) println("filterGetters: $it 由于所在类是接口 被过滤") } }
        .filter { (it.variable.typeName.findType().isPublic).apply { if (!this) println("filterGetters: $it 由于是非公开类型 被过滤") } }
        .filter { println("字段${it}通过Getter过滤"); true }
        .toList()
}

/**
 * 从field中过滤出setter
 */
fun List<Field>.filterSetters(): List<Field> {
    return asSequence()
        // todo 暂时不处理带有列表参数的方法
        .filter { (!it.variable.typeName.isList()).apply { if (!this) println("filterMethod: $it 由于参数中有数组 被过滤") } }
        .filter { (it.isFinal == false).apply { if (!this) println("filterSetters: $it 由于是final字段 被过滤") } }
        .filter { (it.isPublic == true).apply { if (!this) println("filterSetters: $it 由于不是公开field 被过滤") } }
//        .filter { (it.isStatic == false).apply { if (!this) println("filterSetters: $it 由于是静态字段 被过滤") } }
//        .filter { (it.variable.typeName.findType().run { jsonable() || isEnum() }).apply { if (!this) println("filterGetters: $it 由于是非jsonable且非enum类型 被过滤") } }
        .filter { (it.variable.typeName.findType() != Type.UNKNOWN_TYPE).apply { if (!this) println("filterSetters: $it 由于是未知类型 被过滤") } }
//        .filter { (!it.variable.typeName.findType().isInterface()).apply { if (!this) println("filterSetters: $it 由于是接口类型 被过滤") } }
//        .filter { (!it.className.findType().isInterface()).apply { if (!this) println("filterSetters: $it 由于所在类是接口 被过滤") } }
        .filter { (it.variable.typeName.findType().isPublic).apply { if (!this) println("filterSetters: $it 由于字段类型不是公开类型 被过滤") } }
        .filter { println("字段${it}通过Setter过滤"); true }
        .toList()
}

/**
 * 过滤出可以自动生成的类
 */
fun List<Type>.filterType(): List<Type> {
    return asSequence()
        .filter { (it != Type.UNKNOWN_TYPE).apply { if (!this) println("filterType: $it 由于是未知类 被过滤") } }
        .filter { it.isPublic.apply { if (!this) println("filterType: $it 由于不是公开类 被过滤") } }
        // 有泛型的类暂不支持处理
        .filter { it.genericTypes.isEmpty().apply { if (!this) println("filterType: $it 由于含有泛型 被过滤") } }
        .filter {
            (it.constructors.any { it.isPublic == true } || it.isEnum() || it.constructors.isEmpty()).apply {
                if (!this) println("filterType: $it 由于构造器不是全公开且是内部类 被过滤")
            }
        }
        .filter { (!it.isObfuscated()).apply { if (!this) println("filterType: $it 由于是混淆类 被过滤") } }
        .filter { (it.superClass !in IGNORE_TYPE).apply { if (!this) println("filterType: $it 由于父类是忽略类 被过滤") } }
        .filter { (it.superClass.run { isEmpty() || findType() != Type.UNKNOWN_TYPE }).apply { if (!this) println("filterType: $it 由于父类是未知类 被过滤") } }
        .filter { println("类${it}通过过滤"); true }
        .toList()
}

/**
 * 过滤出可以直接构造的类
 */
fun List<Type>.filterConstructable(): List<Type> {
    return filterType()
        .asSequence()
        .filter { it.constructable() }
        .toList()
}

/**
 * 过滤出可以构造的构造器
 */
fun List<Constructor>.filterConstructor(): List<Constructor> {
    return asSequence()
        // 构造器参数为空或者递归检查构造器参数的构造器是否符合相同条件
        .filter {
            ((it.formalParams.isEmpty() || it.formalParams.all { it.variable.typeName.findType().constructable() })
                    && it.isPublic == true
                    && it.formalParams.none { it.variable.typeName.findType().isList() })
                .apply { if (!this) println("filterConstructor: $it 由于构造器含有未知类 被过滤") }
        }
        .toList()
}

/**
 * 过滤出可以自动生成的参数
 */
fun List<Parameter>.filterFormalParams(): List<Parameter> {
    return asSequence()
        .filter { (it.variable.typeName.findType().run { !isLambda() && !isCallback() }).apply { if (!this) println("filterFormalParams: $it 由于是接口, 却不是回调类 被过滤") } }
        .filter { (it.variable.typeName.findType() != Type.UNKNOWN_TYPE).apply { if (!this) println("filterFormalParams: $it 由于是未知类型 被过滤") } }
        .filter { println("参数${it}通过过滤"); true }
        .toList()
}

