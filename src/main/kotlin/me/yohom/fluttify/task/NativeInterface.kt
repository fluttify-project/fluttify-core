package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.extensions.underscore2Camel
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.tmpl.kotlin.platformviewfactory.PlatformViewFactoryTmpl
import me.yohom.fluttify.common.tmpl.kotlin.plugin.PluginTmpl
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

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
            PluginTmpl(it, ext)
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

                PlatformViewFactoryTmpl(it, ext)
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
open class IOSSwiftInterface : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
    }
}