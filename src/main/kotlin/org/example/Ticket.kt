package org.example.kotlin

fun main() {
    val ticket = Ticket(12, 17, 20)
    ticket.tear()
}

/**
 * Kotlin data class practice
 */
data class Ticket(var original: Int, var destination: Int, var price: Int)

/**
 * Kotlin extension practice
 */
fun Ticket.tear() {
    println("this extension tears the ticket.. just kidding")
}
