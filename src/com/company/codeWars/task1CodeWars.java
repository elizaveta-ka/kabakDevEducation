package com.company.codeWars;

import java.util.Arrays;

public class task1CodeWars {
    public static void main(String[] args) {
        int arr[] = {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        //нужно получить : "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
//        int count = 1;
//        String lineNew = "";
//        String tr = "-";
//        for (int i = 0; i < arr.length; i++) {
//            while (arr[i] + 1 == arr[i+1]) {
//                count++;
//            }   if (count < 3) {
//                lineNew = lineNew + arr[i] + ", ";
//            }
//            if (count >= 3) {
//                lineNew = lineNew + tr + arr[i + 1] + ", ";
//            }
//        }
//        System.out.println(lineNew);
    }
}
