package com.company.Figures.CreateColorFactory;

import com.company.Figures.CreateColorFactory.IPaintFigure;
import com.company.Figures.Point;

import java.util.List;

public class YellowFigure implements IPaintFigure {
    @Override
    public String paintFigure(List<Point> points) {
        return "My color is yellow ";
    }
}
