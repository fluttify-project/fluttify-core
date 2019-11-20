package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.extensions.*
import org.junit.Assert
import org.junit.Test

class StringXKtTest {

    @Test
    fun jsonable() {
    }

    @Test
    fun toDartType() {
        println("android_util_Pair<Integer,com_amap_api_maps_model_LatLng>".toDartType())
        println("android_util_Pair<Float,com_amap_api_maps_model_LatLng>".toDartType())
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

    @Test
    fun replaceBatch() {
        Assert.assertTrue("{1, 2, 3}".replaceBatch("{", "}", "[", "]") == "[1, 2, 3]")
    }

    @Test
    fun genericType() {
        println("List<List<List<Abc>>>".genericType())
    }

    @Test
    fun genericLevel() {
        println("List<List<List<Abc>>>".genericLevel())
    }

    @Test
    fun interfaces() {
        println("List<Abc>".genericType())
    }

    @Test
    fun isObfuscated() {
        println("com.amap.api.mapcore.util.el".isObfuscated())
    }

}