package task

import common.model.ProjectSpec
import org.junit.Assert
import org.junit.Test
import java.io.File

class OutputProjectTaskTest {

    @Test
    fun process() {
        val projectSpec = ProjectSpec(org = "com.yibo", name = "tbitble_flutter")
        val projectPath = OutputProjectTask(projectSpec).process()

        val projectFile = File(projectPath)

        Assert.assertTrue(projectFile.exists())
    }
}