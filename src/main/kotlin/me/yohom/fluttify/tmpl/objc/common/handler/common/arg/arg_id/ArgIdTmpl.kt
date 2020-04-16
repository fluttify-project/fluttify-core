package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_id

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// id arg
//id #__name__#;
//// jsonable
//if ([#__name__# isKindOfClass:[NSNumber class]] || [#__name__# isKindOfClass:[NSString class]] || [#__name__# isKindOfClass:[NSArray class]] || [#__name__# isKindOfClass:[NSDictionary class]]) {
//    #__name__# = args[@"#__name__#"];
//}
//// non jsonable
//else {
//    #__name__# = HEAP[@([args[@"#__name__#"] integerValue])];
//}
private val tmpl = getResource("/tmpl/objc/arg_id.stmt.m.tmpl").readText()

fun ArgIdTmpl(variable: Variable): String {
    val argName = variable.name
    return tmpl.replace("#__name__#", argName)
}