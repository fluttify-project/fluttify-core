package me.yohom.fluttify

import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.model.TypeType
import java.io.File

const val SUCCESS_LOG = false

const val CONSTRUCTOR_LOG = false
const val VARIABLE_LOG = false
const val FIELD_LOG = false
const val TYPE_LOG = false
const val FILE_LOG = false
const val METHOD_LOG = false
const val CACHE_LOG = false

const val ENABLE_CACHE = false
//const val ENABLE_CACHE = true

private var idSequence = 0
val NEXT_ID
    get() = ++idSequence

/**
 * 忽略的方法
 */
val EXCLUDE_METHODS
    get() =
        listOf(
            ".*::toString()",
            ".*::equals.*",
            ".*::writeToParcel.*",
            ".*::describeContents.*",
            ".*::recycle.*",
            ".*::hashCode()",
            ".*::addView.*",
            ".*::removeView.*"
        )
            .union(ext.ios.exclude.methods)
            .union(ext.android.exclude.methods)
            .map { Regex(it) }


/**
 * 排除生成的类
 */
val EXCLUDE_TYPES
    get() = listOf(
        "android.app.Fragment",
        "android.support.v4.app.Fragment",
        "java.io.Closeable",
        ".*\\.R((\\.|\\$)(attr|dimen|drawable|layout|string|style|styleable|xml))?",
    ).union(ext.ios.exclude.classes)
        .union(ext.android.exclude.classes)
        .map { Regex(it) }

/**
 * 排除生成的类
 */
val EXCLUDE_LIBS
    get() = ext.ios.exclude.libs
        .union(ext.android.exclude.libs)
        .map { Regex(it) }

/**
 * 排除生成的文件
 */
val EXCLUDE_FILES
    get() = ext.ios.exclude.files
        .union(ext.android.exclude.files)
        .map { Regex(it) }

/**
 * 排除生成的常量
 */
val EXCLUDE_CONSTANTS
    get() = ext.ios.exclude.constants
        .union(ext.android.exclude.constants)
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
    "int32_t" to "int",
    "int64_t" to "long long",
    "uint32_t" to "unsigned int",
    "UInt32" to "unsigned int",
    "uint64_t" to "unsigned long long"
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
    Type().apply { name = "android.view.SurfaceView"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.view.SurfaceHolder"; typeType = TypeType.Interface; platform = Platform.Android },
    Type().apply { name = "android.opengl.GLSurfaceView"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply {
        name = "android.view.SurfaceHolder.Callback"; typeType = TypeType.Interface; platform = Platform.Android
    },
    Type().apply {
        name = "android.view.View.OnApplyWindowInsetsListener"; typeType = TypeType.Interface; platform =
        Platform.Android
    },
    Type().apply {
        name = "android.view.View.OnClickListener"; typeType = TypeType.Interface; platform = Platform.Android
    },
    Type().apply {
        name = "android.view.View.OnTouchListener"; typeType = TypeType.Interface; platform = Platform.Android
    },
    Type().apply { name = "android.view.ViewGroup"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.graphics.Point"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.graphics.PointF"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.graphics.Bitmap"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.widget.ImageView"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "java.lang.Object"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "java.lang.Void"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "java.io.Serializable"; typeType = TypeType.Interface; platform = Platform.Android },
    Type().apply { name = "java.io.Closeable"; typeType = TypeType.Interface; platform = Platform.Android },
    Type().apply { name = "java.io.File"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.location.Location"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply { name = "android.view.MotionEvent"; typeType = TypeType.Class; platform = Platform.Android },
    Type().apply {
        name = "android.graphics.drawable.Drawable"; typeType = TypeType.Class; platform = Platform.Android
    },
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
    Type().apply { name = "NSMutableCopying"; typeType = TypeType.Interface; platform = Platform.iOS },
    Type().apply { name = "UIView"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIViewController"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIControl"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIImage"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIImageView"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSObject"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIColor"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSData"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSDate"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "NSOperation"; typeType = TypeType.Class; platform = Platform.iOS },
    Type().apply { name = "UIBarStyle"; typeType = TypeType.Enum; platform = Platform.iOS },
    Type().apply { name = "UIStatusBarStyle"; typeType = TypeType.Enum; platform = Platform.iOS },

    Type().apply { name = "CLAuthorizationStatus"; typeType = TypeType.Enum; platform = Platform.iOS }
)

object Regexes {
    val MAP = Regex("(\\w*Map|NS(Mutable)?Dictionary)(<(int|double|String),((List<)?int|double|String(>)?)>)?")

    // Regex("\\w*List<(\\w*|.*)>").matches(this)
    //            || Regex("Iterable<(\\w*|.*)>").matches(this)
    //            || Regex("Collection<(\\w*|.*)>").matches(this)
    //            || Regex("NSArray.*\\*?").matches(this)
    //            || Regex("NSMutableArray.*\\*?").matches(this)
    //            || Regex("""\w+\[]""").matches(this)
    val ITERABLE = Regex("java\\.(\\w|\\.)*(List|Iterable|Collection)(<.*>)?|(NS(Mutable)?Array.*\\*?)")
}

/**
 * 类型名 包括类名和接口名
 */
typealias TYPE_NAME = String

typealias JAVA_SOURCE = String
typealias OBJC_SOURCE = String

typealias PATH = String

typealias JAVA_FILE = File
typealias OBJC_FILE = File

val dartReserved = listOf(
    "abstract", "dynamic", "implements", "show", "as", "else",
    "import", "static", "assert", "enum", "in", "super", "async",
    "export", "interface", "switch", "await", "extends", "is", "sync",
    "break", "external", "library", "this", "case", "factory", "mixin",
    "throw", "catch", "false", "new", "true", "class", "final", "null", "try",
    "const", "finally", "on", "typedef", "continue", "for", "operator", "var",
    "covariant", "Function", "part", "void", "default", "get", "rethrow",
    "while", "deferred", "hide", "return", "with", "do", "if", "set", "yield"
)

val JAVA_RESERVED = listOf(
    "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
    "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
    "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
    "new", "package", "private", "protected", "public", "return", "strictfp", "short", "static", "super",
    "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
)