package com.company.Figures;

import com.company.Figures.CreateFigures.FigureCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONHomeWork {
    public static void main(String[] args) throws IOException {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(2, 0);
        Point p5 = new Point(3, 2);
        ArrayList<Figure> figures = new ArrayList<>();
        FigureCreator creator = new FigureCreator();
        figures.add(creator.createFigure(Arrays.asList(p1, p2)));
        figures.add(creator.createFigure(Arrays.asList(p1, p2, p3)));
        figures.add(creator.createFigure(Arrays.asList(p1, p2, p3, p4)));
        figures.add(creator.createFigure(Arrays.asList(p1, p2, p3, p4, p5)));

        FiguresList figuresList = new FiguresList();
        figuresList.figures = figures;

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        BufferedWriter bwr = new BufferedWriter(new FileWriter("Json.json"));

        mapper.writeValue(writer,figuresList);
        bwr.write(writer.toString());
        bwr.close();

        BufferedReader reader = new BufferedReader(new FileReader("Json.json"));
        String json = reader.readLine();
        FiguresList figuresList1 = mapper.readValue(json,FiguresList.class);
        for (var f:figuresList1.figures) {
            System.out.println(f);
        }
        reader.close();
    }
}
