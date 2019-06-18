package task.common

import common.DART_FILE
import task.Task
import task.statik.AndroidDartStaticMethodTask
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 把输入文件进行dartfmt
 *
 * 输入: 未格式化的dart文件
 * 输出: 格式化后的dart文件
 * 依赖: [AndroidDartModelTask], [IOSDartModelTask], [AndroidDartStaticMethodTask]
 */
class DartfmtTask(private val dartFile: DART_FILE) : Task<DART_FILE, DART_FILE>(dartFile) {
    override fun process(): DART_FILE {
        val process = Runtime
            .getRuntime()
            .exec("dartfmt -w ${dartFile.absolutePath}")

        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
        return dartFile
    }
}