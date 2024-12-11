package org.example.restaurant.kotlin

import java.io.File

fun main() {
    println("Welcome to Kotlin restaurant. Meals here are bad and do not try to have them.")
    val restaurant = Restaurant()
    restaurant.printMenu()
}

class Restaurant {
    fun printMenu() {
//        menu.forEach()
        for (entry in menu) {
            println(String.format("%4s: %s", entry.key, entry.value))
        }
    }

    companion object {
        val menuFile: File = File("menu.txt")
    }

    private val menu: MutableMap<String, Meal> = HashMap() // TODO: is it good?
    init {
        menuFile.bufferedReader().forEachLine {
            val tokens = it.split(",")
            menu.put(tokens[0], Meal(
                tokens[1],
                tokens[2].toInt(),
                tokens[3].toInt()
            ))
        }
    }
}

private class Meal(val name: String, val mentalPower: Int, val price: Int) {
    override fun toString(): String {
        return String.format("%20s (provides %4d mental power), $%5d", name, mentalPower, price)
    }
}
