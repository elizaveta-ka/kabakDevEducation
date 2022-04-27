package com.company.Lesson5_DoubleArrays;

public class Lesson5_4 {
    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        int [][] arrayTwo = Lesson5_1.inputArrayWithRandom(n,m,0,10);
        Lesson5_1.printArray(arrayTwo);
        int max = arrayTwo[0][0];
        for (int[] ints : arrayTwo) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (ints[j] > max) {
                    max = ints[j];
                }
            }
        }
        System.out.println();
        System.out.println(max);
        for (int i = 0; i < arrayTwo.length ; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if(arrayTwo[i][j] == max) {
                    System.out.print("Все индексы максимального элемента: " + i + " ");
                    System.out.println(j);           // все индексы
                }
            }
        }
        int maxIndexN = 0;
        int maxIndexM = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrayTwo[i][j] > arrayTwo[maxIndexN][maxIndexM]) {
                    maxIndexN = i;
                    maxIndexM = j;
                }
            }
        }
        System.out.println("Индекс первого найденного максимального: " + maxIndexN + " " + maxIndexM);
    }
}
