package com.company.Figures.CreateColorFactory;

import com.company.Figures.CreateColorFactory.IPaintFigure;
import com.company.Figures.Point;

import java.util.List;

public class RedFigure implements IPaintFigure {
    @Override
    public String paintFigure(List<Point> points) {
        return "My color is red ";
    }
//    @Override
//    public String paintFigure(List<Point> points) {
//        FigureCreator cr = new FigureCreator();
////        cr.createFigure(points);
//        return "Red is my color " + cr.createFigure(points);
//    }

}
