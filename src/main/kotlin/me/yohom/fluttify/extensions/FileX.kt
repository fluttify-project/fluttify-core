package me.yohom.fluttify.extensions

import me.yohom.fluttify.JAVA_FILE
import me.yohom.fluttify.OBJC_FILE
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.model.*
import org.apache.commons.io.FileUtils
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener
import java.io.File

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
    var isInnerClass = false
    var isStaticType = true

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext) {
            packageName = ctx.qualifiedName().text
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            isPublic = ctx.isPublic()
            simpleName = ctx.IDENTIFIER()?.text ?: ""
            isInnerClass = simpleName.contains("$")
            typeType = TypeType.Class
            genericTypes = ctx.genericTypes()
            isAbstract = ctx.isAbstract()

            // 列出所有的import
            val imports = ctx
                .ancestorOf(CompilationUnitContext::class)
                ?.importDeclaration()
                ?.map { it.qualifiedName().text } ?: listOf()
            // 从这些import中找出extends后面的类
            superClass = imports.firstOrNull { it.substringAfterLast(".") == ctx.typeType()?.text } ?: ""
            interfaces.addAll(imports.filter {
                ctx.typeList()
                    ?.typeType()
                    ?.map { it.text }
                    ?.contains(it.substringAfterLast(".")) == true
            })
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext) {
            isPublic = ctx.isPublic()
            simpleName = ctx.IDENTIFIER().text
            isInnerClass = simpleName.contains("$")
            typeType = TypeType.Interface
            genericTypes = ctx.genericTypes()
            interfaces.addAll(ctx.superInterfaces())
            isAbstract = true
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext) {
            isPublic = ctx.isPublic() == true
            simpleName = ctx.IDENTIFIER().text
            isInnerClass = simpleName.contains("$")
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
                    "$packageName.${simpleName.replace("$", ".")}",
                    Platform.Android,
                    ctx.isDeprecated()
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
                    "$packageName.${simpleName.replace("$", ".")}",
                    Platform.Android,
                    ctx.isDeprecated()
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
                    Variable(
                        ctx.type().genericType(),
                        ctx.name(),
                        ctx.type().isList(),
                        ctx.type().genericLevel(),
                        Platform.Android
                    ),
                    "$packageName.${simpleName.replace("$", ".")}",
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
        it.isInnerClass = isInnerClass
        it.isStaticType = isStaticType
        it.genericTypes.addAll(genericTypes)
        it.constructors = constructors
        it.interfaces = interfaces
        it.name = "$packageName.${simpleName.replace("$", ".")}"
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
            name = ctx.className.text.apply { println("类名: $this 开始") }
            superClass = ctx.superclassName.text
            interfaces.addAll(ctx.protocolList()?.protocolName()?.map { it.identifier().text } ?: listOf())
            isAbstract = false
        }

        override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext) {
            name = ctx.className.text.apply { println("类名: $this 结束 方法们: $methods") }
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
            if (result.map { it.name }.contains(ctx.ancestorOf(ObjectiveCParser.EnumDeclarationContext::class)?.identifier()?.text)) return

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
                name = ctx.identifier()?.text ?: ""
            }
        }

        override fun exitStructOrUnionSpecifier(ctx: ObjectiveCParser.StructOrUnionSpecifierContext) {
            if (typeType == TypeType.Struct && name.isNotEmpty()) {
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
                ?.map {
                    it.typeVariableDeclarator()
                        .run {
                            Parameter(
                                variable = Variable(
                                    typeName = declarationSpecifiers().text,
                                    platform = Platform.iOS,
                                    name = declarator().text
                                ),
                                platform = Platform.iOS
                            )
                        }
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
            // 只接收property
            ctx.ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class) ?: return

            val variable = Variable(
                ctx.type().genericType(),
                ctx.name(),
                platform = Platform.iOS,
                isList = ctx.isListType(),
                genericLevel = ctx.type().genericLevel()
            )
            // property肯定是public的, 且肯定是非static的, 因为如果需要static的话, 用方法就行了
            fields.add(
                Field(
                    true,
                    ctx.isFinal(),
                    false,
                    variable,
                    name,
                    ctx.getterName(),
                    ctx.setterName(),
                    Platform.iOS,
                    ctx.macro()?.primaryExpression()?.any { it.text.contains("deprecated") } == true
                )
            )
        }

        override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext) {
            ctx.name().apply { println("类名: $name, 方法名: $this") }
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
                .parameterDeclarationList()
                .parameterDeclaration()
                ?.takeIf { it.all { it.declarationSpecifiers() != null && it.declarator() != null } }
                ?.map {
                    Parameter(
                        variable = Variable(
                            typeName = it.declarationSpecifiers()?.text ?: it.VOID().text,
                            platform = Platform.iOS,
                            name = it.declarator()?.text ?: it.VOID().text
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

fun File.iterate(fileSuffix: String?, recursive: Boolean = true, forEach: (File) -> Unit) {
    FileUtils
        .iterateFiles(this, arrayOf(fileSuffix), recursive)
        .forEach { forEach(it) }
}