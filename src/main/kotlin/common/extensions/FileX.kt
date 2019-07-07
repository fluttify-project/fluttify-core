package common.extensions

import common.JAVA_FILE
import common.model.Method
import common.model.Type
import common.model.TypeType
import common.model.Variable
import org.apache.commons.io.FileUtils
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import java.io.File

/**
 * Java源码解析
 */
fun JAVA_FILE.javaType(): Type {
    val source = readText()

    var packageName = ""
    val fields = mutableListOf<Variable>()
    val methods = mutableListOf<Method>()
    var simpleName = ""
    var typeType: TypeType? = null
    var superClass = ""

    source.walkTree(object : JavaParserBaseListener() {
        override fun enterPackageDeclaration(ctx: PackageDeclarationContext) {
            packageName = ctx.qualifiedName().text
        }

        override fun enterClassDeclaration(ctx: ClassDeclarationContext) {
            if (ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true) {
                simpleName = ctx.IDENTIFIER().text
                typeType = TypeType.Class

                val imports = ctx
                    .ancestorOf(CompilationUnitContext::class)
                    ?.importDeclaration()
                    ?.map { it.qualifiedName().text } ?: listOf()
                superClass = imports.firstOrNull { it.substringAfterLast(".") == ctx.typeType()?.text } ?: ""
            }
        }

        override fun enterInterfaceDeclaration(ctx: InterfaceDeclarationContext) {
            if (ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true) {
                simpleName = ctx.IDENTIFIER().text
                typeType = TypeType.Interface
            }
        }

        override fun enterEnumDeclaration(ctx: EnumDeclarationContext) {
            if (ctx.ancestorOf(TypeDeclarationContext::class)?.isPublic() == true) {
                simpleName = ctx.IDENTIFIER().text
                typeType = TypeType.Enum
            }
        }

        override fun enterMethodDeclaration(ctx: MethodDeclarationContext) {
            methods.add(Method(ctx.returnType(), ctx.name(), ctx.formalParams(), ctx.isStatic(), ctx.isAbstract()))
        }

        override fun enterInterfaceMethodDeclaration(ctx: InterfaceMethodDeclarationContext) {
            methods.add(Method(ctx.returnType(), ctx.name(), ctx.formalParams(), ctx.isStatic(), true))
        }

        override fun enterFieldDeclaration(ctx: FieldDeclarationContext) {
            fields.add(Variable(ctx.isPublic(), ctx.isFinal(), ctx.isStatic(), ctx.type(), ctx.name()))
        }

        override fun enterEnumConstant(ctx: EnumConstantContext) {
            fields.add(Variable(true,  true, false, type = ctx.IDENTIFIER().text, name = ctx.IDENTIFIER().text))
        }
    })

    return Type(
        "$packageName.${simpleName.replace("$", ".")}",
        absolutePath,
        superClass,
        fields,
        methods,
        typeType
    )
}

fun File.iterate(fileSuffix: String, recursive: Boolean = true, forEach: (File) -> Unit) {
    FileUtils
        .iterateFiles(this, arrayOf(fileSuffix), recursive)
        .forEach { forEach(it) }
}