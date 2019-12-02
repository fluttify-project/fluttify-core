package me.yohom.fluttify

// todo 配置信息里再加一个元信息的配置 比如Android的manifest文件和ios的plist文件的配置
open class FluttifyExtension {
    /**
     * jar/aar路径 会在FluttifyCorePlugin创建的时候赋值
     */
    var archiveDir: String = ""

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
    var androidLanguage: String = "java"

    /**
     * ios工程输出语言
     */
    var iOSLanguage: String = "objc"

    /**
     * 插件描述
     */
    var desc: String = "A new fluttify plugin."

    /**
     * 作者
     */
    var author: String = ""

    /**
     * 作者邮箱
     */
    var email: String = ""

    /**
     * 项目主页
     */
    var homepage: String = ""

    /**
     * Fluttify基础库版本 默认值最好跟随foundation_fluttify的更新而更新
     */
    var foundationVersion: String = "^0.1.0"

    /**
     * 插件依赖 <名称, 版本>
     */
    var pluginDependencies: Map<String, String> = mapOf()

    /**
     * 排除生成的iOS类名
     */
    var excludeIOSClasses: List<String> = listOf()

    /**
     * 排除生成的Android类名
     */
    var excludeAndroidClasses: List<String> = listOf()

    /**
     * 排除生成的iOS方法
     */
    var excludeIOSMethods: List<String> = listOf()

    /**
     * 排除生成的Android方法
     */
    var excludeAndroidMethods: List<String> = listOf()

    /**
     * 声明权限 <权限名称, 申请理由> 暂时不做
     */
    var permissions: Map<String, String> = mapOf()

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

    val methodChannelName: String
        get() = "${outputOrg}/${outputProjectName}"
}