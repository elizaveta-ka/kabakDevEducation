package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonAutoDetect
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "type")
@JsonSubTypes(
        {@JsonSubTypes.Type (value = Triangle.class, name = "Triangle"),
                @JsonSubTypes.Type (value = Circle.class, name = "Circle"),
@JsonSubTypes.Type (value = Rectangle.class, name = "Rectangle")})
@JsonIgnoreProperties({"perimeter", "area", "radius"})
public abstract class Figure implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public List<Point> points;
    double radius;

    public  Figure() {

    }
    public Figure(List<Point> points) {
        this.points = points;
        this.radius = getRadius();
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

    public List<Point> getPoints() {
        return points;
    }

    public double getRadius() {
        Point a = points.get(0);
        Point b = points.get(1);
        double radius = Math.sqrt((Math.pow((b.getX() - a.getX()), 2)) + (Math.pow((b.getY() - a.getY()), 2)));
        return radius;
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

    protected void rotate(double angle) {
//        angle *= Math.PI / 180;
//        for (int i = 0; i < points.size(); i++) {
//            points.get(i).setX(((points.get(i).getX() - getCenterFigure().getX()) * Math.cos(angle) - (points.get(i).getY() - getCenterFigure().getY()) * Math.sin(angle)) + getCenterFigure().getX());
//            points.get(i).setY(((points.get(i).getY() - getCenterFigure().getY()) * Math.cos(angle) - (points.get(i).getY() - getCenterFigure().getY()) * Math.sin(angle)) + getCenterFigure().getY());
//        }
        List<Point> points = this.points;
        if (angle > 0 && angle < 360 && points.size() > 2) {
            Point center = this.getCenterFigure();
            double xC = center.getX();
            double yC = center.getY();
            points.replaceAll(x -> {double a = x.getX() - xC; double b = x.getY() - yC;
            x.setX(xC + a * Math.cos(Math.toRadians(angle)) - b * Math.sin(Math.toRadians(angle)));
            x.setY(yC + a * Math.sin(Math.toRadians(angle)) + b * Math.cos(Math.toRadians(angle)));
            return x;
            });
            this.points = points;
        }
        else if (points.size() == 2) System.out.println(" circle?");
        else System.out.println("error");
    }

    protected void move(double a, double b) {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).setX(points.get(i).getX() + a);
            points.get(i).setY(points.get(i).getY() + b);
        }
    }
//    public boolean containPoint(double x, double y, double multiplierX, double multiplierY) {
//        boolean flag = false;
//        for (int i = 0; i < this.getPoints().size(); i++) {
//            int j = i == this.getPoints().size() - 1 ? 0 : i + 1;
//            double x1 = this.getPoints().get(i).getX() * multiplierX;
//            double x2 = this.getPoints().get(j).getX() * multiplierX;
//            double y1 = this.getPoints().get(i).getY() * multiplierY;
//            double y2 = this.getPoints().get(j).getY() * multiplierY;
//            if(x2 - x1 != 0) {
//                double a = (y2 - y1) / (x2 - x1);
//                double b = y1 - a * x1;
//                if ((Math.abs(y - (a * x + b)) <= 2)) {
//                    flag = true;
//                } else {
//                    if ((Math.abs(x - x1) <= 2) && (y >= Math.min(y1,y2)) && y <= Math.max(y1,y2)) flag = true;
//                }
//            }
//        }
//        return flag;
//    }

    public boolean containPoint(double x, double y, int multiplierX, int multiplierY) {
        boolean flag = false;
        for (int i = 0; i < this.getPoints().size(); i++) {
            int j = i == this.getPoints().size() - 1 ? 0 : i + 1;
            double x1 = this.getPoints().get(i).getX() * multiplierX;
            double x2 = this.getPoints().get(j).getX() * multiplierX;
            double y1 = this.getPoints().get(i).getY() * multiplierY;
            double y2 = this.getPoints().get(j).getY() * multiplierY;
            if(x2 - x1 != 0) {
                double a = (y2 - y1) / (x2 - x1);
                double b = y1 - a * x1;
                if ((Math.abs(y - (a * x + b)) <= 2)) {
                    flag = true;
                } else {
                    if ((Math.abs(x - x1) <= 2) && (y >= Math.min(y1,y2)) && y <= Math.max(y1,y2)) flag = true;
                }
            }
        }
        return flag;
    }

//    public boolean containPoint(double x, double y) {
//        boolean flag = false;
//        for (int i = 0; i < this.getPoints().size(); i++) {
//            int j = i == this.getPoints().size() - 1 ? 0 : i + 1;
//            double x1 = this.getPoints().get(i).getX();
//            double x2 = this.getPoints().get(j).getX();
//            double y1 = this.getPoints().get(i).getY();
//            double y2 = this.getPoints().get(j).getY();
//            if(x2 - x1 != 0) {
//                double a = (y2 - y1) / (x2 - x1);
//                double b = y1 - a * x1;
//                if ((Math.abs(y - (a * x + b)) <= 2)) {
//                    flag = true;
//                } else {
//                    if ((Math.abs(x - x1) <= 2) && (y >= Math.min(y1,y2)) && y <= Math.max(y1,y2)) flag = true;
//                }
//            }
//        }
//        return flag;
//    }

    protected void scale(double num) {
        if(points.size() == 2) {
            points.get(1).setX(((points.get(1).getX() - points.get(0).getX())* num) + points.get(0).getX());
            points.get(1).setY(((points.get(1).getY() - points.get(0).getY())* num) + points.get(0).getY());
        } else {
            for (int i = 0; i < points.size(); i++) {
                points.get(i).setX(((points.get(i).getX() - getCenterFigure().getX()) * num) + getCenterFigure().getX());
                points.get(i).setY(((points.get(i).getY() - getCenterFigure().getY()) * num) + getCenterFigure().getY());
            }
        }
//        this.getPerimeter(); //?????????????????????????? ???????????????? ?? ??????????????
//        this.getArea();
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

//    protected Point getCenterFigure() {
//        ArrayList<Point> tmp = new ArrayList<>(this.points);
//        ArrayList<Point> centers = new ArrayList<>();
//            do {
//                centers.clear();
//                for (int i = 1; i < tmp.size() - 1; i++) {
//                    centers.add(getCenterTriangle(tmp.get(0), tmp.get(i), tmp.get(i + 1)));
//                }
//                tmp.clear();
//                tmp.addAll(centers);
//            } while (points.size() % 2 == 0 ? centers.size() != 2 : centers.size() != 3);
//
//            if (points.size() % 2 == 0) {
//                return getCenterLineSegment(centers.get(0), centers.get(1));
//            } else {
//                return getCenterTriangle(centers.get(0), centers.get(1), centers.get(2));
//            }
//    }
    protected Point getCenterFigure() {
        double x = 0;
        double y = 0;
            for (int i = 0; i < points.size(); i++) {
                x += points.get(i).getX();
                y += points.get(i).getY();
                 }
            x /= points.size();
            y/= points.size();
        return new Point(x,y);
}

        protected void sortPoints() {
//        ArrayList<Point> sortPoints = new ArrayList<>(points.size());
//        sortPoints.add(points.get(0));
//        for (int i = 0; i < points.size(); i++) {
//        if ((points.get(i+1).getX() > points.get(i).getX()) && (points.get(i+1).getY() > points.get(i).getY())) {
//            sortPoints.add(points.get(i+1));
//        } else if ()
//        }
    }
}
