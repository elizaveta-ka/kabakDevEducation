package com.company.Figures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
public class Rectangle extends Figure {

    public Rectangle(List<Point> points) {
        super(points);
    }
    @Override
    public double getRadius() {
        return 0;
    }
}
