package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                sum += i;
            }
        }

        System.out.println(sum == N);
    }
}
