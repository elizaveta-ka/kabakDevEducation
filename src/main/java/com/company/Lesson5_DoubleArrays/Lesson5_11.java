package com.company.Lesson5_DoubleArrays;

public class Lesson5_11 {
    public static void main(String[] args) {
        int[][] arrayTwo = Lesson5_1.inputArrayWithRandom(9, 9, 0, 10);
        Lesson5_1.printArray(arrayTwo);
        int min = arrayTwo[0][0];
        boolean flag = false;
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (arrayTwo[i][j] < min) {
                    min = arrayTwo[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("Находим минимальный элемент массива");
        System.out.println(min);
        int tmp = arrayTwo[arrayTwo.length-1][arrayTwo[0].length-1];
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (arrayTwo[i][j] == min) {
                    arrayTwo[i][j] = tmp;
                    arrayTwo[arrayTwo.length-1][arrayTwo[0].length-1] = min;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
            System.out.println();
            System.out.println("Массив изменен. Минимальный элемент в нижнем правом углу");
            Lesson5_1.printArray(arrayTwo);
         //Максимальный элемент в левоми верхнем углу.
        int max = arrayTwo[0][0];
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (arrayTwo[i][j] > max) {
                    max = arrayTwo[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("Находим максимальный элемент массива");
        System.out.println(max);
        int tmp2 = arrayTwo[0][0];
        for (int i = 0; i < arrayTwo.length ; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if(arrayTwo[i][j] == max) {
                    arrayTwo[0][0] = max;
                    arrayTwo[i][j] = tmp2;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        System.out.println();
        System.out.println("Массив изменен. Максимальный элемент в левом верхнем углу");
        Lesson5_1.printArray(arrayTwo);
    }
}
