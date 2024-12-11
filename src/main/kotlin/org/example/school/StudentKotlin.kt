package org.example.school

open class StudentKotlin(var name: String?, var englishScore: Int, var mathScore: Int) {
    companion object {
        // Without @JvmStatic: Class.Companion.{get | set}Field
        // With    @JvmStatic: Class[.Companion].{get | set}Field, where the `.Companion` becomes optional
        //@JvmStatic
        public var gradeElite = 'E'

        @JvmStatic
        public var passScore = 60

        @JvmStatic
        fun companionMethod() {
            println("hi im just a companion method.")
        }
    }

    open fun print() {
        println("name: $name, English: $englishScore, Math: $mathScore, " +
                "average: ${getAverageScore()} (${getGrade()}), ${passOrFailed()}")
    }

    open fun getHighestScore(): Int {
        return Math.max(englishScore, mathScore)
    }

    open fun getAverageScore(): Int {
        return (this.mathScore + this.englishScore) / 2;
    }

    open fun passOrFailed(): String = if (getAverageScore() >= passScore) "PASS" else "FAILED"

    fun getGrade(): Char = when (getAverageScore()) {
        100, 99, 98, 97, 96, 95, 94, 93, 92, 91 -> 'A'
        in 81..90 /*step 1*/ -> 'B'
        35 -> 'E' // Elite
        else -> 'Z'
    }

    fun isElite()/* : Boolean*/ = getGrade() == 'E'
}