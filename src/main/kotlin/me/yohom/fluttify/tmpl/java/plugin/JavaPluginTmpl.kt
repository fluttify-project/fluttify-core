package me.yohom.fluttify.tmpl.java.plugin

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.tmpl.java.plugin.register_handler.RegisterHandlerTmpl
import me.yohom.fluttify.tmpl.java.plugin.register_platform_view.RegisterPlatformViewTmpl
import java.io.File

//package #__package_name__#;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.app.Activity;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import androidx.annotation.NonNull;
//import io.flutter.embedding.engine.plugins.FlutterPlugin;
//import io.flutter.embedding.engine.plugins.activity.ActivityAware;
//import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
//import io.flutter.plugin.common.BinaryMessenger;
//import io.flutter.plugin.common.MethodCall;
//import io.flutter.plugin.common.MethodChannel;
//import io.flutter.plugin.common.PluginRegistry.Registrar;
//import io.flutter.plugin.platform.PlatformViewRegistry;
//
//import #__package_name__#.sub_handler.*;
//import #__package_name__#.sub_handler.custom.SubHandlerCustom;
//
//import static me.yohom.foundation_fluttify.FoundationFluttifyPluginKt.getEnableLog;
//import static me.yohom.foundation_fluttify.FoundationFluttifyPluginKt.getHEAP;
//
//@SuppressWarnings("ALL")
//public class #__plugin_name__#Plugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
//
//    private static List<Map<String, Handler>> handlerMapList;
//
//    // v1 android embedding for compatible
//    public static void registerWith(Registrar registrar) {
//        final MethodChannel channel = new MethodChannel(registrar.messenger(), "#__method_channel__#");
//
//        #__plugin_name__#Plugin plugin = new #__plugin_name__#Plugin();
//
//        BinaryMessenger messenger = registrar.messenger();
//        PlatformViewRegistry platformViewRegistry = registrar.platformViewRegistry();
//        Activity activity = registrar.activity();
//
//        plugin.messenger = messenger;
//        plugin.platformViewRegistry = platformViewRegistry;
//
//        handlerMapList = new ArrayList<>();
//        #__register_handler__#
//        handlerMapList.add(SubHandlerCustom.getSubHandler(messenger));
//
//        channel.setMethodCallHandler(plugin);
//
//        // register platform view
//        #__register_platform_views__#
//    }
//
//    private BinaryMessenger messenger;
//    private PlatformViewRegistry platformViewRegistry;
//
//    // v2 android embedding
//    @Override
//    public void onAttachedToEngine(FlutterPluginBinding binding) {
//        if (getEnableLog()) {
//            Log.d("fluttify-java", "#__plugin_name__#Plugin::onAttachedToEngine@" + binding);
//        }
//
//        final MethodChannel channel = new MethodChannel(binding.getBinaryMessenger(), "#__method_channel__#");
//
//        messenger = binding.getBinaryMessenger();
//        platformViewRegistry = binding.getPlatformViewRegistry();
//
//        handlerMapList = new ArrayList<>();
//        #__register_handler__#
//        handlerMapList.add(SubHandlerCustom.getSubHandler(messenger));
//
//        channel.setMethodCallHandler(this);
//    }
//
//    @Override
//    public void onDetachedFromEngine(FlutterPluginBinding binding) {
//        if (getEnableLog()) {
//            Log.d("fluttify-java", "#__plugin_name__#Plugin::onDetachedFromEngine@" + binding);
//        }
//    }
//
//    @Override
//    public void onAttachedToActivity(ActivityPluginBinding binding) {
//        if (getEnableLog()) {
//            Log.d("fluttify-java", "#__plugin_name__#Plugin::onAttachedToActivity@" + binding);
//        }
//        Activity activity = binding.getActivity();
//
//        // register platform view
//        #__register_platform_views__#
//    }
//
//    @Override
//    public void onDetachedFromActivity() {
//        if (getEnableLog()) {
//            Log.d("fluttify-java", "#__plugin_name__#Plugin::onDetachedFromActivity");
//        }
//    }
//
//    @Override
//    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
//        if (getEnableLog()) {
//            Log.d("fluttify-java", "#__plugin_name__#Plugin::onReattachedToActivityForConfigChanges@" + binding);
//        }
//    }
//
//    @Override
//    public void onDetachedFromActivityForConfigChanges() {
//        if (getEnableLog()) {
//            Log.d("fluttify-java", "#__plugin_name__#Plugin::onDetachedFromActivityForConfigChanges");
//        }
//    }
//
//    @Override
//    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result methodResult) {
//        Handler handler = null;
//        for (Map<String, Handler> handlerMap : handlerMapList) {
//            if (handlerMap.containsKey(methodCall.method)) {
//                handler = handlerMap.get(methodCall.method);
//                break;
//            }
//        }
//        if (handler != null) {
//            try {
//                handler.call(methodCall.arguments, methodResult);
//            } catch (Exception e) {
//                e.printStackTrace();
//                methodResult.error(e.getMessage(), null, null);
//            }
//        } else {
//            methodResult.notImplemented();
//        }
//    }
//
//    @FunctionalInterface
//    public static interface Handler {
//        void call(Object args, MethodChannel.Result methodResult) throws Exception;
//    }
//}
private val tmpl by lazy { getResource("/tmpl/java/plugin.java.tmpl").readText() }

fun JavaPluginTmpl(libs: List<Lib>, subHandlerOutputDir: String): String {
    // 包名
    val packageName = "${ext.org}.${ext.projectName}"

    // 插件名称
    val pluginClassName = ext.projectName.underscore2Camel(true)

    // method channel
    val methodChannel = "${ext.org}/${ext.projectName}"

    val subHandlerDir = File(subHandlerOutputDir)
    val registerHandler = if (subHandlerDir.exists()) {
        subHandlerDir
            .list { _, name -> name?.contains("custom") != true }
            ?.mapIndexed { index, _ -> RegisterHandlerTmpl(index) }
            ?.joinToString("\n") ?: ""
    } else {
        ""
    }

    // 注册PlatformView
    val registerPlatformViews = libs
        .flatMap { it.types }
        .filter { it.isView }
        .joinToString("\n") { RegisterPlatformViewTmpl(it) }

    return tmpl
        .replace("#__package_name__#", packageName)
        .replace("#__plugin_name__#", pluginClassName)
        .replace("#__method_channel__#", methodChannel)
        .replaceParagraph("#__register_handler__#", registerHandler)
        .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
}