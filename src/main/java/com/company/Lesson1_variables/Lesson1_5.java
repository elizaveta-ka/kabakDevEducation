package com.company.Lesson1_variables;

import java.util.Scanner;

public class Lesson1_5 {
    public static void main(String[] args) {
        //y = a * x + b
        double a, b;
        int x1, y1 ,x2 ,y2;
        Scanner scanner = new Scanner(System.in);
        x1 = scanner.nextInt();
        y1 = scanner.nextInt();
        x2 = scanner.nextInt();
        y2 = scanner.nextInt();

        a = (y2 + y1)/(x2 - x1);
        b = y1 - a * x1;
        System.out.println(a);
        System.out.println(b);

        System.out.println("Equation : " + "y = " + a + " * x + " + b);


    }
}
