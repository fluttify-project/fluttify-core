package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.underscore2Camel
import org.gradle.api.tasks.TaskAction

/**
 * 修改默认的项目模板
 */
open class TweakDefaultProject : FluttifyTask() {

    private val buildGradleTmpl = getResource("/tmpl/project/build.gradle.java.tmpl").readText()
    private val infoPlistTmpl = getResource("/tmpl/project/Info.plist.tmpl").readText()
    private val podSpecTmpl = getResource("/tmpl/project/projectName.podspec.tmpl").readText()
    private val pubSpecTmpl = getResource("/tmpl/project/pubspec.yaml.tmpl").readText()
    private val analysisTmpl = getResource("/tmpl/project/analysis_options.yaml.tmpl").readText()

    @TaskAction
    fun process() {
        val outputProjectPath = "${project.projectDir}/output-project/${ext.projectName}"

        "${outputProjectPath}/android/build.gradle"
            .file()
            .writeText(
                buildGradleTmpl
                    .replace("#__project_id__#", "${ext.org}.${ext.projectName}")
                    .replaceParagraph("#__sdk_dependency__#", ext.android.remote.run {
                        dependencies
                            .union(transitiveDependencies)
                            .joinToString("\n") { "api '$it'" }
                    })
                    .replaceParagraph(
                        "#__plugin_dependency__#",
                        ext.pluginDependencies
                            .map { "compileOnly rootProject.findProject(\":${it.key}\")" }
                            .joinToString("\n")
                    )
                    .replaceParagraph(
                        "#__repositories__#",
                        ext.android.repositories.joinToString("\n")
                    )
            )

        "${outputProjectPath}/example/ios/Runner/Info.plist"
            .file()
            .writeText(infoPlistTmpl.replace("#__project_name__#", ext.projectName))

        "${outputProjectPath}/ios/${ext.projectName}.podspec"
            .file()
            .writeText(
                podSpecTmpl
                    .replace("#__project_name__#", ext.projectName)
                    .replace("#__desc__#", ext.desc)
                    .replace("#__author__#", ext.author)
                    .replace("#__email__#", ext.email)
                    .replace("#__homepage__#", ext.homepage)
                    .replaceParagraph("#__sdk_dependency__#", ext.ios.remote.run {
                        dependencies
                            .union(transitiveDependencies)
                            .joinToString("\n") { "s.dependency $it" }
                    })
                    .replaceParagraph(
                        "#__plugin_dependency__#",
                        ext.pluginDependencies.map { "s.dependency '${it.key}'" }.joinToString("\n")
                    )
                    .replace("#__deployment_target__#", ext.ios.iosDeploymentTarget)
                    .replace(
                        "#__frameworks__#",
                        ext.iOSTransitiveFramework.joinToString { "\"$it\"" })
                    .replace("#__libraries__#", ext.iOSTransitiveTbd.joinToString { "\"$it\"" })
                    .replace("#__resources__#", ext.iOSResource.joinToString { "\"$it\"" })
            )

        "${outputProjectPath}/pubspec.yaml"
            .file()
            .writeText(
                pubSpecTmpl
                    .replace("#__project_name__#", ext.projectName)
                    .replace("#__desc__#", ext.desc)
                    .replace("#__author__#", ext.author)
                    .replace("#__email__#", ext.email)
                    .replace("#__homepage__#", ext.homepage)
                    .replaceParagraph(
                        "#__foundation_version__#",
                        ext.foundationVersion.map { "${it.key}: ${it.value}" }.joinToString("\n")
                    )
                    .replaceParagraph(
                        "#__plugin_dependency__#",
                        ext.pluginDependencies.map { "${it.key}: ${it.value}" }.joinToString("\n")
                    )
                    .replaceParagraph(
                        "#__package_dependency__#",
                        ext.packageDependencies.map { "${it.key}: ${it.value}" }.joinToString("\n")
                    )
                    .replace("#__android_identifier__#", "${ext.org}.${ext.projectName}")
                    .replace("#__plugin_class__#", "${ext.projectName.underscore2Camel()}Plugin")
            )

        "${outputProjectPath}/analysis_options.yaml"
            .file()
            .writeText(analysisTmpl)

        // TODO 是否需要实现podfile指定自定义源?
    }
}