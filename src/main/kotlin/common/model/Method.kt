package common.model

data class Method(
    val returnType: String,
    val name: String,
    val formalParams: List<Variable>
)