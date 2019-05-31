package builtparser

import common.model.JavaClassInfo
import org.junit.Assert
import org.junit.Test

internal class JavaParserTest {

    private val classPath = "${System.getProperty("user.dir")}/src/test/resources/android/decompiled/com/tbit/tbitblesdk/Bike/TbitBle.java"
    private val interfacePath = "${System.getProperty("user.dir")}/src/test/resources/android/decompiled/com/tbit/tbitblesdk/protocol/callback/PacketCallback.java"

    @Test
    fun classInfo() {
        val classResult = JavaParser(classPath).typeInfo()
        println("classResult: $classResult")
        Assert.assertTrue(classResult == JavaClassInfo("com.tbit.tbitblesdk.Bike.TbitBle", "TbitBle", classPath))
        val interfaceResult = JavaParser(interfacePath).typeInfo()
        println("interfaceResult: $interfaceResult")
        Assert.assertTrue(interfaceResult == JavaClassInfo("com.tbit.tbitblesdk.protocol.callback.PacketCallback", "PacketCallback", interfacePath))
    }

    @Test
    fun walkTree() {
    }
}