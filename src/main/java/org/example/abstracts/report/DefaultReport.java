package org.example.abstracts.report;

public abstract class DefaultReport implements Report{
    int pages;

    public DefaultReport(int pages) {
        this.pages = pages;
    }

    @Override
    public void print() {
        System.out.println(this.getClass().getName() + " report with " + pages + "pages.");
    }
}
