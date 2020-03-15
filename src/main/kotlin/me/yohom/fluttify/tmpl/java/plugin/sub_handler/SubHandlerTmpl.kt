package me.yohom.fluttify.tmpl.java.plugin.sub_handler

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.underscore2Camel

//package #__package_name__#;
//
//import android.os.Bundle;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import androidx.annotation.NonNull;
//import io.flutter.embedding.engine.plugins.FlutterPlugin;
//import io.flutter.plugin.common.BinaryMessenger;
//import io.flutter.plugin.common.MethodCall;
//import io.flutter.plugin.common.MethodChannel;
//import io.flutter.plugin.common.PluginRegistry.Registrar;
//import io.flutter.plugin.platform.PlatformViewRegistry;
//
//import static me.yohom.foundation_fluttify.FoundationFluttifyPluginKt.getEnableLog;
//import static me.yohom.foundation_fluttify.FoundationFluttifyPluginKt.getHEAP;
//
//@SuppressWarnings("ALL")
//public class SubHandler#__number__# {
//    public static final Map<String, Handler> subHandlerMap = new HashMap<String, Handler>() {{
//        #__handlers__#
//    }};
//
//    static {
//        #__plugin_name__#Plugin.registerSubHandler(subHandlerMap);
//    }
//
//}
private val tmpl = getResource("/tmpl/java/sub_handler.java.tmpl").readText()

fun SubHandlerTmpl(number: Int, handlers: List<String>): String {
    // 包名
    val packageName = "${ext.org}.${ext.projectName}"
    // 编号
    val numberString = number.toString()
    val subHandler = handlers.joinToString("\n")
    val pluginName = ext.projectName.underscore2Camel(true)

    return tmpl
        .replace("#__package_name__#", packageName)
        .replace("#__number__#", numberString)
        .replaceParagraph("#__handlers__#", subHandler)
        .replace("#__plugin_name__#", pluginName)
}