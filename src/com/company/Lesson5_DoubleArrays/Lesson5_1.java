package com.company.Lesson5_DoubleArrays;

import java.util.Random;

public class Lesson5_1 {
    public static void main(String[] args) {
        int [][] arrayTwo = inputArrayWithRandom(9,9,0,9);
        printArray(arrayTwo);
        int min = arrayTwo[0][0];
        for (int[] ints : arrayTwo) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                }
            }
        }
        System.out.println();
        System.out.println(min);
    }
    public static void printArray(int[][] a) {
        for (int[] ints : a) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("    " + ints[j] + "    ");
            }
            System.out.println();
        }
    }
    public static int[][] inputArrayWithRandom(int n, int m, int a, int b) {
        Random random = new Random();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = random.nextInt(a, b);
            }
        }
        return arr;
    }
}
