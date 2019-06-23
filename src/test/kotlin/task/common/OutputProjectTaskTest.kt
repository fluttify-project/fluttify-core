package task.common

import common.model.ProjectSpec
import org.junit.Assert
import org.junit.Test

class OutputProjectTaskTest {

    @Test
    fun process() {
        val projectSpec = ProjectSpec(org = "me.yohom", name = "baidu_map_flutter")
        val projectFile = OutputProjectTask(projectSpec).process()

        Assert.assertTrue(projectFile.exists())
    }
}