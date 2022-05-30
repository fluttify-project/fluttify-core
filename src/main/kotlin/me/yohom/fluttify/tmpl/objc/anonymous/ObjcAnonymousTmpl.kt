package me.yohom.fluttify.tmpl.objc.anonymous

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.objc.common.callback.callback_method.nonview_callback_method.NonViewCallbackMethodTmpl
import me.yohom.fluttify.tmpl.objc.plugin.register_handler.RegisterHandlerTmpl
import me.yohom.fluttify.tmpl.objc.plugin.register_platform_view.RegisterPlatformViewTmpl
import java.io.File

//#import <Flutter/Flutter.h>
//
//typedef void (^Handler)(NSObject <FlutterPluginRegistrar> *, id, FlutterResult);
//
//@interface #__plugin_name__#Plugin : NSObject<FlutterPlugin>
//
//- (instancetype) initWithFlutterPluginRegistrar: (NSObject <FlutterPluginRegistrar> *) registrar;
//
//@property(nonatomic) NSObject<FlutterPluginRegistrar>* registrar;
//
//@end

//#import "#__plugin_name__#Plugin.h"
//
//typedef void (^Handler)(NSObject <FlutterPluginRegistrar> *, NSDictionary<NSString *, NSObject *> *, FlutterResult);
//
//// Dart端一次方法调用所存在的栈, 只有当MethodChannel传递参数受限时, 再启用这个容器
//extern NSMutableDictionary<NSString*, NSObject*>* STACK;
//// Dart端随机存取对象的容器
//extern NSMutableDictionary<NSString*, NSObject*>* HEAP;
//
//@implementation #__plugin_name__#Plugin {
//  NSObject <FlutterPluginRegistrar> * _registrar;
//  NSDictionary<NSString *, Handler> *_handlerMap;
//}
//
//- (instancetype) initWithFlutterPluginRegistrar: (NSObject <FlutterPluginRegistrar> *) registrar {
//  self = [super init];
//  if (self) {
//    _registrar = registrar;
//    // 处理方法们
//    _handlerMap = @{
//      #__handlers__#
//    };
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
//  NSDictionary<NSString *, id> *args = (NSDictionary<NSString *, id> *) [methodCall arguments];
//
//  if (_handlerMap[methodCall.method] != nil) {
//    _handlerMap[methodCall.method](_registrar, args, methodResult);
//  } else {
//    methodResult(FlutterMethodNotImplemented);
//  }
//}
//
//// 委托方法们
//#__delegate_methods__#
//
//@end
private val hTmpl by lazy { getResource("/tmpl/objc/anonymous.h.tmpl").readText() }
private val mTmpl by lazy { getResource("/tmpl/objc/anonymous.m.tmpl").readText() }

fun ObjcAnonymousTmpl(type: Type): List<String> {
    // 导入头文件
    // 如果没有手动指定的话则拼接出一个
    val importLibrary = ext.ios.iosLibraryHeaders.joinToString("\n")

    val callbackMethods = type
        .methods
        .filterMethod() // 过滤一下方法 Java不能过滤, objc这边没事
        .distinctBy { it.exactName }
        .filter { it.mustNot("参数中含有lambda") { formalParams.any { it.variable.isLambda() } } }
        .filter { it.mustNot("过时方法") { isDeprecated } } // objc这边去掉过时回调方法, dart那边保留也无妨
        .map { NonViewCallbackMethodTmpl(it) }

    return listOf(
        hTmpl
            .replace("#__interface_name__#", type.name)
            .replace("#__import_library__#", importLibrary)
        ,
        mTmpl
            .replace("#__interface_name__#", type.name)
            .replaceParagraph("#__delegate_methods__#", callbackMethods.joinToString("\n"))
    )
}