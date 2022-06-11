package com.hyungyu.algorithm.book.number_theory;

import java.util.Scanner;

public class P1456_거의소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        long[] numArray = new long[10000001];
        int numArrayLength = numArray.length;
        for (int i = 2; i < numArrayLength; i++) {
            numArray[i] = i;
        }
        double sqrt = Math.sqrt(numArrayLength);
        for (int i = 2; i <= sqrt; i++) {
            if (numArray[i] == 0) {
                continue;
            }
            for (int j = i + i; j < numArrayLength; j += i) {
                numArray[j] = 0;
            }
        }
        int answer = 0;
        for (int i = 2; i < numArrayLength; i++) {
            if (numArray[i] != 0) {
                long temp = numArray[i];
                while ((double) numArray[i] <= (double) max / (double) temp) {
                    if ((double) numArray[i] >= (double) min / (double) temp) {
                        answer++;
                    }
                    temp *= numArray[i];
                }
            }
        }
        System.out.println(answer);
    }
}
