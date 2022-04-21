package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("testFile");
        PrintWriter pw = new PrintWriter(file);

        Point p1 = new Point(2, 1);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(7, 1);
        Point p4 = new Point(7, 4);
        Point p5 = new Point(3,8);

//        List<Point> points1 = new ArrayList<>(Arrays.asList(p1,p2));
//        FigureCreator creator1 = new FigureCreator();
//        String nameFigure1 = String.valueOf(creator1.createFigure(points1));
//        pw.println(nameFigure1);
//
        List<Point> points2 = new ArrayList<>(Arrays.asList(p1,p2,p3));
        FigureCreator creator2 = new FigureCreator();
        String nameFigure2 = String.valueOf(creator2.createFigure(points2));
        pw.println(nameFigure2);

//        List<Point> points3 = new ArrayList<>(Arrays.asList(p1,p2,p4,p3));
//        FigureCreator creator3 = new FigureCreator();
//        String nameFigure3 = String.valueOf(creator3.createFigure(points3));
//        pw.println(nameFigure3);

//        List<Point> points4 = new ArrayList<>(Arrays.asList(p1,p2,p4,p3,p5));
//        FigureCreator creator4 = new FigureCreator();
//        String nameFigure4 = String.valueOf(creator4.createFigure(points4));
//        pw.println(nameFigure4);

        pw.close();
    }
}
