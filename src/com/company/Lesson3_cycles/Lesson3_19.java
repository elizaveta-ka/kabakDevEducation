package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag =  false;
        int N = scanner.nextInt();
        for (int i = 1; i <= Math.sqrt(N) ; i++) {
            for (int j = i; j <= Math.sqrt(N); j++) {
                if (Math.pow(i, 2) + Math.pow(j, 2) == N) {
                    System.out.println("yes");
                    flag = true;               //
                    break;                     //return;
                }
            }
                   if (flag) break;
        }
                    if(!flag)
                    System.out.println("no");
    }
}
       //Установить флаг, либо return;