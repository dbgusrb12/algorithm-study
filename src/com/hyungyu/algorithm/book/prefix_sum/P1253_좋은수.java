package com.hyungyu.algorithm.book.prefix_sum;

import java.util.Arrays;
import java.util.Scanner;

public class P1253_좋은수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] C = new long[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextLong();
        }
        Arrays.sort(C);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int startIndex = 0;
            int endIndex = N - 1;
            long K = C[i];

            while (startIndex < endIndex) {
                long sum = C[startIndex] + C[endIndex];
                if (sum < K) {
                    startIndex++;
                } else if (sum > K) {
                    endIndex--;
                } else {
                    if (startIndex != i && endIndex != i) {
                        count++;
                        break;
                    } else if (startIndex == i) {
                        startIndex++;
                    } else if (endIndex == i) {
                        endIndex--;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
