package task.common

import Project
import common.PATH
import common.extensions.file
import common.model.ProjectSpec
import task.Task
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 生成初始的输出项目
 *
 * 输入: 生成项目的规格[ProjectSpec]
 * 输出: 项目路径[PATH]
 * 依赖: []
 */
class OutputProjectTask(private val spec: ProjectSpec) : Task<ProjectSpec, File>(spec) {
    override fun process(): File {
        val outputProjectPath = "${Project.path}/build/output-project/${spec.name}"

        val process = Runtime
            .getRuntime()
            .exec("flutter create --offline -a kotlin -i swift --template plugin --org ${spec.org} $outputProjectPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)

        return outputProjectPath.file()
    }
}