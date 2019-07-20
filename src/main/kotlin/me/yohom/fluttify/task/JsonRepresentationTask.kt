package me.yohom.fluttify.task

import org.gradle.api.Plugin
import org.gradle.api.Project

class DevWikiPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.create("devwiki", DevWikiPluginExtension::class.java)
    }
}

class DevWikiPluginExtension {
    val message: String = "Message"
}