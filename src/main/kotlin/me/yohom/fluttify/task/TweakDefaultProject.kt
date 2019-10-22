package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.underscore2Camel
import org.gradle.api.tasks.TaskAction

/**
 * 修改默认的项目模板
 */
open class TweakDefaultProject : FluttifyTask() {

    private val buildGradleTmpl = this::class.java.getResource("/tmpl/project/build.gradle.tmpl").readText()
    private val infoPlistTmpl = this::class.java.getResource("/tmpl/project/Info.plist.tmpl").readText()
    private val podSpecTmpl = this::class.java.getResource("/tmpl/project/projectName.podspec.tmpl").readText()
    private val pubSpecTmpl = this::class.java.getResource("/tmpl/project/pubspec.yaml.tmpl").readText()
    private val utilsDartTmpl = this::class.java.getResource("/tmpl/dart/utils.dart.tmpl").readText()

    @TaskAction
    fun process() {
        val outputProjectPath = "${project.projectDir}/output-project/${ext.outputProjectName}"

        "${outputProjectPath}/android/build.gradle"
            .file()
            .writeText(buildGradleTmpl.replace("#__project_id__#", "${ext.outputOrg}.${ext.outputProjectName}"))

        "${outputProjectPath}/example/ios/Runner/Info.plist"
            .file()
            .writeText(infoPlistTmpl.replace("#__project_name__#", ext.outputProjectName))

        "${outputProjectPath}/ios/${ext.outputProjectName}.podspec"
            .file()
            .writeText(podSpecTmpl.replace("#__project_name__#", ext.outputProjectName))

        "${outputProjectPath}/pubspec.yaml"
            .file()
            .writeText(pubSpecTmpl
                .replace("#__project_name__#", ext.outputProjectName)
                .replace("#__description__#", "")
                .replace("#__android_identifier__#", "${ext.outputOrg}.${ext.outputProjectName}")
                .replace("#__plugin_class__#", "${ext.outputProjectName.underscore2Camel()}Plugin")
            )

        "${outputProjectPath}/lib/src/utils.g.dart"
            .file()
            .writeText(utilsDartTmpl
                .replace("#__current_package__#", ext.outputProjectName)
                .replace("#__method_channel__#", ext.methodChannelName)
            )
    }
}