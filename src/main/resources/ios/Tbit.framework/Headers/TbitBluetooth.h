//
//  TbitBluetooth.h
//  Tbit
//
//  Created by 杨永畅 on 16/12/1.
//  Copyright © 2016年 yangyongchang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BikeState.h"
#import <CoreBluetooth/CoreBluetooth.h>

#define BluetoothDisConnect @"BluetoothDisConnect"

@interface TbitBluetooth : NSObject
/*
 * 版本号
 */
@property(nonatomic,assign)int projectType;

/**
 * 蓝牙状态
 */
@property(nonatomic, assign) CBManagerState state;

/**
 * 发现终端，初步建立蓝牙连接
 */
@property(nonatomic,assign)BOOL isConnected;

/**
 * 发送密钥，建立真正连接
 */
@property(nonatomic,assign)BOOL isRealConnected;

/**
 * 是否保存日志到本地
 * YES:保存到本地
 * NO:不保存到本地，且会删掉创建的文件
 * 默认为NO
 * 日志文件名 TbitLog.txt
 * 此日志只用于SDK测试，为了数据安全，请在APP上线时置为NO
 */
@property(nonatomic,assign)BOOL isSaveLog;

+(instancetype)sharedManager;

+(instancetype)sharedManagerWithProjectType:(int)projectType block:(void(^)(CBManagerState state))block;

/**
 * 状态码block
 */
typedef void(^ResultBlock)(int resultCode);

/**
 * BikeState 终端状态 
 * 连接后，每间隔一段时间自动更新此状态
 */
@property(nonatomic,retain)BikeState *bikeState;

typedef void(^BikeBlock)(BikeState *bikeState,int resultCode);

/**
 * 连接
 */
+(void)connect:(NSString *)macAddress key:(NSString*)key resultBlock:(BikeBlock)resultBlock;

/**
 * 解锁
 */
+(void)unlock:(ResultBlock)resultBlock;

/**
 * 上锁
 */
+(void)lock:(ResultBlock)resultBlock;

/**
 * 获取终端状态信息
 */
+(void)getMachineStatus:(BikeBlock)bikeBlock;

/**
 * 断开连接(发送命令)
 * 还车后需要调用此接口通知终端断开与app的连接
 */
+(void)disConnectWithCommand;

/*
 * 断开连接 (app 主动断开)
 */
+(void)disConnect;

/**
 * 重启终端
 */
+(void)reboot:(ResultBlock)resultBlock;

/*
 * 恢复原厂设置
 */
+(void)reset:(ResultBlock)resultBlock;

/*
 * 通用命令(此命令只用于commandId为0x03、0x04使用)
 * @param commandId 
          key
          value
          dic 返回的数据
          resultCode 返回的代码
 *
 * 以下commandId中的key不可在此接口使用
 * 附:  commandId    key
 *      0x03        0x01    (上锁)
 *      0x03        0x02    (解锁)
 *      0x04        0x05    (获取终端状态信息)
 */
+(void)commandId:(UInt32)commandId key:(UInt32)key value:(UInt32)value block:(void(^)(NSDictionary *dic,int resultCode))block;

/**
 * OTA升级
 */
+(void)OTA:(UInt32)version  fileURL:(NSURL*)fileURL resultBlock:(ResultBlock)resultBlock;

/**
 * OTA升级+连接
 */
+(void)connectForOTA:(UInt32)version macAddress:(NSString *)macAddress fileURL:(NSURL *)fileURL resultBlock:(ResultBlock)resultBlock;
/*
 * 扫描
 * 扫描期间请勿做任何操作指令行为
 * time 扫描时间，默认5秒
 * peripherals 扫描到的设备，包括已经连接中的设备
 * resultCode 返回代码
 */
+(void)scan:(NSInteger)time block:(void(^)(NSArray *peripherals,int resultCode))block;

/*
 * 停止扫描
 * 与扫描方法相对应
 * +(void)scan:(NSInteger)time block:(void(^)(NSArray *peripherals,int resultCode))block;
 */
+(void)stopScan;

@end

//广播数据
@interface CBPeripheral (advertisementData)
/*
 * 编号
 */
@property (nonatomic,copy)NSString *tid;
/*
 * 广播数据包
 */
@property (nonatomic,retain)NSDictionary *advertisementData;

/*
 * 设备RSII值
 */
@property (nonatomic)int rssiValue;

@end
