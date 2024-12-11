package org.example.abstracts.report;

public class FinanceReport implements Report {
    @Override
    public void print() {
        System.out.println("Finance Report");
    }

    @Override
    public void load() {
        System.out.println("Loading Finance Report");
    }
}
