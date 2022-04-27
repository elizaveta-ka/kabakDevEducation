package com.company.Figures;
//
//
//import com.company.Figures.CreateColorFactory.CreateColorFactory;
//import com.company.Figures.CreateFigures.FigureCreator;

import com.company.Figures.CreateFigures.FigureCreator;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import javax.xml.crypto.Data;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.TransformException;
import java.awt.*;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Point p1 = new Point(0, 0);
//        Point p2 = new Point(0, 2);
//        Point p3 = new Point(2, 2);
//        Point p4 = new Point(2, 0);
//        Point p5 = new Point(3,2);
//         Для прямоугольника
//        List<Point> points = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
//        Figure rectangle = new Rectangle(points);
////
//        System.out.println(rectangle);
//        System.out.println(rectangle.getPerimeter());
//        System.out.println(rectangle.getArea());
//        //Перемещение
//        rectangle.move(2,-3);
//        System.out.println(rectangle);
        //Масштабирование
//        rectangle.scale(2);
//        System.out.println(rectangle.getPerimeter());
//        //Поворот
//        FigureCreator creator = new FigureCreator();
//        Figure figure = creator.createFigure(points);
//        System.out.println(figure);
//        Point center = figure.getCenterFigure();
//        System.out.println(center);
//        rectangle.rotate(180);
//        System.out.println(rectangle);

        //JSON


//
        // Для треугольника
//        List<Point> points1 = new ArrayList<>(Arrays.asList(p1, p2, p3));
//
//        Figure triangle = new Triangle(points1);
//        System.out.println(triangle);
//        System.out.println(triangle.getPerimeter());
//        System.out.println(triangle.getArea());
//

        // Для круга
//        List<Point> points3 = new ArrayList<>(Arrays.asList(p1, p2));
//        Figure circle = new Circle(points3);
//        System.out.println(circle);
//        System.out.println(circle.getPerimeter());
//        System.out.println(circle.getArea());
//        circle.move(2,3);
//        System.out.println(circle);
//        circle.scale(2);
//        System.out.println(circle.getPerimeter());

//
//        List<Point> points4 = new ArrayList<>(Arrays.asList(p1,p2,p3));
//        FigureCreator creator = new FigureCreator();
//        System.out.println(creator.createFigure(points4));
//        System.out.println(creator.createFigure(points4).paintFigure("blue"));
//
//        Circle cir = new Circle(p1,p2);
//        System.out.println(cir);
//        cir.printPerimeter();
//        cir.printArea();

        // List
//        int n = 5;
//        Point [] pointsArr = new Point[n];
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            pointsArr[i] = new Point( - 3 + (n /2 - i) * random.nextInt(0, 5), -2 + random.nextInt(-2, 2));
//        }
//

        // Реализация односвязного списка:

//        Array_list list = new Array_list();
//        list.add(5);
//        list.add(5);
//        list.add(2);
//        list.add(3);
//
//        list.remove(5);
//
//        list.print();


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


//    public static void printPoint (Point p, int number) {
//        System.out.println("Point p" + number + ": "+ p.getX() + " " + p.getY());
//    }
        //JPANEL

        Point p1 = new Point(100, 100);
        Point p2 = new Point(200, 200);
        Point p3 = new Point(300, 200);

        Point p4 = new Point(400, 200);
        Point p5 = new Point(400, 400);
        Point p6 = new Point(500, 400);
        Point p7 = new Point(500, 200);

        Point p8 = new Point(600, 200);
        Point p9 = new Point(600, 400);
        Point p10 = new Point(700, 500);
        Point p11 = new Point(800, 400);
        Point p12 = new Point(800, 200);

        Point p13 = new Point(100, 400);
        Point p14 = new Point(200, 300);


        ArrayList<Figure> figures = new ArrayList<>();
        FigureCreator creator = new FigureCreator();
        figures.add(creator.createFigure(Arrays.asList(p13, p14)));
        figures.add(creator.createFigure(Arrays.asList(p1, p2, p3)));
        figures.add(creator.createFigure(Arrays.asList(p4,p5,p6,p7)));
        figures.add(creator.createFigure(Arrays.asList(p8, p9, p10, p11, p12)));

        JPanelExample jPanelExample = new JPanelExample(figures);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setTitle("Рисуем фигуры");
        frame.setBackground(Color.gray);
        frame.setVisible(true);
        frame.add(jPanelExample);

//        Button createFigure = new Button("СОЗДАТЬ ФИГУРУ");
//        createFigure.setBackground(Color.ORANGE);
//        createFigure.setVisible(true);
//        createFigure.setBounds(100,100,100,100);
//        createFigure.setSize(250,250);
//        frame.add(createFigure);
    }
}
