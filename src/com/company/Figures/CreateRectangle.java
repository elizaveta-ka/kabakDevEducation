package com.company.Figures;

import java.util.List;

public class CreateRectangle implements ICreator {

    @Override
    public Figure createFigure(List<Point> points) {
        return new Rectangle(points);
    }
}
