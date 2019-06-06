package common.model

open class PackedUnit(
    open val typeType: TypeType,
    open val typeName: String,
    open val methods: List<Method>
)

enum class TypeType {
    Class, Enum, Interface
}

data class JavaUnit(
    override val typeType: TypeType,
    override val typeName: String,
    override val methods: List<Method>,
    val fields: List<Field>
) : PackedUnit(typeType, typeName, methods)