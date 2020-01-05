package com.exemple.selenide.kotlin

import java.io.File
import kotlin.math.pow

fun main(args: Array<String>) {
//    val listPrime = listPrime(1000)
//    val MAX_VALUE: Int
//    println (listPrime)
//    val li = (2..50 step 2).map { 7 * it +1 }
//    rechercheN(23)
}

fun rechercheN(q: Int): MutableList<Int> {

    var listNResult = mutableListOf<Int>()
    val maxDesN = (q-1)/2

//    println(listPrime(100))

    for(n in 2..(maxDesN) step 2) {
        val r2 = 2.0.pow((q-1)/n) -1
        println("q = $q; n = $n; r2 = $r2 et le reste est : ${r2 % q}")
        if (r2 % q == 0.0) {
            listNResult.add(n)
            println(n)
        }
    }

    println(listNResult)

    return listNResult
}

/**
 * fill file fichier1.txt with n=1; the first 10 Prime number q; for each q, the first 10 number b
 * such that q doesn't divise b.
 *
 */
fun calculEqu2(): Unit {

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
    writer.append("We check equ2 for n=1 : \n\n")
    chaine.forEach { (t, u) ->
        writer.append("pour Q = $t, on a : ${u.areAllMultipleOfQ()} \n ${u.aff()} \n\n")
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

