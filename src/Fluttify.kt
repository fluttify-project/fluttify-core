
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
    println("***************************SimpleStaticAndroid-Dart*********************************")
    println(SimpleStaticAndroid.androidDartResult)
//    val androidDartFile = File(outputPluginAndroidDartPath)
//    if (!androidDartFile.exists()) androidDartFile.createNewFile()
//    androidDartFile.writeText(SimpleStaticAndroid.androidDartResult)
//    println("***************************SimpleStaticAndroid-Dart*********************************")
//    println("***************************SimpleStaticAndroid-Kotlin*********************************")
    println(SimpleStaticAndroid.kotlinResult)
//    val androidKotlinFile = File(outputPluginAndroidKotlinPath)
//    if (!androidKotlinFile.exists()) androidKotlinFile.createNewFile()
//    androidKotlinFile.writeText(SimpleStaticAndroid.kotlinResult)
//
//    // 添加jar依赖 只需要把jar文件拷贝到Android工程下即可
//    val targetJarDir = File(outputPluginAndroidJarDir)
//    if (!targetJarDir.exists()) targetJarDir.mkdirs()
//    Files.copy(
//        File(jarPath).toPath(),
//        File(outputPluginAndroidJarDir + "/" + jarPath.substringAfterLast("/")).toPath()
//    )
//    println("***************************SimpleStaticAndroid-Kotlin*********************************")
    println("***************************SimpleStaticIOS-Dart*********************************")
    println(SimpleStaticIOS.iOSDartResult)
//    val iOSDartFile = File(outputPluginIOSDartPath)
//    if (!iOSDartFile.exists()) iOSDartFile.createNewFile()
//    iOSDartFile.writeText(SimpleStaticIOS.iOSDartResult)
//    println("***************************SimpleStaticIOS-Dart*********************************")
//    println("***************************SimpleStaticIOS-Swift*********************************")
    println(SimpleStaticIOS.swiftResult)
//    val iOSSwiftFile = File(outputPluginIOSSwiftPath)
//    if (!iOSSwiftFile.exists()) iOSSwiftFile.createNewFile()
//    iOSSwiftFile.writeText(SimpleStaticIOS.swiftResult)
//
//    // 添加framework依赖 只需要把framework文件拷贝到ios工程下
//    val targetFrameworkDir = File(outputPluginIOSFrameworkPath)
//    if (!targetFrameworkDir.exists()) targetFrameworkDir.mkdirs()
//    FileUtils.copyDirectory(
//        File(frameworkPath),
//        File(outputPluginIOSFrameworkPath + "/" + frameworkPath.substringAfterLast("/"))
//    )
//    println("***************************SimpleStaticIOS-Swift*********************************")
}
