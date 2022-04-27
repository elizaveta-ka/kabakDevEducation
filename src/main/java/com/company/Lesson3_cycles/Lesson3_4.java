package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int A = scanner.nextInt();
        if (A % 2 == 0) {
            System.out.println(A / 2);
        } else {
            a = A/2;
            for (int i = a; i > 0; i--) {
                if (A % i == 0) {
                    System.out.println(i);
                    break;
                }
            }

        }

    }
}
