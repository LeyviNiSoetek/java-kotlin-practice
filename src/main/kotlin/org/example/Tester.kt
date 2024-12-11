package org.example

import org.example.kotlin.Ticket

fun main() {
//    forLoops()
//    TestKotlin()
}

// primary constructor; the keyword "constructor" can be omitted
class TestKotlin /*constructor*/(
    val name : String,
    var word : String,
    var thatDoesNotMatter: String = ""
) {
    init {
        println("he-he.")
    }
//    secondary constructor
    constructor() : this("nobody", "NO", "yes actually")
}

fun forLoops() {
    // NOTE: `a..b` constructs a IntRange instance
    for (i in 0..3 /*step 1*/) {
        println(i)
    }
    println("---")
    for (i in 1..10 step 2) {
        println(i)
    }
    println("---------")

    for (i in 3 downTo 0 /*step 1*/) {
        println(i)
    }
    println("---")
    for (i in 10 downTo 0 step 3) {
        println(i)
    }
    println("---------")

//    Exception in thread "main" java.lang.IllegalArgumentException: Step must be positive, was: -1.
    /*
    for (i in 0..3 step -1) {
        println(i)
    }
    println("---")
    for (i in 3 downTo 0 step -1) {
        println(i)
    }
    println("---------")
    */

}
