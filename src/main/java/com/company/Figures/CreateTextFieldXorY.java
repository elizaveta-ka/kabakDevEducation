package com.company.Figures;

import javax.swing.*;
import java.awt.*;

public class CreateTextFieldXorY extends JFrame {
    private JButton buttonCancel = new JButton("отмена");

    private JButton buttonAdd = new JButton("Добавить");
    private JLabel labelX = new JLabel("введите x:");
    private JLabel labelY = new JLabel("введите y:");


    private JTextField textX = new JTextField();
    private JTextField textY = new JTextField();
    public CreateTextFieldXorY() {
        super();
        this.setTitle("СОЗДАТЬ");
        this.setVisible(true);
        this.setLocation(0,0);
        this.setSize(1400, 900);
        Container container3 = this.getContentPane();
        container3.add(labelX);
        container3.add(textX);
        container3.add(labelY);
        container3.add(textY);
        container3.add(buttonAdd);
        container3.add(buttonCancel);


    }

}
