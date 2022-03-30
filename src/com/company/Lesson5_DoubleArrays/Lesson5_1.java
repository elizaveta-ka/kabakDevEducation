package com.company.Lesson5_DoubleArrays;

import java.util.Arrays;
import java.util.Random;

public class Lesson5_1 {
    public static void main(String[] args) {
        int [][] arrayTwo = inputArrayWithRandom(9,9,0,10);
        printArray(arrayTwo);
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
    }
    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(" " + a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] inputArrayWithRandom(int n, int c, int a, int b) {
        Random random = new Random();
        int[][] arr = new int[n][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = random.nextInt(a, b);
            }
        }
        return arr;
    }
}
