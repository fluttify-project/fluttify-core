package me.yohom.fluttify

import me.yohom.fluttify.task.*
import org.gradle.api.Plugin
import org.gradle.api.Project

// todo 实现输入输出的指定
open class FluttifyCorePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("fluttify", FluttifyExtension::class.java)

        // 必需任务 顺序已经排列好
        val unzip = project.tasks.create("unzipJar", UnzipJar::class.java)
        val decompileClass = project.tasks.create("decompileClass", DecompileClass::class.java)
        val outputProject = project.tasks.create("outputProject", OutputProject::class.java)
        val tweakDefaultProject = project.tasks.create("tweakDefaultProject", TweakDefaultProject::class.java)
        val androidAddDependency = project.tasks.create("androidAddDependency", AndroidAddDependency::class.java)
        val iOSAddDependency = project.tasks.create("iOSAddDependency", IOSAddDependency::class.java)
        val androidJsonRepresentation = project.tasks.create("androidJsonRepresentation", AndroidJsonRepresentation::class.java)
        val iOSJsonRepresentation = project.tasks.create("iOSJsonRepresentation", IOSJsonRepresentation::class.java)
        val androidDartInterface = project.tasks.create("androidDartInterface", AndroidDartInterface::class.java)
        val iOSDartInterface = project.tasks.create("iOSDartInterface", IOSDartInterface::class.java)
        val androidKotlinInterface = project.tasks.create("androidKotlinInterface", AndroidKotlinInterface::class.java)
        val iOSObjcInterface = project.tasks.create("iOSObjcInterface", IOSObjcInterface::class.java)
        val iOSSwiftInterface = project.tasks.create("iOSSwiftInterface", IOSSwiftInterface::class.java) // 暂时不用
        val dartObjectFactory = project.tasks.create("dartObjectFactory", DartObjectFactory::class.java)
        val export = project.tasks.create("export", Export::class.java)

        // 可选任务
        val cleanEmpty = project.tasks.create("cleanEmpty", CleanEmpty::class.java)
        val dartfmt = project.tasks.create("dartfmt", Dartfmt::class.java)

//        export.dependsOn(dartObjectFactory)
//        dartObjectFactory.dependsOn(iOSObjcInterface)
//        iOSObjcInterface.dependsOn(androidKotlinInterface)
//        androidKotlinInterface.dependsOn(iOSDartInterface)
//        iOSDartInterface.dependsOn(androidDartInterface)
//        androidDartInterface.dependsOn(iOSJsonRepresentation)
//        iOSJsonRepresentation.dependsOn(androidJsonRepresentation)
//        androidJsonRepresentation.dependsOn(iOSAddDependency)
//        iOSAddDependency.dependsOn(androidAddDependency)
//        androidAddDependency.dependsOn(tweakDefaultProject)
//        tweakDefaultProject.dependsOn(outputProject)
//        outputProject.dependsOn(decompileClass)
//        decompileClass.dependsOn(unzip)
//
//        project.task("fluttify").dependsOn(export)

//        decompileClass.dependsOn(unzip)

//        addDependency.dependsOn(decompileClass)
//        addDependency.dependsOn(outputProject)
//
//        androidJsonRepresentation.dependsOn(decompileClass)

//        androidDartInterface.dependsOn(androidAddDependency)
//        androidDartInterface.dependsOn(androidJsonRepresentation)

//        androidKotlinInterface.dependsOn(decompileClass)

//        dartfmt.dependsOn(androidDartInterface)

//        export.dependsOn(androidDartInterface)
    }
}