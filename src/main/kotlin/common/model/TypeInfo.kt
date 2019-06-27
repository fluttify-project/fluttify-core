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
    open val methods: List<Method>,

    /**
     * 是否是model类
     */
    open var isModel: Boolean?,

    /**
     * 是否是回调类
     */
    open var isCallback: Boolean?,

    /**
     * 是否是枚举类
     */
    open var isEnum: Boolean?,

    /**
     * 是否是接口类
     */
    open var isInterface: Boolean?
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
    override val methods: List<Method>,
    override var isModel: Boolean? = null,
    override var isCallback: Boolean? = null,
    override var isEnum: Boolean? = null,
    override var isInterface: Boolean? = null
) : TypeInfo(name, path, fields, methods, isModel, isCallback, isEnum, isInterface)

/**
 * Objc类信息
 */
data class ObjcTypeInfo(
    override val name: String,
    override val path: String,
    override val fields: List<Variable>,
    override val methods: List<Method>,
    override var isModel: Boolean? = null,
    override var isCallback: Boolean? = null,
    override var isEnum: Boolean? = null,
    override var isInterface: Boolean? = null
) : TypeInfo(name, path, fields, methods, isModel, isCallback, isEnum, isInterface)