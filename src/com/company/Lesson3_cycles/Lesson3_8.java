package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int x = N/2;
        int tmp = x;
        while (Math.pow(x,3) != N) {
            if(Math.pow(x,3) > N) {
                tmp = x;
                x = x/2;
            } else {
               while (x < tmp) {
                        x++;
                   if (Math.pow(x,3) == N) {
                       break;
                   }
               }
            }
        }
        if (Math.pow(x,3) == N) {
            System.out.println(x);
        }
    }
}
