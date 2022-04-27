package com.company.Figures;

import jdk.swing.interop.SwingInterOpUtils;

import java.awt.*;
import java.awt.color.ColorSpace;

import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;

public class ExampleAWT {
    public static void main(String[] args) {
        for (String s : Toolkit.getDefaultToolkit().getFontList()) {
            System.out.println(s);
        }
        getLocalGraphicsEnvironment();


    }

}
