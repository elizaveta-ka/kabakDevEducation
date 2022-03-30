package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;
        if (number < 0) {
            System.out.println("Введите положительное число");
        } else {
            for (int i = 1; i <= number; i++) {
                if (i % 2 != 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
