package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteObject {
    public static void main(String[] args) {
        Point p1 = new Point(2, 1);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(7, 1);
        Point p4 = new Point(7, 4);
        Point p5 = new Point(3,8);

        List<Point> points2 = new ArrayList<>(Arrays.asList(p1,p2,p3));
        List<Point> points3 = new ArrayList<>(Arrays.asList(p1,p2,p4,p3));
        FigureCreator creator2 = new FigureCreator();

        try {
            FileOutputStream fos = new FileOutputStream("figure.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(creator2.createFigure(points2));
            oos.writeObject(creator2.createFigure(points3));

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
