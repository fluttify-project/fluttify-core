package task.common

import common.DART_FILE
import task.Task

/**
 * 为Dart文件内的类加入toString方法
 *
 * 输入: 没有toString方法的dart类文件
 * 输出: 有toString方法的dart类文件
 * 依赖: [JsonTask]
 */
class ToStringTask(private val file: DART_FILE): Task<DART_FILE, DART_FILE>(file) {
    override fun process(): DART_FILE {

        // 加入toString
//        dartModelContentBuilder.insert(lastBraceIndex, Temps.Dart.toString)
        return file
    }
}