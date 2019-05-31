
import generator.statik.StaticAndroid

fun main() {
//    JarDecompiler.run { decompile(); unzip() }

//    StaticJsonableAndroid.generateAndroidDart()
//    StaticJsonableAndroid.generateKotlin()
    StaticAndroid.generateAndroidDart()
    StaticAndroid.generateKotlin()
//    SimpleStaticIOS.generateIOSDart()
//    SimpleStaticIOS.generateSwift()


//    println("***************************StaticJsonableAndroid-Dart*********************************")
//    println(StaticJsonableAndroid.androidDartResult)
    //region 写入android端dart文件
//    val androidDartFile = File(androidDartPath)
//    if (!androidDartFile.exists()) androidDartFile.createNewFile()
//    androidDartFile.writeText(StaticJsonableAndroid.androidDartResult)
//    //endregion
//    println("***************************StaticJsonableAndroid-Dart*********************************")

//    println("***************************StaticJsonableAndroid-Kotlin*********************************")
//    println(StaticJsonableAndroid.kotlinResult)
//    //region 写入kotlin文件
//    val androidKotlinFile = File(kotlinPath)
//    if (!androidKotlinFile.exists()) androidKotlinFile.createNewFile()
//    androidKotlinFile.writeText(StaticJsonableAndroid.kotlinResult)
    //endregion

//    //region 添加jar依赖 只需要把jar文件拷贝到Android工程下即可
//    val targetJarDir = File(jarDir)
//    if (!targetJarDir.exists()) targetJarDir.mkdirs()
//    Files.copy(
//        File(jarPath).toPath(),
//        File(jarDir + "/" + jarPath.substringAfterLast("/")).toPath()
//    )
//    //endregion
//    println("***************************StaticJsonableAndroid-Kotlin*********************************")


//    println("***************************StaticAndroid-Dart*********************************")
    println(StaticAndroid.androidDartResult)
//    //region 写入android端dart文件
//    val androidDartFile = File(androidDartPath)
//    if (!androidDartFile.exists()) androidDartFile.createNewFile()
//    androidDartFile.writeText(StaticJsonableAndroid.androidDartResult)
//    //endregion
//    println("***************************StaticAndroid-Dart*********************************")
//    println("***************************StaticAndroid-Kotlin*********************************")
    println(StaticAndroid.kotlinResult)
    //region 写入kotlin文件
//    val androidKotlinFile = File(OutputProject.Android.kotlinPath)
//    if (!androidKotlinFile.exists()) androidKotlinFile.createNewFile()
//    androidKotlinFile.writeText(StaticAndroid.kotlinResult)
    //endregion

//    //region 添加jar依赖 只需要把jar文件拷贝到Android工程下即可
//    val targetJarDir = File(jarDir)
//    if (!targetJarDir.exists()) targetJarDir.mkdirs()
//    Files.copy(
//        File(jarPath).toPath(),
//        File(jarDir + "/" + jarPath.substringAfterLast("/")).toPath()
//    )
    //endregion
//    println("***************************StaticAndroid-Kotlin*********************************")
//
//
//    println("***************************SimpleStaticIOS-Dart*********************************")
//    println(SimpleStaticIOS.iOSDartResult)
//    //region 写入iOS端dart文件
//    val iOSDartFile = File(iOSDartPath)
//    if (!iOSDartFile.exists()) iOSDartFile.createNewFile()
//    iOSDartFile.writeText(SimpleStaticIOS.iOSDartResult)
    //endregion
//    println("***************************SimpleStaticIOS-Dart*********************************")
//    println("***************************SimpleStaticIOS-Swift*********************************")
//    println(SimpleStaticIOS.swiftResult)
//    //region 写入swift文件
//    val iOSSwiftFile = File(swiftPath)
//    if (!iOSSwiftFile.exists()) iOSSwiftFile.createNewFile()
//    iOSSwiftFile.writeText(SimpleStaticIOS.swiftResult)
//    //endregion
//
//    //region 添加framework依赖 只需要把framework文件拷贝到ios工程下
//    val targetFrameworkDir = File(frameworkPath)
//    if (!targetFrameworkDir.exists()) targetFrameworkDir.mkdirs()
//    FileUtils.copyDirectory(
//        File(frameworkPath),
//        File(frameworkPath + "/" + frameworkPath.substringAfterLast("/"))
//    )
    //endregion
//    println("***************************SimpleStaticIOS-Swift*********************************")
}