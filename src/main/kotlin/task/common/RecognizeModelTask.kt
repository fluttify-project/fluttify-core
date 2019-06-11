package task.common

import Framework
import common.OBJC_SOURCE
import common.extensions.file
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
        val result = mutableListOf<File>()
        val slices = mutableListOf<OBJC_SOURCE>()
        // 切割每个类到单独的文件中去
        FileUtils
            .iterateFiles(dir, arrayOf("h"), true)
            .forEach { file ->
                val fileContent = file.readText()
                slices.addAll(fileContent.split("@interface")
                    .map {
                        if (it.contains("@end"))
                            StringBuilder(it).insert(0, "@interface").toString()
                        else
                            it
                    })
            }

        slices.forEachIndexed { index, item ->
            val objcModelDir = Framework.singleClassDirPath.file()
            val modelFile = "${objcModelDir.absolutePath}/Model_$index".file()
            modelFile.writeText(item)
            result.add(modelFile)
        }

        // 过滤出model文件
        return result.filter { it.readText().isObjcModel() }
    }
}