package me.yohom.fluttify

import me.yohom.fluttify.task.*
import org.gradle.api.Plugin
import org.gradle.api.Project

lateinit var ext: FluttifyExtension

// 分包原则:
//   1. 包下面有类:
//     1. 有且仅有一个类, 这个类是对包名的实现
//     2. 包下的其他元素只能是子包, 这些子包下的类是当前包下类的组成部分, 其他类推
//   2. 包下面没有类, 只有子包
//     1. 当包下面没有类, 只有并列的子包时, 代表这些子包是相同组成部分的不同情况
open class FluttifyCorePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        ext = project.extensions.create("fluttify", FluttifyExtension::class.java, project.objects)
        ext.android.libDir = "${project.projectDir}/sdk/android/"
        ext.ios.libDir = "${project.projectDir}/sdk/ios/"

        // 必需任务 顺序已经排列好
        val outputProject = project.tasks.create("outputProject", OutputProject::class.java)
        val tweakDefaultProject = project.tasks.create("tweakDefaultProject", TweakDefaultProject::class.java)

        val downloadIOSSDK = project.tasks.create("downloadIOSSDK", DownloadIOSSDK::class.java)
        val downloadAndroidSDK = project.tasks.create("downloadAndroidSDK", DownloadAndroidSDK::class.java)
        val unzip = project.tasks.create("unzipArchive", UnzipArchive::class.java)
        val decompileClass = project.tasks.create("decompileClass", DecompileClass::class.java)

        val androidAddDependency = project.tasks.create("androidAddDependency", AndroidAddDependency::class.java)
        val iOSAddDependency = project.tasks.create("iOSAddDependency", IOSAddDependency::class.java)

        val androidJsonRepresentation =
            project.tasks.create("androidJsonRepresentation", AndroidJsonRepresentation::class.java)
        val iOSJsonRepresentation = project.tasks.create("iOSJsonRepresentation", IOSJsonRepresentation::class.java)

        val androidDartInterface = project.tasks.create("androidDartInterface", AndroidDartInterface::class.java)
        val iOSDartInterface = project.tasks.create("iOSDartInterface", IOSDartInterface::class.java)
        val commonObjects = project.tasks.create("commonObjects", CommonObjects::class.java)

        val androidJavaInterface = project.tasks.create("androidJavaInterface", AndroidJavaInterface::class.java)
        val iOSObjcInterface = project.tasks.create("iOSObjcInterface", IOSObjcInterface::class.java)

        val export = project.tasks.create("export", Export::class.java)
        val fluttify = project.tasks.create("fluttify", Fluttify::class.java)

        // assembly
        fluttify.dependsOn(export)

        // 导出
        export.dependsOn(iOSObjcInterface, androidJavaInterface)

        // 原生接口
        iOSObjcInterface.dependsOn(commonObjects)
        androidJavaInterface.dependsOn(commonObjects)

        // dart接口
        commonObjects.dependsOn(iOSDartInterface)
        commonObjects.dependsOn(androidDartInterface)
        iOSDartInterface.dependsOn(iOSJsonRepresentation)
        androidDartInterface.dependsOn(androidJsonRepresentation)

        // json表示
        iOSJsonRepresentation.dependsOn(iOSAddDependency)
        androidJsonRepresentation.dependsOn(androidAddDependency)

        // 添加依赖
        iOSAddDependency.dependsOn(decompileClass)
        androidAddDependency.dependsOn(decompileClass)

        // 反编译jar
        decompileClass.dependsOn(unzip)

        // 下载SDK
        unzip.dependsOn(downloadAndroidSDK)
        unzip.dependsOn(downloadIOSSDK)
        downloadAndroidSDK.dependsOn(tweakDefaultProject)
        downloadIOSSDK.dependsOn(tweakDefaultProject)

        // 调整默认项目
        tweakDefaultProject.dependsOn(outputProject)
    }
}