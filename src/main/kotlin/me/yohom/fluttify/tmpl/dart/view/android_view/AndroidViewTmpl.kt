package me.yohom.fluttify.tmpl.dart.view.android_view

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.simpleName
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Type

//import 'dart:convert';
//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/android/android.export.dart';
//import 'package:flutter/foundation.dart';
//import 'package:flutter/gestures.dart';
//import 'package:flutter/material.dart';
//import 'package:flutter/rendering.dart';
//import 'package:flutter/services.dart';
//
//typedef void #__view_simple_name__#CreatedCallback(#__view__# controller);
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
//class #__view__#_Android extends StatefulWidget {
//  const #__view__#_Android({
//    Key key,
//    this.onViewCreated,
//  }) : super(key: key);
//
//  final #__view_simple_name__#CreatedCallback onViewCreated;
//
//  @override
//  _#__view__#_AndroidState createState() =>
//      _#__view__#_AndroidState();
//}
//
//class _#__view__#_AndroidState extends State<#__view__#_Android> {
//  #__view__# _controller;
//
//  @override
//  Widget build(BuildContext context) {
//    final gestureRecognizers = <Factory<OneSequenceGestureRecognizer>>[
//      Factory<OneSequenceGestureRecognizer>(() => EagerGestureRecognizer()),
//    ].toSet();
//
//    final messageCodec = StandardMessageCodec();
//    return AndroidView(
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
//    ObjectFactory_Android.release(_controller);
//    super.dispose();
//  }
//}
class AndroidViewTmpl(
    private val viewClass: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/android_view.dart.tmpl").readText()

    fun dartAndroidView(): String {
        val currentPackage = ext.outputProjectName
        val viewSimpleName = viewClass.name.simpleName()
        val view = viewClass.name
        val org = ext.outputOrg
        val viewType = viewClass.name

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__view_simple_name__#", viewSimpleName)
            .replace("#__view__#", view.toDartType())
            .replace("#__org__#", org)
            .replace("#__view_type__#", viewType)
    }
}
