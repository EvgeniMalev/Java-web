package com.javatpoint;

public class Hydrogen {
    private static final Hydrogen obj = new Hydrogen();
    private int period;
    private double density;
    private double boilingPoint;
    private int quantity;

    private Hydrogen() {
        System.out.println("Hydrogen");
    }

    public static Hydrogen getHydrogen() {
        return obj;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public void setBoilingPoint(double boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void msg() {
        System.out.println("Hydrogen is the first element in the table.");
        System.out.println("Period: " + period);
        System.out.println("Density: " + density);
        System.out.println("Boiling Point: " + boilingPoint);
        System.out.println("Quantity: " + quantity);
    }
}
