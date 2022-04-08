package com.company.Figures;

import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle extends Figure {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public String toString() {
    return  "I'm Rectangle: " + "a = " + a + "; b = " + b + "; c = " + c + "; d = " + d;
    }

    @Override
    public double getPerimeter() {
       return super.getPerimeter(Arrays.asList(a, b, c, d));
    }
    public void printPerimeter() {
        System.out.println("My perimeter is " + getPerimeter());
    }

    @Override
    public double getArea() {
       return super.getArea(Arrays.asList(a,b,c,d));
    }
    public void printArea() {
        System.out.println("My area is " + getArea());
    }
}
