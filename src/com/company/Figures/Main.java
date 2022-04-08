package com.company.Figures;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new Point(2,1);
        Point p1 = new Point(2,1);
        Point p2 = new Point(2,4);
        Point p3 = new Point(7,1);
        Point p4 = new Point(7,4);
        Rectangle rectangle = new Rectangle(p1, p2, p4, p3);
        System.out.println(rectangle);
        rectangle.printPerimeter();
        rectangle.printArea();

        Triangle triangle1 = new Triangle(p1,p2,p3);
        System.out.println(triangle1);
        triangle1.printPerimeter();
        triangle1.printArea();


        Circle circle = new Circle(p1,p2);
        System.out.println(circle);
        circle.printPerimeter();
        circle.printArea();












//        System.out.println("Point p1: " + p1.getX() + " " + p1.getY());
//        printPoint(p1, 1);
//        printPoint(p2, 2);
//        printPoint(p3,3);
//        System.out.println(p1);
//        System.out.println(p2.toString());
//        System.out.println(p3.toString());

//
//        axisPoint ax1 = new axisPoint(0,0);
//        System.out.println(ax1);
//       // Прямоугольник
//        Rectangle r = new Rectangle(p1, p2, new Point(7,4),p3);
//        System.out.println(r);
//        r.getPerimeter();
//        r.getArea();
//
//        // Треугольник
//        Triangle triangle = new Triangle(p1,p2,p3);
//        System.out.println(triangle);
////        triangle.getPerimeter();
//        triangle.getArea();
////
//        Figure f1 = new Triangle(p1,p2,p3);
//        Figure f2 = new Rectangle(p1,p2,p3,new Point(7,1));
////        Figure f3 = new Figure();    //Мы не можем созхдать объект этого класса, так как класс абстрактный
//        //f1 и f2 - создаем конкретные фигуры.
//        Figure f4 = (Figure) triangle;  // Привели треугольник к фигуре.
//        ((Triangle) f4).getPerimeter(); // Фигуру обратно к треугольнику привели. Перед этим нужно проверить:
//        //точно ли это треугольник(может это четырехугольник).
//
//

    }
//    public static void printPoint (Point p, int number) {
//        System.out.println("Point p" + number + ": "+ p.getX() + " " + p.getY());
//    }
}
