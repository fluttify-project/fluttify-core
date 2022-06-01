package me.yohom.fluttify.extensions

import me.yohom.fluttify.JAVA_FILE
import me.yohom.fluttify.OBJC_FILE
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.model.*
import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.IOFileFilter
import org.apache.commons.io.filefilter.TrueFileFilter
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener
import java.io.File
import java.util.*

/**
 * Java源码解析
 */
fun JAVA_FILE.javaType(): SourceFile {
    var source = readText()
    for (entry in ext.android.allMacros.entries) {
        source = source.replace(Regex(entry.key), entry.value)
    }

    var packageName = ""
    var declaredGenericTypes = listOf<TYPE_NAME>()
    val definedGenericTypes = mutableListOf<TYPE_NAME>()
    val fields = mutableListOf<Field>()
    val constructors = mutableListOf<Constructor>()
    val enumConstants = mutableListOf<Enumerator>()
    val methods = mutableListOf<Method>()
    var simpleName = ""
    var typeType: TypeType? = null
    var superClass = ""
    val interfaces = mutableListOf<String>()
    var isPublic = false
    var isAbstract = false
    var isInnerType = false
    var isStaticType: Boolean? = null

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext) {
            packageName = ctx.qualifiedName().text
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            isPublic = ctx.isPublic()
            simpleName = ctx.IDENTIFIER()?.text ?: ""
            isInnerType = simpleName.contains("$")
            typeType = TypeType.Class
            declaredGenericTypes = ctx.genericTypes()
            // 默认给一个和声明泛型相同长度的Object定义泛型
            for (item in declaredGenericTypes.indices) {
                definedGenericTypes.add("java.lang.Object")
            }
            isAbstract = ctx.isAbstract()

            // 列出所有的import
            val imports = ctx
                .ancestorOf(CompilationUnitContext::class)
                ?.importDeclaration()
                ?.map { it.qualifiedName()?.text ?: "" } ?: listOf()
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
            simpleName = ctx.IDENTIFIER()?.text ?: ""
            isInnerType = simpleName.contains("$")
            typeType = TypeType.Interface
            declaredGenericTypes = ctx.genericTypes()
            // 默认给一个和声明泛型相同长度的Object定义泛型
            for (item in declaredGenericTypes.indices) {
                definedGenericTypes.add("java.lang.Object")
            }
            interfaces.addAll(ctx.superInterfaces())
            isAbstract = true
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext) {
            isPublic = ctx.isPublic() == true
            simpleName = ctx.IDENTIFIER()?.text ?: ""
            isInnerType = simpleName.contains("$")
            isStaticType = true
            typeType = TypeType.Enum
            isAbstract = false
        }

        override fun enterConstructorDeclaration(ctx: ConstructorDeclarationContext) {
            if (ctx.IDENTIFIER().text.isObfuscated()) return

            // 如果已经确认是静态类型, 就不需要再往下判断构造器的情况了
            // 碰到一个静态内部类, 有一个无参构造器和一个参数外外部类的构造器, 第二个构造器的判断覆盖了第一个构造器
            if (isStaticType != true) {
                isStaticType = ctx.isStaticType()
            }

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
            enumConstants.add(Enumerator(ctx.IDENTIFIER().text, null))
        }
    })

    return SourceFile().also {
        it.fileName = nameWithoutExtension
        it.types = listOf(Type().also { type ->
            type.typeType = typeType
            type.isPublic = isPublic
            type.isAbstract = isAbstract
            type.isInnerType = isInnerType
            type.isStaticType = isStaticType ?: true
            type.declaredGenericTypes.addAll(declaredGenericTypes)
            type.definedGenericTypes.addAll(definedGenericTypes)
            type.constructors = constructors
            type.interfaces = interfaces
            type.name = "$packageName.${simpleName}"
            type.superClass = superClass
            type.fields.addAll(fields)
            type.methods.addAll(methods)
            type.enumerators.addAll(enumConstants)
            type.platform = Platform.Android
        })
        it.topLevelConstants = listOf()
    }
}

/**
 * Objc源码解析
 */
fun OBJC_FILE.objcType(): SourceFile {
    var source = readText()
    for (entry in ext.ios.allMacros.entries) {
        source = source.replace(Regex(entry.key), entry.value)
    }

    val topLevelConstant = mutableListOf<Variable>()
    val types = mutableListOf<Type>()

    val stack = Stack<Type>()

    source.replaceMacro()
        .walkTree(object : ObjectiveCParserBaseListener() {
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
                        topLevelConstant.add(
                            Variable(
                                "NSString*",
                                constantName.depointer(),
                                Platform.iOS
                            )
                        )
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
                    it.interfaces.addAll(
                        ctx.protocolList()?.protocolName()?.map { it.identifier().text }
                            ?: listOf())
                    it.isAbstract = false
                })
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
                if (stack.isNotEmpty()) types.add(stack.pop())
            }
            //endregion

            //region 协议
            override fun enterProtocolDeclaration(ctx: ObjectiveCParser.ProtocolDeclarationContext) {
                stack.push(Type().also {
                    it.platform = Platform.iOS
                    it.typeType = TypeType.Interface
                    it.name = ctx.protocolName().text
                    it.superClass = ""
                    it.interfaces.addAll(
                        ctx.protocolList()?.protocolName()?.map { it.identifier().text }
                            ?: listOf())
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

            override fun enterEnumerator(ctx: ObjectiveCParser.EnumeratorContext) {
                stack.peekOrNull()?.run {
                    val enumName = ctx.enumeratorIdentifier().identifier().text
                    val enumValue = ctx.expression()?.text
                    enumerators.add(Enumerator(enumName, enumValue))
                }
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
                    it.interfaces.addAll(
                        ctx.protocolList()?.protocolName()?.map { it.identifier().text }
                            ?: listOf())
                    it.isAbstract = false
                })
            }

            override fun exitCategoryInterface(ctx: ObjectiveCParser.CategoryInterfaceContext) {
                types.add(stack.pop())
            }
            //endregion

            //region 结构体 已经在typedef上下文中处理
            override fun enterStructOrUnionSpecifier(ctx: ObjectiveCParser.StructOrUnionSpecifierContext) {
                // 如果结构体没有内容则略过, 这种情况可以是`typedef struct MACoordinateRegion MACoordinateRegion;`
                if (ctx.fieldDeclaration().isEmpty()) return
                stack.push(Type().also {
                    it.platform = Platform.iOS
                    it.typeType = TypeType.Struct
                    // 结构体名字, 从结构体定时时获取, 如果没有则向上找typedef, 获取typedef后的名称
                    it.name = ctx.identifier()?.text
                        ?: ctx.ancestorOf(ObjectiveCParser.TypedefDeclarationContext::class)
                            ?.typeName()
                                ?: ""
                })
            }

            override fun exitStructOrUnionSpecifier(ctx: ObjectiveCParser.StructOrUnionSpecifierContext) {
                if (stack.isNotEmpty()) types.add(stack.pop())
            }
            //endregion

            override fun enterTypedefDeclaration(ctx: ObjectiveCParser.TypedefDeclarationContext) {
                val returnType = ctx
                    .declarationSpecifiers()
                    ?.typeSpecifier()
                    ?.get(0)
                    ?.text
                val typeName = ctx
                    .typeDeclaratorList()
                    ?.typeDeclarator()
                    ?.get(0)
                    ?.directDeclarator()
                    ?.identifier()
                    ?.text
                val formalParams = ctx
                    .typeDeclaratorList()
                    ?.typeDeclarator()
                    ?.get(0)
                    ?.directDeclarator()
                    ?.blockParameters()
                    ?.typeVariableDeclaratorOrName()
                    ?.filter { it.typeName()?.text != "void" } // void类型, 不占用参数
                    ?.mapNotNull { it.typeVariableDeclarator() }
                    ?.mapIndexed { index, it ->
                        val argName = it.declarator().text
                            .depointer()
                            .removeObjcSpecifier()
                            .run { if (isEmpty()) "__arg${index}__" else this }
                        val argType = it.declarationSpecifiers()
                            .text
                            .run { if (it.declarator().text.startsWith("*")) enpointer() else this }
                            .objcSpecifierExpand()
                        Parameter(
                            variable = Variable(argType, argName, Platform.iOS),
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
                        // 结构体统一在struct里处理
//                    stack.push(Type().also {
//                        it.platform = Platform.iOS
//                        it.typeType = TypeType.Struct
//                        it.name = typeName
//                    })
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
                if (stack.isNotEmpty()) types.add(stack.pop())
            }

            override fun enterFieldDeclaration(ctx: ObjectiveCParser.FieldDeclarationContext) {
                // 只接收property和结构体
                if (!ctx.isChildOf(ObjectiveCParser.PropertyDeclarationContext::class)
                    &&
                    !ctx.isChildOf(ObjectiveCParser.StructOrUnionSpecifierContext::class)
                ) return

                stack.peekOrNull()?.run {
                    val variable = Variable(
                        ctx.type().run {
                            when {
                                ctx.name().startsWith("*") -> enpointer()
                                else -> this
                            }
                        },
                        ctx.name().depointer().removeObjcSpecifier(), // 统一把*号加到类名上去
                        Platform.iOS
                    )

                    // 如果是已有的字段就跳过
                    // 为了处理有些条件编译, 但是字段名称相同的情况
                    if (fields.map { it.variable.name }.contains(variable.name)) return

                    // property肯定是public的, 且肯定是非static的, 因为如果需要static的话, 用方法就行了
                    fields.add(
                        Field(
                            true,
                            ctx.isFinal(),
                            ctx.isStatic(),
                            ctx.getValue(),
                            variable,
                            name,
                            ctx.getterName().removeObjcSpecifier(),
                            ctx.setterName().removeObjcSpecifier(),
                            Platform.iOS,
                            ctx.macro()?.any { it.text.contains("deprecated") } == true
                        )
                    )
                }
            }

            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext) {
                stack.peekOrNull()?.run {
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
                    ?.typeSpecifier()
                    ?.last() // 函数可能会多个限定词(包括返回类型), 理论上类型肯定是最后一个(?)
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
                                typeName = (it.declarationSpecifiers()?.text
                                    ?: it.VOID().text).run {
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

    return SourceFile().also { type ->
        type.fileName = nameWithoutExtension
        type.types = types
        type.topLevelConstants = topLevelConstant
    }
}

fun File.iterate(
    vararg fileSuffix: String = arrayOf(),
    recursive: Boolean = true,
    fileFilter: IOFileFilter = TrueFileFilter.INSTANCE,
    forEach: (File) -> Unit
) {
    FileUtils
        .iterateFiles(this, fileSuffix, recursive)
        .forEach { if (fileFilter.accept(it)) forEach(it) }
}

fun String.replaceMacro(): String {
    return replace(Regex("(#(el)?if.*TARGET_OS_(MAC|OSX))[\\s\\S]*?(#else|#endif)"), "$1\n$4")
        // 出现过百度地图中#import和冒号(")连在一起的情况, antlr无法解析, 但是能通过编译, 这里手动给它空个空格出来
        .replace("#import\"", "#import \"")
        .run {
            if (ext.ios.exclude.macros.isNotEmpty()) {
                val regex = ext.ios.exclude.macros.joinToString("|", "(", ")")
                replace(Regex("(#(el)?if.*${regex})[\\s\\S]*?(#else|#endif)"), "$1\n$4")
            } else {
                this
            }
        }
}