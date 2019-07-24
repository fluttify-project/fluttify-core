package me.yohom.fluttify.common.model

data class Method(
    var returnType: String,
    var name: String,
    var formalParams: List<Variable>,
    var isStatic: Boolean,
    var isAbstract: Boolean?
) {
    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract)"
    }
}