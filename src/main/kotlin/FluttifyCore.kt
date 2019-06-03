import generator.statik.StaticAndroid
import io.reactivex.Observable
import task.CleanEmptyTask
import task.DecompileTask
import task.UnzipTask
import java.io.File

fun main() {
//    JarDecompiler.run { decompile(); unzip() }

    Observable
        .just(File(Configs.jarPath))
        .map { DecompileTask(it).process() } // 反编译Jar
        .map { UnzipTask(it).process() } // 解压缩反编译Jar
        .map { CleanEmptyTask(it).process() } // 清理空文件
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