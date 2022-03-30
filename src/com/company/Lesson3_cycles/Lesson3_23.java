package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int length = 0;
        int i = 0;
        int first = 0;
        int second = 1;
        int tmp = 0;
        while(length < a) {
            tmp = second;
            second += first;
            first = tmp;
            System.out.print(tmp);
            length += countNumbers(tmp);
            i = (int) (i * (Math.pow(10, countNumbers(tmp))) + tmp);
        }
        System.out.println("\n" + (int)((i/Math.pow(10, length - a)) % 10));
    }
    public static int countNumbers (int a) {
        int count = 0;
        while(a != 0) {
            a /= 10;
            count++;
        }
        return count;
    }
}
