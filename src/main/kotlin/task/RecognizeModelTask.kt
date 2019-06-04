package task

import common.extensions.isModel
import org.apache.commons.io.FileUtils
import java.io.File

/**
 * 过滤出所有的模型类
 *
 * 输入为待识别的文件夹[dir], 输出为识别成模型类的文件们
 */
class RecognizeAndroidModelTask(private val dir: File) : Task<File, List<File>>(dir) {
    override fun process(): List<File> {
        val result = mutableListOf<File>()
        FileUtils
            .iterateFiles(dir, arrayOf("java"), true)
            .forEach {
                val fileContent = it.readText()
                if (fileContent.isModel()) {
                    result.add(it)
                }
            }
        return result
    }
}

/**
 * 过滤出所有的模型类
 *
 * 输入为待识别的文件夹[dir], 输出为识别成模型类的文件们
 */
class RecognizeIOSModelTask(private val dir: File) : Task<File, List<File>>(dir) {
    override fun process(): List<File> {
        return listOf()
    }
}