package me.yohom.fluttify.extensions

import parser.objc.ObjectiveCParser

fun ObjectiveCParser.TypedefDeclarationContext.typeName(): String? {
    return typeDeclaratorList()
        ?.typeDeclarator()
        ?.get(0)
        ?.directDeclarator()
        ?.identifier()
        ?.text
}