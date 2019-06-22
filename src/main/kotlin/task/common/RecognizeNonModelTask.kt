package task.common

import Jar
import common.extensions.*
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import task.Task
import java.io.File

/**
 * 从主类中识别出需要对应dart类的java类
 *
 * 转换对象: 主类中返回非model对象的方法
 *
 * 输入: 待识别的主类文件
 * 输出: 识别成非模型类的文件们
 * 依赖: [AndroidRecognizeModelTask]
 */
class RecognizeAndroidNonModelTask(private val mainClassFile: File) : Task<File, List<File>>(mainClassFile) {
    override fun process(): List<File> {
        val result = mutableListOf<File>()
        val classContent = mainClassFile.readText()

        classContent.walkTree(object : JavaParserBaseListener() {
            override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
                ctx
                    ?.returnType()
                    ?.run {
                        if (!isJavaModelType()) {
                            // 因为isJavaModelType内部已经有调用过Jar.Decompiled.classes, 所以可以确定Jar.Decompiled.classes[this]
                            // 是能取到值的
                            Jar
                                .Decompiled
                                .classes[this]
                                ?.run { result.add(path.file()) }
                        }
                    }
            }
        })

        return result
    }
}

/**
 * 从objc源文件中过滤出所有的模型类
 *
 * 输入: 待识别的文件夹[dir]
 * 输出: 识别成模型类的文件们
 * 依赖: []
 */
class RecognizeIOSNonModelTask(private val dir: File) : Task<File, List<File>>(dir) {
    override fun process(): List<File> {
        return dir.listFiles().filter { it.readText().isObjcModel() }
    }
}