import common.PATH
import org.junit.Test
import task.DecompileTask
import task.UnzipTask
import java.io.File

class TaskExecutorTest {

    @Test
    fun exec() {
        TaskExecutor
            .exec<PATH, PATH> { DecompileTask() }
            .exec<PATH, File> { UnzipTask(it) }
    }
}