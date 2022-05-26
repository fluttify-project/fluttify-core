package me.yohom.fluttify

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.iterate
import org.gradle.api.Action
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class FluttifyExtension @Inject constructor(objectFactory: ObjectFactory?) {
    /**
     * 项目名称
     */
    var projectName: String = ""

    /**
     * 组织名称
     */
    var org: String = "com.fluttify"

    /**
     * 描述
     */
    var desc: String = "A Fluttify Project"

    /**
     * 作者
     */
    var author: String = "yohom"

    /**
     * 邮箱地址
     */
    var email: String = "yohombao@qq.com"

    /**
     * 主页
     */
    var homepage: String = "https://fluttify.com"

    /**
     * 混淆白名单 在这里列表里的都不认为是混淆类
     */
    var obfuscatedWhiteList: List<String> = listOf()

    /**
     * foundation版本
     */
    var foundationVersion: Map<String, String> = mapOf()

    /**
     * 插件依赖
     */
    var pluginDependencies: Map<String, String> = mapOf()

    /**
     * 纯dart包依赖
     */
    var packageDependencies: Map<String, String> = mapOf()

    /**
     * android端配置
     */
    var android: PlatformSpec = objectFactory?.newInstance(PlatformSpec::class.java) ?: PlatformSpec(objectFactory)

    fun android(action: Action<PlatformSpec?>) {
        action.execute(android)
    }

    /**
     * ios端配置
     */
    var ios: PlatformSpec = objectFactory?.newInstance(PlatformSpec::class.java) ?: PlatformSpec(objectFactory)

    fun ios(action: Action<PlatformSpec?>) {
        action.execute(ios)
    }

    val iOSTransitiveFramework: List<String>
        get() {
            return ios.local.transitiveDependencies
                .filter { it.endsWith(".framework") }
                .map { it.removeSuffix(".framework") }
        }

    val iOSTransitiveTbd: List<String>
        get() {
            return ios.local.transitiveDependencies
                .filter { Regex("lib.+\\.tbd").matches(it) }
                .map { it.removePrefix("lib").removeSuffix(".tbd") }
        }

    val iOSResource: List<String>
        get() {
            return ios.local.transitiveDependencies.filter { it.endsWith(".bundle") }
        }

    val methodChannelName: String
        get() = "$org/$projectName"

    // 暂时没有用处, 需要找方法判断出有没有哪个平台没有配置
    val availablePlatform: List<String>
        get() {
            val result = mutableListOf<String>()
            if (ios != null) result.add("ios")
            if (android != null) result.add("android")
            return result
        }

    override fun toString(): String {
        return "Extension(projectName='$projectName', org='$org', desc='$desc', author='$author', email='$email', homepage='$homepage', foundationVersion='$foundationVersion', pluginDependencies='$pluginDependencies', android=$android, ios=$ios)"
    }
}

open class PlatformSpec @Inject constructor(objectFactory: ObjectFactory?) {
    /**
     * library所在路径
     */
    var libDir: String = ""

    /**
     * 手动指定的回调类
     *
     * 会存在一些情况, 本身的回调类, 但是SDK中有其实体子类, 这里手动指定一下
     */
    var callbackClasses = listOf<String>()

    /**
     * 手动指定的非回调类
     *
     * 会存在一些情况, 本身是接口且没有子类, 但不是回调类的情况
     */
    var noncallbackClasses = listOf<String>()

    /**
     * ios头文件导入, 如果不指定, 则使用默认的头文件导出
     */
    var iosImportHeader: List<String> = listOf()

    /**
     * ios sdk版本
     */
    var iosDeploymentTarget: String = "8.0"

    /**
     * 元素替换
     */
    var overrideElements: Map<String, String> = mapOf()

    /**
     * 全局宏展开, 作用在源代码文件上, 接收正则表达式
     */
    var predefineMacro: Map<String, String> = mapOf()

    /**
     * 依赖仓库
     *
     * Android端即`maven { url 'https://download.flutter.io' }`;
     * iOS端即`source 'https://github.com/artsy/Specs.git'`;
     */
    var repositories: List<String> = listOf()

    /**
     * 远程依赖配置
     */
    val remote: Remote = objectFactory?.newInstance(Remote::class.java) ?: Remote()

    fun remote(action: Action<Remote>) {
        action.execute(remote)
    }

    /**
     * 本地依赖配置
     */
    val local: Local = objectFactory?.newInstance(Local::class.java) ?: Local()

    fun local(action: Action<Local>) {
        action.execute(local)
    }

    /**
     * 排除的成员
     */
    val exclude: Exclude = objectFactory?.newInstance(Exclude::class.java) ?: Exclude()

    fun exclude(action: Action<Exclude>) {
        action.execute(exclude)
    }

    /**
     * ios端的library头文件导入列表
     */
    val iosLibraryHeaders: List<String>
        get() {
            // 导入头文件
            // 如果没有手动指定的话则拼接出一个
            return iosImportHeader.ifEmpty {
                libDir
                    .file()
                    .run {
                        // 所有的Framework
                        val frameworkHeaders = listFiles { _, name -> name.endsWith(".framework") }
                            ?.map { "#import <${it.nameWithoutExtension}/${it.nameWithoutExtension}.h>" }
                            ?: listOf()
                        // 如果没有framework, 那么就遍历出所有的.h文件
                        val directHeaders = mutableListOf<String>()
                        if (list()?.none { it.endsWith(".framework") } == true) {
                            // 所有的.h
                            iterate("h") {
                                // 不导入隐藏文件
                                if (!it.name.startsWith(".")) {
                                    directHeaders.add("#import <${it.parentFile.name}/${it.name}>")
                                }
                            }
                        }
                        frameworkHeaders.union(directHeaders).toList()
                    }
            }
        }

    override fun toString(): String {
        return "PlatformSpec(libDir='$libDir', remote=$remote, local=$local, exclude=$exclude)"
    }
}

open class Exclude {
    /**
     * 排除的类 接受正则表达式
     */
    var classes: List<String> = listOf()

    /**
     * 排除的文件 接受正则表达式
     *
     * 文件名, 不需要路径
     */
    var files: List<String> = listOf()

    /**
     * 排除的方法 接受正则表达式
     */
    var methods: List<String> = listOf()

    /**
     * 排除的库
     */
    var libs: List<String> = listOf()

    /**
     * 排除的常量
     */
    var constants: List<String> = listOf()

    /**
     * 排除的宏
     */
    var macros: List<String> = listOf()

    /**
     * 排除的framework搜索路径
     */
    var frameworkSearchPath: List<String> = listOf()

    override fun toString(): String {
        return "Exclude(classes=$classes, methods=$methods, libs=$libs, constants=$constants)"
    }
}

open class Remote {
    /**
     * 远程依赖
     *
     * Android端即`org:name:version`;
     * iOS端即`'name', 'version'`;
     */
    var dependencies: List<String> = listOf()

    /**
     * 间接远程依赖
     */
    var transitiveDependencies: List<String> = listOf()

    /**
     * android是否已配置
     */
    val configured get() = dependencies.isNotEmpty()

    /**
     * 依赖名称
     */
    val nameList: Boolean
        get() {
            return dependencies.isNotEmpty()
        }

    override fun toString(): String {
        return "Remote(dependencies=$dependencies, transitiveDependencies=$transitiveDependencies)"
    }
}

open class Local {
    /**
     * 间接依赖
     */
    var transitiveDependencies = listOf<String>()

    override fun toString(): String {
        return "Local(transitiveDependencies=$transitiveDependencies)"
    }
}