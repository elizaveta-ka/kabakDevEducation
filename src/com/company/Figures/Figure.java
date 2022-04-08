package com.company.Figures;


import java.util.ArrayList;
import java.util.List;

public abstract class Figure {

    public abstract String toString();

    protected double getPerimeter(List<Point> points) {
        double perimeter = 0;
        for (int i = 1; i < points.size(); i++) {
            perimeter += perimeter + Math.sqrt(Math.pow(points.get(i).getX() - points.get(i - 1).getX(), 2) + Math.pow(points.get(i).getY() - points.get(i - 1).getY(), 2));
        }
        return perimeter;
    }

    protected double getArea(List<Point> points) {
        double area = 0;
        for (int i = 0; i < points.size(); i++) {
            int temp = i + 1 < points.size() ? i + 1 : 0;
             area += points.get(i).getX() * points.get(temp).getY() - points.get(i).getY() * points.get(temp).getX();
        }
        return Math.abs(area / 2);
    }
    public abstract double getPerimeter();

    public abstract double getArea();
}
