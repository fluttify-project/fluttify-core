package me.yohom.fluttify.tmpl.objc.plugin.sub_handler

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.underscore2Camel

//#import "#__plugin_name__#Plugin.h"
//
//NS_ASSUME_NONNULL_BEGIN
//
//@interface #__plugin_name__#Plugin (SubHandler#__number__#)
//- (NSDictionary<NSString*, Handler>*) getSubHandler#__number__#;
//@end
//
//NS_ASSUME_NONNULL_END
//
//
//#import "#__plugin_name__#Plugin+SubHandler#__number__#.h"
//
//@implementation #__plugin_name__#Plugin (SubHandler#__number__#)
//- (NSDictionary<NSString*, Handler>*) getSubHandler#__number__# {
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

    return listOf(
        hTmpl
            .replace("#__number__#", numberString)
            .replace("#__plugin_name__#", pluginName),
        mTmpl
            .replace("#__number__#", numberString)
            .replace("#__plugin_name__#", pluginName)
            .replaceParagraph("#__handlers__#", subHandler)
    )
}