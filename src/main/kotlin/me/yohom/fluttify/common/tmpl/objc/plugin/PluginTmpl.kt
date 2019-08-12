package me.yohom.fluttify.common.tmpl.objc.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod.GetterMethodTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod.HandleMethodTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod.SetterMethodTmpl

//#import "#__plugin_name__#Plugin.h"
//#__imports__#
//
//typedef void (^Handler)(NSObject <FlutterPluginRegistrar> *, NSDictionary<NSString *, NSObject *> *, FlutterResult);
//
//NSMutableDictionary<NSNumber *, NSObject *> *REF_MAP;
//
//@implementation #__plugin_name__#Plugin {
//  NSObject <FlutterPluginRegistrar> *_flutterPluginRegistrar;
//  NSDictionary<NSString *, Handler> *_handlerMap;
//}
//
//+ (void)registerWithRegistrar:(NSObject <FlutterPluginRegistrar> *)registrar {
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"amap_base_flutter"
//            binaryMessenger:[registrar messenger]];
//  #__plugin_name__#Plugin *instance = [[#__plugin_name__#Plugin alloc] initWithFlutterPluginRegistrar:registrar];
//  [registrar addMethodCallDelegate:instance channel:channel];
//
//  // 注册View
//  #__register_platform_views__#
//}
//
//- (instancetype)initWithFlutterPluginRegistrar:(NSObject <FlutterPluginRegistrar> *)flutterPluginRegistrar {
//  self = [super init];
//  if (self) {
//    _flutterPluginRegistrar = flutterPluginRegistrar;
//
//    REF_MAP = @{}.mutableCopy;
//
//    _handlerMap = @{
//         #__handlers__#
//    };
//  }
//
//  return self;
//}
//
//- (void)handleMethodCall:(FlutterMethodCall *)methodCall methodResult:(FlutterResult)methodResult {
//  NSDictionary<NSString *, NSObject *> *args = (NSDictionary<NSString *, NSObject *> *) [methodCall arguments];
//  if ([@"SystemRef::release" isEqualToString:methodCall.method]) {
//    [REF_MAP removeObjectForKey:(NSNumber *) args[@"refId"]];
//    methodResult(@"success");
//  } else if ([@"SystemRef::clearRefMap" isEqualToString:methodCall.method]) {
//    [REF_MAP removeAllObjects];
//    methodResult(@"success");
//  } else {
//    if (_handlerMap[methodCall.method] != nil) {
//      _handlerMap[methodCall.method](_flutterPluginRegistrar, args, methodResult);
//    } else {
//      methodResult(FlutterMethodNotImplemented);
//    }
//  }
//}
//
//@end
class PluginTmpl(
    private val libs: List<Lib>,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin.m.tmpl").readText()

    fun objcPlugin(): String {
        // 插件名称
        val pluginClassName = ext.outputProjectName.underscore2Camel(true)

        // method channel
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        // 注册PlatformView
        val registerPlatformViews = libs
            .flatMap { it.types }
            .filter { it.isView() }
            .joinToString("\n") { RegisterPlatformViewTmpl(it, ext).objcRegisterPlatformView() }

        // 处理方法们 分三种
        // 1. getter handler
        // 2. setter handler
        // 3. 普通方法 handler
        val getterHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.fields }
            .filterGetters()
            .map { GetterMethodTmpl(it).objcGetter() }

        val setterHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { SetterMethodTmpl(it).objcSetter() }

        val methodHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { HandleMethodTmpl(it).objcHandlerMethod() }

        return tmpl
            .replace("#__imports__#", libs.joinToString("\n") { "#include <${it.name}/${it.name}.h>" })
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getter_branches__#", "")
            .replaceParagraph("#__setter_branches__#", "")
            .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
            .replaceParagraph(
                "#__handlers__#",
                methodHandlers.union(getterHandlers).union(setterHandlers).joinToString("\n")
            )
    }
}