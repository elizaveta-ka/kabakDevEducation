package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min, max;
        int sum = 0;
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if (A < B) {
            min = A;
            max = B;
        } else {
            min = B;
            max = A;
        }
        for (int i = min; i <= max ; i++) {
            if (i % 7 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
