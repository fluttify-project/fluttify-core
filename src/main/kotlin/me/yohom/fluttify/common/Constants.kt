package me.yohom.fluttify.common

const val UNKNOWN = "UNKNOWN"
/**
 * 系统保留的model类
 */
val PRESERVED_MODEL = listOf("Bitmap", "Bundle")

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
    "removeView"
)

/**
 * 保留的类
 */
val PRESERVED_CLASS = listOf(
    "android.content.Context"
)

/**
 * 忽略的字段
 */
val IGNORE_FIELD = listOf(
    "CREATOR"
)

/**
 * 忽略的类
 */
val IGNORE_CLASS = listOf(
    "android.support.v4.app.Fragment"
)