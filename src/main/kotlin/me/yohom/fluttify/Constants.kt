package me.yohom.fluttify

import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.model.TypeType
import java.io.File

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
    "NSInteger" to "long",
    "NSUInteger" to "unsigned long",
    "CVPixelBufferRef" to "void*",
    "int64_t" to "long long",
    "uint32_t" to "unsigned int",
    "int32_t" to "int"
)

/**
 * 系统指针类型别名
 */
val SYSTEM_POINTER_TYPEDEF = mapOf(
    "CVPixelBufferRef" to "void*"
)

/**
 * 保留的类
 */
val SYSTEM_TYPE = listOf(
    /////////////////////////////////////////Android系统类/////////////////////////////////////////////
    Type().apply { name = "void"; platform = Platform.Android },
    Type().apply { name = "android.content.Context"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.content.Intent"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.content.ContentProvider"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.app.Application"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.app.Notification"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.app.Activity"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.app.PendingIntent"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.os.Bundle"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.os.Binder"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.view.View"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.view.View.OnApplyWindowInsetsListener"; typeType = TypeType.Interface; platform = Platform.Android },
    Type().apply { name = "android.view.View.OnClickListener"; typeType = TypeType.Interface; platform = Platform.Android },
    Type().apply { name = "android.view.ViewGroup"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.graphics.Point"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.graphics.PointF"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.graphics.Bitmap"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.widget.ImageView"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "java.lang.Object"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "java.io.Serializable"; typeType = TypeType.Interface; platform = Platform.Android },
    Type().apply { name = "android.location.Location"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.view.MotionEvent"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.graphics.drawable.Drawable"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.widget.FrameLayout"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.widget.LinearLayout"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.widget.RelativeLayout"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.os.Parcelable"; typeType = TypeType.Interface; platform = Platform.Android },
    Type().apply { name = "android.util.Pair<.+,.+>"; typeType = TypeType.Class; platform = Platform.Android },

    /////////////////////////////////////////iOS系统类/////////////////////////////////////////////
    Type().apply { name = "CLLocation"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "CLHeading"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "CGRect"; typeType = TypeType.Struct; platform = Platform.iOS },
    Type().apply { name = "CGPoint"; typeType = TypeType.Struct; platform = Platform.iOS },
    Type().apply { name = "CGSize"; typeType = TypeType.Struct; platform = Platform.iOS },
    Type().apply { name = "UIEdgeInsets"; typeType = TypeType.Struct; platform = Platform.iOS },
    Type().apply { name = "CLLocationCoordinate2D"; typeType = TypeType.Struct; platform = Platform.iOS },

    Type().apply { name = "CLLocationManager"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSError"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSCoding"; typeType = TypeType.Interface; platform = Platform.iOS },
    Type().apply { name = "NSCopying"; typeType = TypeType.Interface; platform = Platform.iOS },
    Type().apply { name = "UIView"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIViewController"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIControl"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIImage"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSObject"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIColor"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSData"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSOperation"; typeType = TypeType.Class; platform = Platform.iOS },

    Type().apply { name = "CLAuthorizationStatus"; typeType = TypeType.Enum; platform = Platform.iOS }
)

object Regexes {
    val MAP = Regex("(\\w*Map|NS(Mutable)?Dictionary)(<.+,.+>)?")
    // Regex("\\w*List<(\\w*|.*)>").matches(this)
    //            || Regex("Iterable<(\\w*|.*)>").matches(this)
    //            || Regex("Collection<(\\w*|.*)>").matches(this)
    //            || Regex("NSArray.*\\*?").matches(this)
    //            || Regex("NSMutableArray.*\\*?").matches(this)
    //            || Regex("""\w+\[]""").matches(this)
    // TODO 要不包含数组?
    val ITERABLE = Regex("(((\\w|\\.)*List|Iterable|Collection)(<.*>)?)|(NS(Mutable)?Array.*\\*?)")
}

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