
import common.extensions.file
import common.model.Project
import io.reactivex.Observable
import task.*

fun main() {
    Observable
        .just(Project(org = "com.yibo", name = "tbitble_flutter"))
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
        // 增加export
        .map { ExportTask(OutputProject.dirPath.file()).process() }
        .subscribe()
}