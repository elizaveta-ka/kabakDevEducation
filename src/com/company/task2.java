package com.company;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();
        int n = 0;
        if (value > (int) value) {
            do {
                value *= 10;
                n = (int) value % 10;
            } while (n == 0);
            System.out.println(n);
        }
        else {
            System.out.println("no");
        }
    }
}
