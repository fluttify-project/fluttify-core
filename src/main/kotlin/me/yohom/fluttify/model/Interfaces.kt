package me.yohom.fluttify.model

interface IPlatform {
    var platform: Platform
}

interface IScope {
    val isPublic: Boolean
}

interface IElement {
    var id: Int
}