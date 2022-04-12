package com.company.Figures.CreateFigures;

import com.company.Figures.Figure;
import com.company.Figures.Point;
import com.company.Figures.Rectangle;

import java.util.List;

public class CreateRectangle implements ICreator {

    @Override
    public Figure createFigure(List<Point> points) {
        return new Rectangle(points);
    }
}
