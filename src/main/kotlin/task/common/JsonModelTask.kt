package task.common

import common.DART_FILE
import task.Task

/**
 * TODO 由只有字段的Dart Model生成有`fromJson`和`toJson`的model
 *
 * 输入: 只有字段的dart模型文件
 * 输出: 加入了fromJson和toJson方法的模型文件
 * 依赖: [AndroidDartModelTask]
 */
class JsonModelTask(private val dartModelFile: DART_FILE): Task<DART_FILE, DART_FILE>(dartModelFile) {
    override fun process(): DART_FILE {
        return dartModelFile
    }
}