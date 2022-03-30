package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double D = scanner.nextFloat();
        double item = 1;
        double sum = 0;
        long count = 1L;

        while (Math.abs(item) >= D) {
            item = 1.0 / (count * count);
            sum += item;
            count++;
        }

        System.out.println(sum);

        count = 1L;
        item = 1.0;
        double sum2 = 0;

        while (Math.abs(item) >= D) {
            item = 1.0 / (count * (count + 2));
            sum2 += item;
            count++;
        }

        System.out.println(sum2);

        count = 1L;
        item = 1.0;
        int x = scanner.nextInt();
        long factorial = 1L;
        long numerator = 1L;
        double sum3 = 1;

        while (Math.abs(item) >= D) {
            numerator *= x;
            factorial *= count;
            item = (1.0 * numerator) / (1.0 * factorial);
            sum3 += item;
            count++;
        }

        System.out.println(sum3);
    }
}
