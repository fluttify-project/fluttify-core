package me.yohom.fluttify.model

import com.google.gson.annotations.SerializedName

data class Podspec(

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("requires_arc")
	val requiresArc: Boolean? = null,

	@field:SerializedName("frameworks")
	val frameworks: List<String?>? = null,

	@field:SerializedName("source_files")
	val sourceFiles: String? = null,

	@field:SerializedName("libraries")
	val libraries: List<String?>? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("resources")
	val resources: String? = null,

	@field:SerializedName("compiler_flags")
	val compilerFlags: String? = null,

	@field:SerializedName("source")
	val source: Source? = null,

	@field:SerializedName("ios")
	val ios: Ios? = null,

	// 发现有的在顶层, 有的在ios下面, 这里两个都加进去
	@field:SerializedName("vendored_frameworks")
	val vendoredFrameworks: String? = null,

	@field:SerializedName("version")
	val version: String? = null,

	@field:SerializedName("platforms")
	val platforms: Platforms? = null,

	@field:SerializedName("license")
	val license: License? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("public_header_files")
	val publicHeaderFiles: String? = null,

	@field:SerializedName("homepage")
	val homepage: String? = null,

	@field:SerializedName("authors")
	val authors: String? = null
)

data class Source(

	@field:SerializedName("http")
	val http: String? = null
)

data class License(

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)

data class Ios(

	@field:SerializedName("vendored_frameworks")
	val vendoredFrameworks: String? = null
)

data class Platforms(

	@field:SerializedName("ios")
	val ios: String? = null
)
