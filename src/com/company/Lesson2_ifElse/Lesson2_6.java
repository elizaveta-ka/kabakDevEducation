package com.company.Lesson2_ifElse;

import java.util.Scanner;

public class Lesson2_6 {
    public static void main(String[] args) {
        int x0 = 0;
        int y0 = 0;
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int r = scanner.nextInt();

        double radius = (Math.pow((x1 - x0), 2) + Math.pow((y1 - y0), 2));
        if (r >= radius) {
            System.out.println("Точка попадает в круг");
        } else {
            System.out.println("Точка не попадает в круг");
        }
    }
}
