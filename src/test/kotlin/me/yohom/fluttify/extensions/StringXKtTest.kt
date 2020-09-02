package me.yohom.fluttify.extensions

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.model.Podspec
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class StringXKtTest : FluttifyTest() {

    @Nested
    @DisplayName("Test for genericLevel")
    inner class GenericLevelTest : FluttifyTest() {
        @Test
        fun genericLevel_level_0() {
//            val level = "Abc".iterableLevel()
//            assertEquals(level, 0)
            println("A#".split("#"))
        }

        @Test
        fun genericLevel_level_1() {
//            val level = "List<Abc>".iterableLevel()
//            assertEquals(level, 1)

            """
                {
                  "name": "AMapLocation",
                  "version": "2.6.3",
                  "summary": "AMapLocationKit for iOS.",
                  "description": "AMapLocation SDK for iOS by Autonavi.",
                  "homepage": "http://lbs.amap.com/api/ios-location-sdk/summary/",
                  "license": {
                    "type": "Copyright",
                    "text": "Copyright © 2014 AutoNavi. All Rights Reserved.\n"
                  },
                  "authors": "lbs.amap.com",
                  "social_media_url": "http://lbsbbs.amap.com/forum.php?mod=forumdisplay&fid=55",
                  "documentation_url": "http://a.amap.com/lbs/static/unzip/iOS_Location_Doc/index.html",
                  "source": {
                    "http": "https://a.amap.com/lbs/static/zip/AMap_iOS_Loc_Lib_V2.6.3.zip"
                  },
                  "source_files": "AMapLocationKit.framework/**/*.{h}",
                  "platforms": {
                    "ios": "7.0"
                  },
                  "requires_arc": true,
                  "xcconfig": {
                    "ARCHS": "${'$'}(ARCHS_STANDARD)"
                  },
                  "public_header_files": "AMapLocationKit.framework/Headers/*.h",
                  "vendored_frameworks": "AMapLocationKit.framework",
                  "frameworks": [
                    "CoreLocation",
                    "CoreTelephony",
                    "SystemConfiguration",
                    "Security",
                    "ExternalAccessory"
                  ],
                  "libraries": "z",
                  "dependencies": {
                    "AMapFoundation": [
                      "~>1.4"
                    ]
                  }
                }

            """.trimIndent().fromJson<Podspec>()
        }

        @Test
        fun genericLevel_level_2() {
            val level = "List<List<Abc>>".iterableLevel()
            assertEquals(level, 2)
        }

        @Test
        fun genericLevel_wrong_format_return_0() {
            val level = "Abc>".iterableLevel()
            assertEquals(level, 0)
        }
    }

    @Test
    fun testTrim() {
        val result = """{
                  "exactName": "setDelegate",
                  "returnType": "BOOL",
                  "name": "setDelegate",
                  "formalParams": [
                    {
                      "named": "",
                      "variable": {
                        "typeName": "id",
                        "name": "delegate",
                        "platform": "iOS"
                      },
                      "platform": "iOS"
                    }
                  ],
                  "isStatic": false,
                  "isPublic": true,
                  "className": "BDSEventManager",
                  "platform": "iOS",
                  "isDeprecated": false,
                  "isFunction": false,
                  "isGenericMethod": false
                }""".replace(Regex("\\s*|\t|\r|\n"), "")
        println(result)
    }

    @Nested
    @DisplayName("Test for underscore2Camel")
    inner class Underscore2CamelTest : FluttifyTest() {
        @Test
        fun underscore2Camel_normal() {
            val result = "under_score_name".underscore2Camel()
            assertEquals(result, "UnderScoreName")
        }

        @Test
        fun underscore2Camel_start_with_underscore() {
            val result = "__under_score_name".underscore2Camel()
            assertEquals(result, "UnderScoreName")
        }

        @Test
        fun underscore2Camel_end_with_underscore() {
            val result = "under_score_name__".underscore2Camel()
            assertEquals(result, "UnderScoreName")
        }

        @Test
        fun underscore2Camel_around_with_underscore() {
            val result = "____under_score_name__".underscore2Camel()
            assertEquals(result, "UnderScoreName")
        }
    }

    @Nested
    @DisplayName("Test for camel2Underscore")
    inner class Camel2UnderscoreTest : FluttifyTest() {
        @Test
        fun camel2Underscore_normal() {
            val underscoreString = "ACamelString".camel2Underscore()
            assertEquals(underscoreString, "a_camel_string")
        }

        @Test
        fun camel2Underscore_empty() {
            val underscoreString = "".camel2Underscore()
            assertEquals(underscoreString, "")
        }
    }

    @Nested
    @DisplayName("Test for toDartType")
    inner class ToDartTypeTest : FluttifyTest() {
        @Test
        fun toDartType_non_jsonable_generic_should_as_container_type() {
            val result = "android_util_Pair<Integer,com_amap_api_maps_model_LatLng>".toDartType()
            assertEquals(result, "android_util_Pair")
        }
    }

    @Nested
    @DisplayName("Test for genericType")
    inner class GenericTypeTest : FluttifyTest() {
        @Test
        fun genericType_normal_class_should_as_itself() {
            val result = "Abc".genericTypes()
            assertEquals(result, "Abc")
        }

        @Test
        fun genericType_level1() {
            val result = "List<Abc>".genericTypes()
            assertEquals(result, "Abc")
        }

        @Test
        fun genericType_level2() {
            val result = "List<List<Abc>>".genericTypes()
            assertEquals(result, "Abc")
        }
    }

    @Nested
    @DisplayName("Test for isObfuscated")
    inner class IsObfuscatedTest : FluttifyTest() {
        @Test
        fun isObfuscated_non_obfuscated() {
            assertFalse("com.amap.api.mapcore.util.test".isObfuscated())
        }

        @Test
        fun isObfuscated_com_tencent_lbssearch_object_param() {
            println("com.tencent.lbssearch.object.param.SearchParam\$a".isObfuscated())
        }

        @Test
        fun isObfuscated_obfuscated() {
            assertTrue("com.google.android.gms.common.internal.GmsClientSupervisor\$zza".isObfuscated())
        }
    }

    @Nested
    @DisplayName("Test for isArray")
    inner class IsArrayTest : FluttifyTest() {
        @Test
        fun isArray_java_array() {
            assertTrue("String[]".isArray())
        }
    }
}