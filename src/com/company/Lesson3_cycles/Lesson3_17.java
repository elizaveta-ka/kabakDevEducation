package com.company.Lesson3_cycles;

public class Lesson3_17 {
    public static void main(String[] args) {
        int num;
        for (int i = 10; i <= 99; i++) {
            num = numSum(i);
            boolean flag = true;
            for (int j = 2; j <= 9; j++) {
                if (num != numSum(i * j)) {
                    flag = false;
                    break;
                }
            }
                if(flag) {
                    System.out.println(i);
                }
        }
    }
    public static int numSum (int a) {
        int count = 0;
        while (a != 0) {
            count += a % 10;
            a = (a - (a % 10)) / 10;
        }
        return count;
    }
}
