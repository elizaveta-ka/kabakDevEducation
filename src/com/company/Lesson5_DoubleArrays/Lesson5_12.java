package com.company.Lesson5_DoubleArrays;

public class Lesson5_12 {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        int [][] arrayTwo = new int[m][n];
        int number = 1;
        for (int i = 0; i < n; i++) {
            arrayTwo[0][i] = number;
            number++;
        }
        for (int i = 1; i < m; i++) {
            arrayTwo[i][n-1] = number;
            number++;
        }
        for (int i = n-2; i >= 0 ; i--) {
            arrayTwo[m-1][i] = number;
            number++;
        }
        for (int i = m-2; i > 0; i--) {
            arrayTwo[i][0] = number;
            number++;
        }
        int x = 1;
        int y = 1;
        while (number < m * n) {
            while (arrayTwo[x][y+1] == 0) {
                arrayTwo[x][y] = number;
                number++;
                y++;
            }
            while (arrayTwo[x+1][y] == 0) {
                arrayTwo[x][y] = number;
                number++;
                x++;
            }
            while (arrayTwo[x][y-1] == 0) {
                arrayTwo[x][y] = number;
                number++;
                y--;
            }
            while (arrayTwo[x-1][y] == 0) {
                arrayTwo[x][y] = number;
                number++;
                x--;
            }
        }

        Lesson5_1.printArray(arrayTwo);
    }
}
