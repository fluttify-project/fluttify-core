package me.yohom.fluttify.tmpl.objc.plugin.sub_handler

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*

//#import "#__plugin_name__#Plugin.h"
//
//NS_ASSUME_NONNULL_BEGIN
//
//@interface #__plugin_name__#Plugin (SubHandler#__number__#)
//- (NSDictionary<NSString*, Handler>*) getSubHandler#__number__#;
//@end
//
//#import "SubHandler#__number__#.h"
//#import "FluttifyMessageCodec.h"
//#__import_library__#
//
//// Dart端一次方法调用所存在的栈, 只有当MethodChannel传递参数受限时, 再启用这个容器
//extern NSMutableDictionary<NSString*, NSObject*>* STACK;
//// Dart端随机存取对象的容器
//extern NSMutableDictionary<NSString*, NSObject*>* HEAP;
//// 日志打印开关
//extern BOOL enableLog;
//
//@implementation #__plugin_name__#Plugin (SubHandler#__number__#)
//- (NSDictionary<NSString*, Handler>*) getSubHandler#__number__# {
//    __weak __typeof(self)weakSelf = self;
//    return @{
//        #__handlers__#
//    };
//}
//
//@end
private val hTmpl by lazy { getResource("/tmpl/objc/sub_handler.h.tmpl").readText() }
private val mTmpl by lazy { getResource("/tmpl/objc/sub_handler.m.tmpl").readText() }

fun SubHandlerTmpl(number: Int, handlers: List<String>): List<String> {
    // 编号
    val numberString = number.toString()
    val subHandler = handlers.joinToString("\n")
    val pluginName = ext.projectName.underscore2Camel(true)
    val importLibrary = ext.ios.iosLibraryHeaders.joinToString("\n")

    return listOf(
        hTmpl
            .replace("#__number__#", numberString)
            .replace("#__plugin_name__#", pluginName),
        mTmpl
            .replace("#__number__#", numberString)
            .replace("#__import_library__#", importLibrary)
            .replace("#__plugin_name__#", pluginName)
            .replaceParagraph("#__handlers__#", subHandler)
    )
}