package common

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
    "describeContents"
)