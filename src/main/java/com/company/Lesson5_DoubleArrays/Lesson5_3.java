package com.company.Lesson5_DoubleArrays;

public class Lesson5_3 {
    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        int [][] arrayTwo = Lesson5_1.inputArrayWithRandom(n,m,0,10);
        Lesson5_1.printArray(arrayTwo);
        int min = arrayTwo[0][0];
        for (int[] ints : arrayTwo) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                }
            }
        }
        for (int i = 0; i < arrayTwo.length ; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if(arrayTwo[i][j] == min) {
                    System.out.print("Все индексы минимального элемента: " + i + " ");
                    System.out.println(j);           // все индексы
                }
            }
        }
        int minIndexN = 0;
        int minIndexM = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrayTwo[i][j] < arrayTwo[minIndexN][minIndexM]) {
                    minIndexN = i;
                    minIndexM = j;
                }
            }
        }
        System.out.println("Индекс первого найденного минимального: " + minIndexN + " " + minIndexM);
    }
}
