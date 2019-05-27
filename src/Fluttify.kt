import generator.android.Android
import generator.ios.iOS

fun main() {
    Android.generateDart()
    Android.generateKotlin()
    iOS.generateDart()
    iOS.generateSwift()
    println("***************************Android*********************************")
    println(Android.dartResult)
    println()
    println(Android.javaResult)
    println("***************************Android*********************************")
    println("***************************iOS*********************************")
    println(iOS.dartResult)
    println()
    println(iOS.swiftResult)
    println("***************************iOS*********************************")
}
