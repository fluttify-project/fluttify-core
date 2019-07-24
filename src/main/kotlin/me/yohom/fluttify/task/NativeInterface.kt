package me.yohom.fluttify.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Android端接口生成
 *
 * 输入: java文件
 * 输出: 对应的method channel文件
 */
open class AndroidKotlinInterface : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
    }

}

/**
 * iOS端接口生成
 *
 * 输入: framework文件夹
 * 输出: 对应的method channel文件
 */
open class IOSSwiftInterface : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
    }
}