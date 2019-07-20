package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyCorePluginExtension.outputOrg
import me.yohom.fluttify.FluttifyCorePluginExtension.outputProjectName
import me.yohom.fluttify.OutputProject
import me.yohom.fluttify.common.DART_FILE
import me.yohom.fluttify.common.DIR
import me.yohom.fluttify.common.Tmpl
import common.extensions.*
import me.yohom.fluttify.common.extensions.*

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
                && it.readText().run { javaPublicNonDependencyConstructor() && !javaAllMemberStatic() }
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