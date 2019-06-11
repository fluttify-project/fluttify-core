package task.common

import Configs
import common.extensions.file
import org.junit.Test

class SingleObjcClassTaskTest {

    @Test
    fun process() {
        println(SingleObjcClassTask(Configs.frameworkDirPath.file()).process())
    }
}