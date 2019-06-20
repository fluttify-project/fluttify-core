package task.`object`.platformview

import Configs
import Configs.outputOrg
import Configs.outputProjectName
import Jar
import common.JAVA_FILE
import common.KOTLIN_FILE
import common.Temps
import common.extensions.placeholder
import common.extensions.underscore2Camel
import task.Task

/**
 * 生成PlatformView类, 并输出到文件
 *
 * 输入: PlatformView文件
 * 输出: 生成内容后的PlatformView文件
 * 依赖: [AndroidKotlinFactoryTask]
 */
class AndroidPlatformViewTask(private val platformViewFile: JAVA_FILE) :
    Task<JAVA_FILE, KOTLIN_FILE>(platformViewFile) {
    override fun process(): KOTLIN_FILE {
        val content = Temps.Kotlin.platformView.placeholder(
            "$outputOrg.$outputProjectName",
            Configs.mainJavaClass,
            outputProjectName.underscore2Camel(),
            Jar.Decompiled.mainClassSimpleName,
            "$outputOrg.$outputProjectName"
        )
        return platformViewFile.apply { writeText(content) }
    }
}