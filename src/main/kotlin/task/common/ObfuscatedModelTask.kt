package task.common

import task.Task
import java.io.File

/**
 * 去除输入Java文件列表中的混淆类
 *
 * 输入: 已经被识别为model类的文件列表[modelFileList]
 * 输出: 去除了混淆类的model类文件列表
 * 依赖: [AndroidRecognizeModelTask]
 */
class AndroidObfuscatedModelTask(private val modelFileList: List<File>) : Task<List<File>, List<File>>(modelFileList) {
    override fun process(): List<File> {
        return modelFileList.filter { file ->
            // 把文件名按`$`分开(内部类的情况, 如果不是内部类的话那么就会得到原本的文件名, 不影响)
            // 如果切分后的文件名内含有只有一个字母的类, 那么就认为是混淆类
            !file.nameWithoutExtension.split("$").any { it.length == 1 }
        }
    }
}