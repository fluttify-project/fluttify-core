package task

import me.yohom.fluttify.common.model.Project
import me.yohom.fluttify.task.OutputProjectTask
import org.junit.Assert
import org.junit.Test

class OutputFluttifyProjectTaskTest {

    @Test
    fun process() {
        val projectSpec = Project(org = "me.yohom", name = "baidu_map_flutter")
        val projectFile = OutputProjectTask(projectSpec).process()

        Assert.assertTrue(projectFile.exists())
    }
}