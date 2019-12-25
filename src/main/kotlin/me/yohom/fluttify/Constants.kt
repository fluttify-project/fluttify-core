package me.yohom.fluttify

import me.yohom.fluttify.model.Type
import me.yohom.fluttify.model.TypeType
import java.io.File

// 由于权限比较细, 还是让用户自己去申请权限吧
val PERMISSION_IOS = mapOf(
    "calendar" to listOf("NSCalendarsUsageDescription"),
    "camera" to listOf("NSCameraUsageDescription"),
    "contacts" to listOf("NSContactsUsageDescription"),
    "location" to listOf(
        "NSLocationUsageDescription",
        "NSLocationWhenInUseUsageDescription",
        "NSLocationAlwaysAndWhenInUseUsageDescription",
        "NSLocationAlwaysUsageDescription"
    ),
    "microphone" to listOf("NSMicrophoneUsageDescription"),
    "phone" to listOf(),
    "photos" to listOf("NSPhotoLibraryUsageDescription"),
    "reminders" to listOf("NSRemindersUsageDescription"),
    "sensors" to listOf("NSMotionUsageDescription"),
    "sms" to listOf(),
    "storage" to listOf(),
    "speech" to listOf("NSSpeechRecognitionUsageDescription"),
    "locationAlways" to listOf("NSLocationAlwaysAndWhenInUseUsageDescription"),
    "locationWhenInUse" to listOf("NSLocationWhenInUseUsageDescription"),
    "mediaLibrary" to listOf("NSAppleMusicUsageDescription", "kTCCServiceMediaLibrary")
)

val PERMISSION_ANDROID = mapOf(
    "calendar" to listOf("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"),
    "camera" to listOf("android.permission.CAMERA"),
    "contacts" to listOf(
        "android.permission.READ_CONTACTS",
        "android.permission.WRITE_CONTACTS",
        "android.permission.GET_ACCOUNTS"
    ),
    "location" to listOf(
        "android.permission.ACCESS_FINE_LOCATION",
        "android.permission.ACCESS_COARSE_LOCATION",
        "android.permission.ACCESS_BACKGROUND_LOCATION"
    ),
    "microphone" to listOf("android.permission.RECORD_AUDIO"),
    "phone" to listOf(
        "android.permission.READ_PHONE_STATE",
        "android.permission.CALL_PHONE",
        "android.permission.ADD_VOICEMAIL",
        "android.permission.USE_SIP",
        "android.permission.READ_CALL_LOG",
        "android.permission.WRITE_CALL_LOG",
        "android.permission.PROCESS_OUTGOING_CALLS"
    ),
    "photos" to listOf(),
    "reminders" to listOf(),
    "sensors" to listOf("android.permission.BODY_SENSORS"),
    "sms" to listOf(
        "android.permission.SEND_SMS",
        "android.permission.RECEIVE_SMS",
        "android.permission.READ_SMS",
        "android.permission.RECEIVE_WAP_PUSH",
        "android.permission.RECEIVE_MMS"
    ),
    "storage" to listOf("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"),
    "speech" to listOf("android.permission.RECORD_AUDIO"),
    "locationAlways" to listOf(),
    "locationWhenInUse" to listOf(),
    "mediaLibrary" to listOf()
)

/**
 * 忽略的方法
 */
val EXCLUDE_METHODS
    get() =
        listOf(
            "toString",
            "equals",
            "writeToParcel",
            "describeContents",
            "recycle",
            "hashCode",
            "addView",
            "removeView"
        )
            .union(ext.ios.exclude.methods)
            .union(ext.android.exclude.methods)
            .apply { println("排除方法集合: $this") }


/**
 * 排除生成的类
 */
val EXCLUDE_TYPES
    get() = listOf("android.support.v4.app.Fragment", "UIViewController")
        .union(ext.ios.exclude.classes)
        .union(ext.android.exclude.classes)
        .apply { println("排除类型集合: $this") }


/**
 * 系统别名
 */
val SYSTEM_TYPEDEF = mapOf(
    "CLLocationDirection" to "double",
    "CLLocationDistance" to "double",
    "CLLocationAccuracy" to "double",
    "CLLocationDegrees" to "double",
    "CFTimeInterval" to "double"
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
    Type().apply { name = "android.location.Location"; typeType = TypeType.Class },
    Type().apply { name = "android.view.MotionEvent"; typeType = TypeType.Class },
    Type().apply { name = "android.graphics.drawable.Drawable"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.FrameLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.TextView"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.LinearLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.widget.RelativeLayout"; typeType = TypeType.Class },
    Type().apply { name = "android.os.Parcelable"; typeType = TypeType.Interface },

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