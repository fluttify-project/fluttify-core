package task.`object`.platformview

import Configs.outputOrg
import Configs.outputProjectName
import common.JAVA_FILE
import common.KOTLIN_FILE
import common.Temps
import common.extensions.placeholder
import common.extensions.underscore2Camel
import task.Task

/**
 * 生成PlatformViewFactory类, 并输出到文件
 *
 * 输入: PlatformViewFactory文件
 * 输出: 生成内容后的PlatformViewFactory文件
 * 依赖: [AndroidKotlinPluginTask]
 */
class AndroidKotlinFactoryTask(private val factoryFile: JAVA_FILE) : Task<JAVA_FILE, KOTLIN_FILE>(factoryFile) {
    override fun process(): KOTLIN_FILE {
        val content = Temps.Kotlin.platformViewFactory.placeholder(
            "$outputOrg.$outputProjectName",
            outputProjectName.underscore2Camel(),
            outputProjectName.underscore2Camel()
        )
        return factoryFile.apply { writeText(content) }
    }
}