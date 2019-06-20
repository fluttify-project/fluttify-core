object Configs {
    /**
     * 主类全路径名
     */
    const val mainJavaClass: String = "com.baidu.mapapi.map.MapView"

    /**
     * jar路径
     */
    val jarFilePath: String = "${Project.path}/src/main/resources/android/BaiduLBS_Android.jar"

    /**
     * objc主类名
     */
    const val mainObjcClass: String = "TbitBluetooth"

    /**
     * framework路径
     */
    val frameworkDirPath: String = "${Project.path}/src/main/resources/ios/Tbit.framework"

    /**
     * 生成工程的组织名
     */
    const val outputOrg: String = "me.yohom"

    /**
     * 生成工程名称
     */
    const val outputProjectName: String = "baidu_map_flutter"
}