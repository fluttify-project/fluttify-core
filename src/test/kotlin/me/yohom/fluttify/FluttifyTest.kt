package me.yohom.fluttify

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

open class FluttifyTest {
    @BeforeEach
    fun setUpStreams() {
        ext = FluttifyExtension(null)
    }

    @AfterEach
    fun restoreStreams() {
    }
}