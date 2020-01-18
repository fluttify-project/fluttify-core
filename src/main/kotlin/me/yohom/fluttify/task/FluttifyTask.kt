package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input

abstract class FluttifyTask : DefaultTask() {
    @get:Input
    val ext: FluttifyExtension
        get() = project.extensions.getByType(FluttifyExtension::class.java)

    @Input
    override fun getGroup() = "fluttify"
}