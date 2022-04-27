package com.company.Lesson4_arrays;

import java.util.Arrays;

public class Lesson4_9 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  Lesson4_1.inputArrayWithRandom(n, 0, 20);
        Lesson4_1.printArray(a, n);
        for (int i = a.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = min;
            a[index] = temp;
        }
        System.out.println(Arrays.toString(a));
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i - 1;
            while(j >= 0 && tmp < a[j]) {
                a[j+1] = a[j];
                j--;
            }
                a[j+1] = tmp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
