package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * 为生成android工程加入目标jar/aar到libs文件夹
 */
open class AndroidAddDependency : FluttifyTask() {
    @TaskAction
    fun process() {
        // 只有当不是远程依赖时才需要拷贝
        if (!ext.android.remote.configured) {
            val archiveDir: File = ext.android.libDir.file()
            val libDir: File = "${project.projectDir}/output-project/${ext.projectName}/android/libs/".file()

            FileUtils.copyDirectory(archiveDir, libDir) { it.name != "unzip" && it.length() > 0 }
        }
    }
}

/**
 * 为生成ios工程加入目标framework到文件夹
 *
 */
open class IOSAddDependency : FluttifyTask() {
    @TaskAction
    fun process() {
        // 只有当不是远程依赖时才需要拷贝
        if (!ext.ios.remote.configured) {
            val libraryDir: File = ext.ios.libDir.file()
            val vendorDir: File = "${project.projectDir}/output-project/${ext.projectName}/ios/Vendors/".file()

            // 添加.framework/.a到工程中
            FileUtils.copyDirectory(libraryDir, vendorDir)
        }
    }
}