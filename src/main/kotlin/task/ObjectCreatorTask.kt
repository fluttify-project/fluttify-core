package task

import Configs.outputOrg
import Configs.outputProjectName
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

        val createObjects = StringBuilder("")

        dir.iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated()
                && it.readText().run { publicNonDependencyConstructor() && !allMemberStatic() }
            ) {
                println("处理文件: $it")

                createObjects.appendln(
                    Tmpl.Dart.createObjectMethodBuilder
                        .replace("#__class_name__#", it.javaType().name.toDartType())
                        .replace("#__formal_params__#", "")
                        .replace("#__separator__#", "")
                        .replace("#__params__#", "")
                )
            }
        }

        dartBuilder.appendln(
            Tmpl.Dart.objectCreatorBuilder
                .replace("#__current_package__#", "$outputProjectName/$outputProjectName")
                .replace("#__org__#", outputOrg)
                .replaceParagraph("#__create_objects__#", createObjects.toString())
        )

        return "${OutputProject.Dart.libDirPath}src/object_creator.dart".file()
            .apply { writeText(dartBuilder.toString()) }
    }
}