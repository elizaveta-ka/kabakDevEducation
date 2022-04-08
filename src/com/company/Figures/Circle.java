package com.company.Figures;

public class Circle extends Figure{
    Point a;
    Point b;

    public Circle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    @Override
    public String toString() {
        return "I'm circle. My Points is : " + this.a + "; " + this.b ;
    }
    public double getRadius () {
        double radius = Math.sqrt((Math.pow((b.getX() - a.getX()), 2)) + (Math.pow((b.getY() - a.getY()), 2)));
        return radius;
    }
    @Override
    public double getPerimeter() {
        double perimeter = 2 * Math.PI * getRadius();
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = Math.PI * Math.pow(getRadius(), 2);
    return area;
    }
    public void printPerimeter() {
        System.out.println("My perimeter is " + getPerimeter());
    }
    public void printArea() {
        System.out.println("My area is " + getArea());
    }
}
