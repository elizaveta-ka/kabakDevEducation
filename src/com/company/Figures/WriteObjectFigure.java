package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteObjectFigure {
    public static void main(String[] args) {
        Point p1 = new Point(2, 1);
        Point p2 = new Point(2, 4);
        Point p3 = new Point(7, 1);
        Point p4 = new Point(7, 4);
        Point p5 = new Point(3,8);
        FigureCreator creator = new FigureCreator();
        Figure figure1 = creator.createFigure(Arrays.asList(p1,p2));
        Figure figure2 = creator.createFigure(Arrays.asList(p1,p2,p3));
        Figure figure3 = creator.createFigure(Arrays.asList(p1,p2,p3,p4));
        Figure figure4 = creator.createFigure(Arrays.asList(p1,p2,p3,p4,p5));
        ArrayList<Figure> figures = new ArrayList<>(Arrays.asList(figure1,figure2,figure3,figure4));

//        try (FileOutputStream fos = new FileOutputStream("figuresArray.bin");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(figures);
//
//        } catch (IOException ex) {
//            System.out.println("Exception");
//        }
        try (FileOutputStream fos = new FileOutputStream("figuresArray.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (int i = 0; i < figures.size(); i++) {
                oos.writeObject(figures.get(i));
            }

        } catch (IOException ex) {
            System.out.println("Exception");
        }

    }
}
