package me.yohom.fluttify.tmpl.objc.platform_view_factory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.objc.common.callback.callback_method.CallbackMethodTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_getter.HandlerGetterTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_method.HandlerMethodTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_setter.HandlerSetterTmpl

//#import <Foundation/Foundation.h>
//#import <Flutter/Flutter.h>
//#__import__#
//
//extern NSMutableDictionary<NSString*, NSObject*> *STACK;
//extern NSMutableDictionary<NSNumber*, NSObject*> *HEAP;
//
//@interface #__native_view__#Factory : NSObject <FlutterPlatformViewFactory>
//- (instancetype)initWithRegistrar:(NSObject <FlutterPluginRegistrar> *)registrar;
//@end
//
//@interface #__native_view__#PlatformView : NSObject <#__protocols__#>
//- (instancetype)initWithViewId:(NSInteger)viewId registrar:(NSObject <FlutterPluginRegistrar> *)registrar;
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
//  HEAP[@(_viewId)] = view;
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
//  [HEAP removeObjectForKey:@(_viewId)];
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
        this::class.java.getResource("/tmpl/objc/platform_view_factory.h.tmpl").readText()
    private val mTmpl =
        this::class.java.getResource("/tmpl/objc/platform_view_factory.m.tmpl").readText()

    fun objcPlatformViewFactory(): List<String> {
        val imports = ext.frameworkDir
            .file()
            .listFiles { _, name -> name.endsWith(".framework") } // 所有的Framework
            ?.flatMap { framework ->
                "${framework}/Headers/"
                    .file()
                    .listFiles { _, name -> name.endsWith(".h") }
                    ?.map { framework to it }
                    ?: listOf()
            }
            ?.joinToString("\n") { "#import <${it.first.nameWithoutExtension}/${it.second.nameWithoutExtension}.h>" }
            ?: ""
        val nativeView = viewType.name
        val protocols = lib
            .types
            .filter { it.isCallback() }
            .map { it.name }
            .union(listOf("FlutterPlatformView")) // 补上FlutterPlatformView协议
            .joinToString(", ")

        val plugin = ext.outputProjectName.underscore2Camel()
        val getterHandlers = viewType
            .fields
            .filterGetters()
            .map { HandlerGetterTmpl(it).objcGetter() }

        val setterHandlers = viewType
            .fields
            .filterSetters()
            .map { HandlerSetterTmpl(it).objcSetter() }

        val methodHandlers = viewType
            .methods
            .filterMethod()
            .map { HandlerMethodTmpl(it).objcHandlerMethod() }

        val methodChannel = "${ext.methodChannelName}/${viewType.name.toUnderscore()}"

        val delegateMethods = lib
            .types
            .filter { it.isCallback() }
            .flatMap { it.methods }
            .distinctBy { it.exactName }
            .joinToString("\n") { CallbackMethodTmpl(it).objcDelegateMethod() }

        return listOf(
            hTmpl
                .replace("#__import__#", imports)
                .replace("#__native_view__#", nativeView)
                .replace("#__protocols__#", protocols)
            ,
            mTmpl
                .replace("#__native_view__#", nativeView)
                .replace("#__plugin__#", plugin)
                .replaceParagraph(
                    "#__handlers__#",
                    methodHandlers.union(getterHandlers).union(setterHandlers).joinToString("\n")
                )
                .replace("#__method_channel__#", methodChannel)
                .replaceParagraph("#__delegate_methods__#", delegateMethods)
        )
    }
}