object Configs {
    /**
     * 当前项目路径
     */
    val projectPath: String = System.getProperty("user.dir")
    /**
     * 主类全路径名
     */
    const val mainJavaClass: String = "com.tbit.tbitblesdk.Bike.TbitBle"
    /**
     * jar路径
     */
    val jarPath: String = "$projectPath/resource/android/tbitble.jar"
    /**
     * objc主类名
     */
    const val mainObjcClass: String = "TbitBluetooth"
    /**
     * framework路径
     */
    val frameworkPath: String = "$projectPath/resource/ios/Tbit.framework"
}