package com.company.Lesson5_DoubleArrays;

public class Lesson5_11_ {
    public static void main(String[] args) {
        //Другое решение задачи 11
        //Максимальный элемент массива в левом верхнем углу
        int [][] arrayTwo = Lesson5_1.inputArrayWithRandom(9,9,0,10);
        Lesson5_1.printArray(arrayTwo);
        for (int i = 1; i < arrayTwo.length; i++) {
            for (int j = 1; j < arrayTwo[0].length; j++) {
                if (arrayTwo[0][0] < arrayTwo[i][j]) {
                    int tmp = arrayTwo[0][0];
                    arrayTwo[0][0] = arrayTwo[i][j];
                    arrayTwo[i][j] = tmp;
                }
            }
        }
        System.out.println();
        Lesson5_1.printArray(arrayTwo);
            //Минимальный элемент массива в правом нижнем углу
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (arrayTwo[i][j] < arrayTwo[arrayTwo.length-1][arrayTwo[0].length-1]) {
                    int tmp = arrayTwo[arrayTwo.length-1][arrayTwo[0].length-1];
                    arrayTwo[arrayTwo.length-1][arrayTwo[0].length-1] = arrayTwo[i][j];
                    arrayTwo[i][j] = tmp;
                }
            }
        }
        System.out.println();
        Lesson5_1.printArray(arrayTwo);
    }
}
