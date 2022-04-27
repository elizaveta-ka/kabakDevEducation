package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        double multiplication = 1;
        double sum = 0;
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
            multiplication *= 2 + 1.0 / factorial;
            sum += (1.0 + i) / factorial;
        }

        System.out.println("multiplication = " + multiplication);
        System.out.println("sum = " + sum);
    }
}
