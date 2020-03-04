package me.yohom.fluttify.tmpl.objc.plugin

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.tmpl.objc.common.callback.callback_method.CallbackMethodTmpl
import me.yohom.fluttify.tmpl.objc.plugin.register_handler.RegisterHandlerTmpl
import me.yohom.fluttify.tmpl.objc.plugin.register_platform_view.RegisterPlatformViewTmpl
import java.io.File

//#import "#__plugin_name__#Plugin.h"
//
//typedef void (^Handler)(NSObject <FlutterPluginRegistrar> *, NSDictionary<NSString *, NSObject *> *, FlutterResult);
//
//// Dart端一次方法调用所存在的栈, 只有当MethodChannel传递参数受限时, 再启用这个容器
//extern NSMutableDictionary<NSString*, NSObject*>* STACK;
//// Dart端随机存取对象的容器
//extern NSMutableDictionary<NSNumber*, NSObject*>* HEAP;
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
private val hTmpl = getResource("/tmpl/objc/plugin.h.tmpl").readText()
private val mTmpl = getResource("/tmpl/objc/plugin.m.tmpl").readText()

fun ObjcPluginTmpl(libs: List<Lib>, subHandlerOutputDir: String): List<String> {
    // 插件名称
    val pluginClassName = ext.projectName.underscore2Camel(true)

    // method channel
    val methodChannel = "${ext.org}/${ext.projectName}"

    // PlatformView的头文件
    val platformViewHeader = mutableListOf<String>()
    // 注册PlatformView
    val registerPlatformViews = libs
        .flatMap { it.types }
        .filter { it.isView() }
        .onEach { platformViewHeader.add("#import \"${it.name}Factory.h\"") }
        .joinToString("\n") {
            RegisterPlatformViewTmpl(it)
        }

    // 提取所有framework内的头文件
    val imports = ext.ios.libDir
        .file()
        .run {
            val frameworkHeaders = listFiles { _, name -> name.endsWith(".framework") } // 所有的Framework
                ?.flatMap { framework ->
                    "$framework/Headers/"
                        .file()
                        .listFiles { _, name -> name.endsWith(".h") }
                        ?.map { framework to it }
                        ?: listOf()
                }
                ?.map { "#import <${it.first.nameWithoutExtension}/${it.second.nameWithoutExtension}.h>" }
                ?: listOf()
            val directHeaders = listFiles { _, name -> name.endsWith(".h") } // 所有的.h
                ?.map { "#import \"${it.name}\"" }
                ?: listOf()
            frameworkHeaders.union(directHeaders)
        }
        .union(platformViewHeader)
        .joinToString("\n")

    val protocols = libs
        .flatMap { it.types }
        .filter { it.isCallback() }
        .map { it.name }
        .union(listOf("FlutterPlugin")) // 补上FlutterPlugin协议
        .joinToString(", ")

    val callbackMethods = libs
        .flatMap { it.types }
        .filterType()
        .filter { it.isCallback() }
        .flatMap { it.methods }
        .distinctBy { it.exactName }
        .map { CallbackMethodTmpl(it) }

    val subHandlerDir = File(subHandlerOutputDir)
    val registerHandler = if (subHandlerDir.exists()) {
        subHandlerDir
            .list { _, name -> name?.endsWith(".h") == true }
            ?.mapIndexed { index, _ -> RegisterHandlerTmpl(index) }
            ?.joinToString("\n") ?: ""
    } else {
        ""
    }
    val importSubHandler = if (subHandlerDir.exists()) {
        subHandlerDir
            .list { _, name -> name?.endsWith(".h") == true }
            ?.mapIndexed { index, _ -> "#import \"SubHandler/SubHandler$index.h\"" }
            ?.joinToString("\n") ?: ""
    } else {
        ""
    }

    return listOf(
        hTmpl
            .replace("#__imports__#", imports)
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__protocols__#", protocols),
        mTmpl
            .replace("#__import_sub_handlers__#", importSubHandler)
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
            .replaceParagraph("#__register_handler__#", registerHandler)
            .replaceParagraph("#__delegate_methods__#", callbackMethods.joinToString("\n"))
    )
}