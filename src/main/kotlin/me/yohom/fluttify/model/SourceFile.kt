package me.yohom.fluttify.model

data class SourceFile(
    val types: List<Type>,
    val topLevelConstants: List<Variable>
)