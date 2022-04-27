package com.company.Lesson1_variables;

import java.util.Scanner;

public class Lesson1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double result = (5 * a + Math.pow(b,2))/(b -a);
        System.out.println(result);
    }
}
