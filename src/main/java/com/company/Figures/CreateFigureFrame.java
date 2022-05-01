package com.company.Figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateFigureFrame extends JFrame {
    private JButton buttonCreateCircle = new JButton("СОЗДАТЬ КРУГ");
    private JButton buttonCreateTriangle = new JButton("СОЗДАТЬ ТРЕУГОЛЬНИК");
    private JButton buttonCreateRectangle = new JButton("СОЗДАТЬ ЧЕТЫРЕХУГОЛЬНИК");
    private JButton buttonCreateNangle = new JButton("СОЗДАТЬ МНОГОУГОЛЬНИК");
    private JButton buttonComeback = new JButton("НАЗАД");  //new ImageIcon("pngwing.png"

    public CreateFigureFrame() {
        super("Figure frame");
        this.setTitle("СОЗДАТЬ ФИГУРУ");
        this.setVisible(true);
        this.setLocation(0,0);
        this.setSize(1400, 900);
        Container container2 = this.getContentPane();
        container2.setLayout(new BoxLayout(container2, BoxLayout.Y_AXIS));
        container2.add(buttonCreateCircle);
        container2.add(buttonCreateTriangle);
        container2.add(buttonCreateRectangle);
        container2.add(buttonCreateNangle);
//        buttonComeback.setMargin(new Insets(10,10,10,50));
//        buttonComeback.setIconTextGap(10);   //как уменьшить иконку и добавить?
        container2.add(buttonComeback);
        buttonCreateCircle.addActionListener(listener2);
    }
    ActionListener listener2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
}
