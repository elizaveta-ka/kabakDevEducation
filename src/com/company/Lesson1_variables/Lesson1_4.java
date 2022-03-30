package com.company.Lesson1_variables;

import java.util.Scanner;

public class Lesson1_4 {
    public static void main(String[] args) {
        // a * x + b = c
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if((a != 0) && (b != 0) && (c!= 0)) {
            double x = (double) (c - b)/a;
            System.out.println(x);
        } else {
            System.out.println("Number or numbers = 0 - Attention!");
        }
    }
}
