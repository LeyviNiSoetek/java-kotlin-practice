package org.example.io

import java.io.File

// TODO: global variable??
private val file = File("test-io-out.txt")

fun main() {
    inputTest()
//    outputTest()

}

private fun inputTest() {
    file.bufferedReader().useLines {
        println(it)
    }

    file.bufferedReader().lines().forEach { line -> println(line) }
    // TODO: is the `it` here the default parameter name of Kotlin lambda function or what?
    file.bufferedReader().lines().forEach {
        println(it)
    }
}

private fun outputTest() {
    // NOTE: this is provided through Kotlin extensions
    file.writeText("test text 1")
    file.printWriter().println("test text 2")
    val printWriter = file.printWriter()
    printWriter.use {
        it.println("test text 3")
        it.println("test text 4")
    }
}