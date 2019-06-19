package task.`object`.platformview

import Configs.outputOrg
import Configs.outputProjectName
import Jar
import common.JAVA_FILE
import common.KOTLIN_FILE
import common.Temps
import common.extensions.placeholder
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
            Jar.Decompiled.mainClassSimpleName,
            Jar.Decompiled.mainClassSimpleName
        )
        return factoryFile.apply { writeText(content) }
    }
}