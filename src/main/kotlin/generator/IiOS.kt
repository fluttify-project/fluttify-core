package generator

interface IiOS {
    val iOSDartResult: String

    val swiftResult: String

    fun generateIOSDart()

    fun generateSwift()
}