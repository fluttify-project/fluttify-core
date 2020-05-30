package me.yohom.fluttify.extensions

import me.yohom.fluttify.JAVA_FILE
import me.yohom.fluttify.OBJC_FILE
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.model.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.IOFileFilter
import org.apache.commons.io.filefilter.TrueFileFilter
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener
import java.io.*
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Java源码解析
 */
fun JAVA_FILE.javaType(): SourceFile {
    val source = readText()

    var packageName = ""
    var genericTypes = listOf<TYPE_NAME>()
    val fields = mutableListOf<Field>()
    val constructors = mutableListOf<Constructor>()
    val enumConstants = mutableListOf<String>()
    val methods = mutableListOf<Method>()
    var simpleName = ""
    var typeType: TypeType? = null
    var superClass = ""
    val interfaces = mutableListOf<String>()
    var isPublic = false
    var isAbstract = false
    var isInnerType = false
    var isStaticType = true

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext) {
            packageName = ctx.qualifiedName().text
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            isPublic = ctx.isPublic()
            simpleName = ctx.IDENTIFIER()?.text ?: ""
            isInnerType = simpleName.contains("$")
            typeType = TypeType.Class
            genericTypes = ctx.genericTypes()
            isAbstract = ctx.isAbstract()

            // 列出所有的import
            val imports = ctx
                .ancestorOf(CompilationUnitContext::class)
                ?.importDeclaration()
                ?.map { it.qualifiedName().text } ?: listOf()
            // 从这些import中找出extends后面的类
            // 同接口会碰到的问题, 如果父类是同包下面的类, 那么就
            // 遍历当前文件夹, 如果找到当前父类名字的类, 那么就加上当前包名, 否则就认为是java.lang的类
            val simpleSuperClass = ctx.typeType()?.text
            superClass = imports.firstOrNull { it.substringAfterLast(".") == simpleSuperClass }
                ?: parentFile
                    .list()
                    ?.firstOrNull { it.substringBeforeLast(".") == simpleSuperClass }
                    ?.run { "$packageName.${substringBeforeLast(".")}" }
                        ?: ""

            // 从import中找出含有接口列表中接口名称的import
            interfaces.addAll(imports.filter { import ->
                ctx.typeList()
                    ?.typeType()
                    ?.map { it.text } // 接口简称列表
                    ?.contains(import.substringAfterLast(".")) == true
            })
            // 碰到一种情况, 实现的接口是同包下面的接口, 所以没有import
            // 遍历当前文件夹, 如果找到对应名字的类, 那么就加上当前包名, 否则就认为是java.lang的类
            // 每个文件都和接口列表比对一下, 如果在接口列表中, 那么就过滤出来并加上包名
            interfaces.addAll(parentFile.list()?.filter { fileName ->
                ctx.typeList()
                    ?.typeType()
                    ?.map { it.text } // 接口简称列表
                    ?.contains(fileName.substringBeforeLast(".")) == true
            }?.map { "$packageName.${it.substringBeforeLast(".")}" } ?: listOf())
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext) {
            isPublic = ctx.isPublic()
            simpleName = ctx.IDENTIFIER().text
            isInnerType = simpleName.contains("$")
            typeType = TypeType.Interface
            genericTypes = ctx.genericTypes()
            interfaces.addAll(ctx.superInterfaces())
            isAbstract = true
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext) {
            isPublic = ctx.isPublic() == true
            simpleName = ctx.IDENTIFIER().text
            isInnerType = simpleName.contains("$")
            isStaticType = true
            typeType = TypeType.Enum
            isAbstract = false
        }

        override fun enterConstructorDeclaration(ctx: ConstructorDeclarationContext) {
            if (ctx.IDENTIFIER().text.isObfuscated()) return

            isStaticType = ctx.isStaticType()

            constructors.add(
                Constructor(
                    ctx.IDENTIFIER().text,
                    ctx.formalParams(),
                    ctx.isPublic(),
                    platform = Platform.Android
                )
            )
        }

        override fun enterMethodDeclaration(ctx: MethodDeclarationContext) {
            if (ctx.name().isObfuscated()) return

            methods.add(
                Method(
                    ctx.returnType(),
                    ctx.name(),
                    ctx.formalParams(),
                    ctx.isStatic(),
                    ctx.isAbstract(),
                    ctx.isPublic(),
                    "$packageName.$simpleName",
                    Platform.Android,
                    ctx.isDeprecated(),
                    isGenericMethod = ctx.isGenericMethod()
                )
            )
        }

        override fun enterInterfaceMethodDeclaration(ctx: InterfaceMethodDeclarationContext) {
            methods.add(
                Method(
                    ctx.returnType(),
                    ctx.name(),
                    ctx.formalParams(),
                    ctx.isStatic(),
                    true,
                    true,
                    "$packageName.$simpleName",
                    Platform.Android,
                    ctx.isDeprecated(),
                    isGenericMethod = ctx.isGenericMethod()
                )
            )
        }

        override fun enterFieldDeclaration(ctx: FieldDeclarationContext) {
            if (ctx.name().isObfuscated()) return
            fields.add(
                Field(
                    ctx.isPublic(),
                    ctx.isFinal(),
                    ctx.isStatic(),
                    ctx.getValue(),
                    Variable(
                        ctx.type(),
                        ctx.name(),
                        Platform.Android
                    ),
                    "$packageName.$simpleName",
                    platform = Platform.Android,
                    isDeprecated = ctx.isDeprecated()
                )
            )
        }

        override fun enterEnumConstant(ctx: EnumConstantContext) {
            enumConstants.add(ctx.IDENTIFIER().text)
        }
    })

    return SourceFile(
        nameWithoutExtension,
        listOf(Type().also {
            it.typeType = typeType
            it.isPublic = isPublic
            it.isAbstract = isAbstract
            it.isInnerType = isInnerType
            it.isStaticType = isStaticType
            it.genericTypes.addAll(genericTypes)
            it.constructors = constructors
            it.interfaces = interfaces
            it.name = "$packageName.$simpleName"
            it.superClass = superClass
            it.fields.addAll(fields)
            it.methods.addAll(methods)
            it.constants.addAll(enumConstants)
            it.platform = Platform.Android
        }),
        listOf()
    )
}

/**
 * Objc源码解析
 */
fun OBJC_FILE.objcType(): SourceFile {
    val source = readText()

    val topLevelConstant = mutableListOf<Variable>()
    val types = mutableListOf<Type>()

    val stack = Stack<Type>()

    source.walkTree(object : ObjectiveCParserBaseListener() {

        override fun enterVarDeclaration(ctx: ObjectiveCParser.VarDeclarationContext) {
            // 只有顶层声明需要处理
            if (!ctx.isChildOf(ObjectiveCParser.ClassInterfaceContext::class)
                &&
                !ctx.isChildOf(ObjectiveCParser.ClassImplementationContext::class)
                &&
                !ctx.isChildOf(ObjectiveCParser.CategoryInterfaceContext::class)
                &&
                !ctx.isChildOf(ObjectiveCParser.CategoryImplementationContext::class)
                &&
                !ctx.isChildOf(ObjectiveCParser.ProtocolDeclarationContext::class)
                &&
                !ctx.isChildOf(ObjectiveCParser.FunctionDeclarationContext::class)
            ) {
                val isExternString = ctx
                    .declarationSpecifiers()
                    ?.text
                    ?.run {
                        contains("extern") && contains("NSString")
                    }
                val constantName = ctx
                    .initDeclaratorList()
                    ?.initDeclarator()
                    ?.get(0)
                    ?.declarator()
                    ?.directDeclarator()
                    ?.identifier()
                    ?.text

                if (isExternString == true && constantName != null) {
                    topLevelConstant.add(Variable("NSString*", constantName.depointer(), Platform.iOS))
                }
            }
        }

        //region 类
        override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            stack.push(Type().also {
                it.platform = Platform.iOS
                it.typeType = TypeType.Class
                it.name = ctx.className.text
                it.superClass = ctx.superclassName.text
                it.interfaces.addAll(ctx.protocolList()?.protocolName()?.map { it.identifier().text } ?: listOf())
                it.isAbstract = false
            })
        }

        override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            types.add(stack.pop())
        }
        //endregion

        //region 协议
        override fun enterProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
            stack.push(Type().also {
                it.platform = Platform.iOS
                it.typeType = TypeType.Interface
                it.name = ctx.protocolName().text
                it.superClass = ""
                it.interfaces.addAll(ctx.protocolList()?.protocolName()?.map { it.identifier().text } ?: listOf())
                it.isAbstract = true
            })
        }

        override fun exitProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
            types.add(stack.pop())
        }
        //endregion

        //region 枚举
        override fun enterEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext) {
            // 碰到了
            //
            //enum MALineCapType
            //{
            //    kMALineCapButt,     ///< 普通头
            //    kMALineCapSquare,   ///< 扩展头
            //    kMALineCapArrow,    ///< 箭头
            //    kMALineCapRound     ///< 圆形头
            //};
            //typedef enum MALineCapType MALineCapType;
            //
            // 这种情况, 导致MALineCapType在dart端的内容是空的, 这里如果碰到的枚举是已经定义过的, 那么就跳过
            if (types.map { it.name }.contains(ctx.identifier()?.text)) return

            stack.push(Type().also {
                it.platform = Platform.iOS
                it.typeType = TypeType.Enum
                it.name = ctx.identifier()?.text
                    ?: ctx.enumSpecifier().identifier().firstOrNull { it != null }?.text
                            ?: ""
                it.isAbstract = false
            })
        }

        override fun enterEnumeratorIdentifier(ctx: ObjectiveCParser.EnumeratorIdentifierContext) {
            stack.peek()?.constants?.add(ctx.identifier().text)
        }

        override fun exitEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext) {
            if (stack.isNotEmpty()) types.add(stack.pop())
        }
        //endregion

        //region 分类
        override fun enterCategoryInterface(ctx: ObjectiveCParser.CategoryInterfaceContext) {
            stack.push(Type().also {
                it.platform = Platform.iOS
                it.typeType = TypeType.Extension
                it.name = ctx.categoryName.text
                it.interfaces.addAll(ctx.protocolList()?.protocolName()?.map { it.identifier().text } ?: listOf())
                it.isAbstract = false
            })
        }

        override fun exitCategoryInterface(ctx: ObjectiveCParser.CategoryInterfaceContext) {
            types.add(stack.pop())
        }
        //endregion

        //region 结构体
        override fun enterStructOrUnionSpecifier(ctx: ObjectiveCParser.StructOrUnionSpecifierContext) {
            stack.push(Type().also {
                it.platform = Platform.iOS
                it.typeType = TypeType.Struct
                it.name = ctx.identifier()?.text ?: ""
            })

        }

        override fun exitStructOrUnionSpecifier(ctx: ObjectiveCParser.StructOrUnionSpecifierContext) {
            types.add(stack.pop())
        }
        //endregion

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
                    val argName = it.declarator().text
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
                    stack.push(
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
                    )
                }
                // 结构体
                else if (returnType.contains("struct")) {
                    stack.push(Type().also {
                        it.typeType == TypeType.Struct
                        it.name = typeName
                    })
                }
                // 别名不包含^, 说明不是函数别名
                else if (!typeName.contains("^")) {
                    stack.push(
                        Type().also {
                            it.typeType = TypeType.Alias
                            it.isPublic = true
                            it.isAbstract = false
                            it.name = typeName
                            it.isStaticType = true
                            it.aliasOf = returnType
                            it.platform = Platform.iOS
                        }
                    )
                }
            }
        }

        override fun exitTypedefDeclaration(ctx: ObjectiveCParser.TypedefDeclarationContext) {
            types.add(stack.pop())
        }

        override fun enterFieldDeclaration(ctx: ObjectiveCParser.FieldDeclarationContext) {
            // 只接收property
            if (!ctx.isChildOf(ObjectiveCParser.PropertyDeclarationContext::class)) return

            stack.peek().run {
                val variable = Variable(
                    ctx.type().run {
                        when {
                            ctx.name().startsWith("*") -> enpointer()
                            else -> this
                        }
                    },
                    ctx.name().depointer(), // 统一把*号加到类名上去
                    Platform.iOS
                )
                // property肯定是public的, 且肯定是非static的, 因为如果需要static的话, 用方法就行了
                fields.add(
                    Field(
                        true,
                        ctx.isFinal(),
                        false,
                        ctx.getValue(),
                        variable,
                        name,
                        ctx.getterName(),
                        ctx.setterName(),
                        Platform.iOS,
                        ctx.macro()?.primaryExpression()?.any { it.text.contains("deprecated") } == true
                    )
                )
            }
        }

        override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext) {
            stack.peek().run {
                methods.add(
                    Method(
                        ctx.returnType(),
                        ctx.name(),
                        ctx.formalParams(),
                        ctx.isChildOf(ObjectiveCParser.ClassMethodDeclarationContext::class),
                        null,
                        !ctx.isUnavailable(), // 如果不可用就认为是私有的
                        name,
                        Platform.iOS,
                        ctx.isDeprecated()
                    )
                )
            }
        }

        override fun enterFunctionSignature(ctx: ObjectiveCParser.FunctionSignatureContext) {
            val returnType = ctx
                .declarationSpecifiers()
                .typeSpecifier()[0]
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

            if (returnType != null && typeName != null && formalParams != null) {
                stack.push(Type().also {
                    it.typeType = TypeType.Function
                    it.isPublic = true
                    it.isAbstract = false
                    it.name = typeName
                    it.isStaticType = true
                    it.returnType = returnType
                    it.formalParams = formalParams
                    it.platform = Platform.iOS
                })
            }
        }

        override fun exitFunctionSignature(ctx: ObjectiveCParser.FunctionSignatureContext?) {
            if (stack.isNotEmpty()) types.add(stack.pop())
        }
    })

    return SourceFile(nameWithoutExtension, types, topLevelConstant)
}

fun File.iterate(
    fileSuffix: String?,
    recursive: Boolean = true,
    fileFilter: IOFileFilter = TrueFileFilter.INSTANCE,
    forEach: (File) -> Unit
) {
    FileUtils
        .iterateFiles(this, arrayOf(fileSuffix), recursive)
        .forEach { if (fileFilter.accept(it)) forEach(it) }
}

@Throws(Exception::class)
fun File.downloadFrom(url: String) {
    println("开始从 $url 下载")
    // 忽略HTTPS效验
    var sslContext: SSLContext? = null
    val manager = object : X509TrustManager {
        @Throws(CertificateException::class)
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        override fun getAcceptedIssuers(): Array<X509Certificate?> {
            return arrayOfNulls(0)
        }
    }
    val trustAllCerts: Array<TrustManager> = arrayOf(manager)
    try {
        sslContext = SSLContext.getInstance("SSL")
        sslContext!!.init(null, trustAllCerts, java.security.SecureRandom())
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    } catch (e: KeyManagementException) {
        e.printStackTrace()
    }

    val httpClient: OkHttpClient = OkHttpClient.Builder()
        // 忽略HTTPS效验
        .sslSocketFactory(sslContext!!.socketFactory, manager)
        .callTimeout(20, TimeUnit.MINUTES)
        .readTimeout(20, TimeUnit.MINUTES)
        .retryOnConnectionFailure(true)
        .hostnameVerifier { _, _ -> true }
        .build()

    val request: Request = Request.Builder()
        .url(url)
        .build()

    val response = httpClient.newCall(request).execute()

    var inStream: InputStream? = null
    val buffer = ByteArray(2048)
    var length: Int
    var outStream: FileOutputStream? = null

    try {
        val total = response.body()?.contentLength()
        if (total != (-1).toLong()) {
            var current: Long = 0
            inStream = response.body()?.byteStream()
            outStream = FileOutputStream(this)
            do {
                length = inStream?.read(buffer) ?: -1
                if (length != -1) {
                    current += length.toLong()
                    outStream.write(buffer, 0, length)
                }
            } while (length != -1)
            outStream.flush()
        }
    } catch (e: IOException) {
        e.printStackTrace()
        throw e
    } finally {
        try {
            inStream?.close()
            outStream?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
