package com.company.Figures;

import java.util.List;
// Абстрактная фабрика (+abstract)

public abstract interface ICreator {
    public Figure createFigure(List<Point> points);
}
