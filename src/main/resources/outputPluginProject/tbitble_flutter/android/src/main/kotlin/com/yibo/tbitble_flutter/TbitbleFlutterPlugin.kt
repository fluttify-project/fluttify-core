package com.yibo.tbitble_flutter

import com.tbit.tbitblesdk.Bike.TbitBle

import com.fasterxml.jackson.databind.ObjectMapper

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class TbitbleFlutterPlugin : MethodCallHandler {

    private val mapper: ObjectMapper = ObjectMapper()

    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "com.tbit.tbitblesdk/TbitBle")
            channel.setMethodCallHandler(TbitbleFlutterPlugin())
        }
    }

    override fun onMethodCall(methodCall: MethodCall, methodResult: Result) {
        val args = methodCall.arguments as Map<String, *>
        when (methodCall.method) {
            "testModel" -> {
				val listener = mapper.readValue(args["listener"] as String, BikeState::class.java)
                val result = TbitBle.testModel(listener)

                methodResult.success(result)
            }
            "testModel2" -> {
				val listener = mapper.readValue(args["listener"] as String, BikeState::class.java)
                val result = TbitBle.testModel2(listener)

                methodResult.success(mapper.convertValue(result, Map::class.java))
            }
            "testJsonable" -> {
				val a = args["a"] as int
                val result = TbitBle.testJsonable(a)

                methodResult.success(result)
            }
            "stopScan" -> {
                val result = TbitBle.stopScan()

                methodResult.success(result)
            }
            else -> methodResult.notImplemented()
        }
    }
}
