package me.yohom.fluttify.model

import me.yohom.fluttify.ext
import java.io.File

@Suppress("PropertyName")
class XCConfig(val file: File) {
    val FRAMEWORK_SEARCH_PATHS: String? by lazy {
        file.readLines()
            .find { it.contains("FRAMEWORK_SEARCH_PATHS") }
            ?.split(" = ")
            ?.get(1)
            ?.split(" ")
            ?.get(1)
            ?.removeSurrounding("\"", "\"")
            ?.replace("\${PODS_ROOT}", "output-project/${ext.projectName}/example/ios/Pods")
    }

    val HEADER_SEARCH_PATHS: List<String> by lazy {
        file.readLines()
            .find { it.contains("HEADER_SEARCH_PATHS") }
            ?.split(" = ")
            ?.get(1)
            ?.split(" ")
            ?.map { it.removeSurrounding("\"", "\"") }
            ?.map { it.replace("\${PODS_ROOT}", "output-project/${ext.projectName}/example/ios/Pods") }
            ?: listOf()
    }
}