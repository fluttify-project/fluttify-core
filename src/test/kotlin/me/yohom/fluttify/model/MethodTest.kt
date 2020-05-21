package me.yohom.fluttify.model

import me.yohom.fluttify.Tim
import org.junit.jupiter.api.Test

class MethodTest {

    @Test
    fun filter() {
        Tim.iosSDK
            .libs
            .flatMap { it.types }
            .find { it.name == "TIMGroupManager" }
            ?.methods
            ?.find { it.signature() == "modifyGroupCustomInfo_customInfo_succ_fail" }
            ?.filter()
            ?.run {
                println("通过过滤: $this")
            }
    }
}