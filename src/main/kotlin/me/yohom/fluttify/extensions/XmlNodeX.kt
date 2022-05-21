package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.*
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

    for (item in elementListBy(compounddef)) {
        resultList.add(item.type())
    }

    return resultList
}

/**
 * 从compounddef解析类型数据
 */
fun CompoundDef.type(): Type {
    val result = Type()

    result.name = typeName()
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
    // 构造器
    result.constructors.addAll(constructors())

    return result
}

fun CompoundDef.fields(): List<Field> {
    val resultList = mutableListOf<Field>()

    val variables = elementListBy("sectiondef")
        .find { it.attrBy("kind").isOneOf("public-attrib", "property") }
        ?.elementListBy("memberdef")
        ?.filter { it.attrBy("kind").isOneOf("variable", "property") }

    variables?.let {
        for (item in it) {
            val type = item.elementContentBy("type").pack()
            val isFinal = type.contains("final")
            val isStatic = item.attrBy("static") == "yes"
            val varItem = Variable(
                typeName = type,
                name = item.elementContentBy("name"),
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

/**
 * 方法列表
 */
fun CompoundDef.methods(): List<Method> {
    val resultList = mutableListOf<Method>()

    val methods = elementListBy("sectiondef")
        .find { it.attrBy("kind").isOneOf("public-func", "public-static-func") }
        ?.elementListBy("memberdef")
        ?.filter { it.attrBy("kind") == "function" }

    methods?.let {
        for (item in it) { // memberdef
            if (item.elementContentBy("name") == "__deprecated_msg") continue

            val type = item.elementContentBy("type").pack()
            val name = item.elementContentBy("name")
            val isStatic = item.attrBy("static") == "yes"
            val isAbstract = item.attrBy("abstract") == "yes"
            val method = Method(
                returnType = type,
                name = name,
                isStatic = isStatic,
                isAbstract = isAbstract,
                className = elementContentBy(compoundname),
                platform = platform(language()),
                formalParams = item.parameters(),
                isPublic = true,
                doc = item.doc(), // 简单实现, 能细化的地方挺多
            )
            resultList.add(method)
        }
    }

    return resultList
}

/**
 * 构造器列表
 */
fun CompoundDef.constructors(): List<Constructor> {
    val resultList = mutableListOf<Constructor>()

    val typeName = typeName()
    val simpleTypeName = typeName.simpleName()
    val constructors = elementListBy("sectiondef")
        .find { it.attrBy("kind") == "public-func" }
        ?.elementListBy("memberdef")
        // 方法, 且名称和类名一致的是构造器
        ?.filter {
            it.attrBy("kind") == "function" &&
                    it.elementContentBy("qualifiedname") == "${typeName}.$simpleTypeName"
        }

    constructors?.let {
        for (item in it) { // memberdef
            if (item.elementContentBy("name") == "__deprecated_msg") continue

            val name = item.elementContentBy("name")
            val method = Constructor(
                name = name,
                platform = platform(language()),
                formalParams = item.parameters(),
                isPublic = true,
            )
            resultList.add(method)
        }
    }

    return resultList
}

/**
 * 获取参数
 */
private fun MemberDef.parameters(): List<Parameter> {
    val result = mutableListOf<Parameter>()

    for (node in elementListBy("param")) {
        val platform = platform("")
        val item = Parameter(
            variable = Variable(
                typeName = node.elementContentBy("type").pack(),
                name = node.elementContentBy("declname"),
                platform = platform,
            ),
            named = "", // TODO
            platform = platform,
        )

        result.add(item)
    }

    return result
}

/**
 * 获取文档
 */
private fun MemberDef.doc(): Doc {
    val brief = elementContentBy("briefdescription")
    val detail = elementContentBy("briefdescription")
    return Doc(brief, detail)
}

/**
 * 根据名称获取第一个元素
 */
private fun Node.elementBy(name: String): Node {
    if (childNodes.length > 0) {
        for (i in 0 until childNodes.length) {
            val item = childNodes.item(i)
            if (item.nodeName == name) return item
        }
        throw IllegalAccessException("未找到名为${name}的元素")
    } else {
        throw IllegalAccessException("当前子元素数量为0")
    }
}

/**
 * 根据名称获取第一个元素
 */
private fun Node.elementContentBy(name: String): String {
    return elementBy(name).textContent
}

/**
 * 根据名称获取元素列表
 */
private fun Node.elementListBy(name: String): List<Node> {
    val result = mutableListOf<Node>()
    for (i in 0 until childNodes.length) {
        val item = childNodes.item(i)
        if (item.nodeName == name) result.add(item)
    }
    return result
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
 * 获取xml对应的内容
 */
private fun CompoundDef.language() = attrBy("language")

/**
 * 获取xml对应的内容
 */
private fun CompoundDef.typeName() = elementBy(compoundname).textContent.replace("::", ".")

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