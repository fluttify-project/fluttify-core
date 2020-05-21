package me.yohom.fluttify.tmpl.dart.view.android_view

import me.yohom.fluttify.Regexes
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
//#__foundation__#
//
//typedef void #__view_simple_name__#CreatedCallback(#__view__# controller);
//typedef Future<void> _OnAndroidViewDispose();
//
//class #__view__#_Android extends StatefulWidget {
//  const #__view__#_Android({
//    Key key,
//    this.onViewCreated,
//    this.onDispose,
//    #__creation_params__#
//  }) : super(key: key);
//
//  final #__view_simple_name__#CreatedCallback onViewCreated;
//  final _OnAndroidViewDispose onDispose;
//
//  #__creation_fields__#
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
//    // 碰到一个对象返回的hashCode为0的情况, 造成和这个id冲突了, 这里用一个magic number避免一下
//    _controller = #__view__#()..refId = 2147483647 - id;
//    if (widget.onViewCreated != null) {
//      widget.onViewCreated(_controller);
//    }
//  }
//
//  @override
//  void dispose() {
//    if (widget.onDispose != null) {
//      widget.onDispose().then((_) => _controller.release__());
//    }
//    super.dispose();
//  }
//}
private val tmpl = getResource("/tmpl/dart/android_view.dart.tmpl").readText()

fun AndroidViewTmpl(viewType: Type): String {
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
                param.variable.trueType !in listOf("android.content.Context", "android.util.AttributeSet", "int")
                        &&
                        param.variable.trueType.findType().isKnownType
            }
        }

    return if (customConstructorList.isNotEmpty()) {
        val constructor = customConstructorList[0]
        // 去掉Context的参数列表, 不需要Context
        val formalParamsExcludeContext = constructor
            .formalParams
            .filter { it.variable.trueType != "android.content.Context" }

        // 参数
        val params = formalParamsExcludeContext
            .joinToString("\n") {
                "this.${it.variable.name},"
            }
        // 属性
        val fields = formalParamsExcludeContext
            .joinToString("\n") {
                "final ${it.variable.trueType.toDartType()} ${it.variable.name};"
            }
        // 传入参数
        val creationArgs = formalParamsExcludeContext
            .map { it.variable }
            .toDartMap("creationParams: {", "},") {
                when {
                    it.isEnum() -> "widget.${it.name.depointer()}?.index"
                    it.jsonable() -> "widget.${it.name.depointer()}"
                    (it.isIterable && it.getIterableLevel() <= 1) || it.isStructPointer() -> "widget.${it.name.depointer()}?.map((it) => it.refId)?.toList() ?? []"
                    it.getIterableLevel() > 1 -> "[] /* 多维数组暂不处理 */" // 多维数组暂不处理
                    Regexes.MAP.matches(it.trueType) -> "{} /* Map类型暂不处理 */" // 多维数组暂不处理
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
        .replaceParagraph("#__foundation__#", ext.foundationVersion.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
        .replace("#__view_simple_name__#", viewSimpleName)
        .replace("#__view__#", view.toDartType())
        .replace("#__org__#", org)
        .replace("#__view_type__#", nativeView)
}
