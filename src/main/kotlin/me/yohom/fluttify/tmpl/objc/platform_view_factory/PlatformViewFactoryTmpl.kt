package me.yohom.fluttify.tmpl.objc.platform_view_factory

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.objc.common.callback.callback_method.view_callback_method.ViewCallbackMethodTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_getter.HandlerGetterTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_method.HandlerMethodTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_setter.HandlerSetterTmpl

//#import "#__native_view__#Factory.h"
//#import "#__plugin__#Plugin.h"
//#import <objc/runtime.h>
//
//// Dart端一次方法调用所存在的栈, 只有当MethodChannel传递参数受限时, 再启用这个容器
//extern NSMutableDictionary<NSString*, NSObject*>* STACK;
//// Dart端随机存取对象的容器
//extern NSMutableDictionary<NSNumber*, NSObject*>* HEAP;
//// 日志打印开关
//extern BOOL enableLog;
//
//@implementation #__native_view__#Factory {
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
//  // 这里用一个magic number调整一下id
//  HEAP[@(2147483647 - _viewId)] = view;
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
//  __weak __typeof(self)weakSelf = self;
//  [channel setMethodCallHandler:^(FlutterMethodCall *methodCall, FlutterResult methodResult) {
//    NSDictionary<NSString *, id> *args = (NSDictionary<NSString *, id> *) [methodCall arguments];
//
//    __strong __typeof(weakSelf)strongSelf = weakSelf;
//    if (strongSelf->_handlerMap[methodCall.method] != nil) {
//      strongSelf->_handlerMap[methodCall.method](strongSelf->_registrar, args, methodResult);
//    } else {
//      methodResult(FlutterMethodNotImplemented);
//    }
//  }];
//  //endregion
//  return view;
//}
//
////region delegate
//#__delegate_methods__#
////endregion
//
//@end
private val hTmpl by lazy { getResource("/tmpl/objc/platform_view_factory.h.tmpl").readText() }
private val mTmpl by lazy { getResource("/tmpl/objc/platform_view_factory.m.tmpl").readText() }

fun PlatformViewFactoryTmpl(viewType: Type, lib: Lib): List<String> {
    // 使用前先合并Category
    viewType.mergeWithCategory()

    // 导入头文件
    // 如果没有手动指定的话则拼接出一个
    val imports = (if (ext.ios.iosImportHeader.isNotEmpty()) ext.ios.iosImportHeader else ext.ios.libDir
        .file()
        .run {
            // 所有的Framework
            val frameworkHeaders = listFiles { _, name -> name.endsWith(".framework") }
                ?.map { "#import <${it.nameWithoutExtension}/${it.nameWithoutExtension}.h>" }
                ?: listOf()
            // 如果没有framework, 那么就遍历出所有的.h文件
            val directHeaders = mutableListOf<String>()
            if (list()?.none { it.endsWith(".framework") } == true) {
                // 所有的.h
                iterate("h") {
                    // 不导入隐藏文件
                    if (!it.name.startsWith(".")) {
                        directHeaders.add("#import \"${it.name}\"")
                    }
                }
            }
            frameworkHeaders.union(directHeaders)
        })
        .joinToString("\n")

    val nativeView = viewType.name
    val protocols = lib
        .types
        .filter { it.isCallback }
        .map { it.name }
        .union(listOf("FlutterPlatformView")) // 补上FlutterPlatformView协议
        .joinToString(", ")

    val plugin = ext.projectName.underscore2Camel()

    val methodHandlers = viewType
        .methods
        .filterMethod()
        .map { HandlerMethodTmpl(it) }

    val getters = viewType
        .fields
        .filterGetters()
        .map { HandlerGetterTmpl(it) }

    val setters = viewType
        .fields
        .filterSetters()
        .map { HandlerSetterTmpl(it) }

    val methodChannel = "${ext.methodChannelName}/${viewType.name.toUnderscore()}"

    val delegateMethods = lib
        .types
        .filter { it.isCallback }
        .flatMap { it.methods }
        .distinctBy { it.exactName }
        .joinToString("\n") { ViewCallbackMethodTmpl(it) }

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
                methodHandlers.union(getters).union(setters).joinToString("\n")
            )
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__delegate_methods__#", delegateMethods)
    )
}