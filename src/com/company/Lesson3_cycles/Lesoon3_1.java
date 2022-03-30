package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesoon3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
//        int count = 1;
//        int a = 1;
//        while (count <= B) {
//            a = a * A;
//            count++;
//        }
//        System.out.println(a);
        int result = A;
        for (int i = 1; i < B; i++) {
            result *= A;
        }
        System.out.println(result);
    }
}
