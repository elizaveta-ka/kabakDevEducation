package com.company.Figures.CreateFigures;

import com.company.Figures.Figure;
import com.company.Figures.Point;

import java.util.List;
// Абстрактная фабрика (+abstract)

public  interface ICreator {
    public Figure createFigure(List<Point> points);
}
