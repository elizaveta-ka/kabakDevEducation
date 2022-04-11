package com.company.Figures;

import java.util.List;

public class CreateCircle implements ICreator {
    @Override
    public Figure createFigure(List<Point> points) {
        return new Circle(points);
    }
}
