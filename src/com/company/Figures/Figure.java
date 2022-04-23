package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public abstract class Figure implements Serializable {
    public List<Point> points;

    public Figure(List<Point> points) {
        this.points = points;
    }

    public String paintFigure(String color) {
        return "Figure is colored " + color;
    }

    public String toString() {
        String className = this.getClass().getSimpleName();
        StringBuilder result = new StringBuilder("My name is " + className + " points: ");
        for (var point : points) {
            result.append(point).append("; ");
        }
        return result.toString();
    }

    protected double getPerimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            int temp = i + 1 < points.size() ? i + 1 : 0;
            perimeter += Math.sqrt(Math.pow(points.get(temp).getX() - points.get(i).getX(), 2) + Math.pow(points.get(temp).getY() - points.get(i).getY(), 2));
        }
        return perimeter;
    }

    protected double getArea() {
        double area = 0;
        for (int i = 0; i < points.size(); i++) {
            int temp = i + 1 < points.size() ? i + 1 : 0;
            area += points.get(i).getX() * points.get(temp).getY() - points.get(i).getY() * points.get(temp).getX();
        }
        area = Math.abs(area / 2);
        return area;
    }

    protected void rotate(Point m, double angle) {
        double angleRadian = angle * Math.PI / 180;
        for (int i = 0; i < points.size(); i++) {
            if ((m.getX() == points.get(i).getX()) && (m.getY() == points.get(i).getY())) {
                continue;
            } else {
                points.get(i).setX((points.get(i).getX() - m.getX() * Math.cos(angleRadian)) - (points.get(i).getY() - m.getY() * Math.sin(angleRadian)) + m.getX());
                points.get(i).setY((points.get(i).getX() - m.getX() * Math.sin(angleRadian)) - (points.get(i).getY() - m.getY() * Math.cos(angleRadian)) + m.getY());
            }
        }
    }

    protected void move(int a, int b) {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setX(points.get(i).getX() + a);
            points.get(i).setY(points.get(i).getY() + b);
        }
    }

    protected void scale(int num) {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setX(points.get(i).getX() * num);
            points.get(i).setY(points.get(i).getY() * num);
            //увеличить от центра
        }
    }

    protected static Point getCenterTriangle(Point a, Point b, Point c) {
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(x, y);
    }

    protected static Point getCenterLineSegment(Point a, Point b) {
        double x = (a.getX() + b.getX()) / 2;
        double y = (a.getY() + b.getY()) / 2;
        return new Point(x, y);
    }

    protected Point getCenterFigure() {
        ArrayList<Point> tmp = new ArrayList<>(points);
        ArrayList<Point> centers = new ArrayList<>();

        do {
            centers.clear();

            for (int i = 1; i < tmp.size() - 1; i++) {
                centers.add(getCenterTriangle(tmp.get(0), tmp.get(i), tmp.get(i + 1)));
            }
            tmp.clear();
            tmp.addAll(centers);
        } while (points.size() % 2 == 0 ? centers.size() != 2 : centers.size() != 3);

        if (points.size() % 2 == 0) {
            return getCenterLineSegment(centers.get(0), centers.get(1));
        } else {
            return getCenterTriangle(centers.get(0), centers.get(1), centers.get(2));
        }
    }
//    protected void sortPoints() {
//        for (int i = 0; i < points.size(); i++) {
//
//        }
    }
}
