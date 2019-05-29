
import Configs.frameworkPath
import Configs.jarPath
import generator.statik.SimpleStaticAndroid
import generator.statik.SimpleStaticIOS
import org.apache.commons.io.FileUtils
import preprocess.Analyzer
import preprocess.Analyzer.outputPluginAndroidDartPath
import preprocess.Analyzer.outputPluginAndroidJarDir
import preprocess.Analyzer.outputPluginAndroidKotlinPath
import preprocess.Analyzer.outputPluginIOSDartPath
import preprocess.Analyzer.outputPluginIOSFrameworkPath
import preprocess.Analyzer.outputPluginIOSSwiftPath
import preprocess.JarDecompiler
import java.io.File
import java.nio.file.Files

fun main() {
    JarDecompiler.run { decompile(); unzip() }

    Analyzer.analyze()

    SimpleStaticAndroid.generateAndroidDart()
    SimpleStaticAndroid.generateKotlin()
    SimpleStaticIOS.generateIOSDart()
    SimpleStaticIOS.generateSwift()
    println("***************************SimpleStaticAndroid-Dart*********************************")
    println(SimpleStaticAndroid.androidDartResult)
    //region 写入android端dart文件
    val androidDartFile = File(outputPluginAndroidDartPath)
    if (!androidDartFile.exists()) androidDartFile.createNewFile()
    androidDartFile.writeText(SimpleStaticAndroid.androidDartResult)
    //endregion
    println("***************************SimpleStaticAndroid-Dart*********************************")
    println("***************************SimpleStaticAndroid-Kotlin*********************************")
    println(SimpleStaticAndroid.kotlinResult)
    //region 写入kotlin文件
    val androidKotlinFile = File(outputPluginAndroidKotlinPath)
    if (!androidKotlinFile.exists()) androidKotlinFile.createNewFile()
    androidKotlinFile.writeText(SimpleStaticAndroid.kotlinResult)
    //endregion

    //region 添加jar依赖 只需要把jar文件拷贝到Android工程下即可
    val targetJarDir = File(outputPluginAndroidJarDir)
    if (!targetJarDir.exists()) targetJarDir.mkdirs()
    Files.copy(
        File(jarPath).toPath(),
        File(outputPluginAndroidJarDir + "/" + jarPath.substringAfterLast("/")).toPath()
    )
    //endregion
    println("***************************SimpleStaticAndroid-Kotlin*********************************")
    println("***************************SimpleStaticIOS-Dart*********************************")
    println(SimpleStaticIOS.iOSDartResult)
    //region 写入iOS端dart文件
    val iOSDartFile = File(outputPluginIOSDartPath)
    if (!iOSDartFile.exists()) iOSDartFile.createNewFile()
    iOSDartFile.writeText(SimpleStaticIOS.iOSDartResult)
    //endregion
    println("***************************SimpleStaticIOS-Dart*********************************")
    println("***************************SimpleStaticIOS-Swift*********************************")
    println(SimpleStaticIOS.swiftResult)
    //region 写入swift文件
    val iOSSwiftFile = File(outputPluginIOSSwiftPath)
    if (!iOSSwiftFile.exists()) iOSSwiftFile.createNewFile()
    iOSSwiftFile.writeText(SimpleStaticIOS.swiftResult)
    //endregion

    //region 添加framework依赖 只需要把framework文件拷贝到ios工程下
    val targetFrameworkDir = File(outputPluginIOSFrameworkPath)
    if (!targetFrameworkDir.exists()) targetFrameworkDir.mkdirs()
    FileUtils.copyDirectory(
        File(frameworkPath),
        File(outputPluginIOSFrameworkPath + "/" + frameworkPath.substringAfterLast("/"))
    )
    //endregion
    println("***************************SimpleStaticIOS-Swift*********************************")
}
