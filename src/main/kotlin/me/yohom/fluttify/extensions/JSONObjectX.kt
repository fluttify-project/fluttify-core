package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.*
import org.json.JSONArray
import org.json.JSONObject

private const val doxygen = "doxygen"
private const val compounddef = "compounddef"
private const val compoundname = "compoundname"
private const val objc = "Objective-C"
private const val java = "Java"

fun JSONObject.topLevelConstants(): List<Variable> {
    // TODO
    return listOf()
}

fun JSONObject.types(): List<Type> {
    val compound = getJSONObject(doxygen).opt(compounddef)
    val resultList = mutableListOf<Type>()

    // 单个类型
    if (compound is JSONObject) {
        resultList.add(compound.type())
    }
    // 一组类型
    else if (compound is JSONArray) {
        for (item in compound) {
            if (item is JSONObject) resultList.add(item.type())
        }
    }

    return resultList
}

/**
 * 从compounddef解析类型数据
 */
fun JSONObject.type(): Type {
    val result = Type()
    result.name = optString(compoundname)
//    result.aliasOf = getString(compoundname) // TODO
//    result.declaredGenericTypes = getString(compoundname) // TODO
//    result.definedGenericTypes = getString(compoundname) // TODO

    val language = optString("language")
    val kind = optString("kind")
    result.typeType = when (language) {
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

    result.platform = platform(language)
    result.isPublic = optString("prot") == "public"
    result.isAbstract = optString("abstract") == "yes"
//    result.isInnerType = optString("abstract") == "yes" // TODO
//    result.isStaticType = optString("abstract") == "yes" // TODO

    // 基类 包含父类和接口
    val baseTypes = forceJSONArray("basecompoundref")
    result.superClass = baseTypes
        .firstOrNull()
        ?.stringContent()
        ?: languageObjectType(language)
    if (baseTypes.size > 1) {
        result.interfaces = baseTypes
            .drop(1)
            .map { it.stringContent() }
            .toMutableList()
    }

    // 属性
    result.fields.addAll(fields())

    return result
}

/**
 * 从compounddef解析变量数据
 */
fun JSONObject.fields(): List<Field> {
    val language = optString("language")
    val resultList = mutableListOf<Field>()

    val variables = forceJSONArray("sectiondef")
        .find { it.optString("kind").isOneOf("public-attrib", "property") }
        ?.forceJSONArray("memberdef")
        ?.filter { it.optString("kind").isOneOf("variable", "property") }

    variables?.run {
        for (variable in variables) {
            val type = variable.get("type").run {
                when (this) {
                    is String -> this
                    // FIXME objc的id<>被忽略调了, 应该加上
                    is JSONObject -> getJSONObject("ref").stringContent()
                    else -> ""
                }
            }
            val isFinal = type.contains("final")
            val isStatic = variable.optString("static") == "yes"
            val varItem = Variable(
                typeName = type,
                name = variable.getString("name"),
                platform = platform(language),
            )
            val field = Field(
                isPublic = true,
                isFinal = isFinal,
                isStatic = isStatic,
                variable = varItem,
                className = optString(compoundname),
                platform = platform(language),
            )
            resultList.add(field)
        }
    }

    return resultList
}

/**
 * 强制以列表方式获取
 */
private fun JSONObject.forceJSONArray(key: String): List<JSONObject> {
    val resultList = mutableListOf<JSONObject>()
    val json = opt(key)

    if (json is JSONObject) {
        resultList.add(json)
    } else if (json is JSONArray) {
        for (item in json) {
            if (item is JSONObject) resultList.add(item)
        }
    }

    return resultList
}

/**
 * 获取xml对应的内容
 */
private fun JSONObject.stringContent() = optString("content")

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