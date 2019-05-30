
import generator.statik.StaticModelAndroid
import preprocess.Analyzer
import preprocess.Analyzer.outputPluginAndroidKotlinPath
import java.io.File

fun main() {
//    JarDecompiler.run { decompile(); unzip() }

    Analyzer.analyze()

//    StaticJsonableAndroid.generateAndroidDart()
//    StaticJsonableAndroid.generateKotlin()
    StaticModelAndroid.generateAndroidDart()
    StaticModelAndroid.generateKotlin()
//    SimpleStaticIOS.generateIOSDart()
//    SimpleStaticIOS.generateSwift()


//    println("***************************StaticJsonableAndroid-Dart*********************************")
//    println(StaticJsonableAndroid.androidDartResult)
    //region 写入android端dart文件
//    val androidDartFile = File(outputPluginAndroidDartPath)
//    if (!androidDartFile.exists()) androidDartFile.createNewFile()
//    androidDartFile.writeText(StaticJsonableAndroid.androidDartResult)
//    //endregion
//    println("***************************StaticJsonableAndroid-Dart*********************************")

//    println("***************************StaticJsonableAndroid-Kotlin*********************************")
//    println(StaticJsonableAndroid.kotlinResult)
//    //region 写入kotlin文件
//    val androidKotlinFile = File(outputPluginAndroidKotlinPath)
//    if (!androidKotlinFile.exists()) androidKotlinFile.createNewFile()
//    androidKotlinFile.writeText(StaticJsonableAndroid.kotlinResult)
    //endregion

//    //region 添加jar依赖 只需要把jar文件拷贝到Android工程下即可
//    val targetJarDir = File(outputPluginAndroidJarDir)
//    if (!targetJarDir.exists()) targetJarDir.mkdirs()
//    Files.copy(
//        File(jarPath).toPath(),
//        File(outputPluginAndroidJarDir + "/" + jarPath.substringAfterLast("/")).toPath()
//    )
//    //endregion
//    println("***************************StaticJsonableAndroid-Kotlin*********************************")


    println("***************************StaticModelAndroid-Dart*********************************")
    println(StaticModelAndroid.androidDartResult)
//    //region 写入android端dart文件
//    val androidDartFile = File(outputPluginAndroidDartPath)
//    if (!androidDartFile.exists()) androidDartFile.createNewFile()
//    androidDartFile.writeText(StaticJsonableAndroid.androidDartResult)
//    //endregion
//    println("***************************StaticModelAndroid-Dart*********************************")
//    println("***************************StaticModelAndroid-Kotlin*********************************")
    println(StaticModelAndroid.kotlinResult)
    //region 写入kotlin文件
    val androidKotlinFile = File(outputPluginAndroidKotlinPath)
    if (!androidKotlinFile.exists()) androidKotlinFile.createNewFile()
    androidKotlinFile.writeText(StaticModelAndroid.kotlinResult)
    //endregion

//    //region 添加jar依赖 只需要把jar文件拷贝到Android工程下即可
//    val targetJarDir = File(outputPluginAndroidJarDir)
//    if (!targetJarDir.exists()) targetJarDir.mkdirs()
//    Files.copy(
//        File(jarPath).toPath(),
//        File(outputPluginAndroidJarDir + "/" + jarPath.substringAfterLast("/")).toPath()
//    )
    //endregion
    println("***************************StaticModelAndroid-Kotlin*********************************")
//
//
//    println("***************************SimpleStaticIOS-Dart*********************************")
//    println(SimpleStaticIOS.iOSDartResult)
//    //region 写入iOS端dart文件
//    val iOSDartFile = File(outputPluginIOSDartPath)
//    if (!iOSDartFile.exists()) iOSDartFile.createNewFile()
//    iOSDartFile.writeText(SimpleStaticIOS.iOSDartResult)
    //endregion
//    println("***************************SimpleStaticIOS-Dart*********************************")
//    println("***************************SimpleStaticIOS-Swift*********************************")
//    println(SimpleStaticIOS.swiftResult)
//    //region 写入swift文件
//    val iOSSwiftFile = File(outputPluginIOSSwiftPath)
//    if (!iOSSwiftFile.exists()) iOSSwiftFile.createNewFile()
//    iOSSwiftFile.writeText(SimpleStaticIOS.swiftResult)
//    //endregion
//
//    //region 添加framework依赖 只需要把framework文件拷贝到ios工程下
//    val targetFrameworkDir = File(outputPluginIOSFrameworkPath)
//    if (!targetFrameworkDir.exists()) targetFrameworkDir.mkdirs()
//    FileUtils.copyDirectory(
//        File(frameworkPath),
//        File(outputPluginIOSFrameworkPath + "/" + frameworkPath.substringAfterLast("/"))
//    )
    //endregion
//    println("***************************SimpleStaticIOS-Swift*********************************")
}


//fun main() {
//    val mapper = ObjectMapper()
//    println(mapper.convertValue(A(), Map::class.java))
//}
//
//class A {
//    val b = 0
//    val c = B()
//}
//
//class B {
//    val a = 0
//    val c = C()
//}
//
//class C {
//    val c = 0
//    val d = "abc"
//}