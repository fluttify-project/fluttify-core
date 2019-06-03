package task

import org.apache.commons.io.FileUtils
import java.io.File

/**
 * 清除空文件
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