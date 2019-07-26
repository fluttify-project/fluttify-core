package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class AndroidJsonRepresentationTest {

    @Test
    fun process() {
        val project = ProjectBuilder.builder().build()
        project.extensions.add("fluttify", FluttifyExtension())
        project.tasks.create("androidDartInterface", AndroidDartInterface::class.java).process()
    }
}