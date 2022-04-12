package com.company.Figures.CreateColorFactory;

import com.company.Figures.*;

import java.util.List;

public class CreateColorFactory implements IPaintFigure {

    @Override
    public String paintFigure(List<Point> points) {
        int nPoint = points.size();
        IPaintFigure paintFigure;
        if (nPoint == 2) paintFigure = new RedFigure();
        else if (nPoint == 3) paintFigure = new GreenFigure();
        else if (nPoint == 4) paintFigure = new BlueFigure();
        else if (nPoint > 4) paintFigure = new YellowFigure();
        else return null;
        return paintFigure.paintFigure(points);
    }
}
