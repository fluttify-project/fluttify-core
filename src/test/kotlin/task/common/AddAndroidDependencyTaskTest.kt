package task.common

import common.extensions.toFile
import org.junit.Test

class AddAndroidDependencyTaskTest {

    @Test
    fun process() {
        val path = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/tbitble_flutter"
        AddAndroidDependencyTask(path.toFile()).process()
    }
}