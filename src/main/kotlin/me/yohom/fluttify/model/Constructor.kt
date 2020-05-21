package me.yohom.fluttify.model

import me.yohom.fluttify.NEXT_ID
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
    override var platform: Platform,
    override var id: Int = NEXT_ID
) : IPlatform, IScope, IElement {
    /**
     * 一个类中可能有多个构造器, 这个过滤是过滤出可以使用的构造器.
     * 区分于Type类的constructable方法, 这个方法是判断一个类是否含有可以使用的构造器.
     */
    val filter: Boolean get() {
        return must("必须是公开构造器") { isPublic }
                &&
                (must("构造器没有参数") { formalParams.isEmpty() }
                        ||
                        formalParams.all {
                            // jsonable的
                            it.variable.must("是jsonable") { jsonable() }
                                    ||
                                    must("SDK中有其他方法可以返回构造器需要的参数类型的") {
                                        SDK.sdks.flatMap { it.allFilteredMethods }
                                            .map { it.returnType }
                                            .contains(it.variable.trueType)
                                            .apply { println("SDK中有其他方法可以返回构造器需要的参数类型的: $this") }
                                    }
                                    ||
                                    must("参数类型有实体子类(更精确的应该是可构造的子类)") {
                                        it.variable.trueType.findType().hasConcretSubtype
                                    }
                                    ||
                                    must("构造器的参数类型也是可构造的") {
                                        it.variable.trueType.run {
                                            if (isIterable()) {
                                                innermostGenericType().findType().constructable
                                            } else {
                                                findType().constructable
                                            }
                                        }
                                    }
                        })
    }

    fun creatorName(trueType: TYPE_NAME): String {
        return "${trueType.toUnderscore()}${formalParams.joinToString("__", "__") {
            it.variable.trueType.toUnderscore().replace("[]", "Array")
        }}"
    }
}