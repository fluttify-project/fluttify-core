
import common.extensions.file
import common.model.ProjectSpec
import io.reactivex.Observable
import task.*
import task.statik.AndroidDartStaticMethodTask
import task.statik.AndroidKotlinStaticMethodTask
import task.statik.IOSDartStaticMethodTask
import task.statik.IOSSwiftStaticMethodTask

fun main() {
    Observable
        .just(ProjectSpec(org = "com.yibo", name = "tbitble_flutter"))
        // 生成初始目标工程
        .map { OutputProjectTask(it).process() }
        // 拷贝jar依赖到目标工程
        .map { AddAndroidDependencyTask(it).process() }
        // 解压缩反编译Jar
        .map { UnzipJarTask(it).process() }
        // 反编译Jar
        .map { DecompileClassTask(it).process() }
        // 清理空文件
        .map { CleanEmptyTask(it).process() }
        // 生成静态方法的dart method channel
        .map { AndroidDartStaticMethodTask(Jar.Decompiled.mainClassFilePath.file()).process() }
        // 生成静态方法的kotlin method channel
        .map { AndroidKotlinStaticMethodTask(Jar.Decompiled.mainClassFilePath.file()).process() }
        // 生成静态方法的dart method channel
        .map { IOSDartStaticMethodTask(Framework.mainClassFilePath.file()).process() }
        // 生成静态方法的swift method channel
        .map { IOSSwiftStaticMethodTask(Framework.mainClassFilePath.file()).process() }
        // 增加export
        .map { ExportTask(OutputProject.dirPath.file()).process() }
        .subscribe()
}