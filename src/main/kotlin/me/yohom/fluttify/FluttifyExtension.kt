package me.yohom.fluttify

// todo 配置信息里再加一个元信息的配置 比如Android的manifest文件和ios的plist文件的配置
open class FluttifyExtension {
    /**
     * jar路径 会在FluttifyCorePlugin创建的时候赋值
     */
    var jarDir: String = ""

    /**
     * framework路径 会在FluttifyCorePlugin创建的时候赋值
     */
    var frameworkDir: String = ""

    /**
     * iOS间接依赖 包括前缀和后缀名 形如 xx.framework libxx.a libxx.tbd(tbd是代替dylib的动态库)
     * android间接依赖 maven坐标全名 形如 org.antlr:antlr4-runtime:4.7.2
     */
    var transitiveDependencies = mapOf<String, List<String>>()

    /**
     * 生成工程的组织名
     */
    var outputOrg: String = ""

    /**
     * 生成工程名称
     */
    var outputProjectName: String = ""

    /**
     * android工程输出语言
     */
    var androidLanguage: String = "kotlin"

    /**
     * ios工程输出语言
     */
    var iOSLanguage: String = "objc"

    val androidTransitiveDependencies get() = transitiveDependencies["android"] ?: listOf()

    val iOSTransitiveFramework: List<String>
        get() {
            return transitiveDependencies["iOS"]
                ?.filter { it.endsWith(".framework") }
                ?.map { it.removeSuffix(".framework") }
                ?: listOf()
        }

    val iOSTransitiveTbd: List<String>
        get() {
            return transitiveDependencies["iOS"]
                ?.filter { it.startsWith("lib") && it.endsWith(".tbd") }
                ?.map { it.removePrefix("lib").removeSuffix(".tbd") }
                ?: listOf()
        }

    val iOSResource: List<String>
        get() {
            return transitiveDependencies["iOS"]
                ?.filter { it.endsWith(".bundle") }
                ?: listOf()
        }
}