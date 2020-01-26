package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import org.gradle.api.DefaultTask

abstract class FluttifyTask : DefaultTask() {
    val ext: FluttifyExtension
        get() = project.extensions.getByType(FluttifyExtension::class.java)

    override fun getGroup() = "fluttify"
}