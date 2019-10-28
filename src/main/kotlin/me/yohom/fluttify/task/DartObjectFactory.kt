package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.tmpl.dart.object_factory.ObjectFactoryTmpl
import org.gradle.api.tasks.TaskAction

/**
 * 生成对象创建者的类
 *
 * 输入: 要生成ObjectCreator的文件夹
 * 输出: 生成后的ObjectCreator Dart文件
 */
open class DartObjectFactory : FluttifyTask() {

    @TaskAction
    fun process() {
        val irFiles = listOf(
            "${project.projectDir}/jr/${ext.outputProjectName}.android.json".file(),
            "${project.projectDir}/jr/${ext.outputProjectName}.ios.json".file()
        )
        val androidSdk = irFiles[0].readText().fromJson<SDK>()
        val iosSdk = irFiles[1].readText().fromJson<SDK>()

        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/object_factory.g.dart".file()
            .writeText(ObjectFactoryTmpl(androidSdk.directLibs, Platform.Android).dartObjectFactory())
        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/object_factory.g.dart".file()
            .writeText(ObjectFactoryTmpl(iosSdk.directLibs, Platform.iOS).dartObjectFactory())
    }
}