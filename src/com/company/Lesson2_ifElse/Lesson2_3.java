package com.company.Lesson2_ifElse;

import java.util.Scanner;

public class Lesson2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
            if ((a < b) && (a < c)) {
                System.out.println(a);
                if (b < c) {
                    System.out.println(b);
                    System.out.println(c);
                } else if (c < b) {
                    System.out.println(c);
                    System.out.println(b);
                }

            } else if ((b < a) && (b < c)) {
                System.out.println(b);
                if (a < c) {
                    System.out.println(a);
                    System.out.println(c);
                } else if (c < a) {
                    System.out.println(c);
                    System.out.println(a);
                }

            } else if ((c < a) && (c < b)) {
                System.out.println(c);
                if (a < b) {
                    System.out.println(a);
                    System.out.println(b);
                } else if (b < a) {
                    System.out.println(b);
                    System.out.println(a);
                }
            }
    }
}
