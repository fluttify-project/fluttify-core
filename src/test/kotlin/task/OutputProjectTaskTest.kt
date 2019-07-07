package task

import common.model.Project
import org.junit.Assert
import org.junit.Test

class OutputProjectTaskTest {

    @Test
    fun process() {
        val projectSpec = Project(org = "me.yohom", name = "baidu_map_flutter")
        val projectFile = OutputProjectTask(projectSpec).process()

        Assert.assertTrue(projectFile.exists())
    }
}