package task

import common.DART_FILE
import common.JAVA_FILE
import java.io.File

/**
 * 生成Android端静态方法的MethodChannel
 *
 * 输入: 主Java类文件
 * 输出: 对应Dart文件
 * 依赖: [UnzipTask]
 */
class AndroidStaticMethodTask(private val mainClassFile: JAVA_FILE): Task<JAVA_FILE, DART_FILE>(mainClassFile) {
    override fun process(): DART_FILE {
        return File("abc")
    }
}