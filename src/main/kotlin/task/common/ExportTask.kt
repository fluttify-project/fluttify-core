package task.common

import common.DART_FILE
import task.Task
import task.statik.AndroidDartStaticMethodTask
import task.statik.IOSDartStaticMethodTask

/**
 * TODO 生成export文件, 引入需要导出的文件, 以及import进所有需要的文件
 * 需要引入的内容为android端的主类和模型类以及ios端的主类和模型类
 *
 * 输入: 目标工程文件夹
 * 输出: 加入export后的目标工程文件夹
 * 依赖: [AndroidDartStaticMethodTask], [IOSDartStaticMethodTask], [AndroidDartModelTask]
 */
class ExportTask(private val dartModelFile: DART_FILE) : Task<DART_FILE, DART_FILE>(dartModelFile) {
    override fun process(): DART_FILE {
        return dartModelFile
    }
}