package me.yohom.fluttify.common.tmpl.objc.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.GetterHandlerTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.MethodHandlerTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.handler.SetterHandlerTmpl

//#import "#__plugin_name__#Plugin.h"
//#__imports__#
//
//typedef void (^Handler)(NSObject <FlutterPluginRegistrar> *, NSDictionary<NSString *, NSObject *> *, FlutterResult);
//
//NSMutableDictionary<NSNumber *, NSObject *> *REF_MAP;
//
//@implementation #__plugin_name__#Plugin {
//  NSObject <FlutterPluginRegistrar> *_flutterPluginRegistrar;
//}
//
//+ (void)registerWithRegistrar:(NSObject <FlutterPluginRegistrar> *)registrar {
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[registrar messenger]];
//
//  // 引用Map
//  REF_MAP = @{}.mutableCopy;
//
//  // 处理方法们
//  NSDictionary<NSString *, Handler> *_handlerMap = {
//    #__handlers__#
//  };
//
//  // 处理channel
//  [channel setMethodCallHandler:^(FlutterMethodCall * _Nonnull methodCall, FlutterResult  _Nonnull methodResult) {
//          NSDictionary<NSString *, NSObject *> *args = (NSDictionary<NSString *, NSObject *> *) [methodCall arguments];
//          if ([@"SystemRef::release" isEqualToString:methodCall.method]) {
//              [REF_MAP removeObjectForKey:(NSNumber *) args[@"refId"]];
//              methodResult(@"success");
//          } else if ([@"SystemRef::clearRefMap" isEqualToString:methodCall.method]) {
//              [REF_MAP removeAllObjects];
//              methodResult(@"success");
//          } else {
//              if (_handlerMap[methodCall.method] != nil) {
//                  _handlerMap[methodCall.method](registrar, args, methodResult);
//              } else {
//                  methodResult(FlutterMethodNotImplemented);
//              }
//          }
//      }];
//
//  // 注册View
//  #__register_platform_views__#
//}
//
//@end
class PluginTmpl(
    private val libs: List<Lib>,
    private val ext: FluttifyExtension
) {
    private val mTmpl = this::class.java.getResource("/tmpl/objc/plugin.m.tmpl").readText()

    fun objcPlugin(): String {
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
            .map { GetterHandlerTmpl(it).objcGetter() }

        val setterHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { SetterHandlerTmpl(it).objcSetter() }

        val methodHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { MethodHandlerTmpl(it).objcHandlerMethod() }

        return mTmpl
            .replace("#__imports__#", libs
                .map { "#import <${it.name}/${it.name}.h>" }
                .union(platformViewHeader)
                .joinToString("\n"))
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