@file:JvmName("StaticCar")

package com.exemple.selenide.kotlin

fun topLevel() = println("I am the topLevel function")

class CarKt (val model: String, val couleur: String, val annee: Int ) {

    fun qui() {
        println("bonjour je suis Car : $model")
    }

}

