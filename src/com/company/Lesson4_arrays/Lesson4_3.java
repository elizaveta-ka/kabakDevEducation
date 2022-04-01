package com.company.Lesson4_arrays;

import java.util.Random;

public class Lesson4_3 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  Lesson4_1.inputArrayWithRandom(n, 0, 20);
        Lesson4_1.printArray(a, n);
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (a[minIndex] > a[i]) {
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }
}
