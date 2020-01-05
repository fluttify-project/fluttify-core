package me.yohom.fluttify

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

open class FluttifyTest {
    protected val outContent: ByteArrayOutputStream = ByteArrayOutputStream()
    protected val errContent: ByteArrayOutputStream = ByteArrayOutputStream()
    private val originalOut = System.out
    private val originalErr = System.err

    @BeforeEach
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
        System.setErr(PrintStream(errContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOut)
        System.setErr(originalErr)
    }
}