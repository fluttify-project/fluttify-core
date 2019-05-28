
import generator.statik.StaticAndroid
import generator.statik.StaticIOS
import preprocess.Analyzer
import preprocess.JarDecompiler

fun main() {
    JarDecompiler.run { decompile(); unzip() }

    Analyzer.analyze()

    StaticAndroid.generateAndroidDart()
    StaticAndroid.generateKotlin()
    StaticIOS.generateIOSDart()
    StaticIOS.generateSwift()
    println("***************************StaticAndroid*********************************")
    println(StaticAndroid.androidDartResult)
    println()
    println(StaticAndroid.kotlinResult)
    println("***************************StaticAndroid*********************************")
    println("***************************StaticIOS*********************************")
    println(StaticIOS.iOSDartResult)
    println()
    println(StaticIOS.swiftResult)
    println("***************************StaticIOS*********************************")
}
