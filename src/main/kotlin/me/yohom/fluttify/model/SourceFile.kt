package me.yohom.fluttify.model

import me.yohom.fluttify.FILE_LOG
import me.yohom.fluttify.extensions.isObfuscatedFile
import me.yohom.fluttify.extensions.mustNot

data class SourceFile(
    val fileName: String,
    val types: List<Type>,
    val topLevelConstants: List<Variable>
) {
    @delegate:Transient
    val filter: Boolean by lazy {
        if (FILE_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓文件↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        if (FILE_LOG) println("文件:\"${fileName}\"执行过滤开始")
        val result = mustNot("混淆类型") { fileName.isObfuscatedFile() }
        if (FILE_LOG) println("文件:\"${fileName}\"执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        if (FILE_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑文件↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")

        result
    }
}