
import generator.statik.Android
import generator.statik.iOS
import preprocess.Analyzer
import preprocess.JarDecompiler

fun main() {
    JarDecompiler.run { decompile(); unzip() }

    Analyzer.analyze()

    Android.generateAndroidDart()
    Android.generateKotlin()
    iOS.generateIOSDart()
    iOS.generateSwift()
    println("***************************Android*********************************")
    println(Android.androidDartResult)
    println()
    println(Android.kotlinResult)
    println("***************************Android*********************************")
    println("***************************iOS*********************************")
    println(iOS.iOSDartResult)
    println()
    println(iOS.swiftResult)
    println("***************************iOS*********************************")
}
