package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double x = scanner.nextDouble();
        double result1 = 1 / x;
        double denominator1 = x;

        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                denominator1 *= x + i;
                result1 += 1 / denominator1;         // b = 1; b/=(x+1); sum \+=b;
            }
        }

        System.out.println(result1);

        double numerator2 = 1;
        int denominator2 = 1;
        double result2 = 0;

        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                numerator2 *= x;
                denominator2 *= i;
                result2 += numerator2 / denominator2;
            }
        }

        System.out.println(result2);

    }
}
