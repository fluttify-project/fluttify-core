package task.`object`.platformview

import Configs.outputOrg
import Configs.outputProjectName
import Jar
import OutputProject
import common.DART_FILE
import common.JAVA_FILE
import common.KOTLIN_FILE
import common.Temps
import common.extensions.placeholder
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
        val content = Temps.Kotlin.platformViewPlugin.placeholder(
            "$outputOrg.$outputProjectName",
            OutputProject.classSimpleName,
            "$outputOrg.$outputProjectName",
            Jar.Decompiled.mainClassSimpleName,
            Jar.Decompiled.mainClassSimpleName
        )
        return mainClassFile.apply { writeText(content) }
    }
}