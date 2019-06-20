object Configs {
    /**
     * 主类全路径名
     */
    const val mainJavaClass: String = "com.baidu.mapapi.map.MapView"

    /**
     * 如果是PlatformView的话, 指定PlatformView的控制器类
     *
     * 大部分情况下其实都是PlatformView本身, 但是也有像高德地图和百度地图这样单独有控制器类的
     */
    const val platformViewControllerClass: String = "com.baidu.mapapi.map.BaiduMap"

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