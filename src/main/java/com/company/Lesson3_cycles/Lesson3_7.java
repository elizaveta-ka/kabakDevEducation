package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        while ((A != 0) && (B != 0)) {
            if (A > B) {
                A %= B;
            } else {
                B %= A;
            }
        }
        System.out.println(A + B);
    }
}
