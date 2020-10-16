package me.yohom.fluttify.model

import me.yohom.fluttify.ext
import java.io.File

@Suppress("PropertyName")
class XCConfig(val file: File) {
    val FRAMEWORK_SEARCH_PATHS: List<String> by lazy {
        file.readLines()
            .find { it.contains("FRAMEWORK_SEARCH_PATHS") }
            ?.split(" = ")
            ?.get(1)
            ?.split(" ")
            ?.filterNot { it == "\$(inherited)" }
            ?.filterNot { path -> ext.ios.exclude.frameworkSearchPath
                .map { Regex(it.removeSurrounding("\"", "\"")) }
                .any { it.matches(path) }
            }
            ?.map {
                it.removeSurrounding("\"", "\"")
                    .replace("\${PODS_ROOT}", "output-project/${ext.projectName}/example/ios/Pods")
            }
            ?.apply { println("FRAMEWORK_SEARCH_PATHS: $this") }
            ?: listOf()
    }

    val HEADER_SEARCH_PATHS: List<String> by lazy {
        file.readLines()
            .find { it.contains("HEADER_SEARCH_PATHS") }
            ?.split(" = ")
            ?.get(1)
            ?.split(" ")
            ?.toMutableList()?.apply { removeAt(0) }
            ?.map { it.removeSurrounding("\"", "\"") }
            ?.map { it.replace("\${PODS_ROOT}", "output-project/${ext.projectName}/example/ios/Pods") }
            ?.apply { println("HEADER_SEARCH_PATHS: $this") }
            ?: listOf()
    }

    override fun toString(): String {
        return "XCConfig: $file, $FRAMEWORK_SEARCH_PATHS, $HEADER_SEARCH_PATHS"
    }

}