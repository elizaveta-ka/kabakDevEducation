package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int length = 0;
        int i = 1;
        long tmp = 0;
        while(length < a) {
            int number = (int) Math.pow(i, 2);
            System.out.print((int) Math.pow(i, 2));
            length += countNumbers(number);
            i++;
            tmp = (long) (tmp * (Math.pow(10, countNumbers(number))) + number);
        }
        System.out.println("\n" + (long)((tmp/Math.pow(10, length - a)) % 10));
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
