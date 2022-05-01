//package com.company.Figures;
//
//import javafx.fxml.Initializable;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.shape.Line;
//
//import java.awt.*;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class DrawFigures {
//    private ArrayList<Figure> figures;
//    public Canvas mainCanvas;
//
//    public DrawFigures(ArrayList<Figure> figures) {
//        this.figures = figures;
//    }
//    public void paint(GraphicsContext g) {
//        for (var f:figures) {
////            if (f.getPoints().size() == 2) {
////                g.drawOval((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) (f.getRadius() * 2), (int) (f.getRadius() * 2));
////            } else {
//                for (int i = 0; i < f.getPoints().size(); i++) {
//                    Point value1 = f.getPoints().get(i);
//                    int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
//                    Point value2 = f.getPoints().get(temp);
//                    new Line((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
//                }
//            }
//        }
////    }
//}
