package me.yohom.fluttify.common.model

data class Field(
    val isPublic: Boolean?,
    val isFinal: Boolean?,
    val isStatic: Boolean?,
    val variable: Variable?,
    val className: String
)