package task

import Framework
import common.OBJC_SOURCE
import common.extensions.file
import common.extensions.iterate
import java.io.File

/**
 * 把Framework中的每个类单独输出到一个文件
 * 因为objc允许多个类在一个文件中, 不方便处理, 这里把每个类都输出到一个文件中去
 *
 * 输入: .framework文件夹
 * 输出: build/objc-classes下的所有文件
 * 依赖: []
 */
@Deprecated("感觉新的模型下, 好像不太需要这个任务了, 先放着吧")
class SingleObjcClassTask(private val frameworkDir: File) : Task<File, File>(frameworkDir) {
    override fun process(): File {
        val slices = mutableListOf<OBJC_SOURCE>()
        // 切割每个类到单独的文件中去
        frameworkDir.iterate("h") { file ->
            val fileContent = file.readText()
            slices.addAll(fileContent.split("@interface")
                .map {
                    if (it.contains("@end"))
                        StringBuilder(it).insert(0, "@interface").toString()
                    else
                        it
                })
        }

        val objcClassesDir = Framework.singleClassesDirPath.file()
        slices.forEachIndexed { index, item ->
            val modelFile = "${objcClassesDir.absolutePath}/Class_$index".file()
            modelFile.writeText(item)
        }

        return objcClassesDir
    }
}