package com.company.Lesson5_DoubleArrays;

import java.util.Arrays;
import java.util.Random;

public class Lesson5_7 {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        double [][] arr = inputArrayWithRandom(n, m, 0, 1);
        boolean [] arrNew = new boolean[m];            // для пункта а) задачи
        boolean [] arrNew2 = new boolean[n];          // для пункта б) задачи
        boolean [] arrNew3 = new boolean[n];          // для пункта с) задачи
        printArray(arr, n, m);
        // Все элементы k-ого столбца нулевые
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j][i] == 0) {
                    count++;
                    arrNew[i] = count == n;
                }
            }
        }
        System.out.println(Arrays.toString(arrNew));

        //Элементы k строки матрицы упорядочены по убыванию
        boolean flag1 = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-1; j++) {
                if (arr[i][j] < arr[i][j+1]) {
                    flag1 = false;
                    arrNew2[i] = false;
                    break;
                }
                if (arr[i][j] == arr[i][j+1]) {
                   continue;
                }
            }
            if (flag1) {
                arrNew2[i] = true;
            }
        }
            System.out.println(Arrays.toString(arrNew2));

        // k строка массива симметрична
            boolean flag2 = true;
             for (int i = 0; i < n; i++) {
                 for (int j = 0; j < m; j++) {
                     if (arr[i][j] != arr[i][m-1-j]) {
                         flag2 = false;
                         arrNew3[i] = false;
                         break;
                     }
                 }
                 if(flag2) {
                     arrNew3[i] = true;
                 }
             }
            System.out.println(Arrays.toString(arrNew3));
    }
    public static void printArray(double[][] a, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public static double [][] inputArrayWithRandom(int n, int m, double a, double b) {
        Random random = new Random();
        double [][] arr = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = random.nextDouble(a,b);
            }
        }
        return arr;
    }
    // Не знаю куда применить String.format, чтобы ограничить double одной цифрой после запятой.
    //Пока думаю над этим.
    //Задачу решала на int-ах, чтобы точно проверить, что код работает.
}
