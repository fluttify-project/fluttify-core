package me.yohom.fluttify

import me.yohom.fluttify.task.*
import org.gradle.api.Plugin
import org.gradle.api.Project

lateinit var ext: FluttifyExtension

// todo 可以提供一些启动Activity的方法, 就是以`迁移原生平台的代码`为场景的功能
open class FluttifyCorePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        ext = project.extensions.create("fluttify", FluttifyExtension::class.java)
        ext.archiveDir = "${project.projectDir}/sdk/android/"
        ext.frameworkDir = "${project.projectDir}/sdk/ios/"

        // 必需任务 顺序已经排列好
        val unzip = project.tasks.create("unzipArchive", UnzipArchive::class.java)
        val decompileClass = project.tasks.create("decompileClass", DecompileClass::class.java)
        val outputProject = project.tasks.create("outputProject", OutputProject::class.java)
        val tweakDefaultProject = project.tasks.create("tweakDefaultProject", TweakDefaultProject::class.java)
        val androidAddDependency = project.tasks.create("androidAddDependency", AndroidAddDependency::class.java)
        val iOSAddDependency = project.tasks.create("iOSAddDependency", IOSAddDependency::class.java)
        val androidJsonRepresentation =
            project.tasks.create("androidJsonRepresentation", AndroidJsonRepresentation::class.java)
        val iOSJsonRepresentation = project.tasks.create("iOSJsonRepresentation", IOSJsonRepresentation::class.java)
        val androidDartInterface = project.tasks.create("androidDartInterface", AndroidDartInterface::class.java)
        val iOSDartInterface = project.tasks.create("iOSDartInterface", IOSDartInterface::class.java)
        val androidKotlinInterface = project.tasks.create("androidKotlinInterface", AndroidKotlinInterface::class.java)
        val androidJavaInterface = project.tasks.create("androidJavaInterface", AndroidJavaInterface::class.java)
        val iOSObjcInterface = project.tasks.create("iOSObjcInterface", IOSObjcInterface::class.java)
        val iOSSwiftInterface = project.tasks.create("iOSSwiftInterface", IOSSwiftInterface::class.java) // 暂时不用
        val dartObjectFactory = project.tasks.create("dartObjectFactory", DartObjectFactory::class.java)
        val export = project.tasks.create("export", Export::class.java)

        // 可选任务
        val cleanEmpty = project.tasks.create("cleanEmpty", CleanEmpty::class.java)
        val dartfmt = project.tasks.create("dartfmt", Dartfmt::class.java)

        // 导出
        export.dependsOn(dartObjectFactory)

        // 对象工厂
        dartObjectFactory.dependsOn(iOSObjcInterface, androidJavaInterface)

        // 原生接口
        iOSObjcInterface.dependsOn(iOSDartInterface)
//        androidKotlinInterface.dependsOn(androidDartInterface)
        androidJavaInterface.dependsOn(androidDartInterface)

        // dart接口
        iOSDartInterface.dependsOn(iOSJsonRepresentation)
        androidDartInterface.dependsOn(androidJsonRepresentation)

        // json表示
        iOSJsonRepresentation.dependsOn(iOSAddDependency)
        androidJsonRepresentation.dependsOn(androidAddDependency)

        // 添加依赖
        iOSAddDependency.dependsOn(tweakDefaultProject)
        androidAddDependency.dependsOn(tweakDefaultProject)

        // 调整默认项目
        tweakDefaultProject.dependsOn(outputProject)

        // 创建插件工程
        outputProject.dependsOn(decompileClass)

        // 反编译jar
        decompileClass.dependsOn(unzip)

        // assembly
        project.task("fluttify").apply { group = "fluttify" }.dependsOn(export)
    }
}