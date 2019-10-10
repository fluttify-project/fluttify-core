package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.iterate
import org.gradle.api.tasks.TaskAction

/**
 * 清除空文件
 *
 * 输入: (可能)含有空文件的文件夹
 * 输出: 删除空文件后的文件夹
 * 依赖: []
 */
open class CleanEmpty : FluttifyTask() {
    @TaskAction
    fun process() {
        project.projectDir.iterate(null) {
            if (it.readText().isBlank()) it.deleteRecursively()
        }
    }
}