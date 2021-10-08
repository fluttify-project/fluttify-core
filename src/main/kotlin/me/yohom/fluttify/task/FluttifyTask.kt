package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal

abstract class FluttifyTask : DefaultTask() {
    @Internal
    protected var ext: FluttifyExtension =
        project.extensions.getByType(FluttifyExtension::class.java)

    @Internal
    override fun getGroup() = "fluttify"
}