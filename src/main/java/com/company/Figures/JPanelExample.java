package com.company.Figures;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelExample extends JPanel {
    private ArrayList<Figure> figures;
//    public static void awt () {
//        Point p1 = new Point(0, 0);
//        Point p2 = new Point(0, 2);
//        Point p3 = new Point(2, 2);
//        Point p4 = new Point(2, 0);
//        Point p5 = new Point(3,2);
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//        frame.setSize(1400,900);
////        frame.getContentPane().add(new JPanelExample());
//        frame.setVisible(true);
//        frame.setTitle("Окошечко");
//    }
    public JPanelExample(ArrayList<Figure> figures) {
        super();
        this.figures = figures;
    }

    public void paint(Graphics g) {
        for (var f:figures) {
            if (f.getPoints().size() == 2) {
                g.drawOval((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) (f.getRadius() * 2), (int) (f.getRadius() * 2));
            } else {
            for (int i = 0; i < f.getPoints().size(); i++) {
                    Point value1 = f.getPoints().get(i);
                    int temp = i + 1 < f.getPoints().size() ? i + 1 : 0;
                    Point value2 = f.getPoints().get(temp);
                    g.drawLine((int) value1.getX(), (int) value1.getY(), (int) value2.getX(), (int) value2.getY());
                }
            }
        }
    }
}
