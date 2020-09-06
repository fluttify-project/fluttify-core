package me.yohom.fluttify.tmpl.java.common.handler.handler_getter_batch

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.GoogleMap
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HandlerGetterBatchTmplKtTest : FluttifyTest() {

    @Test
    fun handlerGetterBatchTmpl() {
        GoogleMap.androidSDK
            .allTypes
            .find { it.name == "com.google.android.gms.maps.model.VisibleRegion" }
            ?.fields
            ?.find { it.variable.name == "nearLeft" }
            ?.run {
                print(HandlerGetterBatchTmpl(this))
            }
    }
}