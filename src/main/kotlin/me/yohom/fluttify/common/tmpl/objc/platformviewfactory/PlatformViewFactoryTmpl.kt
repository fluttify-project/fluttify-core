package me.yohom.fluttify.common.tmpl.objc.platformviewfactory

import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Type

//import Flutter
//import UIKit
//import #__import__#
//
//class #__native_view__#Factory: NSObject, FlutterPlatformViewFactory {
//    func create(withFrame frame: CGRect, viewIdentifier viewId: Int64, arguments args: Any?) -> FlutterPlatformView {
//        return #__native_view__#PlatformView(viewId)
//    }
//}
//
//class #__native_view__#PlatformView: NSObject, FlutterPlatformView {
//   private let viewId: Int64
//
//   init(_ viewId: Int64) {
//       self.viewId = viewId
//   }
//
//   func view() -> UIView {
//       let nativeView = #__native_view__#()
//       REF_MAP[viewId] = nativeView
//       return nativeView
//   }
//
//   deinit {
//       REF_MAP.removeValue(forKey: Int(viewId))
//   }
//}
class PlatformViewFactoryTmpl(
    private val viewType: Type,
    private val lib: Lib
) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/platform_view_factory.swift.tmpl").readText()

    fun swiftPlatformViewFactory(): String {
        return tmpl
            .replace("#__import__#", lib.name)
            .replace("#__native_view__#", viewType.name)
    }
}