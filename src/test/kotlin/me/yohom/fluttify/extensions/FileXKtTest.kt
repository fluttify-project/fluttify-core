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

//    @Test
//    fun typeTest() {
//        val text = "package com.cmcm.cmgame.activity;\n" +
//                "\n" +
//                "import android.animation.ValueAnimator;\n" +
//                "import android.app.Activity;\n" +
//                "import android.content.BroadcastReceiver;\n" +
//                "import android.content.Context;\n" +
//                "import android.content.Intent;\n" +
//                "import android.content.IntentFilter;\n" +
//                "import android.os.Bundle;\n" +
//                "import android.os.Handler;\n" +
//                "import android.os.Looper;\n" +
//                "import android.text.TextUtils;\n" +
//                "import android.util.Log;\n" +
//                "import android.view.KeyEvent;\n" +
//                "import android.view.View;\n" +
//                "import android.view.ViewGroup;\n" +
//                "import android.view.animation.AccelerateDecelerateInterpolator;\n" +
//                "import android.view.animation.AccelerateInterpolator;\n" +
//                "import android.widget.FrameLayout;\n" +
//                "import android.widget.ImageView;\n" +
//                "import android.widget.LinearLayout;\n" +
//                "import android.widget.ProgressBar;\n" +
//                "import android.widget.RelativeLayout;\n" +
//                "import android.widget.TextView;\n" +
//                "import android.widget.RelativeLayout.LayoutParams;\n" +
//                "import androidx.annotation.Nullable;\n" +
//                "import androidx.localbroadcastmanager.content.LocalBroadcastManager;\n" +
//                "import com.cmcm.cmgame.CmGameSdk;\n" +
//                "import com.cmcm.cmgame.IResultCallBack;\n" +
//                "import com.cmcm.cmgame.R.id;\n" +
//                "import com.cmcm.cmgame.R.layout;\n" +
//                "import com.cmcm.cmgame.ad.if.byte;\n" +
//                "import com.cmcm.cmgame.common.view.GameMoveView;\n" +
//                "import com.cmcm.cmgame.gamedata.bean.GameInfo;\n" +
//                "import com.cmcm.cmgame.gamedata.bean.H5Extend;\n" +
//                "import com.cmcm.cmgame.membership.MembershipGameJsForGame;\n" +
//                "import com.cmcm.cmgame.membership.bean.MemberInfoRes;\n" +
//                "import com.cmcm.cmgame.misc.GameStateSender;\n" +
//                "import com.cmcm.cmgame.report.do\$do;\n" +
//                "import com.cmcm.cmgame.report.gamemoneysdk_sdk_ad_action;\n" +
//                "import com.cmcm.cmgame.report.goto;\n" +
//                "import com.cmcm.cmgame.utils.PreferencesUtils;\n" +
//                "import com.cmcm.cmgame.utils.X5Helper;\n" +
//                "import com.cmcm.cmgame.utils.break;\n" +
//                "import com.cmcm.cmgame.utils.break\$if;\n" +
//                "import com.cmcm.cmgame.utils.else;\n" +
//                "import com.cmcm.cmgame.utils.this;\n" +
//                "import com.cmcm.cmgame.view.CmGameTopView;\n" +
//                "import java.util.ArrayList;\n" +
//                "\n" +
//                "public class H5GameActivity extends BaseH5GameActivity {\n" +
//                "   public static final String ACTION_REMOVE_AD_SUCCESS = \"action_remove_ad_success\";\n" +
//                "   public static final String EXT_GIVE_REWARD = \"ext_give_reward\";\n" +
//                "   private ProgressBar float;\n" +
//                "   private RelativeLayout short;\n" +
//                "   private TextView super;\n" +
//                "   private ImageView throw;\n" +
//                "   private boolean while = false;\n" +
//                "   private static boolean double = false;\n" +
//                "   private static String import;\n" +
//                "   private static GameInfo native;\n" +
//                "   private boolean public = false;\n" +
//                "   private boolean return = false;\n" +
//                "   private boolean static = false;\n" +
//                "   private boolean switch = false;\n" +
//                "   private LinearLayout throws;\n" +
//                "   private ValueAnimator boolean;\n" +
//                "   private H5GameActivity\$do default;\n" +
//                "   private boolean extends = false;\n" +
//                "   private break finally;\n" +
//                "   private boolean package = false;\n" +
//                "   private boolean private = false;\n" +
//                "   private BroadcastReceiver abstract;\n" +
//                "   private boolean continue = false;\n" +
//                "   private boolean strictfp = false;\n" +
//                "   private boolean volatile = false;\n" +
//                "   private int interface = 0;\n" +
//                "   private GameMoveView protected;\n" +
//                "   private CmGameTopView transient;\n" +
//                "   private View instanceof;\n" +
//                "   private String synchronized;\n" +
//                "   private ArrayList<String> a;\n" +
//                "   private com.cmcm.cmgame.ad.if.new b;\n" +
//                "   private do\$do c;\n" +
//                "   private com.cmcm.cmgame.ad.for d;\n" +
//                "   private static boolean e = false;\n" +
//                "   private BroadcastReceiver f = new H5GameActivity\$11(this);\n" +
//                "\n" +
//                "   public H5GameActivity() {\n" +
//                "   }\n" +
//                "\n" +
//                "   static void do(GameInfo var0) {\n" +
//                "      if (var0 != null) {\n" +
//                "         String var1 = null;\n" +
//                "         if (var0.getH5Extend() != null) {\n" +
//                "            var1 = var0.getH5Extend().getRewardVideoID();\n" +
//                "         }\n" +
//                "\n" +
//                "         if (TextUtils.isEmpty(var1)) {\n" +
//                "            import = com.cmcm.cmgame.gamedata.if.if();\n" +
//                "         } else {\n" +
//                "            import = var1;\n" +
//                "         }\n" +
//                "\n" +
//                "         if (var0.getH5Extend() != null) {\n" +
//                "            double = var0.getH5Extend().isLandscapeGame();\n" +
//                "         }\n" +
//                "\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   public static void show(Context var0, GameInfo var1, do\$do var2) {\n" +
//                "      if (var0 == null) {\n" +
//                "         com.cmcm.cmgame.common.for.for.int(\"gamesdk_h5gamepage\", \"show context is null\");\n" +
//                "      } else if (var1 != null && var1.getH5Game() != null && !TextUtils.isEmpty(var1.getH5Game().getH5_game_url())) {\n" +
//                "         com.cmcm.cmgame.ad.if.byte.do(var0, var1, var2);\n" +
//                "      } else {\n" +
//                "         com.cmcm.cmgame.common.for.for.int(\"gamesdk_h5gamepage\", \"show gameInfo is null\");\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   public static void showGameWithGameInfo(Context var0, GameInfo var1, @Nullable do\$do var2) {\n" +
//                "      if (var1 != null && var1.getH5Game() != null) {\n" +
//                "         String var3;\n" +
//                "         if (var1.isBQGame()) {\n" +
//                "            var3 = var1.getH5Game().getPkg_ver();\n" +
//                "         } else {\n" +
//                "            var3 = var1.getH5Game().getH5_game_ver();\n" +
//                "         }\n" +
//                "\n" +
//                "         native = var1;\n" +
//                "         do(var1);\n" +
//                "         if (null != com.cmcm.cmgame.utils.for.char()) {\n" +
//                "            com.cmcm.cmgame.utils.for.char().gameClickCallback(var1.getName(), var1.getGameId());\n" +
//                "         }\n" +
//                "\n" +
//                "         LoadCostReporter.getInstance().initGameInfo(var1.getName(), var1.getH5Game().getH5_game_ver(), var1.getH5Game().getH5_game_url(), X5Helper.isNeedInitX5());\n" +
//                "\n" +
//                "         try {\n" +
//                "            H5Extend var5 = var1.getH5Extend();\n" +
//                "            Intent var4;\n" +
//                "            if (var5 != null && var5.isLandscapeGame()) {\n" +
//                "               var4 = new Intent(var0, H5GameLandscapeActivity.class);\n" +
//                "            } else {\n" +
//                "               var4 = new Intent(var0, H5GameActivity.class);\n" +
//                "            }\n" +
//                "\n" +
//                "            var4.putExtra(\"ext_url\", var1.getH5Game().getH5_game_url());\n" +
//                "            if (!(var0 instanceof Activity)) {\n" +
//                "               var4.setFlags(268435456);\n" +
//                "            }\n" +
//                "\n" +
//                "            var4.putExtra(\"ext_icon\", var1.getIconUrlSquare());\n" +
//                "            var4.putExtra(\"ext_slogan\", var1.getSlogan());\n" +
//                "            var4.putExtra(\"ext_game_loading_img\", var1.getH5Game().getGameLoadingImg());\n" +
//                "            var4.putExtra(\"ext_name\", var1.getName());\n" +
//                "            var4.putExtra(\"ext_game_id\", var1.getGameId());\n" +
//                "            var4.putExtra(\"ext_game_id_server\", var1.getGameIdServer());\n" +
//                "            var4.putExtra(\"ext_h5_game_version\", var3);\n" +
//                "            var4.putExtra(\"game_category_type\", var1.getGameType());\n" +
//                "            var4.putExtra(\"haveSetState\", var1.isHaveSetState());\n" +
//                "            var4.putStringArrayListExtra(\"ext_type_tags\", var1.getTypeTagList());\n" +
//                "            if (var5 != null) {\n" +
//                "               var4.putExtra(\"ext_menu_style\", var5.getMenuStyle());\n" +
//                "            }\n" +
//                "\n" +
//                "            if (var2 != null) {\n" +
//                "               var4.putExtra(\"ext_game_report_bean\", var2);\n" +
//                "            }\n" +
//                "\n" +
//                "            var0.startActivity(var4);\n" +
//                "         } catch (Exception var6) {\n" +
//                "            Log.e(\"TAG\", \"context\", var6);\n" +
//                "         }\n" +
//                "\n" +
//                "      } else {\n" +
//                "         com.cmcm.cmgame.common.for.for.if(\"gamesdk_h5gamepage\", \"showGameWithGameInfo parameter is illegal\");\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   public int getContentViewRsId() {\n" +
//                "      return layout.cmgame_sdk_activity_h5_game_layout;\n" +
//                "   }\n" +
//                "\n" +
//                "   public void init() {\n" +
//                "      super.init();\n" +
//                "      Intent var1 = this.getIntent();\n" +
//                "      if (var1 != null) {\n" +
//                "         this.do(var1);\n" +
//                "         this.break();\n" +
//                "         com.cmcm.cmgame.do.do().do(this.else, this.long);\n" +
//                "         (new goto()).do(this.try, this.new, 3, (short)0, (short)0, 0);\n" +
//                "         this.extends = false;\n" +
//                "         this.default = new H5GameActivity\$do(this);\n" +
//                "         this.this();\n" +
//                "         this.transient = CmGameSdk.getMoveView();\n" +
//                "         if (this.transient != null) {\n" +
//                "            this.implements = this.transient.getScreenCallback();\n" +
//                "         }\n" +
//                "\n" +
//                "         this.goto();\n" +
//                "      } else {\n" +
//                "         this.finish();\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   private void do(Intent var1) {\n" +
//                "      this.else = var1.getStringExtra(\"ext_url\");\n" +
//                "      this.try = var1.getStringExtra(\"ext_name\");\n" +
//                "      this.synchronized = var1.getStringExtra(\"ext_game_loading_img\");\n" +
//                "      this.long = var1.getStringExtra(\"ext_game_id\");\n" +
//                "      this.byte = var1.getStringExtra(\"ext_h5_game_version\");\n" +
//                "      this.case = var1.getBooleanExtra(\"haveSetState\", false);\n" +
//                "      this.a = var1.getStringArrayListExtra(\"ext_type_tags\");\n" +
//                "      if (var1.hasExtra(\"ext_game_report_bean\")) {\n" +
//                "         this.c = (do\$do)var1.getParcelableExtra(\"ext_game_report_bean\");\n" +
//                "      }\n" +
//                "\n" +
//                "      if (var1.hasExtra(\"ext_menu_style\")) {\n" +
//                "         this.char = var1.getStringExtra(\"ext_menu_style\");\n" +
//                "      }\n" +
//                "\n" +
//                "      com.cmcm.cmgame.try.int.do(\"game_exit_page\", this.long);\n" +
//                "      if (this.byte == null) {\n" +
//                "         this.byte = \"\";\n" +
//                "      }\n" +
//                "\n" +
//                "      this.new = var1.getStringExtra(\"game_category_type\");\n" +
//                "   }\n" +
//                "\n" +
//                "   private void this() {\n" +
//                "      this.finally = new break(this);\n" +
//                "      this.finally.do((break\$if)(new H5GameActivity\$1(this)));\n" +
//                "      this.finally.do();\n" +
//                "   }\n" +
//                "\n" +
//                "   private void void() {\n" +
//                "      if (this.finally != null) {\n" +
//                "         this.finally.if();\n" +
//                "         this.finally = null;\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   private void break() {\n" +
//                "      if (!TextUtils.isEmpty(this.getGameId())) {\n" +
//                "         PreferencesUtils.putLong(\"startup_time_game_\" + this.getGameId(), System.currentTimeMillis());\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   public void initView() {\n" +
//                "      super.initView();\n" +
//                "      LoadCostReporter.getInstance().setX5(this.volatile);\n" +
//                "      LoadCostReporter.getInstance().report(\"start\");\n" +
//                "      if (!e) {\n" +
//                "         e = true;\n" +
//                "      }\n" +
//                "\n" +
//                "      this.short = (RelativeLayout)this.findViewById(id.cmgame_sdk_banner_container);\n" +
//                "      this.short.setVisibility(8);\n" +
//                "      this.throws = (LinearLayout)this.findViewById(id.cmgame_sdk_idLoadding);\n" +
//                "      this.instanceof = this.findViewById(id.cmgame_sdk_coverLayer);\n" +
//                "      this.float = (ProgressBar)this.findViewById(id.cmgame_sdk_loading_progressbar);\n" +
//                "      com.cmcm.cmgame.common.for.for.if(\"gamesdk_h5gamepage\", \"initView => \");\n" +
//                "      if (this.if != null && this.if.getWebView() != null) {\n" +
//                "         this.if.getWebView().setOnTouchListener(new H5GameActivity\$12(this));\n" +
//                "      }\n" +
//                "\n" +
//                "      LoadCostReporter.getInstance().report(\"init_webview\");\n" +
//                "      this.super = (TextView)this.findViewById(id.cmgame_sdk_text_game_name);\n" +
//                "      this.throw = (ImageView)this.findViewById(id.cmgame_sdk_baoqu_logo);\n" +
//                "      this.catch();\n" +
//                "      if (!TextUtils.isEmpty(this.synchronized)) {\n" +
//                "         com.cmcm.cmgame.common.if.do.do(this.do, this.synchronized, this.int);\n" +
//                "      }\n" +
//                "\n" +
//                "      this.do((Context)this, false);\n" +
//                "      this.protected = (GameMoveView)this.findViewById(id.cmgame_sdk_top_view);\n" +
//                "      if (this.transient != null) {\n" +
//                "         com.cmcm.cmgame.common.for.for.do(\"cmgame_move\", \"外部View不为空\");\n" +
//                "         this.protected.setCmGameTopView(this.transient);\n" +
//                "      } else {\n" +
//                "         com.cmcm.cmgame.common.for.for.do(\"cmgame_move\", \"外部View没有设置\");\n" +
//                "         this.protected.setVisibility(8);\n" +
//                "      }\n" +
//                "\n" +
//                "      this.float();\n" +
//                "   }\n" +
//                "\n" +
//                "   private void catch() {\n" +
//                "      if (com.cmcm.cmgame.utils.for.super()) {\n" +
//                "         this.super.setVisibility(8);\n" +
//                "         this.throw.setVisibility(0);\n" +
//                "      } else if (!TextUtils.isEmpty(this.try)) {\n" +
//                "         this.super.setVisibility(0);\n" +
//                "         this.throw.setVisibility(8);\n" +
//                "         this.super.setText(this.try);\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   protected void onNewIntent(Intent var1) {\n" +
//                "      super.onNewIntent(var1);\n" +
//                "      if (var1 != null) {\n" +
//                "         String var2 = var1.getStringExtra(\"ext_url\");\n" +
//                "         if (var2 != null && !var2.equals(this.else)) {\n" +
//                "            GameStateSender.do().if(this.getGameId());\n" +
//                "            this.do(var1);\n" +
//                "            this.break();\n" +
//                "            this.catch();\n" +
//                "            this.class();\n" +
//                "            com.cmcm.cmgame.do.do().do(this.else, this.long);\n" +
//                "            GameStateSender.do().do(this.getGameId());\n" +
//                "         }\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   private void class() {\n" +
//                "      if (!TextUtils.isEmpty(this.synchronized)) {\n" +
//                "         com.cmcm.cmgame.common.if.do.do(this.do, this.synchronized, this.int);\n" +
//                "      }\n" +
//                "\n" +
//                "      if (this.short != null) {\n" +
//                "         this.short.setVisibility(8);\n" +
//                "      }\n" +
//                "\n" +
//                "      if (this.void != null) {\n" +
//                "         if (this.void.isShowing()) {\n" +
//                "            this.void.dismiss();\n" +
//                "         }\n" +
//                "\n" +
//                "         this.void = null;\n" +
//                "      }\n" +
//                "\n" +
//                "      this.reload();\n" +
//                "      this.throw();\n" +
//                "      this.while();\n" +
//                "   }\n" +
//                "\n" +
//                "   public void onRefreshBtnClick() {\n" +
//                "      LoadCostReporter.getInstance().setRefresh(true);\n" +
//                "      LoadCostReporter.getInstance().report(\"refresh_click\");\n" +
//                "      this.do(true, true);\n" +
//                "      (new Handler(Looper.getMainLooper())).post(new H5GameActivity\$13(this));\n" +
//                "      if (this.short != null) {\n" +
//                "         this.short.setVisibility(8);\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   private void do(boolean var1, boolean var2) {\n" +
//                "      if (var1) {\n" +
//                "         this.interface = 0;\n" +
//                "         LayoutParams var3 = (LayoutParams)this.throws.getLayoutParams();\n" +
//                "         this.throws.setLayoutParams(var3);\n" +
//                "         this.throws.setVisibility(0);\n" +
//                "         this.int.setVisibility(0);\n" +
//                "         this.instanceof.setVisibility(0);\n" +
//                "         this.do(6000, false);\n" +
//                "      } else {\n" +
//                "         this.throws.setVisibility(8);\n" +
//                "         this.int.setVisibility(8);\n" +
//                "         this.instanceof.setVisibility(8);\n" +
//                "\n" +
//                "         try {\n" +
//                "            if (this.boolean != null) {\n" +
//                "               this.boolean.cancel();\n" +
//                "               this.boolean = null;\n" +
//                "            }\n" +
//                "         } catch (Exception var4) {\n" +
//                "            Log.e(\"TAG\", \"context\", var4);\n" +
//                "         }\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   private void do(int var1, boolean var2) {\n" +
//                "      this.boolean = ValueAnimator.ofInt(new int[]{this.interface, 100});\n" +
//                "      this.boolean.setDuration((long)var1);\n" +
//                "      if (var2) {\n" +
//                "         this.boolean.setInterpolator(new AccelerateInterpolator());\n" +
//                "      } else {\n" +
//                "         this.boolean.setInterpolator(new AccelerateDecelerateInterpolator());\n" +
//                "      }\n" +
//                "\n" +
//                "      this.boolean.addUpdateListener(new H5GameActivity\$14(this));\n" +
//                "      this.boolean.start();\n" +
//                "   }\n" +
//                "\n" +
//                "   public void speedupAnimation() {\n" +
//                "      if (this.boolean != null) {\n" +
//                "         if (this.boolean.isStarted() && this.boolean.isRunning()) {\n" +
//                "            this.boolean.cancel();\n" +
//                "            this.do(1000, true);\n" +
//                "         }\n" +
//                "\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   public boolean tryToEnterGame() {\n" +
//                "      if (this.isFinishing()) {\n" +
//                "         return false;\n" +
//                "      } else {\n" +
//                "         boolean var1 = true;\n" +
//                "         if (this.interface >= 100 && this.extends) {\n" +
//                "            this.do(false, false);\n" +
//                "            (new Handler(Looper.getMainLooper())).post(new H5GameActivity\$15(this));\n" +
//                "            return true;\n" +
//                "         } else {\n" +
//                "            return false;\n" +
//                "         }\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   public void reload() {\n" +
//                "      if (this.if != null) {\n" +
//                "         try {\n" +
//                "            if (this.boolean != null) {\n" +
//                "               this.boolean.cancel();\n" +
//                "               this.boolean = null;\n" +
//                "            }\n" +
//                "         } catch (Exception var2) {\n" +
//                "            Log.e(\"TAG\", \"context\", var2);\n" +
//                "         }\n" +
//                "\n" +
//                "         this.extends = false;\n" +
//                "         this.do((Context)this, true);\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   private void do(Context var1, String var2, String var3) {\n" +
//                "      (new Handler(Looper.getMainLooper())).post(new H5GameActivity\$16(this, var2, var1, var3));\n" +
//                "   }\n" +
//                "\n" +
//                "   private void do(Context var1, boolean var2) {\n" +
//                "      this.showErrorArea(false);\n" +
//                "      this.do(true, var2);\n" +
//                "      com.cmcm.cmgame.try.new.do((IResultCallBack)(new H5GameActivity\$17(this, var1)));\n" +
//                "      com.cmcm.cmgame.utils.else.do().do(this.else);\n" +
//                "   }\n" +
//                "\n" +
//                "   protected void onCreate(Bundle var1) {\n" +
//                "      if (com.cmcm.cmgame.utils.for.const()) {\n" +
//                "         this.getWindow().setFlags(128, 128);\n" +
//                "      }\n" +
//                "\n" +
//                "      this.requestWindowFeature(1);\n" +
//                "      super.onCreate(var1);\n" +
//                "      this.throw();\n" +
//                "      this.while();\n" +
//                "      this.const();\n" +
//                "      this.registerActivityLifeReceiver(this);\n" +
//                "      GameStateSender.do().do(this.getGameId());\n" +
//                "   }\n" +
//                "\n" +
//                "   private void const() {\n" +
//                "      MemberInfoRes var1 = com.cmcm.cmgame.membership.for.if();\n" +
//                "      if (var1 != null && !var1.isVip()) {\n" +
//                "         com.cmcm.cmgame.membership.int.do();\n" +
//                "         this.abstract = new H5GameActivity\$18(this);\n" +
//                "         LocalBroadcastManager.getInstance(com.cmcm.cmgame.utils.for.do()).registerReceiver(this.abstract, new IntentFilter(\"action_remove_ad_success\"));\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   protected void onResume() {\n" +
//                "      super.onResume();\n" +
//                "      this.package = true;\n" +
//                "      if (this.return) {\n" +
//                "         this.return = false;\n" +
//                "         if (this.static) {\n" +
//                "            this.static = false;\n" +
//                "            this.do((byte)29);\n" +
//                "            this.do(false);\n" +
//                "         }\n" +
//                "      }\n" +
//                "\n" +
//                "      this.new();\n" +
//                "      if (TextUtils.isEmpty(this.goto) || !this.goto.equals(this.else) || !this.switch) {\n" +
//                "         this.goto = this.else;\n" +
//                "      }\n" +
//                "\n" +
//                "      this.switch = false;\n" +
//                "      this.evaluateJavascript(\"javascript:onActivityShow()\");\n" +
//                "      MembershipGameJsForGame.notifyPageActivated(this);\n" +
//                "      if (this.strictfp) {\n" +
//                "         this.strictfp = false;\n" +
//                "         this.do(true);\n" +
//                "      }\n" +
//                "\n" +
//                "      if (this.continue) {\n" +
//                "         this.continue = false;\n" +
//                "         (new Handler(Looper.getMainLooper())).post(new H5GameActivity\$19(this));\n" +
//                "      }\n" +
//                "\n" +
//                "      this.double();\n" +
//                "   }\n" +
//                "\n" +
//                "   protected void onPause() {\n" +
//                "      super.onPause();\n" +
//                "      this.package = false;\n" +
//                "      this.evaluateJavascript(\"javascript:onActivityHide()\");\n" +
//                "      this.try();\n" +
//                "      GameStateSender.do().if();\n" +
//                "   }\n" +
//                "\n" +
//                "   public void finish() {\n" +
//                "      com.cmcm.cmgame.common.for.for.if(\"gamesdk_h5gamepage\", \"finish\");\n" +
//                "      com.cmcm.cmgame.activity.int.do().for();\n" +
//                "      com.cmcm.cmgame.do.new.do().for();\n" +
//                "      com.cmcm.cmgame.ad.do.do().char();\n" +
//                "      super.finish();\n" +
//                "      if (this.final) {\n" +
//                "         com.cmcm.cmgame.membership.for.do();\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   protected void onDestroy() {\n" +
//                "      this.package = false;\n" +
//                "\n" +
//                "      try {\n" +
//                "         if (this.boolean != null) {\n" +
//                "            this.boolean.cancel();\n" +
//                "            this.boolean = null;\n" +
//                "         }\n" +
//                "      } catch (Exception var2) {\n" +
//                "         Log.e(\"TAG\", \"context\", var2);\n" +
//                "      }\n" +
//                "\n" +
//                "      this.void();\n" +
//                "      if (this.protected != null) {\n" +
//                "         this.protected.if();\n" +
//                "      }\n" +
//                "\n" +
//                "      this.transient = null;\n" +
//                "      this.implements = null;\n" +
//                "      if (this.void != null) {\n" +
//                "         if (this.void.isShowing()) {\n" +
//                "            this.void.dismiss();\n" +
//                "         }\n" +
//                "\n" +
//                "         this.void = null;\n" +
//                "      }\n" +
//                "\n" +
//                "      if (this.b != null) {\n" +
//                "         this.b.do();\n" +
//                "      }\n" +
//                "\n" +
//                "      this.long();\n" +
//                "      this.unregisterActivityLifeReceiver(this);\n" +
//                "      com.cmcm.cmgame.utils.else.do().if();\n" +
//                "      super.onDestroy();\n" +
//                "      if (this.d != null) {\n" +
//                "         this.d.do();\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   private void final() {\n" +
//                "      com.cmcm.cmgame.common.for.for.do(\"gamesdk_h5gamepage\", \"checkRewardVideoPlay mIsRewardPlaying: \" + this.public + \" mClearTTRewardFlag: \" + this.return);\n" +
//                "      if (this.public) {\n" +
//                "         this.return = true;\n" +
//                "         this.static = com.cmcm.cmgame.ad.if.byte.do(com.cmcm.cmgame.utils.for.if(), com.cmcm.cmgame.ad.if.byte.do());\n" +
//                "         com.cmcm.cmgame.common.for.for.do(\"gamesdk_h5gamepage\", \"checkRewardVideoPlay mClearedTTRewardFlag: \" + this.static);\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   public boolean getClearTTRewardFlag() {\n" +
//                "      return this.return;\n" +
//                "   }\n" +
//                "\n" +
//                "   public void setClearTTRewardFlag(boolean var1) {\n" +
//                "      this.return = var1;\n" +
//                "   }\n" +
//                "\n" +
//                "   private void float() {\n" +
//                "      ViewGroup var1 = (ViewGroup)this.findViewById(id.cmgame_sdk_image_ad_root);\n" +
//                "      com.cmcm.cmgame.ad.do.do().do(this, native, this.short, var1);\n" +
//                "      com.cmcm.cmgame.do.new.do().if();\n" +
//                "   }\n" +
//                "\n" +
//                "   public boolean showRewardAd() {\n" +
//                "      boolean var1 = com.cmcm.cmgame.ad.do.do().do(new H5GameActivity\$2(this));\n" +
//                "      if (var1) {\n" +
//                "         this.switch = true;\n" +
//                "         this.public = true;\n" +
//                "         if (this.c != null) {\n" +
//                "            com.cmcm.cmgame.report.do.do().do(this.long, this.a, this.c.do, this.c.if, this.c.for, this.c.int, this.c.new);\n" +
//                "         }\n" +
//                "      }\n" +
//                "\n" +
//                "      return var1;\n" +
//                "   }\n" +
//                "\n" +
//                "   public void loadRewardAd() {\n" +
//                "      com.cmcm.cmgame.ad.do.do().if();\n" +
//                "   }\n" +
//                "\n" +
//                "   private void do(boolean var1) {\n" +
//                "      if (var1) {\n" +
//                "         this.evaluateJavascript(\"javascript:onAdShowSuccess()\");\n" +
//                "      } else {\n" +
//                "         this.evaluateJavascript(\"javascript:onAdShowFailed()\");\n" +
//                "         com.cmcm.cmgame.common.for.for.if(\"gamesdk_h5gamepage\", \"adBackToGame not have completed\");\n" +
//                "      }\n" +
//                "\n" +
//                "      this.public = false;\n" +
//                "   }\n" +
//                "\n" +
//                "   private void do(byte var1) {\n" +
//                "      (new gamemoneysdk_sdk_ad_action()).doReportEx(this.try, import, \"\", var1, \"游戏激励视频\", this.try, \"激励视频\", \"穿山甲\");\n" +
//                "   }\n" +
//                "\n" +
//                "   public void setGameName(String var1) {\n" +
//                "      if (!this.package && !this.private) {\n" +
//                "         this.runOnUiThread(new H5GameActivity\$3(this));\n" +
//                "      }\n" +
//                "\n" +
//                "      this.private = true;\n" +
//                "   }\n" +
//                "\n" +
//                "   public void mute() {\n" +
//                "      if (com.cmcm.cmgame.utils.for.class()) {\n" +
//                "         this.runOnUiThread(new H5GameActivity\$4(this));\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   private boolean short() {\n" +
//                "      return this.while;\n" +
//                "   }\n" +
//                "\n" +
//                "   public void setRequestFailed(boolean var1) {\n" +
//                "      this.while = var1;\n" +
//                "   }\n" +
//                "\n" +
//                "   public void setPageFinished(boolean var1) {\n" +
//                "      this.extends = var1;\n" +
//                "      if (var1) {\n" +
//                "         int var2 = ((Integer)com.cmcm.cmgame.utils.this.do(\"\", \"game_reward_ad_delay_ms\", Integer.valueOf(0), Integer.TYPE)).intValue();\n" +
//                "         if (var2 > 0) {\n" +
//                "            com.cmcm.cmgame.common.for.for.if(\"gamesdk_h5gamepage\", \"setPageFinished delayLoadGameRewardAd: \" + var2);\n" +
//                "            this.default.sendEmptyMessageDelayed(1001, (long)var2);\n" +
//                "         } else {\n" +
//                "            this.loadRewardAd();\n" +
//                "         }\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   public void showBanner() {\n" +
//                "      if (this.package) {\n" +
//                "         this.runOnUiThread(new H5GameActivity\$5(this));\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   public void hideBanner() {\n" +
//                "      this.runOnUiThread(new H5GameActivity\$6(this));\n" +
//                "   }\n" +
//                "\n" +
//                "   public void setBannerAdId() {\n" +
//                "      com.cmcm.cmgame.ad.do.do().for();\n" +
//                "   }\n" +
//                "\n" +
//                "   public void setInteractionPosId() {\n" +
//                "      this.runOnUiThread(new H5GameActivity\$7(this));\n" +
//                "   }\n" +
//                "\n" +
//                "   private void super() {\n" +
//                "      com.cmcm.cmgame.ad.do.do().try();\n" +
//                "   }\n" +
//                "\n" +
//                "   public void showInteractionAd() {\n" +
//                "      this.runOnUiThread(new H5GameActivity\$8(this));\n" +
//                "   }\n" +
//                "\n" +
//                "   public boolean onKeyDown(int var1, KeyEvent var2) {\n" +
//                "      if (var1 == 4) {\n" +
//                "         if (!com.cmcm.cmgame.ad.do.do().case()) {\n" +
//                "            this.char();\n" +
//                "         }\n" +
//                "\n" +
//                "         return true;\n" +
//                "      } else {\n" +
//                "         return super.onKeyDown(var1, var2);\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   public void onWebViewPageFinished(String var1) {\n" +
//                "      if (this.if.getWebView() != null) {\n" +
//                "         this.setPageFinished(true);\n" +
//                "         if (!this.tryToEnterGame()) {\n" +
//                "            this.speedupAnimation();\n" +
//                "         }\n" +
//                "\n" +
//                "         Log.i(\"gamesdk_h5gamepage\", \"onPageFinished is be called url is \" + var1);\n" +
//                "         this.catch = this.getGameId();\n" +
//                "         LoadCostReporter.getInstance().report(\"page_finish\");\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   private void throw() {\n" +
//                "      if (!double) {\n" +
//                "         FrameLayout var1 = (FrameLayout)this.findViewById(id.cmgame_sdk_loading_native_container);\n" +
//                "         var1.setVisibility(8);\n" +
//                "         com.cmcm.cmgame.activity.int.do().do(var1, this.try, this.long);\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   private void while() {\n" +
//                "      if (!double) {\n" +
//                "         MemberInfoRes var1 = com.cmcm.cmgame.membership.for.if();\n" +
//                "         if (var1 != null && var1.isVip()) {\n" +
//                "            Log.i(\"gamesdk_h5gamepage\", \"showGameLoadExpressInteractionAd isvip\");\n" +
//                "         } else {\n" +
//                "            boolean var2 = ((Boolean)com.cmcm.cmgame.utils.this.do(\"\", \"game_start_interad_switch\", true, Boolean.TYPE)).booleanValue();\n" +
//                "            boolean var3 = ((Boolean)com.cmcm.cmgame.utils.this.do(\"\", \"loading_cardad_switch\", true, Boolean.TYPE)).booleanValue();\n" +
//                "            boolean var4 = X5Helper.getMX5InitSuccess() && ((Boolean)com.cmcm.cmgame.utils.this.do(this.long, \"isx5showad\", true, Boolean.TYPE)).booleanValue();\n" +
//                "            String var5 = com.cmcm.cmgame.gamedata.if.int();\n" +
//                "            if (TextUtils.isEmpty(var5) && (var3 || var4 || var2)) {\n" +
//                "               if (this.d == null) {\n" +
//                "                  this.d = new com.cmcm.cmgame.ad.for(this);\n" +
//                "               }\n" +
//                "\n" +
//                "               this.d.do(this.long);\n" +
//                "            }\n" +
//                "         }\n" +
//                "      }\n" +
//                "   }\n" +
//                "\n" +
//                "   public boolean isQuitDialogIsShowing() {\n" +
//                "      return this.void != null && this.void.isShowing();\n" +
//                "   }\n" +
//                "\n" +
//                "   private void double() {\n" +
//                "      if (PreferencesUtils.getBoolean(\"key_is_switch_account\", false)) {\n" +
//                "         Log.i(\"mebrBind\", \"reload by switch account onResume\");\n" +
//                "         PreferencesUtils.putBoolean(\"key_is_switch_account\", false);\n" +
//                "         this.reloadWhenAccountSwitched();\n" +
//                "      }\n" +
//                "\n" +
//                "      if (PreferencesUtils.getBoolean(\"should_refresh_gametoken_by_switch_account\", false)) {\n" +
//                "         Log.i(\"mebrBind\", \"remind by switch account onResume\");\n" +
//                "         this.remindGameTokenRefreshFailed();\n" +
//                "      }\n" +
//                "\n" +
//                "   }\n" +
//                "\n" +
//                "   public void reloadWhenAccountSwitched() {\n" +
//                "      this.default.post(new H5GameActivity\$9(this));\n" +
//                "   }\n" +
//                "\n" +
//                "   public void remindGameTokenRefreshFailed() {\n" +
//                "      this.default.post(new H5GameActivity\$10(this));\n" +
//                "   }\n" +
//                "\n" +
//                "   public void registerActivityLifeReceiver(Context var1) {\n" +
//                "      IntentFilter var2 = new IntentFilter();\n" +
//                "      var2.addAction(\"android.intent.action.CLOSE_SYSTEM_DIALOGS\");\n" +
//                "      var1.registerReceiver(this.f, var2);\n" +
//                "   }\n" +
//                "\n" +
//                "   public void unregisterActivityLifeReceiver(Context var1) {\n" +
//                "      var1.unregisterReceiver(this.f);\n" +
//                "   }\n" +
//                "}\n"
//        text.walkTree(object : JavaParserBaseListener() {
//            override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext) {
//                val isPublic = ctx.isPublic()
//                val simpleName = ctx.IDENTIFIER()?.text ?: ""
//                val isInnerType = simpleName.contains("$")
//                val typeType = TypeType.Class
//                val declaredGenericTypes = ctx.genericTypes()
//                val isAbstract = ctx.isAbstract()
//            }
//
//        })
//    }

    @Test
    fun constructable() {
        EaseMob.androidSDK
            .allTypes
            .find { it.name == "com.hyphenate.chat.adapter.EMARHttpCallback" }
            ?.run {
                println(constructable)
            }
    }

    @Test
    fun isPublic() {
        val source = """
            
            @interface TXAudioEffectManager : NSObject

            /// TXAudioEffectManager对象不可直接创建
            /// 要通过 `TRTCCloud` 或 `TXLivePush` 的 `getAudioEffectManager` 接口获取
            - (instancetype)init NS_UNAVAILABLE;
            @end
        """.trimIndent()
        source.walkTree(object : ObjectiveCParserBaseListener() {
            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext) {
                ctx.returnType()
                ctx.name()
                ctx.formalParams()
                ctx.isChildOf(ObjectiveCParser.ClassMethodDeclarationContext::class)
                !ctx.isUnavailable() // 如果不可用就认为是私有的
                ctx.isDeprecated()
            }
        })
    }

    @Test
    fun noArgName() {
        val source = """
typedef void (^GMSReverseGeocodeCallback)(GMSReverseGeocodeResponse *_Nullable,
                                          NSError *_Nullable);
        """.trimIndent()
        source.walkTree(object : ObjectiveCParserBaseListener() {
            override fun enterTypedefDeclaration(ctx: ObjectiveCParser.TypedefDeclarationContext) {
                val formalParams = ctx
                    .typeDeclaratorList()
                    .typeDeclarator()[0]
                    ?.directDeclarator()
                    ?.blockParameters()
                    ?.typeVariableDeclaratorOrName()
                    ?.filter { it.typeName()?.text != "void" } // void类型, 不占用参数
                    ?.mapNotNull { it.typeVariableDeclarator() }
                    ?.mapIndexed { index, it ->
                        val argName = it.declarator().text
                            .depointer()
                            .removeObjcSpecifier()
                            .run { if(isEmpty()) "__arg${index}__" else this }
                        val argType = it.declarationSpecifiers()
                            .text
                            .run { if (argName.startsWith("*")) enpointer() else this }
                            .objcSpecifierExpand()
                        Parameter(
                            variable = Variable(argType, argName, Platform.iOS),
                            platform = Platform.iOS
                        )
                    }
            }
        })
    }

    @Test
    fun methodSig_startScreenCapture() {
        val source = "/Users/yohom/Github/Me/All/fluttify/3rd_party/tencent_live/sdk/ios/TXLiteAVSDK_Professional.framework/Headers/TRTCCloud.h".file().readText()
//        val source = "- (int)stopScreenCapture;"
        source.walkTree(object : ObjectiveCParserBaseListener() {
//            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext) {
//                println(ctx.text)
//            }

            override fun enterInstanceMethodDeclaration(ctx: ObjectiveCParser.InstanceMethodDeclarationContext) {
                println(ctx.text)
            }
        })
    }

    @Test
    fun enum_googlemap() {
        val source = """
typedef NS_ENUM(NSUInteger, GMSMapViewType) {
  kGMSTypeNormal GMS_SWIFT_NAME_2_0_3_0(Normal, normal) = 1,

  kGMSTypeSatellite GMS_SWIFT_NAME_2_0_3_0(Satellite, satellite),

  kGMSTypeTerrain GMS_SWIFT_NAME_2_0_3_0(Terrain, terrain),
  kGMSTypeHybrid GMS_SWIFT_NAME_2_0_3_0(Hybrid, hybrid),

  kGMSTypeNone GMS_SWIFT_NAME_2_0_3_0(None, none),

};"""

        source.walkTree(object : ObjectiveCParserBaseListener() {
            override fun enterEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext) {
                println(ctx.text)
            }
        })
    }
}