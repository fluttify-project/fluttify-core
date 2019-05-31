//
//  BikeState.h
//  Tbit
//
//  Created by 杨永畅 on 16/12/5.
//  Copyright © 2016年 yangyongchang. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>

@interface Location : NSObject

/*
 *经度
 */
@property(nonatomic,assign)CGFloat lo;

/*
 *纬度
 */
@property(nonatomic,assign)CGFloat la;

/*
 *经度分度值
 */
@property(nonatomic,assign)CGFloat lo_minute;

/*
 *纬度分度值
 */
@property(nonatomic,assign)CGFloat la_minute;

@end

@interface Controller : NSObject

/*
 *总里程
 */
@property(nonatomic,assign)int mileage_total;

/*
 *单次里程
 */
@property(nonatomic,assign)int mileage_single;


/*
 *故障数组
 */
@property(nonatomic,strong)NSArray *errorArray;

/*
 *电量
 */
@property(nonatomic,assign)int battery;

/*
 *电池充电总循环数
 */
@property(nonatomic,assign)int chargeCount;

/*
 *电池充电状态
 */
@property(nonatomic,assign)BOOL charging;

/*
 *控制工作状态
 */
@property(nonatomic,assign)int ctrState;

/*
 *脚撑状态
 */
@property(nonatomic,assign)int kickStand;


/*
 *速度
 */
@property(nonatomic,assign)int speed;


/*
 *电压
 */
@property(nonatomic,assign)int voltage;

/*
 *电流
 */
@property(nonatomic,assign)int current;


/*
 *温度
 */
@property(nonatomic,assign)int temperature;

@property(nonatomic,retain)NSArray *status1;

@property(nonatomic,retain)NSArray *status2;

@property(nonatomic,retain)NSArray *status3;

@property(nonatomic,retain)NSArray *status4;

@end


@interface BikeState : NSObject

/*
 * 数据
 */
@property(nonatomic,strong)NSDictionary *valueDic;

/*
 *电量 
 *车辆电压值
 */
@property(nonatomic,copy)NSString *battery;

/*
 *位置
 */
@property(nonatomic)Location *location;

/*
 * 控制器
 */
@property(nonatomic)Controller *controller;

/*
 *GSM:用于标识 GSM 信号强度,范围 0~9
 */
@property(nonatomic,copy)NSString *GSM;

/*
 *GPS:用于标识 GPS 信号强度,范围 0~9
 */
@property(nonatomic,copy)NSString *GPS;

/*
 *BAT:用于标识定位器后备电池电量,范围 0~9
 */
@property(nonatomic,copy)NSString *BAT;

/*
 *状态数组:
 */
@property(nonatomic,strong)NSArray *systemStateArray;

/*
 * 移动用户所属国家代号
 */
@property(nonatomic,assign)UInt32 MCC;

/*
 * 移动网号码 Mobile Network Code
 */
@property(nonatomic,assign)UInt32 MNC;

/*
 * 位置区码 Location Area Code(LAC)包含于LAI中,由两个字节组成,采用16进制编码。
 */
@property(nonatomic,assign)UInt32 LAC;

/*
 * 移动基站 Cell Tower ID
 */
@property(nonatomic,assign)UInt32 CellID;

/*
 * 卫星个数
 */
@property(nonatomic,assign)UInt32 satellite;

/*
 *
 */
@property(nonatomic,assign)int gpsType;
@end
