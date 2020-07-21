package me.yohom.fluttify.model

import me.yohom.fluttify.Amap
import me.yohom.fluttify.FluttifyTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FieldTest : FluttifyTest() {

    @Test
    fun getFilterGetters() {
        Amap.iosLocationSDK
            .allTypes
            .find { it.name == "AMapGeoFenceRegion" }
            ?.fields
            ?.find { it.variable.name == "identifier" }
            ?.run {
                println("getter: $filterGetters")
            }
    }
}