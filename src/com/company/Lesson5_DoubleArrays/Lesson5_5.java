package com.company.Lesson5_DoubleArrays;

public class Lesson5_5 {
    public static void main(String[] args) {
        int [][] arrayTwo = Lesson5_1.inputArrayWithRandom(9,9,0,10);
        Lesson5_1.printArray(arrayTwo);
        System.out.println();
        int array;
        int count = 0;
        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayTwo[0].length; j++) {
                array = arrayTwo[i][j];
                if (((array) > (arrayTwo[i+1][j])) &&
                        ((array) > (arrayTwo[i-1][j])) &&
                        ((array) > (arrayTwo[i][j+1])) &&
                        ((array) > (arrayTwo[i][j-1]))) {
                    if ((i < 0) && (j < 0)) {
                        break;
                    }
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}
