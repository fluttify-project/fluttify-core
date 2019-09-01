package me.yohom.fluttify.common.tmpl.objc.platform_view_factory

import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Type

//#import <Foundation/Foundation.h>
//#import <Flutter/Flutter.h>
//
//@interface #__native_view__#Factory : NSObject <FlutterPlatformViewFactory>
//@end
//
//@interface #__native_view__#PlatformView: NSObject <FlutterPlatformView>
//
//- (instancetype) initWithViewId: (NSInteger) viewId;
//
//@end

//#import "#__native_view__#Factory.h"
//#import "AmapBaseFlutterPlugin.h"
//#__imports__#
//
//@implementation #__native_view__#Factory {
//
//}
//- (NSObject <FlutterPlatformView> *)createWithFrame:(CGRect)frame viewIdentifier:(int64_t)viewId arguments:(id _Nullable)args {
//  return [[#__native_view__#PlatformView alloc] initWithViewId:viewId];
//}
//
//@end
//
//@implementation #__native_view__#PlatformView {
//  NSInteger _viewId;
//}
//
//- (instancetype)initWithViewId:(NSInteger)viewId {
//  self = [super init];
//  if (self) {
//    _viewId = viewId;
//  }
//
//  return self;
//}
//
//- (UIView *)view {
//  return [[MAMapView alloc] init];
//}
//
//- (void)dealloc {
//  [REF_MAP removeObjectForKey:@(_viewId)];
//}
//
//@end
class PlatformViewFactoryTmpl(
    private val viewType: Type,
    private val lib: Lib
) {
    private val hTmpl = this::class.java.getResource("/tmpl/objc/platform_view_factory/platform_view_factory.h.tmpl").readText()
    private val mTmpl = this::class.java.getResource("/tmpl/objc/platform_view_factory/platform_view_factory.m.tmpl").readText()

    fun objcPlatformViewFactory(): List<String> {
        return listOf(
            hTmpl.replace("#__native_view__#", viewType.name),
            mTmpl
                .replace("#__import__#", "<${lib.name}/${lib.name}.h>")
                .replace("#__native_view__#", viewType.name)
        )
    }
}