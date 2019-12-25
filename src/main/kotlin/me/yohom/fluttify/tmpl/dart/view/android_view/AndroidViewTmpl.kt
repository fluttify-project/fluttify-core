package me.yohom.fluttify.tmpl.dart.view.android_view

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type

//import 'dart:convert';
//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/android/android.export.g.dart';
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
//    #__creation_params__#
//  }) : super(key: key);
//
//  final #__view_simple_name__#CreatedCallback onViewCreated;
//  #__creation_field__#
//
//  @override
//  _#__view__#_AndroidState createState() => _#__view__#_AndroidState();
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
//      #__creation_args__#
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
//    PlatformFactory_Android.release(_controller);
//    super.dispose();
//  }
//}
class AndroidViewTmpl(private val viewType: Type) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/android_view.dart.tmpl").readText()

    fun dartAndroidView(): String {
        val currentPackage = ext.projectName
        val viewSimpleName = viewType.name.simpleName()
        val view = viewType.name
        val org = ext.org
        val nativeView = viewType.name

        // 找出是否存在非Context, AttributeSet和int类型参数的构造器
        // 如果存在, 那么以这个构造器进行初始化
        val customConstructorList = viewType
            .constructors
            .filter {
                it.formalParams.any { param ->
                    param.variable.typeName !in listOf("android.content.Context", "android.util.AttributeSet", "int")
                }
            }

        return if (customConstructorList.isNotEmpty()) {
            val constructor = customConstructorList[0]
            // 去掉Context的参数列表, 不需要Context
            val formalParamsExcludeContext = constructor
                .formalParams
                .filter { it.variable.typeName != "android.content.Context" }

            // 参数
            val params = formalParamsExcludeContext
                .joinToString("\n") {
                    "this.${it.variable.name},"
                }
            // 属性
            val fields = formalParamsExcludeContext
                .joinToString("\n") {
                    "final ${it.variable.typeName.toDartType()} ${it.variable.name};"
                }
            // 传入参数
            val creationArgs = formalParamsExcludeContext
                .map { it.variable }
                .toDartMap("creationParams: {", "},") {
                    when {
                        it.typeName.findType().isEnum() -> "widget.${it.name.depointer()}?.index"
                        it.typeName.jsonable() -> "widget.${it.name}?.depointer()"
                        (it.isList && it.genericLevel <= 1) || it.isStructPointer() -> "widget.${it.name.depointer()}?.map((it) => it.refId)?.toList() ?? []"
                        it.genericLevel > 1 -> "[] /* 多维数组暂不处理 */" // 多维数组暂不处理
                        else -> "widget.${it.name.depointer()}?.refId ?? -1"
                    }
                }
            tmpl.replaceParagraph("#__creation_params__#", params)
                .replaceParagraph("#__creation_fields__#", fields)
                .replace("#__creation_args__#", creationArgs)
        } else {
            tmpl.replace("#__creation_params__#", "")
                .replace("#__creation_fields__#", "")
                .replace("#__creation_args__#", "")
        }.replace("#__current_package__#", currentPackage)
            .replace("#__view_simple_name__#", viewSimpleName)
            .replace("#__view__#", view.toDartType())
            .replace("#__org__#", org)
            .replace("#__view_type__#", nativeView)
    }
}
