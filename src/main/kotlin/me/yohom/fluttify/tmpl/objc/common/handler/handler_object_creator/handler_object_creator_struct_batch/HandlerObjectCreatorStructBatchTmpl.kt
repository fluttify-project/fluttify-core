package me.yohom.fluttify.tmpl.objc.common.handler.handler_object_creator.handler_object_creator_struct_batch

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Type

//@"#__method_name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, id argsBatch, FlutterResult methodResult) {
//    NSMutableArray<#__result_type__#>* resultList = [NSMutableArray array];
//
//    for (int i = 0; i < [(NSNumber*) ((NSDictionary<NSString*, NSObject*>) argsBatch)[@"length"] integerValue]; i++) {
//        #__type_name__# data;
//
//        NSValue* dataValue = [NSValue value:&data withObjCType:@encode(#__type_name__#)];
//        HEAP[@(dataValue.hash)] = dataValue;
//
//        resultList.add(@(dataValue.hash));
//    }
//
//    methodResult(resultList);
//
//    if (enableLog) NSLog(@"HEAP: %@", HEAP);
//},
private val tmpl = getResource("/tmpl/objc/handler_object_creator_struct_batch.stmt.m.tmpl").readText()

fun HandlerObjectFactoryStructBatchTmpl(type: Type): String {
    return tmpl
        .replace("#__method_name__#", "ObjectFactory::create_batch${type.name}")
        .replace("#__type_name__#", type.name)
}