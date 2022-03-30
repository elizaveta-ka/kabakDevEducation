package com.company.Lesson5_DoubleArrays;

import com.company.Lesson4_arrays.Lesson4_1;

import java.util.Arrays;

public class Lesson5_6 {
    public static void main(String[] args) {
     // Отразите массив относительно его главной диагонали
        int [][] arrayTwo = Lesson5_1.inputArrayWithRandom(9,9,0,10);
        Lesson5_1.printArray(arrayTwo);
        System.out.println();
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if(j == i) {
                    System.out.print(arrayTwo[i][j] + " ");
                }
            }
        }
    }
}
