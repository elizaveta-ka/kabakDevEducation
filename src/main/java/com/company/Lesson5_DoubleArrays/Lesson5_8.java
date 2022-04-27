    package com.company.Lesson5_DoubleArrays;

    import java.util.Arrays;

    public class Lesson5_8 {
        public static void main(String[] args) {
            int n = 8;
            int m = 9;
            int[][] arrayTwo = Lesson5_1.inputArrayWithRandom(n, m, 0, 10); //{{1,5,7,8,9,0,0},{1,4,5,6,7,8,9},{3,5,6,7,8,9,5},{4,6,3,5,7,9,0}};
            Lesson5_1.printArray(arrayTwo);
            // Элементы равны суммам элементов строк,
            int[] array1 = new int[n];
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += arrayTwo[i][j];
                }
                array1[i] = sum;
            }
            System.out.println(Arrays.toString(array1));

            // Элементы равны произведениям элементов строк
            int[] array2 = new int[n];
            for (int i = 0; i < n; i++) {
                int multiplication = 1;
                for (int j = 0; j < m; j++) {
                    multiplication *= arrayTwo[i][j];
                }
                array2[i] = multiplication;
            }
            System.out.println(Arrays.toString(array2));
            // Элементы равны наименьшим средних арифметических элементов строк
            double[] array3 = new double[n];
            for (int i = 0; i < n; i++) {
                int sum3 = 0;
                for (int j = 0; j < m; j++) {
                    sum3 += arrayTwo[i][j];
                }
                array3[i] = (double) sum3/ m;
            }
            System.out.println(Arrays.toString(array3));
        }
    }
