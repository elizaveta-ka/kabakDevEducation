package com.company.Lesson5_DoubleArrays;

public class Lesson5_3 {
    public static void main(String[] args) {
        int [][] arrayTwo = Lesson5_1.inputArrayWithRandom(9,9,0,10);
        Lesson5_1.printArray(arrayTwo);
        int min = arrayTwo[0][0];
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (arrayTwo[i][j] < min) {
                    min = arrayTwo[i][j];
                }
            }
        }
        System.out.println();
        System.out.println(min);
        for (int i = 0; i < arrayTwo.length ; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if(arrayTwo[i][j] == min) {
                    System.out.print(i + " ");
                    System.out.println(j);           // все индексы
                }
            }
        }
    }
}
