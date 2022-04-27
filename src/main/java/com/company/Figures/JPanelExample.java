package com.company.Figures;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JPanelExample extends JPanel {
    private ArrayList<Figure> figures;
    public static void awt () {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(2, 2);
        Point p4 = new Point(2, 0);
        Point p5 = new Point(3,2);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1400,900);
//        frame.getContentPane().add(new JPanelExample());
        frame.setVisible(true);
        frame.setTitle("Окошечко");
    }
    public JPanelExample(ArrayList<Figure> figures) {
        super();
        this.figures = figures;
    }
    public void paint(Graphics g) {
        for (var f:figures) {
            for (int i = 0; i < f.getPoints().size()-1; i++) {
                g.drawLine((int) f.getPoints().get(i).getX(), (int) f.getPoints().get(i).getY(), (int) f.getPoints().get(i+1).getX(), (int) f.getPoints().get(i+1).getY());
            }
            g.drawLine((int) f.getPoints().get(0).getX(), (int) f.getPoints().get(0).getY(), (int) f.getPoints().get(f.getPoints().size()-1).getX(), (int) f.getPoints().get(f.getPoints().size()-1).getY());

        }
//        g.setColor(Color.BLACK);
//        g.fillRect(10,10,60,50);
    }
}
