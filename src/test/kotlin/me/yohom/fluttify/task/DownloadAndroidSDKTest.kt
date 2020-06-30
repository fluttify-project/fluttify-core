package me.yohom.fluttify.task

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class DownloadAndroidSDKTest {

    @Test
    fun process() {
        val project: Project = ProjectBuilder.builder().build()
        project.pluginManager.apply("org.samples.greeting")
    }
}