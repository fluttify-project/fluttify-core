package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.model.Type

//"ObjectFactory::create#__creator_name__#" to { registrar, args, methodResult ->
//    // 参数
//    #__args__#
//
//    // 创建对象
//    val obj = #__class_name__#(#__args_value__#)
//    REF_MAP[obj.hashCode()] = obj
//
//    methodResult.success(obj.hashCode())
//}
internal class ObjectFactoryTmpl(private val type: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/object_factory.stmt.m.tmpl").readText()

    fun objcObjectFactory(): List<String> {
        return listOf()
    }
}