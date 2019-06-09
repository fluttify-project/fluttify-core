import common.extensions.toFile
import common.model.ProjectSpec
import io.reactivex.Observable
import task.*
import java.io.File

fun main() {
    Observable
        .just(ProjectSpec(org = "com.yibo", name = "tbitble_flutter"))
        // 生成初始目标工程
        .map { OutputProjectTask(it).process() }
        // 反编译Jar
        .map { DecompileTask(File(Configs.jarPath)).process() }
        // 解压缩反编译Jar
        .map { UnzipTask(it).process() }
        // 清理空文件
        .map { CleanEmptyTask(it).process() }
        // 识别android Model文件
        .flatMap { Observable.fromIterable(RecognizeAndroidModelTask(it).process()) }
        // 将每个识别出来的android model文件转换成dart model文件, 并写入
        .map { AndroidDartModelTask(it).process() }
        // 收成一个List, 避免下游的任务重复执行
        .toList()
        // 生成静态方法的dart method channel
        .map { AndroidDartStaticMethodTask(Jar.Decompiled.mainClassPath.toFile()).process() }
        // 生成静态方法的kotlin method channel
        .map { AndroidKotlinStaticMethodTask(Jar.Decompiled.mainClassPath.toFile()).process() }
        // 生成静态方法的dart method channel
        .map { IOSDartStaticMethodTask(Framework.mainClassPath.toFile()).process() }
        // 生成静态方法的swift method channel
        .map { IOSSwiftStaticMethodTask(Framework.mainClassPath.toFile()).process() }
        .subscribe()
}