package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyCorePluginExtension.outputOrg
import me.yohom.fluttify.FluttifyCorePluginExtension.outputProjectName
import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.Tmpl
import me.yohom.fluttify.common.extensions.*
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 生成对象创建者的类
 *
 * 输入: 要生成ObjectCreator的文件夹
 * 输出: 生成后的ObjectCreator Dart文件
 */
open class ObjectFactory : DefaultTask() {
    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val dartBuilder = StringBuilder()
        val createObjects = StringBuilder("")

        project.projectDir.iterate("java") {
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

        "${project.projectDir}/output-project/${ext.outputProjectName}src/object_factory.dart"
            .file()
            .writeText(dartBuilder.toString())
    }
}