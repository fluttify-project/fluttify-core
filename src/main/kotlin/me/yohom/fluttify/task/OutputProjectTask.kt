package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyProject
import me.yohom.fluttify.common.PATH
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.model.Project
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 生成初始的输出项目
 *
 * 输入: 生成项目的规格[FluttifyProject]
 * 输出: 项目路径[PATH]
 * 依赖: []
 */
class OutputProjectTask(private val spec: Project) : Task<Project, File>(spec) {
    override fun process(): File {
        val outputProjectPath = "${FluttifyProject.path}/build/output-project/${spec.name}"

        val process = Runtime
            .getRuntime()
            .exec("flutter create --offline -a kotlin -i swift --template plugin --org ${spec.org} $outputProjectPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)

        return outputProjectPath.file()
    }
}