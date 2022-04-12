package com.company.Figures.CreateFigures;

import com.company.Figures.Figure;
import com.company.Figures.Point;
import com.company.Figures.Triangle;

import java.util.List;

public class CreateTriangle implements ICreator {
    @Override
    public Figure createFigure(List<Point> points) {
        return new Triangle(points);
    }
}
