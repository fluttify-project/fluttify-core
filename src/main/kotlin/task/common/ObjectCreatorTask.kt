package task.common

import Jar
import OutputProject
import common.DART_FILE
import common.DIR
import common.Temps
import common.extensions.*
import task.Task

/**
 * 生成对象创建者的类
 *
 * 输入: 要生成ObjectCreator的文件夹
 * 输出: 生成后的ObjectCreator Dart文件
 * 依赖: [DecompileClassTask]
 */
class ObjectCreatorTask(private val dir: DIR) : Task<DIR, DART_FILE>(dir) {
    override fun process(): DART_FILE {
        val dartBuilder = StringBuilder()

        dartBuilder.appendln(Temps.Dart.ObjectCreator.classDeclare)

        dir.iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated()
                && it.readText().run { publicConstructor() && !allMemberStatic() }) {
                println("处理文件: $it")
                Jar.Decompiled.classes[it.nameWithoutExtension]?.run {
                    dartBuilder.appendln(
                        Temps.Dart.ObjectCreator.creator.placeholder(
                            simpleName,
                            simpleName,
                            "",
                            simpleName,
                            "",
                            "",
                            simpleName
                        )
                    )
                }
            }
        }

        dartBuilder.appendln(Temps.Dart.ObjectCreator.classDeclareEnd)

        return "${OutputProject.Dart.libDirPath}src/object_creator.dart".file()
            .apply { writeText(dartBuilder.toString()) }
    }
}