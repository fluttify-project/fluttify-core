package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input

abstract class FluttifyTask : DefaultTask() {
    protected val ext: FluttifyExtension
        get() = project.extensions.getByType(FluttifyExtension::class.java)

    override fun getGroup() = "fluttify"
}