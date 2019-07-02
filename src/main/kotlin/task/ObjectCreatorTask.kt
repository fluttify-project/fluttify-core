package task

import OutputProject
import common.DART_FILE
import common.DIR
import common.Tmpl
import common.extensions.*

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

        dartBuilder.appendln(Tmpl.Dart.ObjectCreator.classDeclare)

        dir.iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated()
                && it.readText().run { publicConstructor() && !allMemberStatic() }
            ) {
                println("处理文件: $it")
                dartBuilder.appendln(
                    Tmpl.Dart.ObjectCreator.creator.placeholder(
                        it.javaType().name.toDartType(),
                        it.javaType().name.toDartType(),
                        "",
                        it.javaType().name.toDartType(),
                        "",
                        "",
                        it.javaType().name.toDartType()
                    )
                )
            }
        }

        dartBuilder.appendln(Tmpl.Dart.ObjectCreator.classDeclareEnd)

        return "${OutputProject.Dart.libDirPath}src/object_creator.dart".file()
            .apply { writeText(dartBuilder.toString()) }
    }
}