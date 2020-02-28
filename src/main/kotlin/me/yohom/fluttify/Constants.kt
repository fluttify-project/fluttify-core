package me.yohom.fluttify

import me.yohom.fluttify.model.Type
import me.yohom.fluttify.model.TypeType
import java.io.File

@Suppress("ObjectPropertyName")
object X {
    const val _batch = "_batch"
}

/**
 * 忽略的方法
 */
val EXCLUDE_METHODS
    get() =
        listOf("toString", "equals", "writeToParcel", "describeContents", "recycle", "hashCode", "addView", "removeView")
            .union(ext.ios.exclude.methods)
            .union(ext.android.exclude.methods)
            .map { Regex(it) }


/**
 * 排除生成的类
 */
val EXCLUDE_TYPES
    get() = ext.ios.exclude.classes
        .union(ext.android.exclude.classes)
        .map { Regex(it) }


/**
 * 系统别名
 */
val SYSTEM_TYPEDEF = mapOf(
    "CLLocationDirection" to "double",
    "CLLocationDistance" to "double",
    "CLLocationAccuracy" to "double",
    "CLLocationDegrees" to "double",
    "CFTimeInterval" to "double",
    "NSTimeInterval" to "double",
    "int64_t" to "long long"
)

/**
 * 保留的类
 */
val SYSTEM_TYPE = listOf(
    /////////////////////////////////////////Android系统类/////////////////////////////////////////////
    Type().apply { name = "void" },
    Type().apply { name = "android.content.Context"; typeType = TypeType.Class },
    Type().apply { name = "android.content.Intent"; typeType = TypeType.Class },
    Type().apply { name = "android.content.ContentProvider"; typeType = TypeType.Class },
    Type().apply { name = "android.app.Application"; typeType = TypeType.Class },
    Type().apply { name = "android.app.Activity"; typeType = TypeType.Class },
    Type().apply { name = "android.app.PendingIntent"; typeType = TypeType.Class },
    Type().apply { name = "android.os.Bundle"; typeType = TypeType.Class },
    Type().apply { name = "android.os.Binder"; typeType = TypeType.Class },
    Type().apply { name = "android.view.View"; typeType = TypeType.Class },
    Type().apply { name = "android.view.ViewGroup"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.Point"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.PointF"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.Bitmap"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.ImageView"; typeType = TypeType.Class },
    Type().apply { name = "java.lang.Object"; typeType = TypeType.Class },
    Type().apply { name = "java.io.Serializable"; typeType = TypeType.Interface },
    Type().apply { name = "android.location.Location"; typeType = TypeType.Class },
    Type().apply { name = "android.view.MotionEvent"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.drawable.Drawable"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.FrameLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.LinearLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.RelativeLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.os.Parcelable"; typeType = TypeType.Interface },
    Type().apply { name = "android.util.Pair<.+,.+>"; typeType = TypeType.Class },

    /////////////////////////////////////////iOS系统类/////////////////////////////////////////////
    Type().apply { name = "CLLocation"; typeType = TypeType.Class },
    Type().apply { name = "CLHeading"; typeType = TypeType.Class },
    Type().apply { name = "CGRect"; typeType = TypeType.Struct },
    Type().apply { name = "CGPoint"; typeType = TypeType.Struct },
    Type().apply { name = "CGSize"; typeType = TypeType.Struct },
    Type().apply { name = "UIEdgeInsets"; typeType = TypeType.Struct },
    Type().apply { name = "CLLocationCoordinate2D"; typeType = TypeType.Struct },

    Type().apply { name = "CLLocationManager"; typeType = TypeType.Class },
    Type().apply { name = "NSError"; typeType = TypeType.Class },
    Type().apply { name = "NSCoding"; typeType = TypeType.Interface },
    Type().apply { name = "NSCopying"; typeType = TypeType.Interface },
    Type().apply { name = "UIView"; typeType = TypeType.Class },
    Type().apply { name = "UIControl"; typeType = TypeType.Class },
    Type().apply { name = "UIImage"; typeType = TypeType.Class },
    Type().apply { name = "NSObject"; typeType = TypeType.Class },
    Type().apply { name = "UIColor"; typeType = TypeType.Class },
    Type().apply { name = "NSData"; typeType = TypeType.Class },
    Type().apply { name = "NSOperation"; typeType = TypeType.Class },

    Type().apply { name = "CLAuthorizationStatus"; typeType = TypeType.Enum }
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