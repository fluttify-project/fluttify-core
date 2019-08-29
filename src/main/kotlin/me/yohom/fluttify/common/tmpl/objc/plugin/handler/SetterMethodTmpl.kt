package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.isCType
import me.yohom.fluttify.common.extensions.isObjcValueType
import me.yohom.fluttify.common.extensions.toObjcType
import me.yohom.fluttify.common.model.Field

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {
//    #__field_type__# #__field_name__# = (#__field_type__#) args[@"#__field_name__#"];
//
//    NSInteger refId = [args[@"refId"] integerValue];
//    #__class_name__#* ref = (#__class_name__#*) REF_MAP[@(refId)];
//
//    ref.#__setter__# = #__field_value__#;
//    methodResult(@"success");
//},
internal class SetterMethodTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("@\"#__method_name__#\": ^(NSObject <FlutterPluginRegistrar> * registrar, NSDictionary<NSString *, id> * args, FlutterResult methodResult) {\n    #__field_type__# #__field_name__# = (#__field_type__#) args[@\"#__field_name__#\"];\n\n    NSInteger refId = [args[@\"refId\"] integerValue];\n    #__class_name__#* ref = (#__class_name__#*) REF_MAP[@(refId)];\n\n    ref.#__setter__# = #__field_value__#;\n    methodResult(@\"success\");\n},\n").readText()

    fun objcSetter(): String {
        val setter = field.setterName.depointer()
        val fieldName = field.variable.name
        val fieldType = when {
            field.variable.isList -> "List<${field.variable.typeName}>"
            field.variable.typeName.isObjcValueType() -> field.variable.typeName.toObjcType()
            else -> "${field.variable.typeName} *"
        }
        val className = field.className

        return tmpl
            .replace("#__method_name__#", field.setterMethodName())
            .replace("#__setter__#", setter)
            .replace("#__field_name__#", fieldName.depointer())
            .replace("#__field_value__#", fieldName.depointer().run {
                if (field.variable.typeName.isCType()) {
                    "$this.${field.variable.typeName}Value"
                } else {
                    this
                }
            })
            .replace("#__field_type__#", fieldType)
            .replace("#__class_name__#", className)
    }
}