package task.common

import OutputProject
import common.extensions.file
import io.reactivex.Observable
import org.junit.Test
import java.io.File

class AndroidDartModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        Observable.just(testPath)
            .map { AndroidRecognizeModelTask(File(it)).process() }
            .map { AndroidObfuscatedModelTask(it).process() }
            .flatMap { Observable.fromIterable(it) }
            .map { AndroidDartModelTask(it).process() }
            .map { DartfmtTask(it).process() }
            .toList()
            .map { ExportTask(OutputProject.dirPath.file()).process() }
            .subscribe()
    }
}