package com.company.Figures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUIProject extends JFrame {
    private JButton buttonCreateFigure = new JButton("СОЗДАТЬ ФИГУРУ");
    private JButton buttonDeleteFigure = new JButton("УДАЛИТЬ ФИГУРУ");
    private JButton buttonRotateFigure = new JButton("ПОВОРОТ ФИГУРЫ");
    private JButton buttonScaleFigure = new JButton("МАСШТАБИРОВАНИЕ ФИГУРЫ");
    private JButton buttonMoveFigure = new JButton("ДВИЖЕНИЕ ФИГУРЫ");
    private JButton buttonPrintAllFigures = new JButton("ВЫВЕСТИ ВСЕ СОЗДАННЫЕ ФИГУРЫ");



//    private JButton buttonCreateCircle = new JButton("СОЗДАТЬ КРУГ");
//    private JButton buttonCreateTriangle = new JButton("СОЗДАТЬ ТРЕУГОЛЬНИК");
//    private JButton buttonCreateRectangle = new JButton("СОЗДАТЬ ЧЕТЫРЕХУГОЛЬНИК");
//    private JButton buttonCreateNangle = new JButton("СОЗДАТЬ МНОГОУГОЛЬНИК");

    private JButton button7 = new JButton();
    private JButton buttonYes = new JButton("YES");
    private JButton buttonNo = new JButton("NO");
    private JButton buttonCancel = new JButton("отмена");

    private JButton buttonAdd = new JButton("Добавить");
    private JLabel labelX = new JLabel("введите x:");
    private JLabel labelY = new JLabel("введите y:");


    private JTextField textX = new JTextField();
    private JTextField textY = new JTextField();


    public SimpleGUIProject() {
        super("Simple Project");
        this.setBackground(Color.GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Рисуем фигуры");
        this.setVisible(true);
        this.setLocation(0,0);
        this.setSize(1400, 900);
//    this.getContentPane().setLayout(null);
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        buttonCreateFigure.addActionListener(listener1);
        container.add(buttonCreateFigure);
        container.add(buttonDeleteFigure);
        container.add(buttonRotateFigure);
        container.add(buttonScaleFigure);
        container.add(buttonMoveFigure);
        container.add(buttonPrintAllFigures);
        buttonCreateFigure.setRolloverIcon(new ImageIcon("images/cut.png" ));
//        buttonCreateFigure.setBorderPainted(false); // убрать область кнопки, выглядит как текст.
        buttonCreateFigure.setFocusPainted(false);  //// убрать рамку кнопки

    }
    ActionListener listener1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CreateFigureFrame createFigureFrame = new CreateFigureFrame();
            createFigureFrame.setVisible(true);
        }
    };
}
