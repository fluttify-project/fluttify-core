package task.common

import org.apache.commons.io.FileUtils
import task.Task
import java.io.File

/**
 * 清除空文件
 *
 * 输入: (可能)含有空文件的文件夹
 * 输出: 删除空文件后的文件夹
 * 依赖: []
 */
class CleanEmptyTask(private val file: File) : Task<File, File>(file) {
    override fun process(): File {
        if (file.isFile && file.length() == 0L)
            file.delete()
        else
            FileUtils.iterateFiles(file, null, true)
                .forEach { if (it.readText().isBlank()) it.deleteRecursively() }
        return file
    }
}