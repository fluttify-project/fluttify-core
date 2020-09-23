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
//#__foundation__#
//
//typedef void #__view_simple_name__#CreatedCallback(#__view__# controller);
//typedef Future<void> _OnUiKitViewDispose();
//
//class #__view__#_iOS extends StatefulWidget {
//  const #__view__#_iOS({
//    Key key,
//    this.onViewCreated,
//    this.onDispose,
//    this.params = const <String, dynamic>{},
//    this.gestureRecognizers,
//  }) : super(key: key);
//
//  final #__view_simple_name__#CreatedCallback onViewCreated;
//  final _OnUiKitViewDispose onDispose;
//  final Map<String, dynamic> params;
//  final Set<Factory<OneSequenceGestureRecognizer>> gestureRecognizers;
//
//  @override
//  _#__view__#_iOSState createState() => _#__view__#_iOSState();
//}
//
//class _#__view__#_iOSState extends State<#__view__#_iOS> {
//  #__view__# _controller;
//
//  @override
//  Widget build(BuildContext context) {
//    final gestureRecognizers = widget.gestureRecognizers ?? <Factory<OneSequenceGestureRecognizer>>{
//      Factory<OneSequenceGestureRecognizer>(() => EagerGestureRecognizer()),
//    };
//
//    final messageCodec = FluttifyMessageCodec(#__tag__#);
//    return UiKitView(
//      viewType: '#__org__#/#__view_type__#',
//      gestureRecognizers: gestureRecognizers,
//      onPlatformViewCreated: _onViewCreated,
//      creationParamsCodec: messageCodec,
//      creationParams: widget.params,
//    );
//  }
//
//  void _onViewCreated(int id) async {
//    // 碰到一个对象返回的hashCode为0的情况, 造成和这个id冲突了, 这里用一个magic number避免一下
//    // 把viewId转换为refId再使用, 使其与其他对象统一
//    final refId = await viewId2RefId((2147483647 - id).toString());
//    _controller = #__view__#()..refId = refId..tag__ = '#__tag__#';
//    if (widget.onViewCreated != null) {
//      widget.onViewCreated(_controller);
//    }
//  }
//
//  @override
//  void dispose() {
//    if (widget.onDispose != null) {
//      widget.onDispose().then((_) => _controller.release__());
//    } else {
//      _controller.release__();
//    }
//    super.dispose();
//  }
//}
private val tmpl by lazy { getResource("/tmpl/dart/uikit_view.dart.tmpl").readText() }

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
        .replace("#__channel_name__#", ext.methodChannelName)
        .replace("#__tag__#", ext.projectName)
        .replace("#__org__#", org)
        .replace("#__view_type__#", viewType)
}
