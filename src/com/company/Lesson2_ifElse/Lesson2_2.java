package com.company.Lesson2_ifElse;

import java.util.Scanner;

public class Lesson2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if ((x == 0) && (y == 0)) {
            System.out.println("Точка находится в центре координат");
        } else if ((x == 0) && (y != 0)) {
            System.out.println("Точка лежит на оси Y");
        } else if ((x != 0) && (y == 0)) {
                System.out.println("Точка лежит на оси X");
        } else {
            if ((x > 0) && (y > 0)) {
                System.out.println("Точка принадлежит I четверти");
            } else if ((x < 0) && (y > 0)) {
                System.out.println("Точка принадлежит II четверти");
            } else if ((x < 0) && (y < 0)) {
                System.out.println("Точка принадлежит III четверти");
            } else if ((x > 0) && (y < 0)) {
                System.out.println("Точка принадлежит IV четверти");
            }
        }
    }
}
