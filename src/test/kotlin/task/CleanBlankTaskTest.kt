package task

import me.yohom.fluttify.OutputProject
import me.yohom.fluttify.task.CleanEmptyTask
import org.apache.commons.io.FileUtils
import org.junit.Assert
import org.junit.Test
import java.io.File

class CleanBlankTaskTest {

    @Test
    fun process() {
        val testDir = File(OutputProject.Dart.libDirPath)
        val nonEmptyDir = CleanEmptyTask(testDir).process()
        println(nonEmptyDir)

        var containEmpty = false
        FileUtils.iterateFiles(nonEmptyDir, null, true).forEach {
            if (it.readText().isBlank()) {
                println(it.absolutePath)
                containEmpty = true
            }
        }

        Assert.assertFalse(containEmpty)

//        // 测试完成后恢复一个含有blank字符串的文件
//        val blankFile = File("${me.yohom.fluttify.FluttifyProject.path}/src/test/resources/clean_empty_test/Blank.java")
//        if (!blankFile.exists()) {
//            blankFile.createNewFile()
//        }
//        blankFile.writeText("\n\n")
    }
}