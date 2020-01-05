package com.exemple.selenide.kotlin

import java.io.File
import kotlin.math.pow

//fun main(args: Array<String>) {
//    val listPrime = listPrime(10)
//    val MAX_VALUE: Int
//    println (Integer.MAX_VALUE)
//}

fun calcul(): Unit {

    val chaine: MutableMap<Int, EnsembleNb> = mutableMapOf()
    val listPrime = listPrime(10)
    for (i in listPrime) {
        chaine.putIfAbsent(i, EnsembleNb(i))
    }
    afficheChaine(chaine)
    writeToFile(chaine)
}

fun writeToFile(chaine: MutableMap<Int, EnsembleNb>) {

    val file = File("fichier1.txt")
    val writer = file.writer()
    chaine.forEach { (t, u) ->
        writer.append("pour Q = $t, on a : ${u.areAllMultipleOfQ()} \n ${u.aff()} \n")
    }
    writer.close()
}


fun listPrime(nb: Int): List<Int> {
    val listPrime = mutableListOf<Int>()
    var deb = 2
    while(listPrime.size < nb) {
        val ele: Int? = (deb..999999).find { isPrime(it) }
        listPrime.add(ele!!)
        deb = ele + 1
    }
    return listPrime
}


fun isPrime(nb: Int): Boolean {
    if ( nb == 2 || nb == 5 )
        return true
    else if(nb.toString().last() in arrayOf('0', '2', '4', '5', '6', '8'))
        return false
    else if( (2..(nb / 2)).any { nb % it == 0 } )
        return false
    return true
}

fun afficheChaine(chaine: MutableMap<Int, EnsembleNb>) {
    chaine.forEach { (t, u) -> println("pour Q = $t, on a : ${u.areAllMultipleOfQ()} \n ${u.aff()}") }
}

class EnsembleNb(val q:Int) {

    private val mapResult: MutableMap<Int, Double> = mutableMapOf()

    init {
        (0..15).filter { it % q != 0 }.forEach { mapResult[it] = resultat(it) }
    }

    private fun resultat(b: Int) = b.toDouble().pow((q - 1).toDouble()) - 1

    fun aff() = mapResult.map { m -> "${m.key}: ${m.value}" }.joinToString()

    fun areAllMultipleOfQ(): Boolean {
        val find = mapResult.values.find { it % q != 0.0 }
        return find == null
    }

}

