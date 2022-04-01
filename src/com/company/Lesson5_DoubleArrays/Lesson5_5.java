package com.company.Lesson5_DoubleArrays;

public class Lesson5_5 {
    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        int[][] arrayTwo = Lesson5_1.inputArrayWithRandom(n, m, 0, 10);
        Lesson5_1.printArray(arrayTwo);
        System.out.println();
        int array;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array = arrayTwo[i][j];
                   if (((array) > (arrayTwo[i + 1][j])) &&
                            ((array) > (arrayTwo[i - 1][j])) &&
                            ((array) > (arrayTwo[i][j + 1])) &&
                            ((array) > (arrayTwo[i][j - 1]))) {
                        count++;
                    }
                }
            }
                 System.out.println(count);
        }
    }
//          if ((i == 0) && (j == 0)) {
//                    if ((arrayTwo[i][j] > arrayTwo[i + 1][j]) && (arrayTwo[i][j] > arrayTwo[i][j + 1])) {
//                        count++;
//                    }
//                } else if ((i == 0) && (j == m - 1)) {
//                    if ((arrayTwo[i][j] > arrayTwo[i + 1][j]) && (arrayTwo[i][j] > arrayTwo[i][j - 1])) {
//                        count++;
//                    }
//                } else if ((i == n - 1) && (j == 0)) {
//                    if ((arrayTwo[i][j] > arrayTwo[i][j + 1]) && (arrayTwo[i][j] > arrayTwo[i - 1][j])) {
//                        count++;
//                    }
//                } else if ((i == n - 1) && (j == m - 1)) {
//                    if ((arrayTwo[i][j] > arrayTwo[i - 1][j]) && (arrayTwo[i][j] > arrayTwo[i][j - 1])) {
//                        count++;
//                    }
//                }