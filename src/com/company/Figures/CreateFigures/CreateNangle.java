package com.company.Figures.CreateFigures;

import com.company.Figures.Figure;
import com.company.Figures.NAngle;
import com.company.Figures.Point;

import java.util.List;

public class CreateNangle implements ICreator {
    @Override
    public Figure createFigure(List<Point> points) {
        return new NAngle(points);
    }
}
