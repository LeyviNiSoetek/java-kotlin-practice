package org.example

fun main() {
    val isEven: (Int) -> Boolean = { number -> number % 2 == 0 }
    val isOdd = { number: Int -> number % 2 != 0 }
    // NOTE: can use `it` when exactly one known-type parameter
    val is35: (Int) -> Boolean = { it == 35 }
    //       more than 1 params so cannot simply use `it`
    val is1135: (Int, Int) -> Boolean = { a, b -> a == 11 && b == 35 }

    determineNumber(12, 34, { n1, n2 -> Math.max(n1, n2) })

    // NOTE: (looks weird but) when the last parameter is a function, it can be written like this..
    determineNumber(12, 34) { n1, n2 -> Math.max(n1, n2) }
    //       .. for those with exactly one function-typed parameter
    functionAccepter { /* function body */ }

}

private fun determineNumber(a: Int, b: Int, selector: (Int, Int) -> Int) = selector(a, b)

private fun functionAccepter(willNotBeInvoked: () -> Unit): Unit {
    println("Got called but doing nothing.")
}
