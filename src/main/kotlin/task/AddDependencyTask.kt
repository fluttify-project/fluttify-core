package task

import Configs
import Jar
import common.DART_FILE
import common.extensions.file
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
        val targetJarFile = "$libDir/${Jar.name}".file()

        if (!libDir.exists()) libDir.mkdirs()
        if (!targetJarFile.exists()) targetJarFile.createNewFile()

        FileUtils.copyFile(Configs.jarFilePath.file(), targetJarFile)

        return outputProjectFile
    }
}