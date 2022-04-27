package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int tmp;
        for (int i = 1; i <= N; i++) {
            int sumChet = 0;
            int sumNechet = 0;
            tmp = i;

            if (String.valueOf(i).length() % 2 == 0) {
                while (tmp != 0) {
                    sumChet += tmp % 10;
                    tmp = (tmp - (tmp % 10)) / 10;
                    sumNechet += tmp % 10;
                    tmp = (tmp - (tmp % 10)) / 10;
                }
            } else {
                while (tmp != 0) {
                    sumNechet += tmp % 10;
                    tmp = (tmp - (tmp % 10)) / 10;
                    sumChet += tmp % 10;
                    tmp = (tmp - (tmp % 10)) / 10;
                }
            }

            if (sumChet > sumNechet) {
                System.out.println(i);
            }
        }
    }
}
