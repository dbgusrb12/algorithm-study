package com.hyungyu.algorithm.book.two_pointer;

import java.util.Arrays;
import java.util.Scanner;

public class P1940_주몽 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }
        Arrays.sort(C);
        int startIndex = 0;
        int endIndex = N - 1;
        int sum = 0;
        int count = 0;
        while (startIndex < endIndex) {
            sum = C[startIndex] + C[endIndex];
            if (sum > M) {
                endIndex--;
            } else if (sum < M) {
                startIndex++;
            } else {
                count++;
                startIndex++;
                endIndex--;
            }
        }
        System.out.println(count);
    }
}
