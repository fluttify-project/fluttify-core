package me.yohom.fluttify.common.model

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
    val fields: List<Field>,

    /**
     * 所有的方法
     */
    val methods: List<Method>,

    /**
     * 类型的类型(class/enum/interface)
     */
    var typeType: TypeType? = null,

    /**
     * lambda的参数
     */
    val lambdaParams: List<Variable>? = null,

    /**
     * lambda返回类型
     */
    val lambdaReturnType: String? = null
) {
    override fun toString(): String {
        return "Type(name='$name', path='$path', superClass='$superClass', fields=$fields, methods=$methods, typeType=$typeType)"
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda
}