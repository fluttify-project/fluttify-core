import generator.android.Android
import generator.ios.iOS

fun main() {
    Android.generate()
    println(Android.dartResult)
    iOS.generate()
    println(iOS.dartResult)
}
