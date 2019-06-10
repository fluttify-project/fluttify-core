package task.common

import Configs
import common.DART_FILE
import common.extensions.toFile
import org.apache.commons.io.FileUtils
import task.Task
import task.statik.AndroidDartStaticMethodTask
import task.statik.IOSDartStaticMethodTask

/**
 * TODO 生成export文件, 引入需要导出的文件, 以及import进所有需要的文件
 * 需要引入的内容为android端的主类和模型类以及ios端的主类和模型类
 *
 * 输入: 目标工程文件夹
 * 输出: 加入export后的目标工程文件夹
 * 依赖: [AndroidDartStaticMethodTask], [IOSDartStaticMethodTask], [AndroidDartModelTask]
 */
class ExportTask(private val outputProjectDir: DART_FILE) : Task<DART_FILE, DART_FILE>(outputProjectDir) {
    override fun process(): DART_FILE {
        val dartSrcDir = "${outputProjectDir.absolutePath}/lib/src".toFile()
        val exportFile = "${outputProjectDir.absolutePath}/lib/${Configs.outputProjectName}.dart".toFile()

        val existContent = exportFile.readText()
        val result = StringBuilder()
        FileUtils
            .iterateFiles(dartSrcDir, arrayOf("dart"), true)
            .forEach {
                result.append("export '${it.toRelativeString(exportFile).removePrefix("../")}';\n")
            }
        result.append("\n")
        result.append(existContent)

        exportFile.writeText(result.toString())
        return outputProjectDir
    }
}