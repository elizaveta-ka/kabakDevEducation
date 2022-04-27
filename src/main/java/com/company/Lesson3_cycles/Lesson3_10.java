package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int b = 0;
        while (number % 10 != 0) {
            b += number % 10;
            b*= 10;
            number /= 10;
        }
        b /= 10;
        System.out.println(b);
    }
}