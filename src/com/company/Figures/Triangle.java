package com.company.Figures;

public class Triangle {
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
    public void getSquareTriangle() {
        double squareTriangle = ((j.getX() - e.getX()) * (f.getY() - e.getY())) / 2;
        System.out.println(squareTriangle);
    }
    public void getPerimeterTriangle() {
        double side1 = j.getX() - e.getX();
        double side2 = Math.sqrt(Math.pow((f.getX() - e.getX()), 2) + Math.pow(f.getY() - e.getY(), 2));
        double side3 = Math.sqrt(Math.pow((j.getX() - f.getX()), 2) + Math.pow(f.getY() - e.getY(), 2));
        double perimeterTriangle = side1 + side2 + side3;
        System.out.println(perimeterTriangle);
    }
}
