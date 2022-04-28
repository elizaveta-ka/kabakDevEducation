package com.company.Figures.CreateFigures;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {
    JLabel jlabe;

    public ButtonDemo(JLabel jlabe) {
        this.jlabe = jlabe;
    }

    public JLabel getJlabel() {
        return jlabe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //код, после нажатия кнопки
        //обработка событий
        if(e.getActionCommand().equals("Создать фигуру"))
        jlabe.setText("кнопка отпущена");
        else jlabe.setText("кнопка нажата");
    }
}
