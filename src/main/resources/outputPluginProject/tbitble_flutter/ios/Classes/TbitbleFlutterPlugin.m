#import "TbitbleFlutterPlugin.h"
#import <tbitble_flutter/tbitble_flutter-Swift.h>

@implementation TbitbleFlutterPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftTbitbleFlutterPlugin registerWithRegistrar:registrar];
}
@end
