package me.yohom.fluttify.extensions

import com.google.gson.GsonBuilder

fun Any.id(): Int {
    return hashCode()
}

fun Any.toJson(): String {
    return GsonBuilder().setPrettyPrinting().create().toJson(this)
}