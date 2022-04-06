package com.company.Figures;

public class Rectangle {
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

    public  String toString() {
    return  "Rectangle: " + "a = " + a + "; b = " + b + "; c = " + c + "; d = " + d;
    }

    public void getSquare () {
       double square = (d.getX() - a.getX()) * (b.getY() - a.getY());
        System.out.println(square);
    }
    public void getPerimeter() {
        double perimeter = 2 * ((d.getX() - a.getX()) + (b.getY() - a.getY()));
        System.out.println(perimeter);
    }
}
