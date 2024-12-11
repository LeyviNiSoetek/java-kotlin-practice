package org.example.abstracts;

import org.example.abstracts.report.DefaultReport;
import org.example.abstracts.report.FinanceReport;
import org.example.abstracts.report.HealthReport;
import org.example.abstracts.report.Report;

import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List<Report> reports = Arrays.asList(
                new FinanceReport(),
                new HealthReport(),
                new Report() { // anonymous class
                    @Override
                    public void print() {
                        System.out.println("anonymous print");
                    }

                    @Override
                    public void load() {
                        System.out.println("anonymous load");
                    }
                },
                new DefaultReport(5) {
                    @Override
                    public void load() {
                        System.out.println("anonymous default report");
                    }
                }
        );
        for (Report report : reports) {
            report.load();
            report.print();
        }
    }
}
