package preprocess

import Configs.frameworkPath
import Configs.mainJavaClass
import Configs.mainObjcClass
import Configs.projectPath

object Analyzer {

    var mainJavaClassPath: String? = null
    var javaPackage: String? = null
    var javaClassSimpleName: String? = null
    var mainObjcClassPath: String? = null
    var methodChannelName: String? = null

    fun analyze() {
        mainJavaClassPath = "$projectPath/resource/android/decompiled/${mainJavaClass.replace(".", "/")}.java"
        javaPackage = mainJavaClass.substringBeforeLast(".")
        javaClassSimpleName = mainJavaClass.substringAfterLast(".")
        mainObjcClassPath = "$frameworkPath/Headers/$mainObjcClass.h"
        methodChannelName = "$javaPackage/$javaClassSimpleName"
    }
}