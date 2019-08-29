package me.yohom.fluttify.common.tmpl.kotlin.plugin.handler

import me.yohom.fluttify.common.extensions.toUnderscore
import me.yohom.fluttify.common.model.Type

//"ObjectFactory::create#__creator_name__#" to { registrar, args, methodResult ->
//    // 创建对象
//    val obj = #__class_name__#()
//    REF_MAP[obj.hashCode()] = obj
//
//    methodResult.success(obj.hashCode())
//}
internal class ObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/object_factory.stmt.kt.tmpl").readText()

    fun kotlinObjectFactory(): String {
        return tmpl
            .replace("#__creator_name__#", type.name.toUnderscore())
            .replace("#__class_name__#", type.name)
    }
}