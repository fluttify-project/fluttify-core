package common.template

const val `import` = """import 'dart:async';

import 'package:flutter/services.dart';
"""

const val dartClassDeclaration = """
class #__plugin_class_simple_name__#Android {"""

const val methodChannel = """
  static final _channel = MethodChannel('#__methodChannelName__#');
"""

const val invodeMethod = """
  static Future<#__return_type__#> #__method_name__#(#__formal_params__#) {
    return _channel.invokeMethod('#__method_name__#'#__separator__##__actual_params__#);
  }
"""