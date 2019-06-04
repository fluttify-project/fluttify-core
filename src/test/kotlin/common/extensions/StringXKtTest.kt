package common.extensions

import org.junit.Assert
import org.junit.Test

class StringXKtTest {

    @Test
    fun jsonable() {
    }

    @Test
    fun toDartType() {
    }

    @Test
    fun underscore2Camel() {
    }

    @Test
    fun camel2Underscore() {
        val camelString = "ACamelString"

        val underscoreString = camelString.camel2Underscore()

        println(underscoreString)

        Assert.assertTrue(underscoreString == "a_camel_string")
    }

    @Test
    fun placeholder() {
    }

    @Test
    fun isModel() {
    }
}