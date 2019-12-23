package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.extensions.*
import org.junit.Test
import org.zeroturnaround.zip.ZipUtil
import java.io.File

class FileXKtTest {

    @Test
    fun javaType() {
    }

    @Test
    fun objcType() {
//        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/library/ios/BaiduMapAPI_Map.framework/Headers/BMKOfflineMapType.h".file()
//        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/library/ios/BaiduMapAPI_Map.framework/Headers/BMKMapView.h".file()
//        val file = "/Users/yohom/Github/Me/All/fluttify/amap_location_fluttify/output-project/amap_location_fluttify/ios/AMapLocationKit.framework/Headers/AMapLocationManager.h".file()
        val dir =
            "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/sdk/ios/BaiduMapAPI_Base.framework/Headers/".file()
        dir
            .listFiles()
            ?.forEach {
                println(it.objcType())
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
            val archiveFile = "/Users/yohom/Github/Me/All/fluttify/amap/amap_location_fluttify/sdk/ios/ARCHIVE.zip".file()
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
}