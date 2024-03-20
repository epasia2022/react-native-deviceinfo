
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNDeviceinfo1Spec.h"

@interface Deviceinfo1 : NSObject <NativeDeviceinfo1Spec>
#else
#import <React/RCTBridgeModule.h>

@interface Deviceinfo1 : NSObject <RCTBridgeModule>
#endif

@end
