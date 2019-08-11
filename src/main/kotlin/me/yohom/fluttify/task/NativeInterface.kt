package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.extensions.underscore2Camel
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.tmpl.objc.platformviewfactory.PlatformViewFactoryTmpl
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import me.yohom.fluttify.common.tmpl.kotlin.platformviewfactory.PlatformViewFactoryTmpl as KotlinPlatformViewFactoryTmpl
import me.yohom.fluttify.common.tmpl.kotlin.plugin.PluginTmpl as KotlinPluginTmpl
import me.yohom.fluttify.common.tmpl.objc.plugin.PluginTmpl as ObjcPluginTmpl

/**
 * Android端接口生成
 *
 * 输入: java文件
 * 输出: 对应的method channel文件
 */
open class AndroidKotlinInterface : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val pluginOutputFile =
            "${project.projectDir}/output-project/${ext.outputProjectName}/android/src/main/kotlin/${ext.outputOrg.replace(
                ".",
                "/"
            )}/${ext.outputProjectName}/${ext.outputProjectName.underscore2Camel(true)}Plugin.kt"

        val sdk = "${project.projectDir}/ir/android/json_representation.json".file().readText().fromJson<SDK>()

        // 生成主plugin文件
        sdk.libs.forEach {
            KotlinPluginTmpl(it, ext)
                .kotlinPlugin()
                .run {
                    pluginOutputFile.file().writeText(this)
                }
        }

        // 生成PlatformViewFactory文件
        sdk.libs
            .flatMap { it.types }
            .filter { it.isView() }
            .forEach {
                val factoryOutputFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/android/src/main/kotlin/${ext.outputOrg.replace(
                        ".",
                        "/"
                    )}/${ext.outputProjectName}/${it.name.simpleName()}Factory.kt".file()

                KotlinPlatformViewFactoryTmpl(it, ext)
                    .kotlinPlatformViewFactory()
                    .run {
                        factoryOutputFile.writeText(this)
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
open class IOSObjcInterface : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val pluginOutputFile =
            "${project.projectDir}/output-project/${ext.outputProjectName}/ios/Classes/${ext.outputProjectName.underscore2Camel(
                true
            )}Plugin.m"

        val sdk = "${project.projectDir}/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

        // 生成主plugin文件
        ObjcPluginTmpl(sdk.libs, ext)
            .swiftPlugin()
            .run {
                pluginOutputFile.file().writeText(this)
            }

        // 生成PlatformViewFactory文件
        sdk.libs
            .forEach { lib ->
                lib.types
                    .filter { it.isView() }
                    .forEach {
                        val factoryOutputFile =
                            "${project.projectDir}/output-project/${ext.outputProjectName}/ios/Classes/${it.name.simpleName()}Factory.swift".file()

                        PlatformViewFactoryTmpl(it, lib)
                            .swiftPlatformViewFactory()
                            .run {
                                factoryOutputFile.writeText(this)
                            }
                    }
            }
    }
}