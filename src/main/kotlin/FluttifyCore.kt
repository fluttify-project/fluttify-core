
import io.reactivex.Observable
import task.CleanEmptyTask
import task.DecompileTask
import task.RecognizeAndroidModelTask
import task.UnzipTask
import java.io.File

fun main() {
    Observable
        .just(File(Configs.jarPath))
        .map { DecompileTask(it).process() } // 反编译Jar
        .map { UnzipTask(it).process() } // 解压缩反编译Jar
        .map { CleanEmptyTask(it).process() } // 清理空文件
        .map { RecognizeAndroidModelTask(it).process() } // 识别Model文件
}