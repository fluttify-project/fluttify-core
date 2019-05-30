package common.template

import Configs.mainJavaClass

const val kotlinPackageImportTemp = """package #__package_name__#

import $mainJavaClass

import com.fasterxml.jackson.databind.*;

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
"""

const val kotlinClassDeclarationTemp = """
class #__class_name__#Plugin : MethodCallHandler {

    private val MAPPER: ObjectMapper = ObjectMapper()
"""

const val companionObjectTemp = """
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "#__method_channel__#")
            channel.setMethodCallHandler(#__plugin_class_simple_name__#Plugin())
        }
    }
"""

const val kotlinOnMethodCall = """
    override fun onMethodCall(call: MethodCall, result: Result) {
        val args = call.arguments as Map<String, *>
        when (call.method) {"""

const val kotlinInvokeResultTemp = """
            "#__method_name__#" -> result.success(#__java_class_simple_name__#.#__method_name__#(#__params__#))"""

const val kotlinWhenElse = """
            else -> result.notImplemented()"""

const val kotlinClassEnd = """
         }
    }
}
"""
