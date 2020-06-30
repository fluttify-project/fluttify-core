package me.yohom.fluttify.model

data class SourceFile(
    val fileName: String,
    val types: List<Type>,
    val topLevelConstants: List<Variable>
)