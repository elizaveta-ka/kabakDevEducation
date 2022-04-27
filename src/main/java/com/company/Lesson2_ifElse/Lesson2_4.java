package com.company.Lesson2_ifElse;

import java.util.Scanner;

public class Lesson2_4 {
    public static void main(String[] args) {
        // ax^2 + bx + c = 0
        double x1,x2;
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double D;
        D = Math.pow(b,2) - 4 * a * c;
        //System.out.println(D);
        if (D > 0) {
           x1 = (-b + Math.sqrt(D)) / 2 * a;
           x2 = (-b - Math.sqrt(D)) / 2 * a;
           System.out.println(x1);
           System.out.println(x2);

       } else if (D == 0) {
            x1 = -b / 2 * a;
            System.out.println(x1);
        } else {
            System.out.println("Root is not founded");
        }
    }
}
