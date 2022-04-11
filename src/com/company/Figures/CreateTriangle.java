package com.company.Figures;

import java.util.List;

public class CreateTriangle implements ICreator {
    @Override
    public Figure createFigure(List<Point> points) {
        return new Triangle(points);
    }
}
