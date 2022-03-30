package com.company.Lesson4_arrays;

import java.util.Random;

public class Lesson4_3 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  Lesson4_1.inputArrayWithRandom(n, 0, 20);
        Lesson4_1.printArray(a, n);

        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(min);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }
}
