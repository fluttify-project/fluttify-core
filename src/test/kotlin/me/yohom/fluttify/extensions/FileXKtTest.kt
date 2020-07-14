package me.yohom.fluttify.extensions

import me.yohom.fluttify.EaseMob
import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.model.*
import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Test
import org.zeroturnaround.zip.ZipUtil
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener
import java.io.File

class FileXKtTest : FluttifyTest() {

    @Test
    fun moveFile() {
        val libDir = "/Users/yohom/Github/Me/All/fluttify/3rd_party/tencent_live/sdk/ios/".file()
        val framework =
            "/Users/yohom/Github/Me/All/fluttify/3rd_party/tencent_live/sdk/ios/TXLiteAVSDK_Smart/SDK/TXLiteAVSDK_Smart.framework/".file()
        FileUtils.copyDirectoryToDirectory(framework, libDir)
    }

    @Test
    fun objcType() {
//        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/library/ios/BaiduMapAPI_Map.framework/Headers/BMKOfflineMapType.h".file()
//        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/library/ios/BaiduMapAPI_Map.framework/Headers/BMKMapView.h".file()
//        val file = "/Users/yohom/Github/Me/All/fluttify/amap_location_fluttify/output-project/amap_location_fluttify/ios/AMapLocationKit.framework/Headers/AMapLocationManager.h".file()
//        val dir =
//            "/Users/yohom/Github/Me/All/fluttify/3rd_party/baidu_asr/sdk/ios/BDSEventManager.h".file()
//        println(dir.objcType())

        "/Users/yohom/Github/Me/All/fluttify/amap/amap_map_fluttify/output-project/amap_map_fluttify/android/src/main/java/me/yohom/amap_map_fluttify/".file()
            .iterate("java") {
                println("文件路径: ${it.path}")
                if (!it.path.contains("sub_handler/custom")) {
                    it.delete()
                }
            }
    }

    @Test
    fun downloadIOSSDK() {
        val testCoordinates = "'AMapLocation', '2.6.3'"

        var iosArchiveSpec: File? = null

        val specDir = "${System.getProperty("user.home")}/.cocoapods/repos/master/Specs/".file()
        val archiveName = testCoordinates.split(",").map { it.stripQuotes().trim() }[0]
        val archiveVersion = try {
            testCoordinates.split(",").map { it.stripQuotes().trim() }[1]
        } catch (e: Exception) {
            ""
        }.removePrefix("~>").trim()
        // 找出目标pod所在的文件
        val l0Files = specDir.listFiles()
        out@ for (i in 0..0xf) {
            val l0 = l0Files?.get(i)
            val l1Files = l0?.listFiles()
            for (j in 0..0xf) {
                val l1 = l1Files?.get(j)
                val l2Files = l1?.listFiles()
                for (k in 0..0xf) {
                    val l2 = l2Files?.get(k)
                    for (l3 in l2?.listFiles() ?: arrayOf()) {
                        if (l3.name == archiveName) {
                            iosArchiveSpec = l3
                            break@out
                        }
                    }
                }
            }
        }

        println("iosArchiveSpec: $iosArchiveSpec")

        val targetVersion: File? = iosArchiveSpec?.listFiles()?.firstOrNull { it.name.contains(archiveVersion) }
        println("targetVersion: $targetVersion")
        targetVersion?.run {
            val podspecJson = File("$this/$archiveName.podspec.json").readText().fromJson<Map<String, Any>>()
            val source: Map<String, String> = podspecJson["source"] as Map<String, String>
            val archiveFile =
                "/Users/yohom/Github/Me/All/fluttify/amap/amap_location_fluttify/sdk/ios/ARCHIVE.zip".file()
            source["http"]?.run { archiveFile.downloadFrom(this) }
            // 下载完成后解压
            ZipUtil.unpack(archiveFile, archiveFile.parentFile)
            // 删除压缩文件
            archiveFile.delete()
        }
    }

    @Test
    fun downloadAndroidSDK() {
        val androidArchiveDir = "/Users/yohom/Github/Me/All/fluttify/amap/amap_map_fluttify/sdk/android/".file()
        androidArchiveDir.run {
            if (list()?.isEmpty() != false) {
                val coord = "com.amap.api:3dmap:6.9.2".split(":")
                val org = coord[0].replace(".", "/")
                val repo = coord[1]
                val version = coord[2]
                try {
                    "$androidArchiveDir/$repo-$version.jar".file()
                        .downloadFrom("https://jcenter.bintray.com/$org/$repo/$version/$repo-$version.jar")
                } catch (e: Exception) {
                    "$androidArchiveDir/$repo-$version.aar".file()
                        .downloadFrom("https://jcenter.bintray.com/$org/$repo/$version/$repo-$version.aar")
                }
            }
        }
    }

    @Test
    fun functionSig() {
        val text =
            """
                UIKIT_STATIC_INLINE BMKCoordinateSpan BMKCoordinateSpanMake(CLLocationDegrees latitudeDelta, CLLocationDegrees longitudeDelta) {
                    BMKCoordinateSpan span;
                    span.latitudeDelta = latitudeDelta;
                    span.longitudeDelta = longitudeDelta;
                    return span;
                }
            """.trimIndent()
        text.walkTree(object : ObjectiveCParserBaseListener() {
            override fun enterFunctionSignature(ctx: ObjectiveCParser.FunctionSignatureContext) {
                val returnType = ctx
                    .declarationSpecifiers()
                    .typeSpecifier()
                    .last()
                    ?.text
                val typeName = ctx
                    .identifier()
                    ?.text
                val formalParams = ctx
                    .parameterList()
                    ?.parameterDeclarationList()
                    ?.parameterDeclaration()
                    ?.takeIf { it.all { it.declarationSpecifiers() != null && it.declarator() != null } }
                    ?.map {
                        Parameter(
                            variable = Variable(
                                typeName = (it.declarationSpecifiers()?.text ?: it.VOID().text).run {
                                    if (it.declarator()?.text?.startsWith("*") == true) enpointer() else this
                                },
                                platform = Platform.iOS,
                                name = (it.declarator()?.text ?: it.VOID().text).depointer()
                            ),
                            platform = Platform.iOS
                        )
                    }
            }
        })
    }

    @Test
    fun typedefTest() {
        val text =
            "typedef void(^NIMChatroomQueueInfoHandler)(NSError * __nullable error, NSArray<NSDictionary<NSString*, NSString*>*>* __nullable info);"
        text.walkTree(object : ObjectiveCParserBaseListener() {
            override fun enterTypedefDeclaration(ctx: ObjectiveCParser.TypedefDeclarationContext) {
                val returnType = ctx
                    .declarationSpecifiers()
                    .typeSpecifier()[0]
                    ?.text
                val typeName = ctx
                    .typeDeclaratorList()
                    .typeDeclarator()[0]
                    ?.directDeclarator()
                    ?.identifier()
                    ?.text
                val formalParams = ctx
                    .typeDeclaratorList()
                    .typeDeclarator()[0]
                    ?.directDeclarator()
                    ?.blockParameters()
                    ?.typeVariableDeclaratorOrName()
                    ?.mapNotNull { it.typeVariableDeclarator() }
                    ?.map {
                        val argName = it.declarator().text.objcSpecifierExpand()
                        val argType = it.declarationSpecifiers()
                            .text
                            .run { if (argName.startsWith("*")) enpointer() else this }
                        Parameter(
                            variable = Variable(
                                argType,
                                argName.depointer(),
                                Platform.iOS
                            ),
                            platform = Platform.iOS
                        )
                    }

                if (returnType != null && typeName != null) {
                    // lambda
                    if (formalParams != null) {
                        Type().also {
                            it.typeType = TypeType.Lambda
                            it.isPublic = true
                            it.isAbstract = false
                            it.name = typeName
                            it.isStaticType = true
                            it.returnType = returnType
                            it.formalParams = formalParams
                            it.platform = Platform.iOS
                        }
                    }
                    // 结构体
                    else if (returnType.contains("struct")) {
                    }
                    // 别名不包含^, 说明不是函数别名
                    else if (!typeName.contains("^")) {
                        Type().also {
                            it.typeType = TypeType.Alias
                            it.isPublic = true
                            it.isAbstract = false
                            it.name = typeName
                            it.isStaticType = true
                            it.aliasOf = returnType
                            it.platform = Platform.iOS
                        }
                    }
                }
            }
        })
    }

    @Test
    fun enumTest() {
        val text =
            """
                typedef NS_OPTIONS(NSUInteger, AMapGeoFenceActiveAction)
                {
                    AMapGeoFenceActiveActionNone     = 0,       ///< 不进行监听
                    AMapGeoFenceActiveActionInside   = 1 << 0,  ///< 在范围内
                    AMapGeoFenceActiveActionOutside  = 1 << 1,  ///< 在范围外
                    AMapGeoFenceActiveActionStayed   = 1 << 2,  ///< 停留(在范围内超过10分钟)
                };
            """.trimIndent()
        text.walkTree(object : ObjectiveCParserBaseListener() {
            override fun enterEnumerator(ctx: ObjectiveCParser.EnumeratorContext) {
                val enumName = ctx.enumeratorIdentifier().identifier().text
                val enumValue = ctx.expression()?.text
            }
        })
    }

    @Test
    fun constructable() {
        EaseMob.androidSDK
            .allTypes
            .find { it.name == "com.hyphenate.chat.adapter.EMARHttpCallback" }
            ?.run {
                println(constructable)
            }
    }
}