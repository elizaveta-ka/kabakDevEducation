package com.company.Figures;

import java.util.ArrayList;

public class Point {
    protected double x;
    protected double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String toString () {
        return "Point: " + this.getX() + ", " + this.getY();
    }

}
