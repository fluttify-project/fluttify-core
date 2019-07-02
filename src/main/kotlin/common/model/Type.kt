package common.model

/**
 * 类信息 Java类和Objc类公用
 */
class Type(
    /**
     * 全名
     */
    val name: String,

    /**
     * 类文件所在绝对路径
     */
    val path: String,

    /**
     * 父类全名
     */
    val superClass: String,

    /**
     * 所有的字段
     */
    val fields: List<Variable>,

    /**
     * 所有的方法
     */
    val methods: List<Method>,

    /**
     * 类型的类型(class/enum/interface)
     */
    var typeType: TypeType? = null
)

enum class TypeType {
    Class, Enum, Interface
}