package org.example.many

fun main() {
    lists()
}

private fun lists() {
    // NOTE: `List`s are immutable; for mutable ver use MutableList
    val list1: List<Int> = ArrayList()
    val list2: List<Int> = ArrayList<Int>()
    val list3 = listOf<Int>(1, 2, 3)
    val list4 = listOf(1, 2, 3)

    val mutableList1: MutableList<Int> = MutableList(5) { 0 }
    println(mutableList1)
    mutableList1.add(35)
    println(mutableList1)

    for (i in list3) {
        println(i)
    }
}
