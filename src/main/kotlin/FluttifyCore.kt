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

}