package com.company.Lesson2_ifElse;

import java.util.Scanner;

public class Lesson2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите трехзначное число");
        int value1 = scanner.nextInt();                //a
        int a = value1 / 100;
        int b = value1 /10 % 10;
        int c = value1 % 10;
        if (Math.pow(value1,2) == Math.pow((a + b + c), 3)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
                                                        //b
        System.out.println("Введите четырехзначное число");
        int value2 = scanner.nextInt();
        int d = value2 / 1000;
        int e = value2 / 100 % 10;
        int f = value2 / 10 % 10;
        int j = value2 % 10;
        if ((d + e) == (f + j)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
                                                          //c
        System.out.println("Введите трехзначное число");
        int value3 = scanner.nextInt();
        int num1 = value1 / 100;
        int num2 = value1 /10 % 10;
        int num3 = value1 % 10;
        if ((num1 == num2) || (num2 == num3) ||(num3 == num1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
                                                            //d
        System.out.println("Введите дробное число");
        double number = scanner.nextDouble();
        int number1 = (int) (number * 10) % 10;
        int number2 = (int) (number * 100) % 10;
        int number3 = (int) (number * 1000) % 10;
        if ((number1 == 0) || (number2 == 0) || (number3 == 0)) {
            System.out.println("True");
        }
    }
}
