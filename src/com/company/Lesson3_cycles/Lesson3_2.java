package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for(int i = 1; i <= 1000; i++) {
            if(i % a == 0) {
                System.out.println(i);
            }
        }
    }
}
