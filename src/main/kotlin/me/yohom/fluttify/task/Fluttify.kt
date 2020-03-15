package me.yohom.fluttify.task

import org.gradle.api.tasks.TaskAction

open class Fluttify : FluttifyTask() {
    @TaskAction
    fun process() {
        println("""
 =========================================================================
‖                     Thank you for using Fluttify!                       ‖
‖                                                                         ‖
‖                If you encountered any problem, please                   ‖
‖ go to https://github.com/fluttify-project/fluttify-feedback/issues/new  ‖
‖                          for feedback.                                  ‖
 =========================================================================
""".trimIndent())
    }
}