package me.yohom.fluttify.common.model

data class SDK(
    val version: String,
    val name: String,
    val platform: Platform,
    val types: List<Type>
)

enum class Platform {
    iOS, Android
}