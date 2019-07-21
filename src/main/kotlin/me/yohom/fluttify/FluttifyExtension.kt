package me.yohom.fluttify

object FluttifyCorePluginExtension {
    /**
     * jar路径
     */
    val jarFilePath: String = "${FluttifyProject.path}/src/main/resources/library/android/BaiduLBS_Android.jar"

    /**
     * framework路径
     */
    val frameworkDirPath: String = "${FluttifyProject.path}/src/main/resources/library/ios/"

    /**
     * 生成工程的组织名
     */
    const val outputOrg: String = "me.yohom"

    /**
     * 生成工程名称
     */
    const val outputProjectName: String = "baidu_map_flutter"
}

open class FluttifyExtension {
    /**
     * jar路径
     */
    var jarFile: String = ""

    /**
     * framework路径
     */
    var frameworkDir: String = ""

    /**
     * 生成工程的组织名
     */
    var outputOrg: String = ""

    /**
     * 生成工程名称
     */
    var outputProjectName: String = ""
}