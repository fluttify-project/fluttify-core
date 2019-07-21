package me.yohom.fluttify.common.model

open class Type(
    /**
     * 全名
     */
    open val name: String
)

/**
 * 类信息 Java类和Objc类公用
 */
data class ClassType(
    /**
     * 全名
     */
    override val name: String,

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
    val fields: List<Field>,

    /**
     * 所有的方法
     */
    val methods: List<Method>
) : Type(name)

/**
 * 类信息 Java类和Objc类公用
 */
data class InterfaceType(
    /**
     * 全名
     */
    override val name: String,

    /**
     * 类文件所在绝对路径
     */
    val path: String,

    /**
     * 父类全名
     */
    val superClass: String,

    /**
     * 所有的方法
     */
    val methods: List<Method>
) : Type(name)

/**
 * 类信息 Java类和Objc类公用
 */
data class EnumType(
    /**
     * 全名
     */
    override val name: String,

    /**
     * 类文件所在绝对路径
     */
    val path: String,

    /**
     * 枚举值
     */
    val constants: List<String>
) : Type(name)

enum class TypeType {
    Class, Enum, Interface, Lambda
}