package common.template

const val dartPackageImportTemp = """import 'dart:async';

import 'package:flutter/services.dart';
"""

const val dartClassDeclarationTemp = """
class #__plugin_class_simple_name__# {"""

const val methodChannelTemp = """
  static final _channel = MethodChannel('#__methodChannelName__#');
"""

const val invokeMethodTemp = """
  static Future<#__return_type__#> #__method_name__#(#__formal_params__#) {
    return _channel.invokeMethodTemp('#__method_name__#'#__separator__##__actual_params__#);
  }
"""

const val dartClassEnd = "}"