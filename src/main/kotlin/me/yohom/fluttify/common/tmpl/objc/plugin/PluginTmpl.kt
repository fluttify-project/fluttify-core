package me.yohom.fluttify.common.tmpl.objc.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.tmpl.objc.common.delegate_method.DelegateMethodTmpl
import me.yohom.fluttify.common.tmpl.objc.common.handler.*
import me.yohom.fluttify.common.tmpl.objc.plugin.register_platform_view.RegisterPlatformViewTmpl

//#import "#__plugin_name__#Plugin.h"
//
//typedef void (^Handler)(NSObject <FlutterPluginRegistrar> *, NSDictionary<NSString *, NSObject *> *, FlutterResult);
//
//NSMutableDictionary<NSNumber *, NSObject *> *REF_MAP;
//
//@implementation #__plugin_name__#Plugin {
//  NSObject <FlutterPluginRegistrar> * _registrar;
//}
//
//- (instancetype) initWithFlutterPluginRegistrar: (NSObject <FlutterPluginRegistrar> *) registrar {
//  self = [super init];
//  if (self) {
//    _registrar = registrar;
//  }
//
//  return self;
//}
//
//+ (void)registerWithRegistrar:(NSObject <FlutterPluginRegistrar> *)registrar {
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[registrar messenger]];
//
//  [registrar addMethodCallDelegate:[[#__plugin_name__#Plugin alloc] initWithFlutterPluginRegistrar:registrar]
//                           channel:channel];
//
//  // 注册View
//  #__register_platform_views__#
//}
//
//// Method Handlers
//- (void)handleMethodCall:(FlutterMethodCall *)methodCall result:(FlutterResult)methodResult {
//  // 引用Map
//  REF_MAP = @{}.mutableCopy;
//
//  // 处理方法们
//  NSDictionary<NSString *, Handler> *_handlerMap = @{
//    #__handlers__#
//  };
//
//  NSDictionary<NSString *, id> *args = (NSDictionary<NSString *, id> *) [methodCall arguments];
//  if ([@"ObjectFactory::release" isEqualToString:methodCall.method]) {
//    [REF_MAP removeObjectForKey:(NSNumber *) args[@"refId"]];
//    methodResult(@"success");
//  } else if ([@"ObjectFactory::clearRefMap" isEqualToString:methodCall.method]) {
//    [REF_MAP removeAllObjects];
//    methodResult(@"success");
//  } else if ([@"ObjectFactory::createCLLocationCoordinate2D" isEqualToString:methodCall.method]) {
//    CLLocationDegrees latitude = [args[@"latitude"] doubleValue];
//    CLLocationDegrees longitude = [args[@"longitude"] doubleValue];
//
//    CLLocationCoordinate2D data = CLLocationCoordinate2DMake(latitude, longitude);
//
//    NSValue* dataValue = [NSValue value:&data withObjCType:@encode(CLLocationCoordinate2D)];
//    REF_MAP[@(dataValue.hash)] = dataValue;
//
//    methodResult(@(dataValue.hash));
//  } else {
//    if (_handlerMap[methodCall.method] != nil) {
//      _handlerMap[methodCall.method](_registrar, args, methodResult);
//    } else {
//      methodResult(FlutterMethodNotImplemented);
//    }
//  }
//}
//
//// 委托方法们
//#__delegate_methods__#
//
//@end
class PluginTmpl(
    private val libs: List<Lib>,
    private val ext: FluttifyExtension
) {
    private val hTmpl = this::class.java.getResource("/tmpl/objc/plugin.h.tmpl").readText()
    private val mTmpl = this::class.java.getResource("/tmpl/objc/plugin.m.tmpl").readText()

    fun objcPlugin(): List<String> {
        // 插件名称
        val pluginClassName = ext.outputProjectName.underscore2Camel(true)

        // method channel
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        val platformViewHeader = mutableListOf<String>()
        // 注册PlatformView
        val registerPlatformViews = libs
            .flatMap { it.types }
            .filter { it.isView() }
            .onEach { platformViewHeader.add("#import \"${it.name}Factory.h\"") }
            .joinToString("\n") { RegisterPlatformViewTmpl(
                it,
                ext
            ).objcRegisterPlatformView() }

        // 处理方法们 分三种
        // 1. getter handler
        // 2. setter handler
        // 3. 普通方法 handler
        val getterHandlers = libs
            .flatMap { it.types }
            .filterType()
            .filter { !it.isView() } // View相关的逻辑都在PlatformView里了
            .flatMap { it.fields }
            .filterGetters()
            .map { HandlerGetterTmpl(it).objcGetter() }

        val setterHandlers = libs
            .flatMap { it.types }
            .filterType()
            .filter { !it.isView() } // View相关的逻辑都在PlatformView里了
            .flatMap { it.fields }
            .filterSetters()
            .map { HandlerSetterTmpl(it).objcSetter() }

        val methodHandlers = libs
            .flatMap { it.types }
            .filterType()
            .filter { !it.isView() } // View相关的逻辑都在PlatformView里了
            .flatMap { it.methods }
            .filterMethod()
            .map { HandlerMethodTmpl(it).objcHandlerMethod() }

        val typeCastHandlers = libs
            .flatMap { it.types }
            .filterType()
            .distinctBy { it.name }
            .filter { !it.isInterface() && !it.isEnum() && !it.isStruct() }
            .map { HandlerTypeCastTmpl(it).objcTypeCast() }

        val typeCheckHandlers = libs
            .flatMap { it.types }
            .filterType()
            .distinctBy { it.name }
            .filter { !it.isInterface() && !it.isEnum() && !it.isStruct() }
            .map { HandlerTypeCheckTmpl(it).objcTypeCheck() }

        val createObjectHandlers = libs
            .flatMap { it.types }
            .filterType()
            .distinctBy { it.name }
            .filter { !it.isInterface() && !it.isEnum() && !it.isStruct() }
            .map { HandlerObjectFactoryTmpl(it).objcObjectFactory() }

        val callbackMethods = libs
            .flatMap { it.types }
            .filterType()
            .filter { it.isCallback() }
            .flatMap { it.methods }
            .distinctBy { "${it.name}${it.formalParams}" }
            .map { DelegateMethodTmpl(it).objcDelegateMethod() }

        return listOf(
            hTmpl
                .replace("#__imports__#", libs
                    .map { "#import <${it.name}/${it.name}.h>" }
                    .union(platformViewHeader)
                    .joinToString("\n"))
                .replace("#__plugin_name__#", pluginClassName)
                .replace("#__protocols__#", libs
                    .flatMap { it.types }
                    .filter { it.isCallback() }
                    .map { it.name }
                    .union(listOf("FlutterPlugin")) // 补上FlutterPlugin协议
                    .joinToString(", ")),
            mTmpl
                .replace("#__plugin_name__#", pluginClassName)
                .replace("#__method_channel__#", methodChannel)
                .replaceParagraph("#__getter_branches__#", "")
                .replaceParagraph("#__setter_branches__#", "")
                .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
                .replaceParagraph(
                    "#__handlers__#",
                    methodHandlers.union(getterHandlers)
                        .union(setterHandlers)
                        .union(typeCheckHandlers)
                        .union(typeCastHandlers)
                        .union(createObjectHandlers)
                        .joinToString("\n")
                )
                .replaceParagraph(
                    "#__delegate_methods__#",
                    callbackMethods.joinToString("\n")
                )
        )
    }
}