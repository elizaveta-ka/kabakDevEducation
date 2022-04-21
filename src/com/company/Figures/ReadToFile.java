package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadToFile {
    public static void main(String[] args) throws IOException {
        File file = new File("testFile");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str;
        ArrayList<Point> pointsList = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            String figureName = str.substring(0,str.indexOf(":"));
            figureName = figureName.substring(11, figureName.indexOf("points")).trim();
            String point = str.substring(str.indexOf(":") + 1).trim();
            String [] strPoint = point.split(";");
            for (var p: strPoint) {
                p = p.substring(7).trim();
                String[] coordinates = p.split(",");
                double x = Double.parseDouble(coordinates[0].trim());
                double y = Double.parseDouble(coordinates[1].trim());
                Point pointNew = new Point(x, y);
                pointsList.add(pointNew);
            }
            System.out.println(figureName);
            FigureCreator create = new FigureCreator();
            System.out.println(create.createFigure(pointsList));
            System.out.println(create.createFigure(pointsList).paintFigure("blue"));
            System.out.println(create.createFigure(pointsList).getPerimeter());
            System.out.println(create.createFigure(pointsList).getArea());
        }
    }
}
