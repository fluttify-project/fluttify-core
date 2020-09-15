package me.yohom.fluttify.model

import me.yohom.fluttify.EXCLUDE_FILES
import me.yohom.fluttify.EXCLUDE_LIBS
import me.yohom.fluttify.FILE_LOG
import me.yohom.fluttify.extensions.isObfuscatedFile
import me.yohom.fluttify.extensions.mustNot

class SourceFile {

    var fileName: String = ""
    var types: List<Type> = listOf()
    var topLevelConstants: List<Variable> = listOf()

    @delegate:Transient
    val filter: Boolean by lazy {
        if (FILE_LOG) println("\n↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓文件↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
        if (FILE_LOG) println("文件:\"${fileName}\"执行过滤开始")
        val result = mustNot("混淆类型") { fileName.isObfuscatedFile() }
                &&
                mustNot("忽略文件") { EXCLUDE_FILES.any { it.matches(this.fileName) } }
        if (FILE_LOG) println("文件:\"${fileName}\"执行过滤结束 ${if (result) "通过过滤" else "未通过过滤"}")
        if (FILE_LOG) println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑文件↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑\n")

        result
    }
}