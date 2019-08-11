package me.yohom.fluttify

import me.yohom.fluttify.task.*
import org.gradle.api.Plugin
import org.gradle.api.Project

open class FluttifyCorePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("fluttify", FluttifyExtension::class.java)

        val unzip = project.tasks.create("unzipJar", UnzipJar::class.java)
        val decompileClass = project.tasks.create("decompileClass", DecompileClass::class.java)
        val androidAddDependency = project.tasks.create("androidAddDependency", AndroidAddDependency::class.java)
        val iOSAddDependency = project.tasks.create("iOSAddDependency", IOSAddDependency::class.java)
        val outputProject = project.tasks.create("outputProject", OutputProject::class.java)
        val cleanEmpty = project.tasks.create("cleanEmpty", CleanEmpty::class.java)
        val dartfmt = project.tasks.create("dartfmt", Dartfmt::class.java)
        val export = project.tasks.create("export", Export::class.java)
        val systemRef = project.tasks.create("systemRef", AndroidSystemRef::class.java)
        val objectFactory = project.tasks.create("objectFactory", ObjectFactory::class.java)
        val androidDartInterface = project.tasks.create("androidDartInterface", AndroidDartInterface::class.java)
        val iOSDartInterface = project.tasks.create("iOSDartInterface", IOSDartInterface::class.java)
        val androidKotlinInterface = project.tasks.create("androidKotlinInterface", AndroidKotlinInterface::class.java)
        val iOSSwiftInterface = project.tasks.create("iOSSwiftInterface", IOSObjcInterface::class.java)
        val androidJsonRepresentation = project.tasks.create("androidJsonRepresentation", AndroidJsonRepresentation::class.java)
        val iOSJsonRepresentation = project.tasks.create("iOSJsonRepresentation", IOSJsonRepresentation::class.java)

//        decompileClass.dependsOn(unzip)

//        addDependency.dependsOn(decompileClass)
//        addDependency.dependsOn(outputProject)
//
//        androidJsonRepresentation.dependsOn(decompileClass)

        androidDartInterface.dependsOn(androidAddDependency)
        androidDartInterface.dependsOn(androidJsonRepresentation)
        androidDartInterface.dependsOn(systemRef)

//        androidKotlinInterface.dependsOn(decompileClass)

        dartfmt.dependsOn(androidDartInterface)

        export.dependsOn(androidDartInterface)
    }
}