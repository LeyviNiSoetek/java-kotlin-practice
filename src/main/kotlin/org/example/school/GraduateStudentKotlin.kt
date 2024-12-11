package org.example.school

class GraduateStudentKotlin(name: String?, englishScore: Int, mathScore: Int, val thesisScore: Int)
    : StudentKotlin(name, englishScore, mathScore) {
    companion object {
        @JvmStatic
        var passScore: Int = 70
    }

    override fun passOrFailed(): String = if (getAverageScore() >= passScore) "PASS" else "FAILED"

    override fun getHighestScore(): Int = Math.max(super.getHighestScore(), thesisScore)

    override fun getAverageScore(): Int = (englishScore + mathScore + thesisScore) / 3
}