package me.yohom.fluttify.model

import com.google.gson.annotations.SerializedName

data class Podspec(

    @field:SerializedName("summary")
    val summary: Any? = null,

    @field:SerializedName("requires_arc")
    val requiresArc: Any? = null,

    @field:SerializedName("frameworks")
    val frameworks: List<String?>? = null,

    @field:SerializedName("source_files")
    val sourceFiles: Any? = null,

    // 可能是List<String>或String
    @field:SerializedName("libraries")
    val libraries: Any? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("resources")
    val resources: Any? = null,

    @field:SerializedName("compiler_flags")
    val compilerFlags: Any? = null,

    @field:SerializedName("source")
    val source: Source? = null,

    @field:SerializedName("ios")
    val ios: Ios? = null,

    // 发现有的在顶层, 有的在ios下面, 这里两个都加进去
    @field:SerializedName("vendored_frameworks")
    val vendoredFrameworks: Any? /* String|List<String> */ = null,

    @field:SerializedName("version")
    val version: String? = null,

    @field:SerializedName("platforms")
    val platforms: Platforms? = null,

    @field:SerializedName("license")
    val license: Any? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("public_header_files")
    val publicHeaderFiles: String? = null,

    @field:SerializedName("homepage")
    val homepage: String? = null,

    @field:SerializedName("authors")
    val authors: Any? = null
)

data class Source(

    @field:SerializedName("http")
    val http: String? = null,

    @field:SerializedName("git")
    val git: String? = null,

    @field:SerializedName("tag")
    val tag: String? = null
)

data class License(

    @field:SerializedName("text")
    val text: String? = null,

    @field:SerializedName("type")
    val type: String? = null
)

data class Ios(

    @field:SerializedName("vendored_frameworks")
    val vendoredFrameworks: Any? /* String|List<String> */ = null
)

data class Platforms(

    @field:SerializedName("ios")
    val ios: String? = null
)
