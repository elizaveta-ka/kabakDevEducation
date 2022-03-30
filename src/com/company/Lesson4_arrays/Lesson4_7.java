package com.company.Lesson4_arrays;

public class Lesson4_7 {
    public static void main(String[] args) {
        int n = 20;
        int [] a =  Lesson4_1.inputArrayWithRandom(n, 0, 20);
        Lesson4_1.printArray(a, n);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
