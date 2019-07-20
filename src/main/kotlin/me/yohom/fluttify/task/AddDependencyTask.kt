package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyCorePluginExtension
import me.yohom.fluttify.common.DART_FILE
import me.yohom.fluttify.common.extensions.file
import org.apache.commons.io.FileUtils
import java.io.File

/**
 * 为生成android工程加入目标jar到libs文件夹
 *
 * 输入: 没有加入jar的生成工程
 * 输出: 加入了jar的生成工程
 * 依赖: [OutputProjectTask]
 */
class AddAndroidDependencyTask(private val outputProjectFile: File): Task<File, File>(outputProjectFile) {
    override fun process(): DART_FILE {
        val libDir = "$outputProjectFile/android/libs/".file()

        if (!libDir.exists()) libDir.mkdirs()

        FileUtils.copyDirectory(FluttifyCorePluginExtension.jarFilePath.substringBeforeLast("/").file(), libDir)

        return outputProjectFile
    }
}