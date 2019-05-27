import generator.android.Android
import generator.ios.iOS

fun main() {
    Android.generate()
    println(Android.dartResult)
    println()
    iOS.generate()
    println(iOS.dartResult)
}
