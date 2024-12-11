package org.example.abstracts.report;

public class HealthReport implements Report {
    @Override
    public void print() {
        System.out.println("Health Report");
    }

    @Override
    public void load() {
        System.out.println("Loading Health Report");
    }
}
