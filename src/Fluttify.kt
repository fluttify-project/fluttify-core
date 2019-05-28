import generator.android.Android
import generator.ios.iOS
import preprocess.Analyzer
import preprocess.JarDecompiler

fun main() {
    JarDecompiler.run { decompile(); unzip() }

    Analyzer.analyze()

    Android.generateDart()
    Android.generateKotlin()
    iOS.generateDart()
    iOS.generateSwift()
    println("***************************Android*********************************")
    println(Android.dartResult)
    println()
    println(Android.kotlinResult)
    println("***************************Android*********************************")
    println("***************************iOS*********************************")
    println(iOS.dartResult)
    println()
    println(iOS.swiftResult)
    println("***************************iOS*********************************")
}
