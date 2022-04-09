package com.company.Figures;

import java.util.List;

public class Circle extends Figure{
    double radius;

    public Circle(List<Point> points) {
        super(points);
        this.radius = getRadius();
    }
    public double getRadius () {
        Point a = points.get(0);
        Point b = points.get(1);
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
}
