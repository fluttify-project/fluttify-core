package me.yohom.fluttify.common

import me.yohom.fluttify.common.model.Type
import me.yohom.fluttify.common.model.TypeType

/**
 * 忽略的方法
 */
val IGNORE_METHOD = listOf(
    "toString",
    "equals",
    "writeToParcel",
    "describeContents",
    "recycle",
    "hashCode",
    "addView",
    "removeView",
    "loadTileAtPath", // ios端的这个方法比较复杂, 先忽略
    "takeSnapshotInRect" // ios端的这个方法比较复杂, 先忽略
)

val SYSTEM_TYPEDEF = mapOf(
    "CLLocationDirection" to "double",
    "CFTimeInterval" to "double"
)

/**
 * 保留的类
 */
val SYSTEM_TYPE = listOf(
    Type().apply { name = "void" },
    Type().apply { name = "android.content.Context"; typeType = TypeType.Class },
    Type().apply { name = "android.app.Application"; typeType = TypeType.Class },
    Type().apply { name = "android.app.Activity"; typeType = TypeType.Class },
    Type().apply { name = "android.os.Bundle"; typeType = TypeType.Class },
    Type().apply { name = "android.view.View"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.FrameLayout"; typeType = TypeType.Class },
    Type().apply { name = "CLLocationManager"; typeType = TypeType.Class },
    Type().apply { name = "CLLocationCoordinate2D"; typeType = TypeType.Struct },
    Type().apply { name = "UIEdgeInsets"; typeType = TypeType.Struct },
    Type().apply { name = "CGRect"; typeType = TypeType.Struct },
    Type().apply { name = "CGPoint"; typeType = TypeType.Struct },
    Type().apply { name = "NSError"; typeType = TypeType.Class },
    Type().apply { name = "NSObject"; typeType = TypeType.Class },
    Type().apply { name = "UIControl"; typeType = TypeType.Class },
    Type().apply { name = "UIView"; typeType = TypeType.Class }
)

/**
 * 忽略的类
 */
val IGNORE_TYPE = listOf(
    "android.support.v4.app.Fragment",
    "UIViewController"
)