package common.template

const val packageImport = """package #__package_name__#

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar
"""

const val kotlinClassDeclaration = """
class #__class_name__#Plugin : MethodCallHandler {"""

const val companionObject = """
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "#__method_channel__#")
            channel.setMethodCallHandler(#__plugin_class_simple_name__#}Plugin())
        }
    }
"""

const val onMethodCall = """
    override fun onMethodCall(call: MethodCall, result: Result) {
        val args = call.arguments as Map<String, *>
        when (call.method) {"""

const val invokeResult = """
            "#__method_name__#" -> result.success(#__java_class_simple_name__#.#__method_name__#(#__params__#))"""

const val classEnd = """
         }
    }
}
"""
