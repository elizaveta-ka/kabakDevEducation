package com.company.Lesson4_arrays;

import java.util.Arrays;

public class Lesson4_8 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  Lesson4_1.inputArrayWithRandom(n, 0, 20);
        Lesson4_1.printArray(a, n);
        int tmp;
        if (a.length % 2 == 0) {
            for (int i = 0; i < a.length / 2; i++) {
                tmp = a[i];
                a[i] = a[(a.length / 2) + i];
                a[(a.length / 2) + i] = tmp;
            }
        } else {
            for (int i = 0; i < a.length / 2; i++) {
                tmp = a[i];
                a[i] = a[(a.length / 2) + i + 1];
                a[(a.length / 2) + i + 1] = tmp;
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
}
