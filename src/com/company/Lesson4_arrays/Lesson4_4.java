package com.company.Lesson4_arrays;

import java.util.Random;

public class Lesson4_4 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  Lesson4_1.inputArrayWithRandom(n, 0, 20);
        Lesson4_1.printArray(a, n);
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        System.out.println(max);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                System.out.println(i);
                break;
            }
        }
    }
}
