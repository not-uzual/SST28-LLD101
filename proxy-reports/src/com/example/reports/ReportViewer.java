package com.example.reports;

/**
 * Client class that works with the Report abstraction.
 * Now depends on the Report interface instead of concrete implementation.
 */
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}
