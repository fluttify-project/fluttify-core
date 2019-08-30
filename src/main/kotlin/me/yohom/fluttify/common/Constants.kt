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
    "loadTileAtPath" // ios端的这个方法比较复杂, 先忽略
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
    Type().apply { name = "CLLocationCoordinate2D"; typeType = TypeType.Struct }
)

/**
 * 忽略的类
 */
val IGNORE_TYPE = listOf(
    "android.support.v4.app.Fragment",
    "UIViewController"
)