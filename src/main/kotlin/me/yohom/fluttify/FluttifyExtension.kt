package me.yohom.fluttify

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
     * 元素替换
     */
    var overrideElements: Map<Int, String> = mapOf()
//        get() {
//            val packedMethods = field.map { entry -> Pair(entry.key.pack(), entry.key.pack()) }.toMap()
//            println("packedMethods: $packedMethods")
//            return packedMethods
//        }

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
     * 排除的方法 接受正则表达式
     */
    var methods: List<String> = listOf()

    override fun toString(): String {
        return "Exclude(classes=$classes, methods=$methods)"
    }
}

open class Remote {
    /**
     * 组织名 ios可不填
     */
    var org: String = ""

    /**
     * 依赖名称
     */
    var name: String = ""

    /**
     * 依赖版本
     */
    var version: String = ""

    /**
     * 间接远程依赖
     */
    var transitiveDependencies: List<String> = listOf()

    /**
     * android maven 坐标
     */
    val androidCoordinate get() = "$org:$name:$version"

    /**
     * android是否已配置
     */
    val androidConfigured get() = org.isNotEmpty() && name.isNotEmpty() && version.isNotEmpty()

    /**
     * ios pod 坐标
     */
    val iosCoordinate get() = "'$name', '~> $version'"

    /**
     * ios是否已配置
     */
    val iosConfigured get() = name.isNotEmpty() && version.isNotEmpty()

    override fun toString(): String {
        return "Remote(org='$org', name='$name', version='$version')"
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