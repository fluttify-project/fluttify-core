package task.common

import common.DIR
import task.Task
import task.statik.AndroidDartStaticMethodTask
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 把输入文件进行dartfmt
 *
 * 输入: 未格式化的dart文件
 * 输出: 格式化后的dart文件
 * 依赖: [AndroidDartStaticMethodTask]
 */
class DartfmtTask(private val dir: DIR) : Task<DIR, DIR>(dir) {
    override fun process(): DIR {
        val process = Runtime
            .getRuntime()
            .exec("dartfmt -w ${dir.absolutePath}")

        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
        return dir
    }
}