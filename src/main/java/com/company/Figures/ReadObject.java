package com.company.Figures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("figure.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Figure figure1 = (Figure) ois.readObject();
            Figure figure2 = (Figure) ois.readObject();
            System.out.println(figure1);
            System.out.println(figure2);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
