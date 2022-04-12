package com.company.Figures.CreateFigures;

import com.company.Figures.Circle;
import com.company.Figures.Figure;
import com.company.Figures.Point;

import java.util.List;

public class CreateCircle implements ICreator {
    @Override
    public Figure createFigure(List<Point> points) {
        return new Circle(points);
    }
}
