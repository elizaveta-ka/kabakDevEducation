package com.company.Figures;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadToFile {
    public static void main(String[] args) throws IOException {
        File file = new File("testFile");
        FileReader fr = new FileReader(file);
        int c;
        while ((c = fr.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
