package me.yohom.fluttify.tmpl.objc.common.handler.common.ref.ref_ref

import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//#__type_name__# ref = (#__type_name__#) args[@"__this__"];
//if ((NSNull *) ref == [NSNull null] || ref == nil) {
//    methodResult([FlutterError errorWithCode:@"目标对象为nil" message:@"目标对象为nil" details:@"目标对象为nil"]);
//    return;
//}
private val tmpl by lazy { getResource("/tmpl/objc/ref_ref.stmt.m.tmpl").readText() }

fun RefRefTmpl(method: Method): String {
    val classType = method.className.findType()
    val empty = ""
    val protocol = "id<${method.className}>"
    val `class` = method.className.enpointer()
    val extensionClass = classType.superClass.enpointer()

    if(classType.name=="BMKGeometryExtension")
    println("classType: $classType")

    return when {
        method.isStatic -> empty
        classType.isInterface -> tmpl.replace("#__type_name__#", protocol)
        classType.isExtension -> tmpl.replace("#__type_name__#", extensionClass)
        else -> tmpl.replace("#__type_name__#", `class`)
    }
}