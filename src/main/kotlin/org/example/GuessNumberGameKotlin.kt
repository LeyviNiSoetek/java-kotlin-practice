package org.example

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var secret: Int = Random().nextInt(100) + 1
    var guess: Int

    println(secret)
    while (true) {
        print("Enter your guess: ")
//        guess = scanner.nextInt()
        guess = readLine()!!.toInt() // TODO: exception (NoSuchElementException) handling

        if (guess == secret) {
            println("GJ.")
            break
        }
        println("$guess is too ${if (guess < secret) "low" else "high"}.")
    }
}