package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Type

//import 'dart:convert';
//import 'dart:typed_data';
//
//import 'package:flutter/foundation.dart';
//import 'package:flutter/gestures.dart';
//import 'package:flutter/material.dart';
//import 'package:flutter/rendering.dart';
//import 'package:flutter/services.dart';
//import 'package:#__current_package__#/#__current_package__#.dart';
//
//typedef void #__view_simple_name__#CreatedCallback(#__view__# controller);
//
//class #__view__#_Android extends StatelessWidget {
//    const #__view__#_Android({
//        Key key,
//        this.onViewCreated,
//    }) : super(key: key);
//
//    final #__view_simple_name__#CreatedCallback onViewCreated;
//
//    @override
//    Widget build(BuildContext context) {
//        final gestureRecognizers = <Factory<OneSequenceGestureRecognizer>>[
//                Factory<OneSequenceGestureRecognizer>(() => EagerGestureRecognizer()),
//        ].toSet();
//
//        final messageCodec = StandardMessageCodec();
//        return AndroidView(
//            viewType: '#__org__#/#__view_type__#',
//        gestureRecognizers: gestureRecognizers,
//        onPlatformViewCreated: _onViewCreated,
//        creationParamsCodec: messageCodec,
//        );
//    }
//
//    void _onViewCreated(int id) {
//        final controller = #__view__#.withRefId(id);
//        if (onViewCreated != null) {
//            onViewCreated(controller);
//        }
//    }
//}
/**
 * 一个Android的View类, 需要生成两个类
 *
 * 1: 控制器类, 即这个View类的dart接口
 * 2: AndroidView类
 */
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
