package preprocess

import Jar
import org.junit.Test

internal class JarTest {
    @Test
    fun testDecompiledClasses() {
        println(Jar.Decompiled.classes)
    }
}