
import generator.statik.SimpleStaticAndroid
import generator.statik.SimpleStaticIOS
import preprocess.Analyzer
import preprocess.Analyzer.outputPluginAndroidDartPath
import preprocess.Analyzer.outputPluginAndroidKotlinPath
import preprocess.Analyzer.outputPluginIOSDartPath
import preprocess.Analyzer.outputPluginIOSSwiftPath
import preprocess.JarDecompiler
import java.io.File

fun main() {
    JarDecompiler.run { decompile(); unzip() }

    Analyzer.analyze()

    SimpleStaticAndroid.generateAndroidDart()
    SimpleStaticAndroid.generateKotlin()
    SimpleStaticIOS.generateIOSDart()
    SimpleStaticIOS.generateSwift()
    println("***************************SimpleStaticAndroid-Dart*********************************")
    println(SimpleStaticAndroid.androidDartResult)
    val androidDartFile = File(outputPluginAndroidDartPath)
    if(!androidDartFile.exists()) androidDartFile.createNewFile()
    androidDartFile.writeText(SimpleStaticAndroid.androidDartResult)
    println("***************************SimpleStaticAndroid-Dart*********************************")
    println("***************************SimpleStaticAndroid-Kotlin*********************************")
    println(SimpleStaticAndroid.kotlinResult)
    val androidKotlinFile = File(outputPluginAndroidKotlinPath)
    if(!androidKotlinFile.exists()) androidKotlinFile.createNewFile()
    androidKotlinFile.writeText(SimpleStaticAndroid.kotlinResult)
    println("***************************SimpleStaticAndroid-Kotlin*********************************")
    println("***************************SimpleStaticIOS-Dart*********************************")
    println(SimpleStaticIOS.iOSDartResult)
    val iOSDartFile = File(outputPluginIOSDartPath)
    if(!iOSDartFile.exists()) iOSDartFile.createNewFile()
    iOSDartFile.writeText(SimpleStaticIOS.iOSDartResult)
    println("***************************SimpleStaticIOS-Dart*********************************")
    println("***************************SimpleStaticIOS-Swift*********************************")
    println(SimpleStaticIOS.swiftResult)
    val iOSSwiftFile = File(outputPluginIOSSwiftPath)
    if(!iOSSwiftFile.exists()) iOSSwiftFile.createNewFile()
    iOSSwiftFile.writeText(SimpleStaticIOS.swiftResult)
    println("***************************SimpleStaticIOS-Swift*********************************")
}
