package com.company.Lesson5_DoubleArrays;

public class Lesson5_5 {
    public static void main(String[] args) {
        }
    }
//        int n = 9;
//        int m = 9;
//        int[][] arrayTwo = Lesson5_1.inputArrayWithRandom(n, m, 0, 10);
//        Lesson5_1.printArray(arrayTwo);
//        System.out.println();
////        Task(arrayTwo, n, m);
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if ( isLocalMax(arrayTwo,n,m,i,j)) {
//                    count++;
//                    System.out.println(count + "число = " + arrayTwo[i][j]);
//                    System.out.println("Индекс: " + i + " " + j);
//                }
//            }
//        }
//        if (count == 0) {
//            System.out.println("Чисел нет");
//        }
//    }
//    public static boolean isLocalMax ( int [][] arr, int n, int m, int i, int m) {
//        int [][] arr = new int [n][m];
//
//    }

//    public static void Task (int [][] arr, int n, int m) {
//        boolean chek;
//        int count  = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                chek = true;
//                for (int f = i-1; f <= i+1 ; f++) {
//                    for (int k = j-1; k <= n ; k++) {
//                        if (f >= 0 && k >= 0 && f<n && k <m && !(f==i && k == j)) {
//                            if (arr[f][k] >= arr[i][j]) {
//                                chek = false;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if (chek) {
//                    count++;
//                    System.out.println(count + "число = " + arr[i][j]);
//                    System.out.println("Индекс " + i + " " + j);
//                }
//            }
//        }
//        if(count == 0) {
//            System.out.println("Чисел нет");
//        }
//    }
