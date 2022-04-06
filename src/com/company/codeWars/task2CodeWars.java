package com.company.codeWars;

public class task2CodeWars {
    public static void main(String[] args) {
        //12 ==> 21
        //513 ==> 531
        //2017 ==> 2071
        System.out.println(nextBiggerNumber(144));
    }
    public static long nextBiggerNumber(long n) {
        int count = 0;
        long m = 0;
        long c = 0;
        long number = n;
        if (n > 0) {
            c = (n / 100) * 100;
            while (count < 2) {
                m += number % 10;
                m *= 10;
                number /= 10;
                count++;
            }
        }
        if (n / 10 == 0) {
            m /= 100;
        } else {
            m /= 10;
        }
            m = c + m;
            if (m > n) {
                return m;
            } else {
                return -1;
            }
    }
}
