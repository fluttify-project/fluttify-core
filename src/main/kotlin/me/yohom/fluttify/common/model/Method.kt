package me.yohom.fluttify.common.model

data class Method(
    val returnType: String,
    val name: String,
    val formalParams: List<Variable>,
    val isStatic: Boolean,
    val isAbstract: Boolean?
)