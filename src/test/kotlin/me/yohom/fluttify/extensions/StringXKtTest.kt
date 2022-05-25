package me.yohom.fluttify.extensions

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.ext
import me.yohom.fluttify.model.Podspec
import me.yohom.fluttify.tmpl.dart.type.type_sdk.TypeSdkTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.common.ref.ref_ref.RefRefTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_getter.HandlerGetterTmpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import javax.xml.parsers.DocumentBuilderFactory

class StringXKtTest : FluttifyTest() {
    @Test
    fun parseSDK() {
        val irDir =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/".file()
        val sdk = irDir.parseSDK()
        println("解析结果: $sdk")
    }

    @Test
    fun parseXml() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/interface_b_m_k_map_manager.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.types()
        println("解析结果: $result")
    }

    @Test
    fun parseEnum() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/_b_m_k_types_8h.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.enums()
        println("解析结果: $result")
    }

    @Test
    fun parseStruct() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_map_fluttify/ir/ios/xml/struct_b_m_navi_status.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.types()

        println(TypeSdkTmpl(result.first()))
    }

    @Test
    fun parseNamedArg() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/interface_b_m_k_base_log.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.types()

        println("解析结果: $result")
    }

    @Test
    fun parseFinalProperty() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/interface_b_m_k_build_info.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.types()

        println("解析结果: $result")
    }

    @Test
    fun parseProtocol() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/protocol_b_m_k_general_delegate-p.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.types()

        println("解析结果: $result")
    }

    @Test
    fun parseClassMethod() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/interface_b_m_k_map_manager.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.types()

        println("解析结果: $result")
    }

    @Test
    fun parseFunctions() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/ir/ios/xml/_b_m_k_types_8h.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.topLevelFunctions()

        println("解析结果: $result")
    }

    @Test
    fun parseCategory() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_utils_fluttify/ir/ios/xml/category_n_s_value_07_b_m_k_geometry_extension_08.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.types()

        result.first().methods.map(::RefRefTmpl)

        println("解析结果: $result")
    }

    @Test
    fun parseTypedef() {
        val xmlFile =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_map_fluttify/ir/ios/xml/_b_m_k_location_manager_8h.xml".file()
        val doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(xmlFile)
        val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
        val result = doxygenRoot.typedefs()

        println("解析结果: $result")
    }

//    @Nested
//    @DisplayName("Test for genericLevel")
//    inner class GenericLevelTest : FluttifyTest() {
//        @Test
//        fun genericLevel_level_0() {
////            val level = "Abc".iterableLevel()
////            assertEquals(level, 0)
//            println("A#".split("#"))
//        }
//
//        @Test
//        fun genericLevel_level_1() {
////            val level = "List<Abc>".iterableLevel()
////            assertEquals(level, 1)
//
//            """
//                {
//                  "name": "AMapLocation",
//                  "version": "2.6.3",
//                  "summary": "AMapLocationKit for iOS.",
//                  "description": "AMapLocation SDK for iOS by Autonavi.",
//                  "homepage": "http://lbs.amap.com/api/ios-location-sdk/summary/",
//                  "license": {
//                    "type": "Copyright",
//                    "text": "Copyright © 2014 AutoNavi. All Rights Reserved.\n"
//                  },
//                  "authors": "lbs.amap.com",
//                  "social_media_url": "http://lbsbbs.amap.com/forum.php?mod=forumdisplay&fid=55",
//                  "documentation_url": "http://a.amap.com/lbs/static/unzip/iOS_Location_Doc/index.html",
//                  "source": {
//                    "http": "https://a.amap.com/lbs/static/zip/AMap_iOS_Loc_Lib_V2.6.3.zip"
//                  },
//                  "source_files": "AMapLocationKit.framework/**/*.{h}",
//                  "platforms": {
//                    "ios": "7.0"
//                  },
//                  "requires_arc": true,
//                  "xcconfig": {
//                    "ARCHS": "${'$'}(ARCHS_STANDARD)"
//                  },
//                  "public_header_files": "AMapLocationKit.framework/Headers/*.h",
//                  "vendored_frameworks": "AMapLocationKit.framework",
//                  "frameworks": [
//                    "CoreLocation",
//                    "CoreTelephony",
//                    "SystemConfiguration",
//                    "Security",
//                    "ExternalAccessory"
//                  ],
//                  "libraries": "z",
//                  "dependencies": {
//                    "AMapFoundation": [
//                      "~>1.4"
//                    ]
//                  }
//                }
//
//            """.trimIndent().fromJson<Podspec>()
//        }
//
//        @Test
//        fun genericLevel_level_2() {
//            val level = "List<List<Abc>>".iterableLevel()
//            assertEquals(level, 2)
//        }
//
//        @Test
//        fun genericLevel_wrong_format_return_0() {
//            val level = "Abc>".iterableLevel()
//            assertEquals(level, 0)
//        }
//    }
//
//    @Test
//    fun testTrim() {
//        val result = """{
//                  "exactName": "setDelegate",
//                  "returnType": "BOOL",
//                  "name": "setDelegate",
//                  "formalParams": [
//                    {
//                      "named": "",
//                      "variable": {
//                        "typeName": "id",
//                        "name": "delegate",
//                        "platform": "iOS"
//                      },
//                      "platform": "iOS"
//                    }
//                  ],
//                  "isStatic": false,
//                  "isPublic": true,
//                  "className": "BDSEventManager",
//                  "platform": "iOS",
//                  "isDeprecated": false,
//                  "isFunction": false,
//                  "isGenericMethod": false
//                }""".replace(Regex("\\s*|\t|\r|\n"), "")
//        println(result)
//    }
//
//    @Nested
//    @DisplayName("Test for underscore2Camel")
//    inner class Underscore2CamelTest : FluttifyTest() {
//        @Test
//        fun underscore2Camel_normal() {
//            val result = "under_score_name".underscore2Camel()
//            assertEquals(result, "UnderScoreName")
//        }
//
//        @Test
//        fun underscore2Camel_start_with_underscore() {
//            val result = "__under_score_name".underscore2Camel()
//            assertEquals(result, "UnderScoreName")
//        }
//
//        @Test
//        fun underscore2Camel_end_with_underscore() {
//            val result = "under_score_name__".underscore2Camel()
//            assertEquals(result, "UnderScoreName")
//        }
//
//        @Test
//        fun underscore2Camel_around_with_underscore() {
//            val result = "____under_score_name__".underscore2Camel()
//            assertEquals(result, "UnderScoreName")
//        }
//    }
//
//    @Nested
//    @DisplayName("Test for camel2Underscore")
//    inner class Camel2UnderscoreTest : FluttifyTest() {
//        @Test
//        fun camel2Underscore_normal() {
//            val underscoreString = "ACamelString".camel2Underscore()
//            assertEquals(underscoreString, "a_camel_string")
//        }
//
//        @Test
//        fun camel2Underscore_empty() {
//            val underscoreString = "".camel2Underscore()
//            assertEquals(underscoreString, "")
//        }
//    }
//
//    @Nested
//    @DisplayName("Test for toDartType")
//    inner class ToDartTypeTest : FluttifyTest() {
//        @Test
//        fun toDartType_non_jsonable_generic_should_as_container_type() {
//            val result = "java.util.Collection<java.lang.Object>".toDartType()
//            println(result)
//        }
//    }
//
//    @Nested
//    @DisplayName("Test for genericType")
//    inner class GenericTypeTest : FluttifyTest() {
//        @Test
//        fun genericType_normal_class_should_as_itself() {
//            val result = "Abc".genericTypes()
//            assertEquals(result, "Abc")
//        }
//
//        @Test
//        fun genericType_level1() {
//            val result = "List<Abc>".genericTypes()
//            assertEquals(result, "Abc")
//        }
//
//        @Test
//        fun genericType_level2() {
//            val result = "List<List<Abc>>".genericTypes()
//            assertEquals(result, "Abc")
//        }
//    }
//
//    @Nested
//    @DisplayName("Test for isObfuscated")
//    inner class IsObfuscatedTest : FluttifyTest() {
//        @Test
//        fun isObfuscated_non_obfuscated() {
//            assertFalse("com.amap.api.mapcore.util.test".isObfuscated())
//        }
//
//        @Test
//        fun isObfuscated_com_tencent_lbssearch_object_param() {
//            println("com.tencent.lbssearch.object.param.SearchParam\$a".isObfuscated())
//        }
//
//        @Test
//        fun isObfuscated_obfuscated() {
//            assertTrue("com.google.android.gms.common.internal.GmsClientSupervisor\$zza".isObfuscated())
//        }
//    }
//
//    @Nested
//    @DisplayName("Test for isArray")
//    inner class IsArrayTest : FluttifyTest() {
//        @Test
//        fun isArray_java_array() {
//            assertTrue("String[]".isRefArray())
//        }
//    }
//
//    @Test
//    fun replaceMarco() {
//        val source = """
//#if TARGET_OS_IPHONE
///**
// * 8.1 启动屏幕分享（iOS）
// *
// * iPhone 屏幕分享的推荐配置参数：
// * - 分辨率(videoResolution): 1280 x 720
// * - 帧率(videoFps): 10 FPS
// * - 码率(videoBitrate): 1600 kbps
// * - 分辨率自适应(enableAdjustRes): NO
// *
// * @param encParams 设置屏幕分享时的编码参数，推荐采用上述推荐配置，如果您指定 encParams 为 nil，则使用您调用 startScreenCapture 之前的编码参数设置。
// */
//- (void)startScreenCapture:(TRTCVideoEncParam *)encParams API_AVAILABLE(ios(13.0));
//
//#elif TARGET_OS_MAC
//
///**
// * 8.1 启动屏幕分享（Mac）
// *
// * @param view 渲染控件所在的父控件，可以设置为 nil，表示不显示屏幕分享的预览效果。
// * @param streamType 屏幕分享使用的线路，可以设置为主路（TRTCVideoStreamTypeBig）或者辅路（TRTCVideoStreamTypeSub），默认使用辅路。
// * @param encParam 屏幕分享的画面编码参数，可以设置为 nil，表示让 SDK 选择最佳的编码参数（分辨率、码率等）。
// *
// * @note 一个用户同时最多只能上传一条主路（TRTCVideoStreamTypeBig）画面和一条辅路（TRTCVideoStreamTypeSub）画面，
// * 默认情况下，屏幕分享使用辅路画面，如果使用主路画面，建议您提前停止摄像头采集（stopLocalPreview）避免相互冲突。
// */
//- (void)startScreenCapture:(NSView *)view streamType:(TRTCVideoStreamType)streamType encParam:(TRTCVideoEncParam *)encParam;
//#endif
//"""
//        ext.ios.exclude.macros = listOf("TENCENTLBS_DEBUG")
//        val source2 = """
//            #if TENCENTLBS_DEBUG
//            + (void)upLoadData;
//            + (NSData *)getLocationLog;
//            + (void)newLocationLog;
//            #endif
//        """.trimIndent()
//        println(source2.replaceMacro())
//    }
}