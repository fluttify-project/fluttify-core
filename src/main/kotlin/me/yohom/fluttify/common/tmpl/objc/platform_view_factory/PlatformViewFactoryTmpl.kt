package me.yohom.fluttify.common.tmpl.objc.platform_view_factory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.underscore2Camel
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Type
import me.yohom.fluttify.common.tmpl.objc.common.delegate_method.DelegateMethodTmpl
import me.yohom.fluttify.common.tmpl.objc.common.handler.HandlerMethodTmpl

//#import <Foundation/Foundation.h>
//#import <Flutter/Flutter.h>
//#import #__import__#
//
//extern NSMutableDictionary<NSNumber *, NSObject *> *REF_MAP;
//
//@interface #__native_view__#Factory : NSObject <FlutterPlatformViewFactory>
//- (instancetype)initWithRegistrar:(NSObject <FlutterPluginRegistrar> *)registrar;
//@end
//
//@interface #__native_view__#PlatformView : NSObject <#__protocols__#>
//- (instancetype)initWithViewId:(NSInteger)viewId registrar:(NSObject <FlutterPluginRegistrar> *)registrar;
//@end

//#import "#__native_view__#Factory.h"
//#import "#__plugin__#Plugin.h"
//
//typedef void (^Handler)(NSObject <FlutterPluginRegistrar> *, NSDictionary<NSString *, NSObject *> *, FlutterResult);
//
//@implementation #__native_view__#Factory {
//  NSObject <FlutterPluginRegistrar> *_registrar;
//}
//
//- (instancetype)initWithRegistrar:(NSObject <FlutterPluginRegistrar> *)registrar {
//  self = [super init];
//  if (self) {
//    _registrar = registrar;
//  }
//
//  return self;
//}
//
//- (NSObject <FlutterPlatformView> *)createWithFrame:(CGRect)frame viewIdentifier:(int64_t)viewId arguments:(id _Nullable)args {
//  return [[#__native_view__#PlatformView alloc] initWithViewId:viewId registrar:_registrar];
//}
//
//@end
//
//@implementation #__native_view__#PlatformView {
//  NSObject <FlutterPluginRegistrar> *_registrar;
//  NSInteger _viewId;
//  NSDictionary<NSString *, Handler> *_handlerMap;
//}
//
//- (instancetype)initWithViewId:(NSInteger)viewId registrar:(NSObject <FlutterPluginRegistrar> *)registrar {
//  self = [super init];
//  if (self) {
//    _viewId = viewId;
//    _registrar = registrar;
//  }
//
//  return self;
//}
//
//- (UIView *)view {
//  #__native_view__# *view = [[#__native_view__# alloc] init];
//  REF_MAP[@(_viewId)] = view;
//
//  //region handlers
//  _handlerMap = @{
//      #__handlers__#
//  };
//  //endregion
//
//  //region method call handler
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[_registrar messenger]];
//
//  [channel setMethodCallHandler:^(FlutterMethodCall *methodCall, FlutterResult methodResult) {
//    NSDictionary<NSString *, id> *args = (NSDictionary<NSString *, id> *) [methodCall arguments];
//    if (_handlerMap[methodCall.method] != nil) {
//      _handlerMap[methodCall.method](_registrar, args, methodResult);
//    } else {
//      methodResult(FlutterMethodNotImplemented);
//    }
//  }];
//  //endregion
//  return view;
//}
//
//- (void)dealloc {
//  [REF_MAP removeObjectForKey:@(_viewId)];
//}
//
//
////region delegate
//#__delegate_methods__#
////endregion
//
//@end
class PlatformViewFactoryTmpl(
    private val viewType: Type,
    private val lib: Lib,
    private val ext: FluttifyExtension
) {
    private val hTmpl =
        this::class.java.getResource("/tmpl/objc/platform_view_factory/platform_view_factory.h.tmpl").readText()
    private val mTmpl =
        this::class.java.getResource("/tmpl/objc/platform_view_factory/platform_view_factory.m.tmpl").readText()

    fun objcPlatformViewFactory(): List<String> {
        val imports = "<${lib.name}/${lib.name}.h>"
        val nativeView = viewType.name
        val protocols = lib
            .types
            .filter { it.isDelegate() }
            .map { it.name }
            .union(listOf("FlutterPlatformView")) // 补上FlutterPlatformView协议
            .joinToString(", ")

        val plugin = ext.outputProjectName.underscore2Camel()
        val handlers = viewType.methods.joinToString("\n") { HandlerMethodTmpl(it).objcHandlerMethod() }
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}/${viewType.name}"
        val delegateMethods = lib
            .types
            .filter { it.isDelegate() }
            .flatMap { it.methods }
            .distinctBy { "${it.name}${it.formalParams.joinToString()}" }
            .joinToString("\n") { DelegateMethodTmpl(it).objcDelegateMethod() }

        return listOf(
            hTmpl
                .replace("#__import__#", imports)
                .replace("#__native_view__#", nativeView)
                .replace("#__protocols__#", protocols),
            mTmpl
                .replace("#__native_view__#", nativeView)
                .replace("#__plugin__#", plugin)
                .replaceParagraph("#__handlers__#", handlers)
                .replace("#__method_channel__#", methodChannel)
                .replaceParagraph("#__delegate_methods__#", delegateMethods)
        )
    }
}