package com.company.Lesson1_variables;

import java.util.Scanner;

public class Lesson1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        String c = a;
         a = b;
         b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
