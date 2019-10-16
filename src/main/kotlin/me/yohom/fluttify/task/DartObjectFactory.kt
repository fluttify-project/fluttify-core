package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.tmpl.dart.object_factory.ObjectFactoryTmpl
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.TaskAction

/**
 * 生成对象创建者的类
 *
 * 输入: 要生成ObjectCreator的文件夹
 * 输出: 生成后的ObjectCreator Dart文件
 */
open class DartObjectFactory : FluttifyTask() {
    @InputFiles
    val irFiles = listOf(
        "${project.projectDir}/ir/android/json_representation.json".file(),
        "${project.projectDir}/ir/ios/json_representation.json".file()
    )

//    @OutputFiles
//    val objectFactoryFiles = listOf(
//        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/object_factory.dart".file(),
//        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/object_factory.dart".file()
//    )

    @TaskAction
    fun process() {
        val androidSdk = irFiles[0].readText().fromJson<SDK>()
        val iosSdk = irFiles[1].readText().fromJson<SDK>()

        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/object_factory.g.dart".file()
            .writeText(ObjectFactoryTmpl(androidSdk.libs, ext, Platform.Android).dartObjectFactory())
        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/object_factory.g.dart".file()
            .writeText(ObjectFactoryTmpl(iosSdk.libs, ext, Platform.iOS).dartObjectFactory())
    }
}