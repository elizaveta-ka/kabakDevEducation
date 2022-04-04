package com.company.codeWars;

import java.util.Arrays;

public class task1CodeWars {
    public static void main(String[] args) {
        int [] arr = {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        //нужно получить : "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
        System.out.println(rangeExtraction(arr));
    }
    public static String rangeExtraction(int[] arr) {
        boolean flag = false;
        StringBuilder lineNew = new StringBuilder();
        String tr = "-";
        for (int i = 0; i < arr.length - 1;i ++) {
            int count = 1;
            lineNew.append(arr[i]);
            while (arr[i] + 1 == arr[i + 1]) {
                count ++;
                i++;
                if (i == arr.length - 1) {
                    flag = true;
                    break;
                }
            }
                if (flag) {
                    lineNew.append(tr).append(arr[i]);
                    break;
                }
                if (count >= 3) {
                    lineNew.append(tr).append(arr[i]).append(", ");
                } else if (count == 2) {
                    i--;
                    lineNew.append(", ");
                } else {
                    lineNew.append(", ");
                }
            }
        return lineNew.toString();
    }
}
