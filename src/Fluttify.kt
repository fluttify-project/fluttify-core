import generator.statik.SimpleStaticAndroid
import generator.statik.SimpleStaticIOS
import preprocess.Analyzer
import preprocess.JarDecompiler

fun main() {
    JarDecompiler.run { decompile(); unzip() }

    Analyzer.analyze()

    SimpleStaticAndroid.generateAndroidDart()
    SimpleStaticAndroid.generateKotlin()
    SimpleStaticIOS.generateIOSDart()
    SimpleStaticIOS.generateSwift()
    println("***************************SimpleStaticAndroid*********************************")
    println(SimpleStaticAndroid.androidDartResult)
    println()
    println(SimpleStaticAndroid.kotlinResult)
    println("***************************SimpleStaticAndroid*********************************")
    println("***************************SimpleStaticIOS*********************************")
    println(SimpleStaticIOS.iOSDartResult)
    println()
    println(SimpleStaticIOS.swiftResult)
    println("***************************SimpleStaticIOS*********************************")
}
