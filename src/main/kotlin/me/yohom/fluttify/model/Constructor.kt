package me.yohom.fluttify.model

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*

data class Constructor(
    /**
     * 构造器名称
     */
    var name: String,
    /**
     * 形参
     */
    var formalParams: List<Parameter>,
    /**
     * 是否公开
     */
    override var isPublic: Boolean,
    override var platform: Platform
) : IPlatform, IScope {
    /**
     * 一个类中可能有多个构造器, 这个过滤是过滤出可以使用的构造器.
     * 区分于Type类的constructable方法, 这个方法是判断一个类是否含有可以使用的构造器.
     */
    fun filter(): Boolean {
        return must("必须是公开构造器") { isPublic }
                &&
                (formalParams.isEmpty() || // 构造器没有参数
                        formalParams.all {
                            // jsonable的
                            it.variable.jsonable() ||
                                    // SDK中有其他方法可以返回构造器需要的参数类型的
                                    SDK.sdks.flatMap { it.allFilteredMethods }.map { it.returnType }
                                        .contains(it.variable.typeName) ||
                                    // 构造器的参数类型也是可构造的
                                    it.variable.typeName.run {
                                        if (isIterable()) {
                                            innermostGenericType().findType().constructable()
                                        } else {
                                            findType().constructable()
                                        }
                                    }
                        })
    }

    fun creatorName(typeName: TYPE_NAME): String {
        return "${typeName.toUnderscore()}${formalParams.joinToString("__", "__") {
            it.variable.typeName.toUnderscore().replace("[]", "Array")
        }}"
    }
}