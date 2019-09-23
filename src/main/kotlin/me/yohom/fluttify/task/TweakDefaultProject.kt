package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.file
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 修改默认的项目模板
 */
open class TweakDefaultProject : DefaultTask() {

    private val buildGradleTmpl = this::class.java.getResource("/tmpl/project/build.gradle.tmpl").readText()
    private val infoPlistTmpl = this::class.java.getResource("/tmpl/project/Info.plist.tmpl").readText()
    private val podSpecTmpl = this::class.java.getResource("/tmpl/project/projectName.podspec.tmpl").readText()

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
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
    }
}