package com.company.Lesson2_ifElse;

import java.util.Scanner;

public class Lesson2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if(a > b) {
            System.out.println("a + b = " + (a + b));
        } else if (a == b) {
            System.out.println("a * b = " + (a * b));
        } else {
            System.out.println("a - b = " + (a - b));
        }
    }
}
