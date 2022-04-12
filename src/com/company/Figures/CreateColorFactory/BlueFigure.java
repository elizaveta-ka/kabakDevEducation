package com.company.Figures.CreateColorFactory;

import com.company.Figures.Point;

import java.util.List;

public class BlueFigure implements IPaintFigure {
    @Override
    public String paintFigure(List<Point> points) {
        return "My color is blue ";
    }
}
