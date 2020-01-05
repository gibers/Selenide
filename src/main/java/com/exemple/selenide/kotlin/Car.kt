@file:JvmName("StaticCar")

package com.exemple.selenide.kotlin

import java.io.IOException

fun topLevel() = println("I am the topLevel function")

fun main(args: Array<String>) {
    "Print this".print()
}


object SingletonObj {
    fun doSomething() = println("I m doing something in the singleton object")
}

class Car (val model: String, couleur: String, val annee: Int ) {

    @JvmField var color = couleur

    companion object {
        val isAuto = false
        @JvmStatic fun carComp() = println("I am in Car's companion object")
    }

    fun printMe(text: String?) {
        println("I dont expect a null value: $text")
        Math.pow(4.0, 4.0)

    }

    @Throws(IOException::class)
    fun doIo() {
        throw IOException()
    }

//        get() = "field"

//        set (value) {
//            field = value.plus("cc")
//        }
//
//    var motor: String = couleur
//        set (value) {
//            field = "V8"
//        }

//    fun qui() {
//        println("bonjour je suis Car : $model de couleur: $isColor, motor: $motor")
//    }

}

fun String.print() {
    println(this)
}
