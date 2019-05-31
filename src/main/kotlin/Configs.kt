import preprocess.Project

object Configs {
    /**
     * 主类全路径名
     */
    const val mainJavaClass: String = "com.tbit.tbitblesdk.Bike.TbitBle"
    /**
     * jar路径
     */
    val jarPath: String = "${Project.path}/src/main/resources/android/tbitble.jar"
    /**
     * objc主类名
     */
    const val mainObjcClass: String = "TbitBluetooth"
    /**
     * framework路径
     */
    val frameworkPath: String = "${Project.path}/src/main/resources/ios/Tbit.framework"
    /**
     * 生成工程的组织名
     */
    val outputOrg: String = "com.yibo"
    /**
     * 生成工程名称
     */
    val outputProjectName: String = "tbitble_flutter"
}