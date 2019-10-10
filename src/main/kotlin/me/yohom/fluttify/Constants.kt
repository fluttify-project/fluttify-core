package me.yohom.fluttify

import me.yohom.fluttify.model.Type
import me.yohom.fluttify.model.TypeType
import java.io.File

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
    Type().apply { name = "android.view.ViewGroup"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.Point"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.PointF"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.Bitmap"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.ImageView"; typeType = TypeType.Class },
    Type().apply { name = "java.lang.Object"; typeType = TypeType.Class },
    Type().apply { name = "android.location.Location"; typeType = TypeType.Class },
    Type().apply { name = "android.view.MotionEvent"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.drawable.Drawable"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.FrameLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.LinearLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.RelativeLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.os.Parcelable"; typeType = TypeType.Interface },

    Type().apply { name = "CLLocationManager"; typeType = TypeType.Class },
    Type().apply { name = "CLLocationCoordinate2D"; typeType = TypeType.Struct },
    Type().apply { name = "UIEdgeInsets"; typeType = TypeType.Struct },
    Type().apply { name = "CGRect"; typeType = TypeType.Struct },
    Type().apply { name = "CGPoint"; typeType = TypeType.Struct },
    Type().apply { name = "NSError"; typeType = TypeType.Class },
    Type().apply { name = "NSObject"; typeType = TypeType.Class },
    Type().apply { name = "UIControl"; typeType = TypeType.Class },
    Type().apply { name = "NSCopying"; typeType = TypeType.Interface },
    Type().apply { name = "NSCoding"; typeType = TypeType.Interface },
    Type().apply { name = "UIView"; typeType = TypeType.Class },
    Type().apply { name = "CLAuthorizationStatus"; typeType = TypeType.Enum }
)

/**
 * 忽略的类
 */
val IGNORE_TYPE = listOf(
    "android.support.v4.app.Fragment",
    "UIViewController"
)

/**
 * 类型名 包括类名和接口名
 */
typealias TYPE_NAME = String

typealias JAVA_SOURCE = String
typealias OBJC_SOURCE = String
typealias DART_SOURCE = String
typealias KOTLIN_SOURCE = String

typealias PATH = String

typealias JAVA_FILE = File
typealias OBJC_FILE = File
typealias DART_FILE = File
typealias KOTLIN_FILE = File
typealias SWIFT_FILE = File

typealias DIR = File