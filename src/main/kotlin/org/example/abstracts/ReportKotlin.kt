package org.example.abstracts

fun main() {
    val reports = listOf<ReportKotlin>(
        FinanceReportKotlin(),
        HealthReportKotlin(),
    )
    for (report in reports) {
        report.load()
        report.print()
    }
}

interface ReportKotlin {
    fun print()

    // interface with default implementation?
    fun load(){
        println("Loading report (abstract)")
    }
}

class FinanceReportKotlin : ReportKotlin {
    override fun print() {
//        super.print() // compile error since it has no default implementation
        println("Finance report")
    }

    override fun load() {
        super.load() // works (optional)
        println("Loading finance report")
    }
}

class HealthReportKotlin : ReportKotlin {
    override fun print() {
        println("Health report")
    }

//    works even without overriding `load`
}
