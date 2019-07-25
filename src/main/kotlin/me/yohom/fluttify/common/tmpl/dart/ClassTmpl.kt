package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Type

/**
 * 生成普通类的dart接口
 */
class ClassTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/class.dart.tmpl").readText()

    fun dartClass(): String {
        val currentPackage = ext.outputProjectName
        val className = type.name.toDartType()
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        val getters = type.fields
            .filter { it.isPublic == true }
            .filter { it.isStatic == false }
            .map { GetterTmpl(it).dartGetter() }

        val setters = type.fields
            .filter { it.isFinal == false }
            .filter { it.isPublic == true }
            .filter { it.isStatic == false }
            .map { SetterTmpl(it).dartSetter() }

        val methods = type.methods
            .filter { it.isPublic == true }
            .map { MethodTmpl(it).dartMethod() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__class_name__#", className)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
            .replaceParagraph("#__methods__#", methods.joinToString("\n"))
    }
}