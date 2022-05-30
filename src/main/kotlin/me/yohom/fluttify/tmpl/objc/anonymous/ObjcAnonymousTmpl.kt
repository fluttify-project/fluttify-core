package me.yohom.fluttify.tmpl.objc.anonymous

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.objc.common.callback.callback_method.nonview_callback_method.NonViewCallbackMethodTmpl
import me.yohom.fluttify.tmpl.objc.plugin.register_handler.RegisterHandlerTmpl
import me.yohom.fluttify.tmpl.objc.plugin.register_platform_view.RegisterPlatformViewTmpl
import java.io.File

//#import <Foundation/Foundation.h>
//#__import_library__#
//
//@protocol FlutterPluginRegistrar;
//
//NS_ASSUME_NONNULL_BEGIN
//
//@interface #__interface_name__#_Anonymous : NSObject<#__interface_name__#>
//
//- (instancetype) initWithFlutterPluginRegistrar: (NSObject <FlutterPluginRegistrar> *) registrar;
//
//@property(nonatomic) NSObject<FlutterPluginRegistrar>* registrar;
//
//@end
//
//NS_ASSUME_NONNULL_END
//
//#import "#__interface_name__#_Anonymous.h"
//#import <Flutter/Flutter.h>
//#import <FluttifyMessageCodec.h>
//
//// Dart端一次方法调用所存在的栈, 只有当MethodChannel传递参数受限时, 再启用这个容器
//extern NSMutableDictionary<NSString*, NSObject*>* STACK;
//// Dart端随机存取对象的容器
//extern NSMutableDictionary<NSString*, NSObject*>* HEAP;
//// 日志打印开关
//extern BOOL enableLog;
//
//@implementation #__interface_name__#_Anonymous
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