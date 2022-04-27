package com.company.Lesson1_variables;

import java.util.Scanner;

public class Lesson1_1 {
    public static void main(String[] args) {
       int a, b;
       double result;
       Scanner scanner = new Scanner(System.in);
       a = scanner.nextInt();
       b = scanner.nextInt();
       result = 1.0 * a / b;
       int result2 = a % b;
        System.out.println("a/b = " + result);
        System.out.println("remaindor = " + result2);
    }
}
