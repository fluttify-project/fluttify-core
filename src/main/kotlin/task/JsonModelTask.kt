package task

import common.DART_FILE

/**
 * TODO 由只有字段的Dart Model生成有`fromJson`和`toJson`的model
 * 依赖 [AndroidDartModelTask]
 */
class JsonModelTask(private val dartModelFile: DART_FILE): Task<DART_FILE, DART_FILE>(dartModelFile) {
    override fun process(): DART_FILE {
        return dartModelFile
    }
}