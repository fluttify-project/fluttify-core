@file:Suppress("ClassName")

package preprocess

import Configs.frameworkPath
import Configs.mainJavaClass
import Configs.mainObjcClass
import Configs.outputOrg
import Configs.outputProjectName
import builtparser.JavaParser
import common.extensions.underscore2Camel
import common.model.JavaClassInfo
import org.apache.commons.io.FileUtils
import preprocess.Jar.Decompiled.mainClassSimpleName
import preprocess.Jar.`package`
import preprocess.Project.path
import java.io.File

/**
 * 目标jar
 */
object Jar {
    /**
     * Jar的包名, 取[javaPackage]前三个字段
     */
    val `package` = Decompiled.`package`.split(".").subList(0, 3).joinToString(".")

    /**
     * 反编译后的jar
     */
    object Decompiled {
        /**
         * Jar反编译后的源码根路径
         */
        val rootPath = "$path/src/main/resources/android/decompiled"

        /**
         * 主java类的路径
         */
        val mainClassPath =
            "$path/src/main/resources/android/decompiled/${mainJavaClass.replace(".", "/")}.java"

        /**
         * 主java类所在的包名
         */

        val `package` = mainJavaClass.substringBeforeLast(".")
        /**
         * 主java类的类名
         */

        val mainClassSimpleName = mainJavaClass.substringAfterLast(".")

        /**
         * 所有类的信息, key为class simple name, value为对应类的信息
         *
         * 需要遍历反编译后的jar的所有文件来确定所有类的信息
         */
        val classes: Map<String, JavaClassInfo> by lazy {
            val result = mutableMapOf<String, JavaClassInfo>()
            FileUtils
                .iterateFiles(File(rootPath), arrayOf("java"), true)
                .forEach {
                    val typeInfo = JavaParser(it.absolutePath).typeInfo()
                    if (typeInfo != null) {
                        result.putIfAbsent(typeInfo.simpleName, typeInfo)
                    }
                }
            result
        }
    }
}

/**
 * 目标framework
 */
object Framework {
    /**
     * 主objc类的路径
     */
    val mainClassPath: String = "$frameworkPath/Headers/$mainObjcClass.h"

    /**
     * Framework的名字, 没有framework后缀
     */
    val name = frameworkPath.substringAfterLast("/").substringBefore(".")
}

/**
 * 当前项目
 */
object Project {
    /**
     * 当前项目路径
     */
    val path: String = System.getProperty("user.dir")
}

/**
 * 输出的插件项目
 */
object OutputProject {
    /**
     * 生成工程的主类名
     */
    val classSimpleName = outputProjectName.underscore2Camel()

    /**
     * methodChannel名称
     */
    val methodChannel = "$`package`/$mainClassSimpleName"

    /**
     * 输出项目的dart文件相关信息
     */
    object Dart {
        /**
         * 生成工程的Android端Dart文件路径
         */
        val androidDartPath =
            "$path/src/main/resources/outputPluginProject/$outputProjectName/lib/$outputProjectName.android.dart"

        /**
         * 生成工程的iOS端Dart文件路径
         */
        val iOSDartPath =
            "$path/src/main/resources/outputPluginProject/$outputProjectName/lib/$outputProjectName.ios.dart"
    }

    /**
     * 输出项目的android文件相关信息
     */
    object Android {
        /**
         * 生成工程的Android端Kotlin文件路径
         */
        val kotlinPath =
            "$path/src/main/resources/outputPluginProject/$outputProjectName/android/src/main/kotlin/${outputOrg.replace(
                ".",
                "/"
            )}/$outputProjectName/${classSimpleName}Plugin.kt"

        /**
         * 生成工程的Android端Jar路径
         */
        val jarDir = "$path/src/main/resources/outputPluginProject/$outputProjectName/android/libs"
    }

    /**
     * 输出项目的iOS文件相关信息
     */
    object iOS {
        /**
         * 生成工程的iOS端Swift文件路径
         */
        val swiftPath =
            "$path/src/main/resources/outputPluginProject/$outputProjectName/ios/Classes/Swift${classSimpleName}Plugin.swift"

        /**
         * 生成工程的iOS端Framework路径
         */
        val frameworkPath = "$path/src/main/resources/outputPluginProject/$outputProjectName/ios"
    }
}

private fun orgName(path: String): String {
    return if (File(path).listFiles { file -> file?.isDirectory == true }.size <= 1) {
        path
    } else {
        orgName(path.substringBeforeLast("/"))
    }
}