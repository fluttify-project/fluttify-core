package generator

interface IIOS {
    val iOSDartResult: String

    val swiftResult: String

    fun generateIOSDart()

    fun generateSwift()
}