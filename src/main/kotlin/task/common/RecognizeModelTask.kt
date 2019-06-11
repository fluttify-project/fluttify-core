package task.common

import common.extensions.isJavaModel
import common.extensions.isObjcModel
import org.apache.commons.io.FileUtils
import task.Task
import java.io.File

/**
 * 从java源文件中过滤出所有的模型类
 *
 * 输入: 待识别的文件夹[dir]
 * 输出: 识别成模型类的文件们
 * 依赖: [UnzipJarTask]
 */
class RecognizeAndroidModelTask(private val dir: File) : Task<File, List<File>>(dir) {
    override fun process(): List<File> {
        val result = mutableListOf<File>()
        FileUtils
            .iterateFiles(dir, arrayOf("java"), true)
            .forEach {
                val fileContent = it.readText()
                if (fileContent.isJavaModel()) {
                    result.add(it)
                }
            }
        return result
    }
}

/**
 * 从objc源文件中过滤出所有的模型类
 *
 * 输入: 待识别的文件夹[dir]
 * 输出: 识别成模型类的文件们
 * 依赖: []
 */
class RecognizeIOSModelTask(private val dir: File) : Task<File, List<File>>(dir) {
    override fun process(): List<File> {
        return dir.listFiles().filter { it.readText().isObjcModel() }
    }
}