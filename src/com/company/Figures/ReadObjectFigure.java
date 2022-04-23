package com.company.Figures;

import java.io.*;
import java.util.ArrayList;

public class ReadObjectFigure {
    public static void main(String[] args) {
        ArrayList<Figure> figures = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("figuresArray.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            figures = (ArrayList<Figure>) ois.readObject();
        } catch (IOException ex) {
            System.out.println("Exception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Figure fig:figures) {
            System.out.println(fig);
        }
    }
}
