package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.Type
import org.json.JSONArray
import org.json.JSONObject

private const val doxygen = "doxygen"
private const val compounddef = "compounddef"
private const val compoundname = "compoundname"

fun JSONObject.typeList(): List<Type> {
    val compound = getJSONObject(doxygen).get(compounddef)
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

fun JSONObject.type(): Type {
    val result = Type()
    result.name = getString(compoundname)

    return result
}