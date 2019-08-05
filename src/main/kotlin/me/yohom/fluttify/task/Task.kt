package me.yohom.fluttify.task

abstract class Task<T, R>(input: T) {
    init {
        println("*******************************************************************************")
        println("* 任务: ${this::class.simpleName}")
        println("* 输入: $input")
        println("*******************************************************************************")
    }

    abstract fun process(): R
}