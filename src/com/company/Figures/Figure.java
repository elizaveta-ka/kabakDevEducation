package com.company.Figures;

import java.util.List;

public abstract class Figure {
    public List<Point> points;

    public Figure(List<Point> points) {
        this.points = points;
    }

    public String toString() {
        String className = this.getClass().getSimpleName();
        String result = "My name is " + className + " points: ";
        for (var point : points) {
            result+=point +"; ";
        }
        return result;
    }

    protected double getPerimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            int temp = i + 1 < points.size() ? i + 1 : 0;
            perimeter += Math.sqrt(Math.pow(points.get(temp).getX() - points.get(i).getX(), 2) + Math.pow(points.get(temp).getY() - points.get(i).getY(), 2));
        }
        return  perimeter;
    }
    protected double getArea() {
        double area = 0;
        for (int i = 0; i < points.size(); i++) {
            int temp = i + 1 < points.size() ? i + 1 : 0;
             area += points.get(i).getX() * points.get(temp).getY() - points.get(i).getY() * points.get(temp).getX();
        }
            area = Math.abs(area/2);
        return area;
    }
}
