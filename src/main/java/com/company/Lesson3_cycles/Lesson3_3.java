package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int count = 0;
        int A = scanner.nextInt();
        for (int i = 1; Math.pow(i,2) < A; i++) {
            count++;
        }
        System.out.println(count);
    }
//            Scanner in = new Scanner(System.in);
//            int a = in.nextInt();
//            while ( a <= 0) a = in.nextInt();
//            int count = 0;
//                for (int i = 1; i < Math.sqrt(a); i++) count++;
//                    System.out.println(count);
    }
