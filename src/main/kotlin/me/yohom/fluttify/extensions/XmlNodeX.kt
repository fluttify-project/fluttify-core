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

fun CompoundDef.types(): List<Type> {
    val resultList = mutableListOf<Type>()

    for (item in listBy(compounddef)) {
        resultList.add(item.type())
    }

    return resultList
}

fun Node.topLevelConstants(): List<Variable> {
    // TODO
    return listOf()
}

/**
 * 从compounddef解析类型数据
 */
private fun CompoundDef.type(): Type {
    val result = Type()

    result.name = typeName()
//    result.aliasOf = getString(compoundname) // TODO
//    result.declaredGenericTypes = getString(compoundname) // TODO
//    result.definedGenericTypes = getString(compoundname) // TODO

    val kind = this("kind")
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
    result.isPublic = this("prot") == "public"
    result.isAbstract = this("abstract") == "yes"
//    result.isInnerType = optString("abstract") == "yes" // TODO
//    result.isStaticType = optString("abstract") == "yes" // TODO

    // 基类 包含父类和接口
    val baseTypes = listBy("basecompoundref")
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
    // 是否过时
    result.isDeprecated = isDeprecated()

    return result
}

/**
 * 属性
 */
private fun CompoundDef.fields(): List<Field> {
    val resultList = mutableListOf<Field>()

    val variables = listBy("sectiondef")
        .find { it("kind").isOneOf("public-attrib", "property") }
        ?.listBy("memberdef")
        ?.filter { it("kind").isOneOf("variable", "property") }

    variables?.let {
        for (item in it) {
            val type = item.contentOf("type").pack()
            val isFinal = type.contains("final")
            val isStatic = item("static") == "yes"
            val varItem = Variable(
                typeName = type,
                name = item.contentOf("name"),
                platform = platform(language()),
            )
            val field = Field(
                isPublic = true,
                isFinal = isFinal,
                isStatic = isStatic,
                variable = varItem,
                className = contentOf(compoundname),
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
private fun CompoundDef.methods(): List<Method> {
    val resultList = mutableListOf<Method>()

    val methods = listBy("sectiondef")
        .find { it("kind").isOneOf("public-func", "public-static-func") }
        ?.listBy("memberdef")
        ?.filter { it("kind") == "function" }

    methods?.let {
        for (item in it) { // memberdef
            if (item.contentOf("name") == "__deprecated_msg") continue

            val type = item.contentOf("type").pack()
            val name = item.contentOf("name")
            val isStatic = item("static") == "yes"
            val isAbstract = item("abstract") == "yes"
            val method = Method(
                returnType = type,
                name = name,
                isStatic = isStatic,
                isAbstract = isAbstract,
                className = contentOf(compoundname),
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
private fun CompoundDef.constructors(): List<Constructor> {
    val resultList = mutableListOf<Constructor>()

    val typeName = typeName()
    val simpleTypeName = typeName.simpleName()
    val constructors = listBy("sectiondef")
        .find { it("kind") == "public-func" }
        ?.listBy("memberdef")
        // 方法, 且名称和类名一致的是构造器
        ?.filter {
            it("kind") == "function" &&
                    it.contentOf("qualifiedname") == "${typeName}.$simpleTypeName"
        }

    constructors?.let {
        for (item in it) { // memberdef
            if (item.contentOf("name") == "__deprecated_msg") continue

            val name = item.contentOf("name")
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
 * 是否过时
 */
private fun MemberDef.isDeprecated(): Boolean {
    return this["detaileddescription"]?.get("para")?.get("xrefsect")
        ?.contentOf("xreftitle") == "Deprecated"
}

/**
 * 获取参数
 */
private fun MemberDef.parameters(): List<Parameter> {
    val result = mutableListOf<Parameter>()

    for (node in listBy("param")) {
        val platform = platform("")
        val item = Parameter(
            variable = Variable(
                typeName = node.contentOf("type").pack(),
                name = node.contentOf("declname"),
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
    val brief = contentOf("briefdescription")
    val detail = contentOf("briefdescription")
    return Doc(brief, detail)
}

/**
 * 根据名称获取第一个元素
 */
private operator fun Node.get(name: String): Node? {
    if (childNodes.length > 0) {
        for (i in 0 until childNodes.length) {
            val item = childNodes.item(i)
            if (item.nodeName == name) return item
        }
        return null
    } else {
        return null
    }
}

/**
 * 根据名称获取第一个元素内容
 */
private fun Node.contentOf(name: String): String {
    return this[name]?.textContent ?: ""
}

/**
 * 根据名称获取元素列表
 */
private fun Node.listBy(name: String): List<Node> {
    val result = mutableListOf<Node>()
    for (i in 0 until childNodes.length) {
        val item = childNodes.item(i)
        if (item.nodeName == name) result.add(item)
    }
    return result
}

/**
 * 根据名称获取属性值
 */
private operator fun Node.invoke(name: String): String {
    return attributes.getNamedItem(name)?.nodeValue ?: ""
}

/**
 * 获取xml对应的内容
 */
private fun CompoundDef.language() = this("language")

/**
 * 获取xml对应的内容
 */
private fun CompoundDef.typeName() = this[compoundname]?.textContent?.replace("::", ".") ?: ""

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