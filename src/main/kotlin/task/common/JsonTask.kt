package task.common

import common.DART_FILE
import common.Temps
import common.extensions.ancestorOf
import common.extensions.jsonable
import common.extensions.placeholder
import common.extensions.walkTree
import parser.dart.Dart2BaseListener
import parser.dart.Dart2Parser
import task.Task

/**
 * 由只有字段的Dart Model生成有`fromJson`和`toJson`的model
 *
 * 输入: 只有字段的dart模型文件
 * 输出: 加入了fromJson和toJson方法的模型文件
 * 依赖: [AndroidDartModelTask]
 */
class JsonTask(private val dartModelFile: DART_FILE) : Task<DART_FILE, DART_FILE>(dartModelFile) {
    override fun process(): DART_FILE {
        val dartModelContent = dartModelFile.readText()
        val dartModelContentBuilder = StringBuilder(dartModelFile.readText())

        var className = ""
        val fromJson = StringBuilder()
        val toJson = StringBuilder()
        var isEnum = false

        dartModelContent.walkTree(object : Dart2BaseListener() {
            override fun enterClassDefinition(ctx: Dart2Parser.ClassDefinitionContext?) {
                ctx?.run { className = ctx.identifier().text }
            }

            override fun enterEnumType(ctx: Dart2Parser.EnumTypeContext?) {
                ctx?.run { isEnum = true }
            }

            override fun enterInitializedIdentifier(ctx: Dart2Parser.InitializedIdentifierContext?) {
                ctx?.run {
                    // 生成json相关方法时, 跳过静态成员
                    if (ctx.ancestorOf(Dart2Parser.DeclarationContext::class)?.STATIC() != null) return

                    val type = ctx.ancestorOf(Dart2Parser.DeclarationContext::class)?.dtype()?.text ?: ""
                    val name = ctx.identifier().text
                    when {
                        type.contains("List<") -> {
                            val genericType = type.substring(type.indexOf("<"), type.indexOf(">") + 1)
                            fromJson.append("\n    bean.$name = (json['$name'] as List).cast$genericType();")
                            toJson.append("\n      '$name': $name,")
                        }
                        type.jsonable() -> {
                            fromJson.append("\n    bean.$name = json['$name'] as $type;")
                            toJson.append("\n      '$name': $name,")
                        }
                        else -> {
                            fromJson.append("\n    if (json['$name'] != null) bean.$name = $type.fromJson((json['$name'] as Map).cast<String, dynamic>());")
                            toJson.append("\n      '$name': $name.toJson(),")
                        }
                    }
                }
            }
        })

        // 枚举不需要生成json方法
        if (!isEnum) {
            // 最后的"}"索引
            val lastBraceIndex = dartModelContent.lastIndexOf("}")
            // 加入toJson
            dartModelContentBuilder.insert(
                lastBraceIndex,
                Temps.Dart.toJson.placeholder(toJson.toString())
            )
            // 加入fromJson
            dartModelContentBuilder.insert(
                lastBraceIndex,
                Temps.Dart.fromJson.placeholder(className, className, fromJson.toString())
            )
        }
        return dartModelFile.apply { writeText(dartModelContentBuilder.toString()) }
    }
}