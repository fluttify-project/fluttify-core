package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.containerType
import me.yohom.fluttify.extensions.genericTypes
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// list arg
//List<Integer> #__arg_name__#RefIdList = (List<Integer>) ((Map<String, Object>) __args__).get("#__arg_name__#");
//#__type_name__# #__arg_name__# = new ArrayList<>();
//for (int refId : #__arg_name__#RefIdList) {
//    ((ArrayList<#__generic_type_name__#>) #__arg_name__#).add((#__generic_type_name__#) getHEAP().get(refId));
//}
private val tmpl by lazy { getResource("/tmpl/java/arg_list.stmt.java.tmpl").readText() }

fun ArgListTmpl(variable: Variable): String {
    val containerType = variable.trueType.containerType()
    // TODO 对应参数类型是泛型的workaround, 判断类型名长度是否为1, 如果是的话, 则替换为Object, 这个需要后期完善一下
    val genericType = variable.trueType.genericTypes().run {
        if (isNotEmpty() && this[0].length != 1) {
            variable.trueType.genericTypes()[0]
        } else {
            "java.lang.Object"
        }
    }
    val typeName = "$containerType<$genericType>"
    val name = variable.name
    // 只处理非列表和一维列表, 多维列表一律返回一个空的列表
    return if (variable.getIterableLevel() <= 1) {
        tmpl
            .replace("#__type_name__#", typeName.replace("$", "."))
            .replace("#__generic_type_name__#", genericType.replace("$", "."))
            .replace("#__arg_name__#", variable.name)
    } else {
        "${typeName.replace("$", ".")} $name = new ArrayList<>();"
    }
}