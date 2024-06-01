package com.example.workhours.model;

public class Workhours {
    private String employeeName;
    private int hoursWorked;

    public Workhours(String employeeName, int hoursWorked) {
        this.employeeName = employeeName;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
