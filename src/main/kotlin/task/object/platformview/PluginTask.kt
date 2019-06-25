package task.`object`.platformview

import common.DART_FILE
import common.JAVA_FILE
import common.KOTLIN_FILE
import common.Temps
import task.Task
import task.common.OutputProjectTask

/**
 * 生成PlatformView的Plugin类
 *
 * 输入: 生成内容前的Plugin类所在文件
 * 输出: 生成内容后的Plugin类所在文件
 * 依赖: [OutputProjectTask]
 */
class AndroidKotlinPluginTask(private val mainClassFile: JAVA_FILE) :
    Task<JAVA_FILE, KOTLIN_FILE>(mainClassFile) {
    override fun process(): DART_FILE {
        return mainClassFile.apply { writeText(Temps.Kotlin.PlatformView.plugin) }
    }
}