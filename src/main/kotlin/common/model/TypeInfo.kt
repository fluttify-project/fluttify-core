package common.model

import common.TYPE_NAME

/**
 * 类信息 Java类和Objc类公用
 */
abstract class TypeInfo(
    /**
     * 全名 包含包名
     */
    open val name: String,

    /**
     * 类文件所在绝对路径
     */
    open val path: String,

    /**
     * 所有的字段
     */
    open val fields: List<Variable>,

    /**
     * 所有的方法
     */
    open val methods: List<Method>
)

/**
 * Java类信息
 */
data class JavaTypeInfo(
    override val name: String,

    /**
     * 去除包名的类名
     */
    val simpleName: TYPE_NAME,

    override val path: String,
    override val fields: List<Variable>,
    override val methods: List<Method>
) : TypeInfo(name, path, fields, methods)

/**
 * Objc类信息
 */
data class ObjcTypeInfo(
    override val name: String,
    override val path: String,
    override val fields: List<Variable>,
    override val methods: List<Method>
) : TypeInfo(name, path, fields, methods)