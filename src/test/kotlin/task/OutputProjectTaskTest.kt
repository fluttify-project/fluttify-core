package task

import common.model.ProjectSpec
import org.junit.Assert
import org.junit.Test

class OutputProjectTaskTest {

    @Test
    fun process() {
        val projectSpec = ProjectSpec(org = "com.yibo", name = "tbitble_flutter")
        val projectFile = OutputProjectTask(projectSpec).process()

        Assert.assertTrue(projectFile.exists())
    }
}