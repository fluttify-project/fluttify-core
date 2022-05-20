package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.*
import org.json.JSONObject
import org.w3c.dom.NamedNodeMap
import org.w3c.dom.Node
import org.w3c.dom.NodeList

private const val doxygen = "doxygen"
private const val compounddef = "compounddef"
private const val compoundname = "compoundname"
private const val objc = "Objective-C"
private const val java = "Java"

typealias MemberDef = Node
typealias CompoundDef = Node

fun Node.topLevelConstants(): List<Variable> {
    // TODO
    return listOf()
}

fun CompoundDef.types(): List<Type> {
    val resultList = mutableListOf<Type>()

    for (i in 0 until childNodes.length) {
        resultList.add(childNodes.item(i).elementBy(compounddef).type())
    }

    return resultList
}

/**
 * 从compounddef解析类型数据
 */
fun CompoundDef.type(): Type {
    val result = Type()

    result.name = elementBy(compoundname).textContent
//    result.aliasOf = getString(compoundname) // TODO
//    result.declaredGenericTypes = getString(compoundname) // TODO
//    result.definedGenericTypes = getString(compoundname) // TODO

    val kind = attrBy("kind")
    result.typeType = when (language()) {
        java -> when (kind) {
            "class" -> TypeType.Class
            "interface" -> TypeType.Interface
            "enum" -> TypeType.Enum
            else -> TypeType.Class
        }
        objc -> when (kind) {
            "interface" -> TypeType.Class
            "protocol" -> TypeType.Interface
            "enum" -> TypeType.Enum
            else -> TypeType.Class
        }
        else -> TypeType.Class
    }

    result.platform = platform(language())
    result.isPublic = attrBy("prot") == "public"
    result.isAbstract = attrBy("abstract") == "yes"
//    result.isInnerType = optString("abstract") == "yes" // TODO
//    result.isStaticType = optString("abstract") == "yes" // TODO

    // 基类 包含父类和接口
    val baseTypes = elementListBy("basecompoundref")
    result.superClass = baseTypes
        .firstOrNull()
        ?.textContent
        ?: languageObjectType(language())
    if (baseTypes.size > 1) {
        result.interfaces = baseTypes
            .drop(1)
            .map { it.textContent }
            .toMutableList()
    }

    // 属性
    result.fields.addAll(fields())
    // 方法
    result.methods.addAll(methods())

    return result
}

fun CompoundDef.fields(): List<Field> {
    val resultList = mutableListOf<Field>()

    val variables = elementListBy("sectiondef")
        .find { it.attrBy("kind").isOneOf("public-attrib", "property") }
        ?.elementListBy("memberdef")
        ?.filter { it.attrBy("kind").isOneOf("variable", "property") }

    variables?.run {
        for (doc in variables) {
            val type = doc.elementContentBy("type").pack()
            val isFinal = type.contains("final")
            val isStatic = doc.attrBy("static") == "yes"
            val varItem = Variable(
                typeName = type,
                name = doc.elementContentBy("name"),
                platform = platform(language()),
            )
            val field = Field(
                isPublic = true,
                isFinal = isFinal,
                isStatic = isStatic,
                variable = varItem,
                className = elementContentBy(compoundname),
                platform = platform(language()),
            )
            resultList.add(field)
        }
    }

    return resultList
}

fun CompoundDef.methods(): List<Method> {
    val resultList = mutableListOf<Method>()

    val methods = elementListBy("sectiondef")
        .find { it.attrBy("kind") == "public-func" }
        ?.elementListBy("memberdef")
        ?.filter { it.attrBy("kind") == "function" }

    methods?.run {
        for (doc in methods) { // memberdef
            val type = doc.elementContentBy("type").pack()
            val name = doc.elementContentBy("name")
            val isStatic = doc.attrBy("static") == "yes"
            val isAbstract = doc.attrBy("abstract") == "yes"
            val varItem = Variable(
                typeName = type,
                name = doc.elementContentBy("name"),
                platform = platform(language()),
            )
            val method = Method(
                returnType = type,
                name = name,
                isStatic = isStatic,
                isAbstract = isAbstract,
                className = elementContentBy(compoundname),
                platform = platform(language()),
                formalParams = doc.parameters(),
                isPublic = true,
//                doc = // TODO 增加文档
            )
            resultList.add(method)
        }
    }

    return resultList
}

private fun MemberDef.parameters(): List<Parameter> {
    val result = mutableListOf<Parameter>()



    return result
}

/**
 * 获取xml对应的内容, 如果有多级, 则拍扁并合并
 */
private fun JSONObject.stringContent(): String {
    return optString("content") ?: ""
}

/**
 * 根据名称获取第一个元素
 */
private fun Node.elementBy(name: String): Node {
    val nodeList = ownerDocument.getElementsByTagName(name)
    return nodeList.item(0)
}

/**
 * 根据名称获取第一个元素
 */
private fun Node.elementContentBy(name: String): String {
    return elementBy(name).textContent
}

/**
 * 根据名称获取第一个元素
 */
private fun Node.elementListBy(name: String): List<Node> {
    val nodeList = ownerDocument.getElementsByTagName(name)
    return nodeList.toList()
}

private fun NodeList.toList(): List<Node> {
    val result = mutableListOf<Node>()
    for (i in 0 until length) {
        result.add(item(i))
    }
    return result
}

/**
 * 根据名称获取第一个属性
 */
private fun Node.attrBy(name: String): String {
    return attributes.getNamedItem(name)?.nodeValue ?: ""
}

/**
 * 根据元素名称获取第一个
 */
private fun Node.firstElementOrNull(name: String): Node? {
    val nodeList = ownerDocument.getElementsByTagName(name)
    return if (nodeList.length == 0) null else nodeList.item(0)
}

/**
 * 获取xml对应的内容
 */
private fun CompoundDef.language() = attrBy("language")

/**
 * 根据语言获取对应的Object类型
 */
private fun languageObjectType(language: String): String {
    return if (language == java) "java.lang.Object" else if (language == objc) "NSObject" else ""
}

/**
 * 根据语言获取对应的Object类型
 */
private fun platform(language: String): Platform {
    return when (language) {
        java -> Platform.Android
        objc -> Platform.iOS
        else -> Platform.Unknown
    }
}