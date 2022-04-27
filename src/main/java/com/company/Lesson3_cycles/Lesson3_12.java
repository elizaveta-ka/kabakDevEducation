package com.company.Lesson3_cycles;

import java.util.Scanner;

public class Lesson3_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int tmp1, tmp2, tmp3;
        boolean flag = false;
        while(a % 10 != 0) {
            tmp1 = a % 10;
            a /= 10;
            tmp3 = b;
            while (b % 10 != 0) {
                tmp2 = b % 10;
                b /= 10;
                if(tmp1 == tmp2) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            if (a % 10 != 0) {
                b = tmp3;
            }
        }
            if(!flag) {
                System.out.println("NO");
            }
    }
}
