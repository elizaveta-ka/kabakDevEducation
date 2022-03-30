package com.company.Lesson4_arrays;

import java.util.Random;
import java.util.Scanner;

public class Lesson4_1 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  inputArrayWithRandom(n, 0, 20);
        printArray(a, n);
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(min);

    }
    public static void printArray(int [] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    public static int [] inputArrayWithRandom(int n, int a, int b) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(a,b);
        }
        return arr;
    }
}
