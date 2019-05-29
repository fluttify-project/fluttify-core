package preprocess

import Configs.frameworkPath
import Configs.mainJavaClass
import Configs.mainObjcClass
import Configs.outputOrg
import Configs.outputProjectName
import common.underscore2Camel
import java.io.File

object Analyzer {
    /**
     * 主java类的路径
     */
    var mainJavaClassPath: String = ""
    /**
     * 主java类所在的包名
     */
    var javaPackage: String = ""
    /**
     * 主java类的类名
     */
    var javaClassSimpleName: String = ""
    /**
     * 主objc类的路径
     */
    var mainObjcClassPath: String = ""
    /**
     * method channel的名字
     */
    var methodChannelName: String = ""
    /**
     * 当前项目路径
     */
    val projectPath: String = System.getProperty("user.dir")
    /**
     * 生成工程的主类名
     */
    var pluginClassSimpleName: String = ""
    /**
     * 生成工程的Dart文件路径
     */
    var outputPluginDartPath: String = ""
    /**
     * 生成工程的Android端Dart文件路径
     */
    var outputPluginAndroidDartPath: String = ""
    /**
     * 生成工程的Android端Kotlin文件路径
     */
    var outputPluginAndroidKotlinPath: String = ""
    /**
     * 生成工程的Android端Jar路径
     */
    var outputPluginAndroidJarDir: String = ""
    /**
     * Jar的包名, 通过判断哪一层文件夹下开始有多个文件夹来判断
     */
    var jarPackage: String = ""
    /**
     * 生成工程的iOS端Dart文件路径
     */
    var outputPluginIOSDartPath: String = ""
    /**
     * 生成工程的iOS端Swift文件路径
     */
    var outputPluginIOSSwiftPath: String = ""
    /**
     * 生成工程的iOS端Framework路径
     */
    var outputPluginIOSFrameworkPath: String = ""
    /**
     * Framework的名字, 没有framework后缀
     */
    var frameworkName: String = ""

    fun analyze() {
        mainJavaClassPath = "$projectPath/resource/android/decompiled/${mainJavaClass.replace(".", "/")}.java"
        javaPackage = mainJavaClass.substringBeforeLast(".")
        javaClassSimpleName = mainJavaClass.substringAfterLast(".")
        mainObjcClassPath = "$frameworkPath/Headers/$mainObjcClass.h"
        // jar的包名采取java包名截取前三段
        jarPackage = javaPackage.split(".").subList(0, 3).joinToString(".")
        methodChannelName = "$jarPackage/$javaClassSimpleName"
        pluginClassSimpleName = outputProjectName.underscore2Camel()
        outputPluginDartPath =
            "$projectPath/resource/outputPluginProject/$outputProjectName/lib/$outputProjectName.dart"
        outputPluginAndroidDartPath =
            "$projectPath/resource/outputPluginProject/$outputProjectName/lib/$outputProjectName.android.dart"
        outputPluginAndroidKotlinPath =
            "$projectPath/resource/outputPluginProject/$outputProjectName/android/src/main/kotlin/${outputOrg.replace(
                ".",
                "/"
            )}/$outputProjectName/${pluginClassSimpleName}Plugin.kt"
        outputPluginAndroidJarDir = "$projectPath/resource/outputPluginProject/$outputProjectName/android/libs"
        outputPluginIOSDartPath =
            "$projectPath/resource/outputPluginProject/$outputProjectName/lib/$outputProjectName.ios.dart"
        outputPluginIOSSwiftPath =
            "$projectPath/resource/outputPluginProject/$outputProjectName/ios/Classes/Swift${pluginClassSimpleName}Plugin.swift"
        outputPluginIOSFrameworkPath = "$projectPath/resource/outputPluginProject/$outputProjectName/ios"
        frameworkName = frameworkPath.substringAfterLast("/").substringBefore(".")
    }

    private fun orgName(path: String): String {
        return if (File(path).listFiles { file -> file?.isDirectory == true }.size <= 1) {
            path
        } else {
            orgName(path.substringBeforeLast("/"))
        }
    }
}