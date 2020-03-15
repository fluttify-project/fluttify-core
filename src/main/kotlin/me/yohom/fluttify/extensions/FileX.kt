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
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

// todo 以嵌套/多个类的前提生成结构
/**
 * Java源码解析
 */
fun JAVA_FILE.javaType(): Type {
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
                        ctx.type()
                            .run { if (isCollection()) genericType() else this }, // 如果是集合类型, 那么抽取出泛型类型作为类型, 其他直接使用原始类名
                        ctx.name(),
                        Platform.Android,
                        ctx.type().run {
                            when {
                                isArray() -> ListType.Array
                                isArrayList() -> ListType.ArrayList
                                isLinkedList() -> ListType.LinkedList
                                isCollection() -> ListType.List
                                else -> ListType.NonList
                            }
                        },
                        ctx.type().collectionLevel()
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

    return Type().also {
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
    }
}

/**
 * Objc源码解析
 */
fun OBJC_FILE.objcType(): List<Type> {
    val source = readText()

    val result = mutableListOf<Type>()

    var fields = mutableListOf<Field>()
    var enumConstants = mutableListOf<String>()
    var methods = mutableListOf<Method>()
    var name = ""
    var typeType: TypeType? = null
    var superClass = ""
    var interfaces = mutableListOf<String>()
    var isAbstract = false
    var genericTypes = listOf<TYPE_NAME>()

    source.walkTree(object : ObjectiveCParserBaseListener() {
        //region 类
        override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            typeType = TypeType.Class
            name = ctx.className.text
            superClass = ctx.superclassName.text
            interfaces.addAll(ctx.protocolList()?.protocolName()?.map { it.identifier().text } ?: listOf())
            isAbstract = false
        }

        override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            name = ctx.className.text
            if (name.isNotEmpty()) {
                result.add(
                    Type().also {
                        it.typeType = typeType
                        it.isPublic = true
                        it.isAbstract = isAbstract
                        it.name = name
                        it.isStaticType = true
                        it.superClass = superClass
                        it.interfaces = interfaces
                        it.fields.addAll(fields)
                        it.methods.addAll(methods)
                        it.constants.addAll(enumConstants)
                        it.platform = Platform.iOS
                    }
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                interfaces = mutableListOf()
                methods = mutableListOf()
            }
        }
        //endregion

        //region 协议
        override fun enterProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
            typeType = TypeType.Interface
            name = ctx.protocolName().text
            superClass = ""
            interfaces.addAll(ctx.protocolList()?.protocolName()?.map { it.identifier().text } ?: listOf())
            isAbstract = true
        }

        override fun exitProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
            if (name.isNotEmpty()) {
                result.add(
                    Type().also {
                        it.typeType = typeType
                        it.isPublic = true
                        it.isAbstract = isAbstract
                        it.name = name
                        it.superClass = superClass
                        it.isStaticType = true
                        it.interfaces = interfaces
                        it.fields.addAll(fields)
                        it.methods.addAll(methods)
                        it.constants.addAll(enumConstants)
                        it.platform = Platform.iOS
                    }
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                interfaces = mutableListOf()
                methods = mutableListOf()
            }
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
            if (result.map { it.name }.contains(ctx.identifier()?.text)) return

            typeType = TypeType.Enum
            name = ctx.identifier()?.text
                ?: ctx.enumSpecifier().identifier().firstOrNull { it != null }?.text
                        ?: ""
            isAbstract = false
        }

        override fun enterEnumeratorIdentifier(ctx: ObjectiveCParser.EnumeratorIdentifierContext) {
            if (result.map { it.name }.contains(
                    ctx.ancestorOf(ObjectiveCParser.EnumDeclarationContext::class)?.identifier()?.text
                )
            ) return

            enumConstants.add(ctx.identifier().text)
        }

        override fun exitEnumDeclaration(ctx: ObjectiveCParser.EnumDeclarationContext) {
            if (result.map { it.name }.contains(ctx.identifier()?.text)) return

            if (name.isNotEmpty()) {
                result.add(Type().also {
                    it.typeType = typeType
                    it.isPublic = true
                    it.isAbstract = isAbstract
                    it.name = name
                    it.superClass = superClass
                    it.isStaticType = true
                    it.fields.addAll(fields)
                    it.methods.addAll(methods)
                    it.constants.addAll(enumConstants)
                    it.platform = Platform.iOS
                })
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
                enumConstants = mutableListOf()
            }
        }
        //endregion

        //region 分类
        override fun enterCategoryInterface(ctx: ObjectiveCParser.CategoryInterfaceContext) {
            typeType = TypeType.Class
            name = ctx.categoryName.text
            superClass = ""
            isAbstract = false
        }

        override fun exitCategoryInterface(ctx: ObjectiveCParser.CategoryInterfaceContext) {
            // 先在已识别出来的类型列表中寻找是否存在Category对应的类型
            val categoryClass = result.find { it.name == ctx.categoryName.text }
            // 如果存在的话, 那么把收集到的属性和方法数据添加进去, 否则什么都不做, 并清空属性和方法列表
            categoryClass?.run {
                categoryClass.fields.addAll(fields)
                categoryClass.methods.addAll(methods)
            }
            fields = mutableListOf()
            methods = mutableListOf()
        }
        //endregion

        //region 结构体
        override fun enterStructOrUnionSpecifier(ctx: ObjectiveCParser.StructOrUnionSpecifierContext) {
            // 只有结构体不是在类里面才处理
            // 因为碰到了这种情况
            // @interface BMKOverlayView : UIView
            //{
            // // 其他代码
            //    struct {
            //        unsigned int keepAlive:1;
            //        unsigned int levelCrossFade:1;
            //        unsigned int drawingDisabled:1;
            //        unsigned int usesTiledLayer:1;
            //    } _flags;
            //}
            // // 其他代码
            // @end
            if (!ctx.isChildOf(ObjectiveCParser.ClassInterfaceContext::class)) {
                typeType = TypeType.Struct
                // 当struct由typedef定义时, 形如:
                // typedef struct {
                //    double x; /// 横坐标
                //    double y; /// 纵坐标
                // } BMKMapPoint;
                //
                // 另外一种结构体定义
                // ///经度、纬度定义的经纬度跨度范围
                // struct MACoordinateSpan{
                //     CLLocationDegrees latitudeDelta;  ///< 纬度跨度
                //     CLLocationDegrees longitudeDelta; ///< 经度跨度
                // };
                // typedef struct MACoordinateSpan MACoordinateSpan;
                //
                // 到这个方法时, 在ObjectiveCParser.TypedefDeclarationContext上下文下, 可能会已经读取到结构体的名称
                // 这里优先使用identifier的值, 如果有说明是第二种定义方式, 如果没有说明是第一种, 采用已经获取到的name
                name = ctx.identifier()?.text ?: name
            }
        }

        override fun exitStructOrUnionSpecifier(ctx: ObjectiveCParser.StructOrUnionSpecifierContext) {
            // 结构体 && 名称不为空 && result中不包含当前名称
            if (typeType == TypeType.Struct && name.isNotEmpty() && !result.map { it.name }.contains(name)) {
                result.add(
                    Type().also {
                        it.typeType = typeType
                        it.isPublic = true
                        it.isAbstract = isAbstract
                        it.name = name
                        it.superClass = superClass
                        it.isStaticType = true
                        it.fields.addAll(fields)
                        it.methods.addAll(methods)
                        it.constants.addAll(enumConstants)
                        it.platform = Platform.iOS
                    }
                )
                // 创新创建fields和methods
                fields = mutableListOf()
                methods = mutableListOf()
            }
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
                    val rawTypeName = it.declarationSpecifiers().text
                    val paramListType = rawTypeName.run {
                        when {
                            isArray() -> ListType.Array
                            isArrayList() -> ListType.ArrayList
                            isLinkedList() -> ListType.LinkedList
                            isCollection() -> ListType.List
                            else -> ListType.NonList
                        }
                    }
                    Parameter(
                        variable = Variable(
                            rawTypeName.genericType(),
                            it.declarator().text,
                            Platform.iOS,
                            paramListType,
                            rawTypeName.collectionLevel()
                        ),
                        platform = Platform.iOS
                    )
                }

            if (returnType != null && typeName != null) {
                if (formalParams != null) {
                    result.add(
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
                    typeType == TypeType.Struct
                    name = typeName
                }
                // 别名不包含^, 说明不是函数别名
                else if (!typeName.contains("^")) {
                    result.add(
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

        override fun enterFieldDeclaration(ctx: ObjectiveCParser.FieldDeclarationContext) {
            // 只接收property和struct
            if (ctx.isChildOf(ObjectiveCParser.PropertyDeclarationContext::class)
                || ctx.isChildOf(ObjectiveCParser.StructOrUnionSpecifierContext::class)
            ) {
                val variable = Variable(
                    ctx.type().run {
                        when {
                            isCollection() -> genericType()
                            ctx.name().startsWith("*") -> enpointer()
                            else -> this
                        }
                    },
                    ctx.name().depointer(), // 统一把*号加到类名上去
                    Platform.iOS,
                    ctx.type().run {
                        when {
                            isArray() -> ListType.Array
                            isArrayList() -> ListType.ArrayList
                            isLinkedList() -> ListType.LinkedList
                            isCollection() -> ListType.List
                            else -> ListType.NonList
                        }
                    },
                    ctx.type().collectionLevel()
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
                result.add(
                    Type().also {
                        it.typeType = TypeType.Function
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
        }
    })

    return result
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
