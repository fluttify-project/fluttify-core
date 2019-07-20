@file:Suppress("ClassName")

package me.yohom.fluttify

import me.yohom.fluttify.FluttifyCorePluginExtension.frameworkDirPath
import me.yohom.fluttify.FluttifyCorePluginExtension.outputOrg
import me.yohom.fluttify.FluttifyCorePluginExtension.outputProjectName
import me.yohom.fluttify.FluttifyProject.path
import me.yohom.fluttify.common.TYPE_NAME
import common.extensions.*
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Type
import org.apache.commons.io.FileUtils
import java.io.File

/**
 * 目标jar
 */
object Jar {
    /**
     * jar的文件名
     */
    val name = FluttifyCorePluginExtension.jarFilePath.substringAfterLast("/")

    /**
     * 反编译后的jar
     */
    object Decompiled {
        /**
         * Jar反编译后的源码根路径
         */
        val rootDirPath = "$path/build/decompiled/"

        /**
         * Jar内所有类的信息, key为class simple name, value为对应类的信息
         *
         * 需要遍历反编译后的jar的所有文件来确定所有类的信息
         */
        val CLASSES: Map<TYPE_NAME, Type> by lazy {
            val result = mutableMapOf<TYPE_NAME, Type>()
            FileUtils
                .iterateFiles(File(rootDirPath), arrayOf("java"), true)
                .forEach {
                    val typeInfo = it.javaType()
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
     * Framework的名字, 没有framework后缀
     */
    val name = frameworkDirPath.substringAfterLast("/").substringBefore(".")

    /**
     * framework中的所有类都单独放一个文件 因为objc的模型类可能多个模型类写在一个文件里,
     * 在识别的时候把它们分散到单独的文件中去, 供下一步处理
     */
    @Deprecated("新模型下不需要这个了")
    val singleClassesDirPath = "$path/build/objc-classes/"

    /**
     * Framework内所有类的信息, key为class simple name, value为对应类的信息
     *
     * 遍历Headers内的所有类文件
     */
    val CLASSES: Map<TYPE_NAME, Type> by lazy {
        val result = mutableMapOf<TYPE_NAME, Type>()

        frameworkDirPath
            .file()
            .iterate("h") {
                it.absolutePath
                    .file()
                    .objcType()
                    .forEach { type -> result.putIfAbsent(type.name, type) }
            }

        result
    }
}

/**
 * 当前项目
 */
object FluttifyProject {
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
         * 生成工程的系统引用的Dart文件路径
         */
        val systemRefFilePath = "$libDirPath/src/android/system_ref.dart"

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
         * 生成工程的Android端Jar路径
         */
        val jarDirPath = "$path/build/output-project/$outputProjectName/android/libs/"
    }

    /**
     * 输出项目的iOS文件相关信息
     */
    object iOS {
        /**
         * 生成工程的iOS端Swift路径
         */
        val swiftDirPath =
            "$path/build/output-project/$outputProjectName/ios/Classes/"

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
