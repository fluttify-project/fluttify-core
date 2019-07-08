package task

import OutputProject
import OutputProject.methodChannel
import common.DART_FILE
import common.JAVA_FILE
import common.Tmpl
import common.extensions.file

/**
 * 生成系统类的dart引用
 *
 * 输入: 无
 * 输出: 对应的dart类引用
 * 依赖: [DecompileClassTask]
 */
class AndroidSystemRefTask(whatever: JAVA_FILE) : Task<JAVA_FILE, DART_FILE>(whatever) {
    override fun process(): DART_FILE {
        return OutputProject
            .Dart
            .systemRefFilePath
            .file()
            .apply { writeText(Tmpl.Dart.systemRefBuilder.replace("#__method_chanel__#", methodChannel)) }
    }
}