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
        var lastCycleCount = -1

        // 循环寻找model类, 知道上一次循环和这一次循环的结果一样
        while (lastCycleCount != result.size) {
            lastCycleCount = result.size
            FileUtils
                .iterateFiles(dir, arrayOf("java"), true)
                .forEach {
                    val fileContent = it.readText()
                    if (fileContent.isJavaModel() && !result.contains(it)) {
                        result.add(it)
                    }
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