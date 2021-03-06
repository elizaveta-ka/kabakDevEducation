package com.company.Figures;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
@JsonAutoDetect
@NoArgsConstructor
public class Point implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected double x;
    protected double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String toString () {
        return "Point: " + this.getX() + ", " + this.getY();
    }

}
