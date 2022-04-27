package com.company.Lesson3_cycles;

public class Lesson3_18 {
    public static void main(String[] args) {
        int first;
        int second;
        int third;
        for (int i = 100; i <= 999; i++) {
            third = i % 10;
            second = ((i - third) / 10) % 10;
            first = i / 100;

            if (factorial(first) + factorial(second) + factorial(third) == i) {
                System.out.println(i);
            }
        }
    }

    public static long factorial(int n) {
        if (n <= 2) {
            return n;
        }
        long result = 1;

        for (int i = 1; i <= n ; i++) {
            result *= i;
        }
        return result;
    }
}