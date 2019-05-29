package common.template

const val kotlinPackageImportTemp = """package #__package_name__#

dartPackageImportTemp io.flutter.plugin.common.MethodCall
dartPackageImportTemp io.flutter.plugin.common.MethodChannel
dartPackageImportTemp io.flutter.plugin.common.MethodChannel.MethodCallHandler
dartPackageImportTemp io.flutter.plugin.common.MethodChannel.Result
dartPackageImportTemp io.flutter.plugin.common.PluginRegistry.Registrar
"""

const val kotlinClassDeclarationTemp = """
class #__class_name__#Plugin : MethodCallHandler {"""

const val companionObjectTemp = """
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "#__method_channel__#")
            channel.setMethodCallHandler(#__plugin_class_simple_name__#}Plugin())
        }
    }
"""

const val kotlinOnMethodCall = """
    override fun kotlinOnMethodCall(call: MethodCall, result: Result) {
        val args = call.arguments as Map<String, *>
        when (call.method) {"""

const val kotlinInvokeResultTemp = """
            "#__method_name__#" -> result.success(#__java_class_simple_name__#.#__method_name__#(#__params__#))"""

const val kotlinClassEnd = """
         }
    }
}
"""
