package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.tmpl.java.common.handler.handler_getter.HandlerGetterBatchTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_getter.HandlerGetterTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_method.HandlerMethodBatchTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_method.HandlerMethodTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_object_creator.HandlerObjectFactoryBatchTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_object_creator.HandlerObjectFactoryTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_setter.HandlerSetterTmpl
import me.yohom.fluttify.tmpl.java.plugin.JavaPluginTmpl
import me.yohom.fluttify.tmpl.java.plugin.sub_handler.SubHandlerTmpl
import me.yohom.fluttify.tmpl.kotlin.plugin.KotlinPluginTmpl
import me.yohom.fluttify.tmpl.objc.plugin.ObjcPluginTmpl
import org.gradle.api.tasks.TaskAction
import me.yohom.fluttify.tmpl.java.platform_view_factory.PlatformViewFactoryTmpl as JavaPlatformViewFactory
import me.yohom.fluttify.tmpl.kotlin.platform_view_factory.PlatformViewFactoryTmpl as KotlinPlatformViewFactory
import me.yohom.fluttify.tmpl.objc.platform_view_factory.PlatformViewFactoryTmpl as ObjcPlatformViewFactory

/**
 * Android端接口生成
 *
 * 输入: java文件
 * 输出: 对应的method channel文件
 */
open class AndroidJavaInterface : FluttifyTask() {

    @TaskAction
    fun process() {
        val projectDir = project.projectDir
        val projectName = ext.projectName
        val packageSubDir = ext.org.replace(".", "/")

        val jrFile = "$projectDir/jr/$projectName.android.json".file()
        val packageDir = "$projectDir/output-project/$projectName/android/src/main/java/$packageSubDir/$projectName"
        val pluginOutputFile = "$packageDir/${ext.projectName.underscore2Camel()}Plugin.java"
        val subHandlerOutputDir = "$packageDir/sub_handler"
        val subHandlerOutputFile = "$subHandlerOutputDir/SubHandler#__number__#.java"

        val sdk = jrFile.readText().fromJson<SDK>()

        // 生成主plugin文件
        sdk.directLibs.forEach { lib ->
            val getters = lib.types
                .filterType()
                .flatMap { it.fields }
                .filterGetters()
                .map { HandlerGetterTmpl(it) }

            val gettersBatch = lib.types
                .filterType()
                .flatMap { it.fields }
                .filterGetters()
                .map { HandlerGetterBatchTmpl(it) }

            val setters = lib.types
                .filterType()
                .flatMap { it.fields }
                .filterSetters()
                .map { HandlerSetterTmpl(it) }

            val methods = lib.types
                .filterType()
                .flatMap { it.methods }
                .filterMethod()
                .map { HandlerMethodTmpl(it) }

            val methodsBatch = lib.types
                .filterType()
                .flatMap { it.methods }
                .filterMethod(true)
                .map { HandlerMethodBatchTmpl(it) }

            val objectCreators = lib.types
                .filterConstructable()
                .flatMap { HandlerObjectFactoryTmpl(it) }

            val objectCreatorsBatch = lib.types
                .filterConstructable()
                .flatMap { HandlerObjectFactoryBatchTmpl(it) }

            getters
                .union(gettersBatch)
                .union(setters)
                .union(methods)
                .union(methodsBatch)
                .union(objectCreators)
                .union(objectCreatorsBatch)
                .toObservable()
                .buffer(200)
                .blockingIterable()
                .mapIndexed { index, subHandler -> SubHandlerTmpl(index, subHandler) }
                .forEachIndexed { index, content ->
                    subHandlerOutputFile.replace("#__number__#", index.toString()).file().writeText(content)
                }

            JavaPluginTmpl(lib, subHandlerOutputDir)
                .run {
                    pluginOutputFile.file().writeText(this)
                }
        }

        // 生成PlatformViewFactory文件
        sdk.directLibs
            .forEach { lib ->
                lib.types
                    .filter { it.isView() && !it.isObfuscated() }
                    .forEach {
                        val factoryOutputFile =
                            "${project.projectDir}/output-project/${ext.projectName}/android/src/main/java/${ext.org.replace(
                                ".",
                                "/"
                            )}/${ext.projectName}/${it.name.simpleName()}Factory.java".file()

                        JavaPlatformViewFactory(it)
                            .run {
                                factoryOutputFile.writeText(this)
                            }
                    }
            }
    }
}

/**
 * Android端接口生成
 *
 * 输入: java文件
 * 输出: 对应的method channel文件
 */
open class AndroidKotlinInterface : FluttifyTask() {

    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/${ext.projectName}.android.json".file()
        val pluginOutputFile =
            "${project.projectDir}/output-project/${ext.projectName}/android/src/main/kotlin/${ext.org.replace(
                ".",
                "/"
            )}/${ext.projectName}/${ext.projectName.underscore2Camel()}Plugin.kt"

        val sdk = jrFile.readText().fromJson<SDK>()

        // 生成主plugin文件
        sdk.directLibs.forEach {
            KotlinPluginTmpl(it)
                .kotlinPlugin()
                .run {
                    pluginOutputFile.file().writeText(this)
                }
        }

        // 生成PlatformViewFactory文件
        sdk.directLibs
            .forEach { lib ->
                lib.types
                    .filter { it.isView() && !it.isObfuscated() }
                    .forEach {
                        val factoryOutputFile =
                            "${project.projectDir}/output-project/${ext.projectName}/android/src/main/kotlin/${ext.org.replace(
                                ".",
                                "/"
                            )}/${ext.projectName}/${it.name.simpleName()}Factory.kt".file()

                        KotlinPlatformViewFactory(it)
                            .kotlinPlatformViewFactory()
                            .run {
                                factoryOutputFile.writeText(this)
                            }
                    }
            }
    }
}

/**
 * iOS端接口生成
 *
 * 输入: framework文件夹
 * 输出: 对应的method channel文件
 */
open class IOSObjcInterface : FluttifyTask() {

    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/${ext.projectName}.ios.json".file()
        val pluginHFile =
            "${project.projectDir}/output-project/${ext.projectName}/ios/Classes/${ext.projectName.underscore2Camel()}Plugin.h"
        val pluginMFile =
            "${project.projectDir}/output-project/${ext.projectName}/ios/Classes/${ext.projectName.underscore2Camel()}Plugin.m"

        val sdk = jrFile.readText().fromJson<SDK>()

        // 生成主plugin文件
        ObjcPluginTmpl(sdk.directLibs)
            .run {
                pluginHFile.file().writeText(this[0])
                pluginMFile.file().writeText(this[1])
            }

        // 生成PlatformViewFactory文件
        sdk.directLibs
            .forEach { lib ->
                lib.types
                    .filter { it.isView() && !it.isObfuscated() }
                    .forEach {
                        val factoryHFile =
                            "${project.projectDir}/output-project/${ext.projectName}/ios/Classes/${it.name.simpleName()}Factory.h".file()
                        val factoryMFile =
                            "${project.projectDir}/output-project/${ext.projectName}/ios/Classes/${it.name.simpleName()}Factory.m".file()

                        ObjcPlatformViewFactory(it, lib)
                            .run {
                                factoryHFile.writeText(this[0])
                                factoryMFile.writeText(this[1])
                            }
                    }
            }
    }
}

/**
 * iOS端swift接口生成
 *
 * 输入: framework文件夹
 * 输出: 对应的method channel文件
 */
open class IOSSwiftInterface : FluttifyTask() {

    @TaskAction
    fun process() {
//        val pluginOutputFile =
//            "${project.projectDir}/output-project/${ext.projectName}/ios/Classes/Swift${ext.projectName.underscore2Camel()}Plugin.swift"
//
//        val sdk = "${project.projectDir}/ir/ios/json_representation.json".file().readText().fromJson<SDK>()
//
//        // 生成主plugin文件
//        SwiftPluginTmpl(sdk.libs, ext)
//            .swiftPlugin()
//            .run {
//                pluginOutputFile.file().writeText(this)
//            }
//
//        // 生成PlatformViewFactory文件
//        sdk.libs
//            .forEach { lib ->
//                lib.types
//                    .filter { it.isView() }
//                    .forEach {
//                        val factoryOutputFile =
//                            "${project.projectDir}/output-project/${ext.projectName}/ios/Classes/${it.name.simpleName()}Factory.swift".file()
//
//                        SwiftPlatformViewFactoryTmpl(it, lib)
//                            .swiftPlatformViewFactory()
//                            .run {
//                                factoryOutputFile.writeText(this)
//                            }
//                    }
//            }
    }
}