package me.yohom.fluttify

import me.yohom.fluttify.task.*
import me.yohom.fluttify.task.OutputProject
import org.gradle.api.Plugin
import org.gradle.api.Project

//fun main() {
//    Observable
//        .just(me.yohom.fluttify.FluttifyProject(org = "com.yibo", name = "tbitble_flutter"))
//        // 生成初始目标工程
//        .map { OutputProject(it).process() }
//        // 拷贝jar依赖到目标工程
//        .map { AddAndroidDependencyTask(it).process() }
//        // 解压缩反编译Jar
//        .map { UnzipJarTask(it).process() }
//        // 反编译Jar
//        .map { DecompileClassTask(it).process() }
//        // 清理空文件
//        .map { CleanEmpty(it).process() }
//        // 增加export
//        .map { Export(me.yohom.fluttify.OutputProject.dirPath.file()).process() }
//        .subscribe()
//}

open class FluttifyCorePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("fluttify", FluttifyExtension::class.java)

        val unzip = project.tasks.create("unzipJar", UnzipJar::class.java)
        val decompileClass = project.tasks.create("decompileClass", DecompileClass::class.java)
        val addDependency = project.tasks.create("addDependency", AddAndroidDependency::class.java)
        val outputProject = project.tasks.create("outputProject", OutputProject::class.java)
        val cleanEmpty = project.tasks.create("cleanEmpty", CleanEmpty::class.java)
        val dartfmt = project.tasks.create("dartfmt", Dartfmt::class.java)
        val export = project.tasks.create("export", Export::class.java)

        decompileClass.dependsOn(unzip)
        addDependency.dependsOn(outputProject)
    }
}