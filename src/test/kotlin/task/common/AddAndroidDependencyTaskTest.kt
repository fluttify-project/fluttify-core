package task.common

import common.extensions.file
import org.junit.Test

class AddAndroidDependencyTaskTest {

    @Test
    fun process() {
        val path = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter"
        AddAndroidDependencyTask(path.file()).process()
    }
}