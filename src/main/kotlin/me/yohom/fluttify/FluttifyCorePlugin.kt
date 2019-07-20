package me.yohom.fluttify

import me.yohom.fluttify.task.FluttifyTask
import org.gradle.api.Plugin
import org.gradle.api.Project

//fun main() {
//    Observable
//        .just(me.yohom.fluttify.FluttifyProject(org = "com.yibo", name = "tbitble_flutter"))
//        // 生成初始目标工程
//        .map { OutputProjectTask(it).process() }
//        // 拷贝jar依赖到目标工程
//        .map { AddAndroidDependencyTask(it).process() }
//        // 解压缩反编译Jar
//        .map { UnzipJarTask(it).process() }
//        // 反编译Jar
//        .map { DecompileClassTask(it).process() }
//        // 清理空文件
//        .map { CleanEmptyTask(it).process() }
//        // 增加export
//        .map { ExportTask(me.yohom.fluttify.OutputProject.dirPath.file()).process() }
//        .subscribe()
//}

class FluttifyCorePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create("fluttify", FluttifyCorePluginExtension::class.java)
        target.tasks.create("fluttify", FluttifyTask::class.java)
    }
}