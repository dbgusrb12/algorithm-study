package com.hyungyu.algorithm.book.number_theory;

import java.util.Scanner;

public class P1016_제곱이아닌수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        int checkLength = (int) (max - min);
        boolean[] checkArray = new boolean[checkLength + 1];
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;
            if (min % pow != 0) {
                startIndex++;
            }
            for (long j = startIndex; pow * j <= max; j++) {
                int checkIndex = (int) (j * pow - min);
                checkArray[checkIndex] = true;
            }
        }
        int answer = 0;

        for (int i = 0; i <= checkLength; i++) {
            if (!checkArray[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
