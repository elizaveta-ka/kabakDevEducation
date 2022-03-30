package com.company;

import java.util.Random;
import java.util.Scanner;

public class task4_1 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  inputArrayWithRandom(n, 0, 20);
        printArray(a, n);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] % 2 != 0) {
                sum += a[i];
                count++;
            }
        }
        System.out.println(count);

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
            arr[i] = random.nextInt(a,b);     //origin - включительно; bound - не включительнож
        }
        return arr;
    }
}