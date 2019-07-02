package common.model

import common.extensions.toDartType

data class Method(
    val returnType: String,
    val name: String,
    val formalParams: List<Variable>,
    val isStatic: Boolean,
    val isAbstract: Boolean
) {
    override fun toString(): String {
        return if (isAbstract) {
            "$returnType $name(${formalParams.joinToString()})"
        } else {
            "$returnType $name(${formalParams.joinToString()})"
        }
    }

    fun toDartString(): String {
        return if (isAbstract) {
            "${returnType.toDartType()} $name(${formalParams.joinToString { it.toDartString() }})"
        } else {
            "${returnType.toDartType()} $name(${formalParams.joinToString { it.toDartString() }})"
        }
    }
}