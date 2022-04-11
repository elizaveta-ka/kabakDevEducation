package com.company.Figures;

import java.util.List;

public class CreateNangle implements ICreator {
    @Override
    public Figure createFigure(List<Point> points) {
        return new NAngle(points);
    }
}
