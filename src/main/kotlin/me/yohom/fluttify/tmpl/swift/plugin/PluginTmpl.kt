package me.yohom.fluttify.tmpl.swift.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.tmpl.swift.plugin.handler.GetterMethodTmpl
import me.yohom.fluttify.tmpl.swift.plugin.handler.HandleMethodTmpl
import me.yohom.fluttify.tmpl.swift.plugin.handler.SetterMethodTmpl

//import Flutter
//import UIKit
//#__imports__#
//
//var HEAP = [Int : Any]()
//
//public class Swift#__plugin_name__#Plugin: NSObject, FlutterPlugin {
//
//    private var registrar: FlutterPluginRegistrar
//
//    init(_ registrar: FlutterPluginRegistrar) {
//        self.registrar = registrar
//    }
//
//    public static func register(with registrar: FlutterPluginRegistrar) {
//        let channel = FlutterMethodChannel(name: "#__method_channel__#", binaryMessenger: registrar.messenger())
//        let instance = Swift#__plugin_name__#Plugin(registrar)
//        registrar.addMethodCallDelegate(instance, channel: channel)
//
//        // 注册View
//        #__register_platform_views__#
//    }
//
//    private let handlerMap: [String : (FlutterPluginRegistrar, Dictionary<String, Any>, FlutterResult) -> Void] = [
//        #__branches__#
//    ]
//
//    public func handle(_ methodCall: FlutterMethodCall, methodResult: @escaping FlutterResult) {
//        let args = methodCall.arguments as? Dictionary<String, Any> ?? [:]
//        switch methodCall.method {
//        // 释放一个对象
//        case "SystemRef::release":
//            HEAP.removeValue(forKey: args["refId"] as! Int)
//            methodResult("success")
//        // 清空HEAP中所有对象
//        case "SystemRef::clearHeap":
//            HEAP.removeAll()
//            methodResult("success")
//        default:
//            handlerMap[methodCall.method]?.self(registrar, args, methodResult) ?? methodResult(FlutterMethodNotImplemented)
//        }
//    }
//}
//
//// 与branch对应的方法们
//#__handlers__#
class PluginTmpl(
    private val libs: List<Lib>,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/plugin.swift.tmpl").readText()

    fun swiftPlugin(): String {
        // 包名 iOS端是不需要的其实
        val packageName = "${ext.outputOrg}.${ext.outputProjectName}"

        // 插件名称
        val pluginClassName = ext.outputProjectName.underscore2Camel(true)

        // method channel
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        // 分支们 分为三种
        // 1. 普通方法
        // 2. getter
        // 3. setter
        val gettersBranches = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.fields }
            .filterGetters()
            .map { GetterBranchTmpl(it).swiftGetterBranch() }

        val settersBranches = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { SetterBranchTmpl(it).swiftSetterBranch() }

        val methodBranches = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { MethodBranchTmpl(it).swiftMethodBranch() }

        // 注册PlatformView
        val registerPlatformViews = libs
            .flatMap { it.types }
            .filter { it.isView() }
            .joinToString("\n") { RegisterPlatformViewTmpl(it, ext).swiftRegisterPlatformView() }

        // 处理方法们 分三种
        // 1. getter handler
        // 2. setter handler
        // 3. 普通方法 handler
        val getterHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.fields }
            .filterGetters()
            .map { GetterMethodTmpl(it).swiftGetter() }

        val setterHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { SetterMethodTmpl(it).swiftSetter() }

        val methodHandlers = libs
            .flatMap { it.types }
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { HandleMethodTmpl(it).swiftHandlerMethod() }

        return tmpl
            .replace("#__imports__#", libs.joinToString("\n") { "import ${it.name}" })
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getter_branches__#", "")
            .replaceParagraph("#__setter_branches__#", "")
            .replaceParagraph(
                "#__branches__#",
                methodBranches.union(gettersBranches).union(settersBranches).joinToString(",\n")
            )
            .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
            .replaceParagraph(
                "#__handlers__#",
                methodHandlers.union(getterHandlers).union(setterHandlers).joinToString("\n")
            )

    }
}