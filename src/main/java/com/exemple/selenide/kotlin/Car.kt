package com.exemple.selenide.kotlin

fun topLevel() = println("I am the topLevel function")

class Car (val model: String, val couleur: String, val annee: Int ) {

    fun qui() {
        println("bonjour je suis Car : $model")
    }

}

