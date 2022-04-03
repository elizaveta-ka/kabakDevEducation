package com.company.Lesson5_DoubleArrays;

import java.util.Scanner;

public class Lesson5_10 {
    public static void main(String[] args) {
        int n = 5;
        int m = 7;
        int[][] arr = Lesson5_1.inputArrayWithRandom(n, m, 0, 9);
        Lesson5_1.printArray(arr);
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();                 //i = 3; j = 5; i + j = k
        if (k < ((n-1) + (m-1))) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i + j == k) {
                System.out.println("Для i = " + i + " и j = " + j);
                 System.out.println("Сумма чисел равна = " + sumArray(smallArray(arr, i, j)));
                    }
                }
            }
        } else {
            System.out.println("Ошибка");
        }
    }
        // Считаем сумму чисел переданного массива
        public static int sumArray (int [][] array) {
        int sum = 0;
            for (int[] ints : array) {
                for (int j = 0; j < array[0].length; j++) {
                    sum += ints[j];
                }
            }
        return sum;
    }
        // Создаем новый массив. Заполняем только рамку(i и j)
        public static int [][] smallArray (int [][] arr, int n, int m) {
        int [][] arrayTwo = new int [n+1][m+1];
            for (int i = 0; i < n+1; i++) {
                for (int j = 0; j < m+1; j++) {
                    if ((j == m)|| (i == n)) {
                        arrayTwo[i][j] = arr[i][j];
                    }
                }
            }
            return arrayTwo;
    }
}
