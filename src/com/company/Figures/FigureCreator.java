package com.company.Figures;

import java.util.List;

public class FigureCreator implements ICreator {

    @Override
    public Figure createFigure(List<Point> points) {
        int nPoints = points.size();
        ICreator creator;
        if (nPoints == 2) creator = new CreateCircle();
        else if (nPoints == 3) creator = new CreateTriangle();
        else if (nPoints ==4) creator = new CreateRectangle();
        else if (nPoints > 4) creator = new CreateNangle();
        else return null;
        return creator.createFigure(points);
    }
}
