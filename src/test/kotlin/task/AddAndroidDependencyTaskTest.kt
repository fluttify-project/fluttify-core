package task

import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.AddAndroidDependencyTask
import org.junit.Test

class AddAndroidDependencyTaskTest {

    @Test
    fun process() {
        val path = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter"
        AddAndroidDependencyTask(path.file()).process()
    }
}