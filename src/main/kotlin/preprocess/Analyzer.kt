package preprocess

import Configs.frameworkPath
import Configs.mainJavaClass
import Configs.mainObjcClass
import Configs.outputOrg
import Configs.outputProjectName
import common.underscore2Camel
import java.io.File

object Analyzer {
    //region 路径类
    /**
     * 主java类的路径
     */
    var mainJavaClassPath: String = ""
    /**
     * 主objc类的路径
     */
    var mainObjcClassPath: String = ""
    /**
     * 当前项目路径
     */
    val projectPath: String = System.getProperty("user.dir")
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
     * Jar反编译后的源码根路径
     */
    var jarSourcePath: String = ""
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
     * 生成工程的Android端Jar路径
     */
    var outputPluginAndroidJarDir: String = ""
    //endregion

    //region 名称类
    /**
     * 主java类所在的包名
     */
    var javaPackage: String = ""
    /**
     * 主java类的类名
     */
    var javaClassSimpleName: String = ""
    /**
     * method channel的名字
     */
    var methodChannelName: String = ""
    /**
     * 生成工程的主类名
     */
    var pluginClassSimpleName: String = ""
    /**
     * Jar的包名, 取[javaPackage]前三个字段
     */
    var jarPackage: String = ""
    /**
     * Framework的名字, 没有framework后缀
     */
    var frameworkName: String = ""
    //endregion

    fun analyze() {
        mainJavaClassPath = "$projectPath/src/main/resources/android/decompiled/${mainJavaClass.replace(".", "/")}.java"
        javaPackage = mainJavaClass.substringBeforeLast(".")
        javaClassSimpleName = mainJavaClass.substringAfterLast(".")
        mainObjcClassPath = "$frameworkPath/Headers/$mainObjcClass.h"
        jarPackage = javaPackage.split(".").subList(0, 3).joinToString(".")
        jarSourcePath = "$projectPath/src/main/resources/android/decompiled"
        methodChannelName = "$jarPackage/$javaClassSimpleName"
        pluginClassSimpleName = outputProjectName.underscore2Camel()
        outputPluginDartPath =
            "$projectPath/src/main/resources/outputPluginProject/$outputProjectName/lib/$outputProjectName.dart"
        outputPluginAndroidDartPath =
            "$projectPath/src/main/resources/outputPluginProject/$outputProjectName/lib/$outputProjectName.android.dart"
        outputPluginAndroidKotlinPath =
            "$projectPath/src/main/resources/outputPluginProject/$outputProjectName/android/src/main/kotlin/${outputOrg.replace(
                ".",
                "/"
            )}/$outputProjectName/${pluginClassSimpleName}Plugin.kt"
        outputPluginAndroidJarDir = "$projectPath/src/main/resources/outputPluginProject/$outputProjectName/android/libs"
        outputPluginIOSDartPath =
            "$projectPath/src/main/resources/outputPluginProject/$outputProjectName/lib/$outputProjectName.ios.dart"
        outputPluginIOSSwiftPath =
            "$projectPath/src/main/resources/outputPluginProject/$outputProjectName/ios/Classes/Swift${pluginClassSimpleName}Plugin.swift"
        outputPluginIOSFrameworkPath = "$projectPath/src/main/resources/outputPluginProject/$outputProjectName/ios"
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