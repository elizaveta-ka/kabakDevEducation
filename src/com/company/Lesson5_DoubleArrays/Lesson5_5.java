package com.company.Lesson5_DoubleArrays;

public class Lesson5_5 {
    public static void main(String[] args) {
        int n = 9;
        int m = 9;
        int[][] arrayTwo = Lesson5_1.inputArrayWithRandom(n, m, 0, 10);
        Lesson5_1.printArray(arrayTwo);
        System.out.println();
        Task(arrayTwo, n, m);
    }
    public static void Task(int[][] arr, int n, int m) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isLocalMax(arr, n, m, i, j)) {
                    count++;
                   System.out.println(count + "число = " + arr[i][j]);
                   System.out.println("Индекс: " + i + " " + j);
                }
            }
        }
        System.out.println(count);
        if (count == 0) {
            System.out.println("Чисел нет");
        }
    }
    public static boolean isLocalMax(int[][] arr, int n, int m, int i, int j) {
        int startI = i > 0 ? i - 1 : 0;
        int endI = i < n - 1 ? i + 1 : n - 1;
        int startJ = j > 0 ? j - 1 : 0;
        int endJ = j < m - 1 ? j + 1 : m - 1;
        for (int f = startI; f <=  endI; f++) {
            for (int k = startJ; k <= endJ; k++) {
                if (!(f == i && k == j)) {
                    if(arr[f][k] >= arr[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
