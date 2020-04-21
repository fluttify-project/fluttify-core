package me.yohom.fluttify.tmpl.dart.view.uikit_view

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.simpleName
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Type

//import 'dart:convert';
//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//import 'package:flutter/foundation.dart';
//import 'package:flutter/gestures.dart';
//import 'package:flutter/material.dart';
//import 'package:flutter/rendering.dart';
//import 'package:flutter/services.dart';
//
//typedef void #__view_simple_name__#CreatedCallback(#__view__# controller);
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
//class #__view__#_iOS extends StatefulWidget {
//  const #__view__#_iOS({
//    Key key,
//    this.onViewCreated,
//  }) : super(key: key);
//
//  final #__view_simple_name__#CreatedCallback onViewCreated;
//
//  @override
//  _#__view__#_iOSState createState() =>
//      _#__view__#_iOSState();
//}
//
//class _#__view__#_iOSState extends State<#__view__#_iOS> {
//  #__view__# _controller;
//
//  @override
//  Widget build(BuildContext context) {
//    final gestureRecognizers = <Factory<OneSequenceGestureRecognizer>>[
//      Factory<OneSequenceGestureRecognizer>(() => EagerGestureRecognizer()),
//    ].toSet();
//
//    final messageCodec = StandardMessageCodec();
//    return UiKitView(
//      viewType: '#__org__#/#__view_type__#',
//      gestureRecognizers: gestureRecognizers,
//      onPlatformViewCreated: _onViewCreated,
//      creationParamsCodec: messageCodec,
//    );
//  }
//
//  void _onViewCreated(int id) {
//    _controller = #__view__#()..refId = id;
//    if (widget.onViewCreated != null) {
//      widget.onViewCreated(_controller);
//    }
//  }
//
//  @override
//  void dispose() {
//    ObjectFactory_iOS.release(_controller);
//    super.dispose();
//  }
//}
private val tmpl = getResource("/tmpl/dart/uikit_view.dart.tmpl").readText()

fun UiKitViewTmpl(viewClass: Type): String {
    val currentPackage = ext.projectName
    val viewSimpleName = viewClass.name.simpleName()
    val view = viewClass.name
    val org = ext.org
    val viewType = viewClass.name

    return tmpl
        .replace("#__current_package__#", currentPackage)
        .replaceParagraph("#__foundation__#", ext.foundationVersion.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
        .replace("#__view_simple_name__#", viewSimpleName)
        .replace("#__view__#", view.toDartType())
        .replace("#__org__#", org)
        .replace("#__view_type__#", viewType)
}
