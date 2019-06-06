package task

import common.PATH
import common.model.ProjectSpec
import preprocess.Project
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 生成初始的输出项目
 *
 * 输入: 生成参数[ProjectSpec]
 * 输出: 项目路径[PATH]
 * 依赖: []
 */
class OutputProjectTask(private val spec: ProjectSpec) : Task<ProjectSpec, PATH>(spec) {
    override fun process(): PATH {
        val outputProjectPath = "${Project.path}/build/output-project/${spec.name}"

        val process = Runtime
            .getRuntime()
            .exec("flutter create -a kotlin -i swift --template plugin --org ${spec.org} $outputProjectPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)

        return outputProjectPath
    }
}