package generator

interface IAndroid {
    val androidDartResult: String

    val kotlinResult: String

    fun generateAndroidDart()

    fun generateKotlin()
}