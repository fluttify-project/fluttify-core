package me.yohom.fluttify.extensions

import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java Field
fun JavaParser.FieldDeclarationContext.isStatic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") == true
}

fun JavaParser.FieldDeclarationContext.isDeprecated(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.any { it.text.contains("@Deprecated") } == true
}

fun JavaParser.FieldDeclarationContext.isPrivate(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("private") == true
}

fun JavaParser.FieldDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
}

fun JavaParser.FieldDeclarationContext.getValue(): String {
    return variableDeclarators()
        ?.variableDeclarator()
        ?.get(0)
        ?.variableInitializer()
        ?.text ?: ""
}

fun JavaParser.FieldDeclarationContext.type(): String {
    return typeFullName(typeType().text)
}

fun JavaParser.FieldDeclarationContext.name(): String {
    return variableDeclarators()?.variableDeclarator()?.get(0)?.variableDeclaratorId()?.text ?: ""
}

fun JavaParser.FieldDeclarationContext.isFinal(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("final") == true
            || isChildOf(JavaParser.InterfaceDeclarationContext::class)
}

fun JavaParser.FieldDeclarationContext?.value(): String? {
    if (this == null) return null
    return variableDeclarators()
        ?.variableDeclarator()
        ?.get(0)
        ?.variableInitializer()
        ?.run {
            return when {
                arrayInitializer() != null -> {
                    arrayInitializer().text.replace("{", "[").replace("}", "]")
                }
                expression() != null -> {
                    expression().text
                }
                else -> ""
            }
        }
}

fun JavaParser.FieldDeclarationContext?.jsonable(): Boolean {
    if (this == null) return true

    return type().jsonable()
}
//endregion

//region Objc field
/**
 * 是否是只读 有两种情况
 *
 * 1. property指定是readonly
 * 2. 声明了getter却没有声明setter
 */
fun ObjectiveCParser.FieldDeclarationContext.isFinal(): Boolean {
    val propertyAttributes = ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class)
        ?.propertyAttributesList()
        ?.propertyAttribute()
        ?.map { it.text }

//    // 如果只设置了getter的名称, setter没有设置, 不代表是只读的
//    val getter = propertyAttributes
//        ?.find { it.contains("getter") }
//        ?.run { split("=")[1] } ?: ""
//
//    val setter = propertyAttributes
//        ?.find { it.contains("setter") }
//        ?.run { split("=")[1] } ?: ""

    val readonly = propertyAttributes?.contains("readonly") == true

//    // 高德地图 AMapService.apiKey是copy的, 但是不是只读的
//    val copy = propertyAttributes?.contains("copy") == true

    return readonly /*|| copy || (getter.isNotEmpty() && setter.isEmpty())*/
}

fun ObjectiveCParser.FieldDeclarationContext.getValue(): String {
    return "null"
}

fun ObjectiveCParser.FieldDeclarationContext.type(): String {
    return specifierQualifierList().text.run {
        if (contains("id<")) {
            replaceFirst("id<", "").removeSuffix(">")
        } else {
            this
        }
    }
}

fun ObjectiveCParser.FieldDeclarationContext.name(): String {
    // 由于没有找到DEPRECATED_ATTRIBUTE对应的antlr声明部分, 所以这里只能先强行删除了
    return fieldDeclaratorList().text.removeSuffix("DEPRECATED_ATTRIBUTE")
}

/**
 * 判断一个字段是否是列表
 *
 * 规则:
 *   1. 类型是否是NSArray
 * 由于需要判断字段的类型是否是结构体(需要读取SDK的数据, SDK的数据从json中反序列化而来), 但是当下阶段又是在生成json的过程中,
 * 导致了先有鸡还是先有蛋的问题, 所以这里暂时就先只判断是否是NSArray
 */
fun ObjectiveCParser.FieldDeclarationContext.isListType(): Boolean {
    return specifierQualifierList().text.isIterable()
}

fun ObjectiveCParser.FieldDeclarationContext.isStatic(): Boolean {
    return false
}

fun ObjectiveCParser.FieldDeclarationContext.getterName(): String {
    return ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class)
        ?.propertyAttributesList()
        ?.propertyAttribute()
        ?.map { it.text }
        ?.find { it.contains("getter") }
        ?.run { split("=")[1] }
        ?: name().depointer()
}

fun ObjectiveCParser.FieldDeclarationContext.setterName(): String {
    return ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class)
        ?.propertyAttributesList()
        ?.propertyAttribute()
        ?.map { it.text }
        ?.find { it.contains("setter") }
        ?.run { split("=")[1] }
        ?: name().depointer()
}

fun ObjectiveCParser.FieldDeclarationContext.jsonable(): Boolean {
    return type().toDartType() in listOf(
        "bool",
        "int",
        "double",
        "String",
        "List",
        "Map",
        "null",
        "List<int>",
        "List<double>",
        "void"
    )
}
//endregion