package org.example.school

import java.util.*

fun main() {
//    userInput()
//    val student = inputStudent()
    // NOTE: seems Kotlin doesn't allow generic typed variable ..?
    val student/*: StudentKotlin*/ = GraduateStudentKotlin("Name", 34, 78, 69)
    student.print()
//    practiceWhileLoop()
}

fun practiceWhileLoop() {
    val scanner = Scanner(System.`in`)
    var number: Int = 0
    do {
        print("Please enter a number: ")
        number = scanner.nextInt()
        println(number)
    } while (number != -1)
}

fun inputStudent() : StudentKotlin {
    val scanner = Scanner(System.`in`)
    val name: String;
    val englishGrade: Int
    val mathGrade: Int
    print("Enter the student's name: ")
    name = scanner.next()
    print("Enter the student's English grade: ")
    englishGrade = scanner.nextInt()
    print("Enter the student's Math grade: ")
    mathGrade = scanner.nextInt()

    return StudentKotlin(name, englishGrade, mathGrade)
}

private fun userInput() {
    val scanner = Scanner(System.`in`)
    val name: String;
    val englishGrade: Int
    val mathGrade: Int
    print("Enter the student's name: ")
    name = scanner.next()
    print("Enter the student's English grade: ")
    englishGrade = scanner.nextInt()
    print("Enter the student's Math grade: ")
    mathGrade = scanner.nextInt()

    val student = StudentKotlin(name, englishGrade, mathGrade)
    student.print()

    student.name = null
    student.print()
    print("student.name?.length = ")
    println(student.name?.length)
    try {
        print("student.name!!.length = ")
        println(student.name!!.length)
    } catch (e: NullPointerException) {
        println("Oops: $e")
    }
}
