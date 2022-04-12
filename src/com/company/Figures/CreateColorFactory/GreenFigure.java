package com.company.Figures.CreateColorFactory;

import com.company.Figures.Point;

import java.util.List;

public class GreenFigure implements IPaintFigure {
    @Override
    public String paintFigure(List<Point> points) {
        return "My color is green ";
    }

//    @Override
//    public String paintFigure(List<Point> points) {
//        FigureCreator cr = new FigureCreator();
////        cr.createFigure(points);
//        return "Green is my color " + cr.createFigure(points);
//    }

}
