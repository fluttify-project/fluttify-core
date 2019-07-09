package common.model

data class Method(
    val returnType: String,
    val name: String,
    val formalParams: List<Variable>,
    val isStatic: Boolean,
    val isAbstract: Boolean?
) {
    fun toDartString(): String {
        // 这个方法是否只有由接口转lambda的时候才使用?如果是的话, 那么返回类型一律是void
        return if (isAbstract == true) {
            "void $name(${formalParams.joinToString { it.toDartString() }})"
        } else {
            "void $name(${formalParams.joinToString { it.toDartString() }})"
        }
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract)"
    }
}