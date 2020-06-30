package me.yohom.fluttify.extensions

import java.util.Stack

fun <T> Stack<T>.peekOrNull(): T? {
    return if (this.isEmpty()) null else this.peek()
}