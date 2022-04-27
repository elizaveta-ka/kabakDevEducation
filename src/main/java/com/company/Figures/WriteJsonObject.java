package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteJsonObject {
    public static void main(String[] args) throws IOException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(2, 0);
        Point p5 = new Point(3, 2);
//        FigureCreator creator = new FigureCreator();
//        Figure figure1 = creator.createFigure(Arrays.asList(p1,p2));
//        Figure figure2 = creator.createFigure(Arrays.asList(p1,p2,p3));
//        Figure figure3 = creator.createFigure(Arrays.asList(p1,p2,p3,p4));
//        Figure figure4 = creator.createFigure(Arrays.asList(p1,p2,p3,p4,p5));
        Circle figure1 = new Circle(Arrays.asList(p1, p2));
        Triangle figure2 = new Triangle(Arrays.asList(p1, p2, p3));
        Rectangle figure3 = new Rectangle(Arrays.asList(p1, p2, p3, p4));
        NAngle figure4 = new NAngle(Arrays.asList(p1, p2, p3, p4, p5));
        ArrayList<Figure> figures = new ArrayList<>(Arrays.asList(figure1, figure2, figure3, figure4));

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();

        for (var f:figures) {
        mapper.writeValue(writer,f);
        writer.write("\n");
        }

        BufferedWriter bwr = new BufferedWriter(new FileWriter("JsonForExample.json"));
        bwr.write(writer.toString());
        bwr.close();
    }
}
