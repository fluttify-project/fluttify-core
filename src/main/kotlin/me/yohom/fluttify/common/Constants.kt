package me.yohom.fluttify.common

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
val SYSTEM_CLASS = listOf(
    "void",
    "android.content.Context",
    "android.app.Application",
    "android.app.Activity",
    "android.os.Bundle"
)

/**
 * 忽略的类
 */
val IGNORE_CLASS = listOf(
    "android.support.v4.app.Fragment",
    "UIViewController"
)