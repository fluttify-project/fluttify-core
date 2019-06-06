package common

import common.extensions.formalParams
import common.model.*
import parser.dart.Dart2Parser
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

/**
 * AST信息压缩
 */
object Packer {
    fun pack(javaUnit: JavaParser.CompilationUnitContext): PackedUnit {
        // 获取类型的类型(类/枚举/接口)
        val typeType: TypeType = javaUnit
            // 获取类型声明
            .typeDeclaration()
            // 过滤出文件中唯一的public类型
            .firstOrNull { it.classOrInterfaceModifier().map { modifier -> modifier.text }.contains("public") }
            ?.run {
                when {
                    classDeclaration() != null -> TypeType.Class
                    enumDeclaration() != null -> TypeType.Enum
                    interfaceDeclaration() != null -> TypeType.Interface
                    else -> throw IllegalArgumentException("非法的内容")
                }
            } ?: throw IllegalArgumentException("非法的内容")

        // 获取类型的名称
        val typeName: String = javaUnit
            // 获取类型声明
            .typeDeclaration()
            // 过滤出文件中唯一的public类型
            .firstOrNull { it.classOrInterfaceModifier().map { modifier -> modifier.text }.contains("public") }
            ?.run {
                when {
                    classDeclaration() != null -> classDeclaration().IDENTIFIER().text
                    enumDeclaration() != null -> enumDeclaration().IDENTIFIER().text
                    interfaceDeclaration() != null -> interfaceDeclaration().IDENTIFIER().text
                    else -> throw IllegalArgumentException("非法的内容")
                }
            } ?: throw IllegalArgumentException("非法的内容")

        // 获取所有的字段信息
        val fields: List<Field> = javaUnit
            // 获取类型声明
            .typeDeclaration()
            // 获取类内部所有的声明(属性和方法)
            .flatMap { it.classDeclaration().classBody().classBodyDeclaration() }
            .filter { it.memberDeclaration().fieldDeclaration() != null }
            .map {
                val (fieldType, name) = it
                    .memberDeclaration()
                    .fieldDeclaration()
                    .run {
                        Pair(
                            typeType()?.text ?: "",
                            variableDeclarators().variableDeclarator()[0].variableDeclaratorId().IDENTIFIER().text
                        )
                    }
                return@map Field(fieldType, name)
            }

        // 获取所有的方法信息
        val methods: List<Method> = javaUnit
            // 获取类型声明
            .typeDeclaration()
            // 获取类内部所有的声明(属性和方法)
            .flatMap { it.classDeclaration().classBody().classBodyDeclaration() }
            .filter { it.memberDeclaration().methodDeclaration() != null }
            .map {
                val returnType = it
                    .memberDeclaration()
                    .methodDeclaration()
                    .run { typeTypeOrVoid().text }

                val name = it
                    .memberDeclaration()
                    .methodDeclaration()
                    .run { IDENTIFIER().text }

                val formalParams = it
                    .memberDeclaration()
                    .methodDeclaration()
                    .run { formalParams() }

                return@map Method(returnType, name, formalParams)
            }

        return JavaUnit(typeType, typeName, methods, fields)
    }

    fun pack(objcUnit: ObjectiveCParser.TranslationUnitContext) {

    }

    fun pack(dart2Unit: Dart2Parser.CompilationUnitContext) {

    }

}