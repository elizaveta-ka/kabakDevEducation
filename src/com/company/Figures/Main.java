package com.company.Figures;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2,1);
        Point p2 = new Point(2,4);
        Point p3 = new Point(7,1);

//        System.out.println("Point p1: " + p1.getX() + " " + p1.getY());
//        printPoint(p1, 1);
//        printPoint(p2, 2);
//        printPoint(p3,3);
//        System.out.println(p1);
//        System.out.println(p2.toString());
//        System.out.println(p3.toString());


        axisPoint ax1 = new axisPoint(0,0);
        System.out.println(ax1);
        // Прямоугольник
        Rectangle r = new Rectangle(p1, p2, new Point(7,4),p3);
        System.out.println(r);
        System.out.println(Rectangle.getPerimeter(p1,p2,new Point(7,4), p3));
        System.out.println(Rectangle.getSquare(p1,p2,new Point(7,4), p3));

        // Треугольник
        Triangle triangle = new Triangle(p1,p2,p3);
        System.out.println(triangle);
        System.out.println(Triangle.getSquareTriangle(p1,p2,p3));
        System.out.println(Triangle.getPerimeterTriangle(p1,p2,p3));
    }
//    public static void printPoint (Point p, int number) {
//        System.out.println("Point p" + number + ": "+ p.getX() + " " + p.getY());
//    }
}
