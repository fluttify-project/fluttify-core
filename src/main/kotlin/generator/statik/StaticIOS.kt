//package generator.statik
//
//import Configs.mainObjcClass
//import builtparser.ObjcParser
//import common.Temps
//import common.extensions.*
//import generator.IiOS
//import parser.objc.ObjectiveCParser
//import parser.objc.ObjectiveCParserBaseListener
//import preprocess.Framework
//import preprocess.OutputProject
//
//private val parser = ObjcParser(Framework.mainClassPath)
//
///**
// * iOS端目标类以静态模式创建对象, 简单接口
// */
//object SimpleStaticIOS: IiOS {
//    override val iOSDartResult get() = dartResultBuilder.toString()
//    override val swiftResult get() = swiftResultBuilder.toString()
//
//    private val dartResultBuilder = StringBuilder()
//    private val swiftResultBuilder = StringBuilder()
//
//    override fun generateIOSDart() {
//        parser.walkTree(object : ObjectiveCParserBaseListener() {
//            override fun enterTranslationUnit(ctx: ObjectiveCParser.TranslationUnitContext?) {
//                dartResultBuilder.append(Temps.Dart.packageImport)
//            }
//
//            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
//                dartResultBuilder.append(Temps.Dart.classDeclaration.placeholder("${OutputProject.classSimpleName}IOS"))
//                dartResultBuilder.append(Temps.Dart.methodChannel.placeholder(OutputProject.methodChannel))
//            }
//
//            override fun enterMethodDeclaration(method: ObjectiveCParser.MethodDeclarationContext?) {
//                // 如果参数中有无法直接json序列化的, 就跳过
//                if (method.formalParams().any { !it.type.jsonable() }) return
//                // 如果返回类型无法直接json序列化的, 就跳过
//                if (!method.returnType().jsonable()) return
//
//                dartResultBuilder.append(Temps.Dart.invokeMethod.placeholder(
//                    method.returnType(),
//                    method.name(),
//                    method.formalParams().joinToString { "${it.type} ${it.name}" },
//                    method.name(),
//                    if (method.formalParams().isEmpty()) "" else ", ",
//                    method.formalParams().toDartMap()
//                ))
//            }
//
//            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
//                dartResultBuilder.append(Temps.Dart.classEnd)
//            }
//        })
//    }
//
//    override fun generateSwift() {
//        parser.walkTree(object : ObjectiveCParserBaseListener() {
//            override fun enterTranslationUnit(ctx: ObjectiveCParser.TranslationUnitContext?) {
//                swiftResultBuilder.append(Temps.Swift.packageImport)
//            }
//
//            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
//                swiftResultBuilder.append(Temps.Swift.classDeclaration.placeholder(OutputProject.classSimpleName))
//                swiftResultBuilder.append(Temps.Swift.register.placeholder(OutputProject.methodChannel, OutputProject.classSimpleName))
//                swiftResultBuilder.append(Temps.Swift.onMethodCall)
//            }
//
//            override fun enterClassMethodDeclaration(method: ObjectiveCParser.ClassMethodDeclarationContext?) {
//                // 如果参数中有无法直接json序列化的, 就跳过
//                if (method.formalParams().any { !it.type.jsonable() }) return
//                // 如果返回类型无法直接json序列化的, 就跳过
//                if (!method.returnType().jsonable()) return
//
//                swiftResultBuilder.append(Temps.Swift.invokeResult.placeholder(
//                    method.name(),
//                    mainObjcClass,
//                    method.name(),
//                    method.formalParams().joinToString { "args[\"${it.name}\"] as! ${it.type}" }
//                ))
//            }
//
//            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
//                swiftResultBuilder.append(Temps.Swift.switchDefault)
//                swiftResultBuilder.append(Temps.Swift.classEnd)
//            }
//        })
//    }
//}
//
///**
// * iOS端目标类以静态模式创建对象, 复杂接口
// */
//object ComplicatedStaticIOS: IiOS {
//    override val iOSDartResult get() = dartResultBuilder.toString()
//    override val swiftResult get() = swiftResultBuilder.toString()
//
//    private val dartResultBuilder = StringBuilder()
//    private val swiftResultBuilder = StringBuilder()
//
//    override fun generateIOSDart() {
//    }
//
//    override fun generateSwift() {
//    }
//}