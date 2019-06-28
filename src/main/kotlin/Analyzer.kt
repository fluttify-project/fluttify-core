@file:Suppress("ClassName")

import Configs.frameworkDirPath
import Configs.mainJavaClass
import Configs.mainObjcClass
import Configs.outputOrg
import Configs.outputProjectName
import Jar.Decompiled.mainClassSimpleName
import Project.path
import common.TYPE_NAME
import common.extensions.*
import common.model.JavaTypeInfo
import common.model.ObjcTypeInfo
import org.apache.commons.io.FileUtils
import java.io.File

/**
 * 目标jar
 */
object Jar {
    /**
     * Jar的包名, 取[javaPackage]前三个字段
     */
    val `package` = Jar.Decompiled.`package`.split(".").subList(0, 3).joinToString(".")

    /**
     * jar的文件名
     */
    val name = Configs.jarFilePath.substringAfterLast("/")

    /**
     * 反编译后的jar
     */
    object Decompiled {
        /**
         * Jar反编译后的源码根路径
         */
        val rootDirPath = "$path/build/decompiled/"

        /**
         * 主java类的路径
         */
        val mainClassFilePath = "$rootDirPath/${mainJavaClass.replace(".", "/")}.java"

        /**
         * 主java类所在的包名
         */

        val `package` = mainJavaClass.substringBeforeLast(".")

        /**
         * 主java类的类名
         */
        val mainClassSimpleName = mainJavaClass.substringAfterLast(".")

        /**
         * Jar内所有类的信息, key为class simple name, value为对应类的信息
         *
         * 需要遍历反编译后的jar的所有文件来确定所有类的信息
         */
        val classes: Map<TYPE_NAME, JavaTypeInfo> by lazy {
            val result = mutableMapOf<TYPE_NAME, JavaTypeInfo>()
            FileUtils
                .iterateFiles(File(rootDirPath), arrayOf("java"), true)
                .forEach {
                    val typeInfo = it.javaTypeInfo()
                    result.putIfAbsent(typeInfo.name.replace("$", "."), typeInfo)
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
    val mainClassFilePath = "$frameworkDirPath/Headers/$mainObjcClass.h"

    /**
     * Framework的名字, 没有framework后缀
     */
    val name = frameworkDirPath.substringAfterLast("/").substringBefore(".")

    /**
     * framework中的所有类都单独放一个文件 因为objc的模型类可能多个模型类写在一个文件里,
     * 在识别的时候把它们分散到单独的文件中去, 供下一步处理
     */
    val singleClassesDirPath = "$path/build/objc-classes/"

    /**
     * Framework内所有类的信息, key为class simple name, value为对应类的信息
     *
     * 遍历Headers内的所有类文件
     */
    val classes: Map<TYPE_NAME, ObjcTypeInfo> by lazy {
        val result = mutableMapOf<TYPE_NAME, ObjcTypeInfo>()
        FileUtils
            .iterateFiles(singleClassesDirPath.file(), null, true)
            .forEach {
                val typeInfo = it.absolutePath.file().objcTypeInfo()
                result.putIfAbsent(typeInfo.name, typeInfo)
            }
        result
    }
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
    val methodChannel = "$outputOrg/$classSimpleName"

    /**
     * 输出工程路径
     */
    val dirPath = "$path/build/output-project/$outputProjectName/"

    /**
     * 输出项目的dart文件相关信息
     */
    object Dart {
        /**
         * 生成工程的lib路径
         */
        val libDirPath = "$path/build/output-project/$outputProjectName/lib/"

        /**
         * 生成工程的Android端Dart文件路径
         */
        val androidDirPath = "$libDirPath/src/android/"

        /**
         * 生成工程的Android端PlatformView的Dart文件路径
         */
        val androidPlatformViewFilePath = "${androidDirPath}android_${mainClassSimpleName.camel2Underscore()}.dart"

        /**
         * 生成工程的Android端PlatformViewController的Dart文件路径
         */
        val androidDartControllerFilePath =
            "${androidDirPath}android_${mainClassSimpleName.camel2Underscore()}_controller.dart"

        /**
         * 生成工程的Android端Dart模型文件路径
         */
        val androidModelDirPath = "$libDirPath/src/android/model/"

        /**
         * 生成工程的iOS端Dart文件路径
         */
        val iOSDirPath = "$libDirPath/src/ios/"

        /**
         * 生成工程的iOS端Dart模型文件路径
         */
        val iOSModelDirPath = "$libDirPath/src/ios/model/"
    }

    /**
     * 输出项目的android文件相关信息
     */
    object Android {
        /**
         * 生成工程的Android端Kotlin路径
         */
        val kotlinDirPath =
            "$path/build/output-project/$outputProjectName/android/src/main/kotlin/${outputOrg.package2Path()}/$outputProjectName/"

        /**
         * 生成工程的Android端Kotlin文件路径
         */
        val kotlinFilePath =
            "$path/build/output-project/$outputProjectName/android/src/main/kotlin/${outputOrg.package2Path()}/$outputProjectName/${classSimpleName}Plugin.kt"

        /**
         * PlatformViewFactory文件路径
         */
        val platformViewFactoryFilePath =
            "$path/build/output-project/$outputProjectName/android/src/main/kotlin/${outputOrg.package2Path()}/$outputProjectName/${classSimpleName}Factory.kt"

        /**
         * PlatformView文件路径
         */
        val platformViewFilePath =
            "$path/build/output-project/$outputProjectName/android/src/main/kotlin/${outputOrg.package2Path()}/$outputProjectName/$classSimpleName.kt"

        /**
         * 生成工程的Android端Jar路径
         */
        val jarDirPath = "$path/build/output-project/$outputProjectName/android/libs/"
    }

    /**
     * 输出项目的iOS文件相关信息
     */
    object iOS {
        /**
         * 生成工程的iOS端Swift文件路径
         */
        val swiftFilePath =
            "$path/build/output-project/$outputProjectName/ios/Classes/Swift${classSimpleName}Plugin.swift"

        /**
         * 生成工程的iOS端Framework路径
         */
        val frameworkDirPath = "$path/build/output-project/$outputProjectName/ios/"
    }
}
