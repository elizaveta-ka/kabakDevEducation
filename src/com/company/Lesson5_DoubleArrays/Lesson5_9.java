package com.company.Lesson5_DoubleArrays;

public class Lesson5_9 {
    public static void main(String[] args) {
        int [][] arrayTwo = {{4,3,0,6,2,3},{2,3,2,9,3,5},{5,4,1,0,6,8},{4,3,0,2,1,0}};
        int n = 4;
        int m = 6;
        Lesson5_1.printArray(arrayTwo);
        int [] min_a = minPoint(arrayTwo,n,m);
        int [] max_a = maxPoint(arrayTwo,n,m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((arrayTwo[i][j] == min_a[i]) && (arrayTwo[i][j] == max_a[j])) {
                    System.out.println("Седловая точка найдена: " + arrayTwo[i][j] + " с координатами строки " + i + " c координатами столбца " + j);
                }
            }
        }
    }
    public static int [] minPoint (int [][] arrayTwo, int n, int m) {
        int [] minArray = new int[n];
        for (int i = 0; i < n; i++) {
            int min = arrayTwo[i][0];
            for (int j = 0; j < m; j++) {
                if (min > arrayTwo[i][j]) {
                    min = arrayTwo[i][j];
                }
                minArray[i] = min;
            }
        }
        return minArray;
    }
    public static int [] maxPoint (int [][] arrayTwo, int n, int m) {
        int [] maxArray = new int[m];
        for (int i = 0; i < m; i++) {
            int max = arrayTwo[0][i];
            for (int j = 0; j < n; j++) {
                if (max < arrayTwo[j][i]) {
                    max = arrayTwo[j][i];
                }
                maxArray[i] = max;
            }
        }
        return maxArray;
    }
}
