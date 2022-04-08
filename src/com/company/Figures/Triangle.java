package com.company.Figures;

import java.util.Arrays;

public class Triangle extends Figure {
    private Point e;
    private Point f;
    private Point j;

    public Point getE() {
        return e;
    }

    public Point getF() {
        return f;
    }

    public Point getJ() {
        return j;
    }

    public Triangle(Point e, Point f, Point j) {
        this.e = e;
        this.f = f;
        this.j = j;
    }
    public String toString () {
        return "Hello! I'm triangle: " + "e = " + e + "; f = " + f + "; j = " + j;
    }
        @Override
        public double getArea() {
            return super.getArea(Arrays.asList(e, f, j));
        }
        @Override
        public double getPerimeter() {
          return super.getPerimeter(Arrays.asList(e, f, j));
         }
        public void printArea() {
        System.out.println("My area is " + getArea());
        }
         public void printPerimeter() {
        System.out.println("My perimeter is " + getPerimeter());
        }
}
