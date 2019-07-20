package me.yohom.fluttify.common.extensions

fun Any.id(): Int {
    return hashCode()
}