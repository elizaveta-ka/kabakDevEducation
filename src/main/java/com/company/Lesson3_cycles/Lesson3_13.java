package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double n = 0;
        for ( int i = 1; i <= N; i++) {
            n = n + (1 + 1/(Math.pow(i, 2)));
        }
        System.out.println(n);
    }
}
