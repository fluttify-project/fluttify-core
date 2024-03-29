package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.*
import org.w3c.dom.Node
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

private const val compounddef = "compounddef"
private const val compoundname = "compoundname"
private const val objc = "Objective-C"
private const val cpp = "C++"
private const val java = "Java"

typealias MemberDef = Node
typealias CompoundDef = Node
typealias TypeDef = Node

// 此次解析上下文
var language: String = ""
var objectType: String = ""
var platform: Platform = Platform.Unknown

/**
 * 顶层常量
 */
fun CompoundDef.topLevelConstants(): List<Variable> {
    val compound = this[compounddef]!!
    compound.setupEnv()

    val resultList = mutableListOf<Variable>()

    val variables = compound
        .listBy("sectiondef")
        .filter { it("kind") == "var" }
        .flatMap { it.listBy("memberdef") }

    for (item in variables) { // memberdef
        val variable = Variable(
            typeName = item["type"]?.get("ref")?.textContent
                ?: item.contentOf("type").removeObjcSpecifier(),
            name = item.contentOf("name"),
            platform = platform,
        )

        resultList.add(variable)
    }

    return resultList
}

/**
 * 顶层函数
 */
fun CompoundDef.topLevelFunctions(): List<Type> {
    val compound = this[compounddef]!!
    compound.setupEnv()

    val resultList = mutableListOf<Type>()

    val functions = compound
        .listBy("sectiondef")
        .filter { it("kind") == "func" }
        .flatMap { it.listBy("memberdef") }

    for (item in functions) { // memberdef
        val type = Type()
        type.platform = platform
        type.typeType = TypeType.Function
        type.name = item.contentOf("name")
        type.returnType = item["type"]!!.contentOf("ref")
            .ifBlank {
                item.contentOf("type")
                    .split(" ")
                    .filterNot { it.startsWith("UIKIT") }
                    .filterNot { it.startsWith("FOUNDATION_EXPORT") }
                    .joinToString("")
            }
        type.formalParams = item.parameters()

        resultList.add(type)
    }

    return resultList
}

/**
 * typedef
 */
fun CompoundDef.typedefs(): List<Type> {
    val compound = this[compounddef]!!
    compound.setupEnv()

    val resultList = mutableListOf<Type>()

    val typedef = compound
        .listBy("sectiondef")
        .filter { it("kind") == "typedef" }
        .flatMap { it.listBy("memberdef") }

    for (item in typedef) { // memberdef
        val aliasOf = item.contentOf("type")
        val type = Type()
        // block别名无法被doxygen识别, 只能通过antlr辅助解析一下
        if (aliasOf.contains("(^")) {
            val definition = "${item.contentOf("definition")};"
            // 代码参考了antlr版本解析的逻辑
            definition.walkTree(object : ObjectiveCParserBaseListener() {
                override fun enterTypedefDeclaration(ctx: ObjectiveCParser.TypedefDeclarationContext) {
                    val returnType = ctx
                        .declarationSpecifiers()
                        ?.typeSpecifier()
                        ?.get(0)
                        ?.text
                    val typeName = ctx
                        .typeDeclaratorList()
                        ?.typeDeclarator()
                        ?.get(0)
                        ?.directDeclarator()
                        ?.identifier()
                        ?.text
                    val formalParams = ctx
                        .typeDeclaratorList()
                        ?.typeDeclarator()
                        ?.get(0)
                        ?.directDeclarator()
                        ?.blockParameters()
                        ?.typeVariableDeclaratorOrName()
                        ?.filter { it.typeName()?.text != "void" } // void类型, 不占用参数
                        ?.mapNotNull { it.typeVariableDeclarator() }
                        ?.mapIndexed { index, it ->
                            val argName = it.declarator().text
                                .depointer()
                                .removeObjcSpecifier()
                                .run { ifEmpty { "__arg${index}__" } }
                            val argType = it.declarationSpecifiers()
                                .text
                                .run { if (it.declarator().text.startsWith("*")) enpointer() else this }
                                .objcSpecifierExpand()
                            Parameter(
                                variable = Variable(argType, argName, Platform.iOS),
                                platform = Platform.iOS
                            )
                        }

                    if (returnType != null && typeName != null) {
                        type.typeType = TypeType.Lambda
                        type.isPublic = true
                        type.isAbstract = false
                        type.name = typeName
                        type.isStaticType = true
                        type.returnType = returnType
                        type.formalParams = formalParams ?: listOf()
                        type.platform = Platform.iOS
                    }
                }
            })
        } else {
            type.platform = platform
            type.typeType = TypeType.Alias
            type.name = item.contentOf("name")
            type.aliasOf = aliasOf
        }

        resultList.add(type)
    }

    return resultList
}

/**
 * 枚举类型
 */
fun CompoundDef.enums(): List<Type> {
    val resultList = mutableListOf<Type>()

    val compound = this[compounddef]!!

    compound.setupEnv()

    // 形如typedef enum { ... }
    // 参考示例
    // <memberdef kind="enum" id="_b_m_k_types_8h_1a1c0ca878c2fe5e5594b6cf781f6a88e1" prot="public" static="no" strong="no">
    //   <type></type>
    //   <name>BMKMapModule</name>
    //   <enumvalue id="_b_m_k_types_8h_1a1c0ca878c2fe5e5594b6cf781f6a88e1a3824e71525102346965f54f4b7e78691" prot="public">
    //     <name>BMKMapModuleTile</name>
    //     <initializer>= 0</initializer>
    //     <briefdescription></briefdescription>
    //     <detaileddescription></detaileddescription>
    //   </enumvalue>
    //   <enumvalue id="_b_m_k_types_8h_1a1c0ca878c2fe5e5594b6cf781f6a88e1a92e64c2b6f07e53e0762889b4a6f9c17" prot="public">
    //     <name>BMKMapModuleBasic</name>
    //     <briefdescription></briefdescription>
    //     <detaileddescription></detaileddescription>
    //   </enumvalue>
    //   <briefdescription></briefdescription>
    //   <detaileddescription></detaileddescription>
    //   <inbodydescription></inbodydescription>
    //   <location file="sdk/ios/BaiduMapKit/BaiduMapKit/BaiduMapAPI_Base.framework/Headers/BMKTypes.h" line="16" column="1" bodyfile="sdk/ios/BaiduMapKit/BaiduMapKit/BaiduMapAPI_Base.framework/Headers/BMKTypes.h" bodystart="16" bodyend="19" />
    // </memberdef>
    val enums = compound
        .listBy("sectiondef")
        .find { it("kind") == "enum" }
        ?.listBy("memberdef")
        ?.filter { it("kind") == "enum" }
        ?.filterNot { it.contentOf("name").startsWith("@") }

    enums?.let {
        for (item in it) { // memberdef
            val type = Type()
            type.name = item["name"]!!.textContent
            type.typeType = TypeType.Enum
            type.platform = platform

            val valueList = item.listBy("enumvalue")
            val firstValue = valueList.first()
                .contentOf("initializer")
                .replace("=", "")
                .pack()
                .toIntOrNull() ?: 0
            for ((index, entry) in valueList.withIndex()) {
                val name = entry["name"]!!.textContent
                val value = entry.contentOf("initializer").run {
                    // 如果枚举有值, 就直接拿值
                    if (isNotBlank()) {
                        replace("=", "").pack()
                    }
                    // 否则取第一个枚举的值+当前索引
                    else {
                        "${firstValue + index}"
                    }
                }
                type.enumerators.add(Enumerator(name, value))
            }

            resultList.add(type)
        }
    }

    return resultList
}

/**
 * 普通类型
 */
fun CompoundDef.types(): List<Type> {
    val resultList = mutableListOf<Type>()

    for (item in listBy(compounddef)) {
        resultList.add(item.type())
    }

    return resultList
}

/**
 * 从compounddef解析类型数据
 */
private fun CompoundDef.type(): Type {
    setupEnv()

    val result = Type()

    result.name = typeName()
//    result.aliasOf = getString(compoundname) // TODO
//    result.declaredGenericTypes = getString(compoundname) // TODO
//    result.definedGenericTypes = getString(compoundname) // TODO

    result.typeType = when (language) {
        java -> when (this("kind")) {
            "class" -> TypeType.Class
            "interface" -> TypeType.Interface
            "enum" -> TypeType.Enum
            else -> TypeType.Class
        }
        objc, cpp -> when (this("kind")) {
            "interface" -> TypeType.Class
            "protocol" -> TypeType.Interface
            "enum" -> TypeType.Enum
            "struct" -> TypeType.Struct
            "category" -> TypeType.Extension
            else -> TypeType.Class
        }
        else -> TypeType.Class
    }

    result.platform = platform
    result.isPublic = this("prot") == "public"
    result.isAbstract = this("abstract") == "yes" || result.typeType == TypeType.Interface
//    result.isInnerType = optString("abstract") == "yes" // TODO
//    result.isStaticType = optString("abstract") == "yes" // TODO

    // 基类 包含父类和接口
    result.superClass = superType()
    result.interfaces.addAll(interfaces())

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
        for (item in it) { // memberdef
            val type = item.contentOf("type").pack()
            val isFinal = type.contains("final") || item("writable") == "no"
            val isStatic = item("static") == "yes"
            val varItem = Variable(
                typeName = type,
                name = item.contentOf("name"),
                platform = platform,
            )
            val field = Field(
                isPublic = true,
                isFinal = isFinal,
                isStatic = isStatic,
                variable = varItem,
                className = typeName(),
                getterName = item.contentOf("read").ifBlank { varItem.name },
                setterName = item.contentOf("write").ifBlank { varItem.name },
                platform = platform,
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
        .filter { it("kind").isOneOf("public-func", "public-static-func") }
        .flatMap { it.listBy("memberdef") }
        .filter { it("kind") == "function" }

    methods.let {
        for (item in it) { // memberdef
            val returnType = item.refTypeName()
            val name = item.contentOf("name").split(":").first()
            val isStatic = item("static") == "yes"
            val isAbstract = item("abstract") == "yes"
            val method = Method(
                returnType = returnType,
                name = name,
                isStatic = isStatic,
                isAbstract = isAbstract,
                className = typeName(),
                platform = platform,
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
                platform = platform,
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

    for (node in listBy("param")) { // param
        val type = node.refTypeName()
        val name = node.contentOf("declname")

        if (type == "void") continue

        val item = Parameter(
            variable = Variable(typeName = type, name = name, platform = platform),
            named = node.contentOf("attributes").deSquareBracket(),
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
private fun CompoundDef.typeName(): String {
    val typeText = this[compoundname]?.textContent ?: ""
    return typeText
        .replace("::", ".") // java类名调整
        .replace("-p", "") // objc不明原因多出-p后缀
        .run {
            if (contains("(") && contains(")")) {
                substring(typeText.indexOf("(") + 1, typeText.lastIndexOf(")"))
            } else {
                this
            }
        }
}

private fun CompoundDef.superType(): String {
    val typeName = contentOf("compoundname")
    // oc分类
    return if (typeName.run { contains("(") && contains(")") }) {
        typeName.substringBefore("(")
    }
    // 普通父类
    else {
        val baseTypes = listBy("basecompoundref")
        baseTypes
            .firstOrNull()
            ?.textContent
            ?.deAngleBracket()
            ?: objectType
    }

}

private fun CompoundDef.interfaces(): List<String> {
    val baseTypes = listBy("basecompoundref")
    return if (baseTypes.size > 1) {
        baseTypes
            .drop(1)
            .map { it.textContent.deAngleBracket() }
            .reversed()
    } else {
        listOf()
    }
}

/**
 * 上下文赋值
 */
private fun CompoundDef.setupEnv() {
    // 上下文赋值
    language = this("language")
    objectType = when (language) {
        java -> "java.lang.Object"
        objc, cpp -> "NSObject"
        else -> ""
    }
    platform = when (language) {
        java -> Platform.Android
        objc, cpp -> Platform.iOS
        else -> Platform.Unknown
    }
}

/**
 * 引用类型名称
 */
private fun TypeDef.refTypeName(): String {
    return if (platform == Platform.Android) {
        val refId = this["type"]?.get("ref")?.invoke("refid")
        if (refId == null) {
            this.contentOf("type")
        } else {
            val fragments = refId.split("_1_1")
            val packageName = fragments.dropLast(1)
                .joinToString(".")
                .removePrefix("class")
                .removePrefix("interface")
            val className = fragments.last().underscore2Camel()

            "$packageName.$className"
        }
    } else {
        this.contentOf("type")
    }.pack().removeObjcSpecifier().removePrefix("final")
}