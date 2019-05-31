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
            "initialize" -> {
                val result = TbitBle.initialize(context, adapter)

                methodResult.success(result)
            }
            "setDebugListener" -> {
                val result = TbitBle.setDebugListener(listener)

                methodResult.success(result)
            }
            "testJsonable" -> {
				val a = args["a"] as int
                val result = TbitBle.testJsonable(a)

                methodResult.success(result)
            }
            "connect" -> {
				val machineId = args["machineId"] as String
				val key = args["key"] as String
                val result = TbitBle.connect(machineId, key, resultCallback, stateCallback)

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
