package com.company.Figures;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Circle extends Figure {

    public Circle(List<Point> points) {
        super(points);
//        this.radius = getRadius();
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * Math.PI * getRadius();
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = Math.PI * Math.pow(getRadius(), 2);
        return area;
    }

    public void rotate(double angle) {
        System.out.println("");
    }

    public Point getCenterFigure() {
        double x = points.get(0).getX();
        double y = points.get(0).getY();
        return new Point(x, y);
    }

    @Override
    public boolean containPoint(double x, double y, int multiplierX, int multiplierY) {
        this.getCenterFigure();
        int multiplier = Math.min(multiplierX,multiplierY);
        double distance = Math.sqrt((Math.pow(x - this.getCenterFigure().getX() * multiplier, 2))
                + Math.pow(y - this.getCenterFigure().getY() * multiplier, 2));
        return (Math.abs(distance) <= radius * multiplier);
    }
}
